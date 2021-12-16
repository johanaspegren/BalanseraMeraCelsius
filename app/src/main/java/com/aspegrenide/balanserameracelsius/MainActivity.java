package com.aspegrenide.balanserameracelsius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.aspegrenide.balanserameracelsius.support.Round;
import com.aspegrenide.balanserameracelsius.support.UploadData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "MAIN";

    public static final String ROUND = "ROUND";
    public static final String STATION_INDEX = "STATION_INDEX" ;
    public static final String ROSENKNOPPEN = "Rosenknoppen";
    public static final String RYDEBACKEN = "Rydebäcken";
    public static final String SKOLDENBORG = "Sköldenborg";
    public static final String PAARP = "Påarp";
    public static final String STATION = "STATION";

    // Use FireBase database to handle family details
    private DatabaseReference fbDatabaseReference;
    ArrayList<Round> rounds = new ArrayList<>();

/*
    // See: https://developer.android.com/training/basics/intents/result
    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
        new FirebaseAuthUIActivityResultContract(),
        new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
            @Override
            public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
                onSignInResult(result);
            }
        }
    );

    public void createSignInIntent() {
        // [START auth_fui_create_intent]
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        // Create and launch sign-in intent
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build();
        signInLauncher.launch(signInIntent);
        // [END auth_fui_create_intent]
    }

    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse response = result.getIdpResponse();
        if (result.getResultCode() == RESULT_OK) {
            // Successfully signed in
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            Log.d(LOG_TAG, "GOT user " + user.toString());
            // ...
        } else {
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            // ...
        }
    }

 */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // sign in stuff
        /*
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            Log.d(LOG_TAG, "signed in as " + auth.getCurrentUser());
        } else {
            Log.d(LOG_TAG, "NOT signed in ");
            AuthUI.SignInIntentBuilder
        }
//        createSignInIntent();

         */

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("BalanseraMera");

        // load data
        fbDatabaseReference = FirebaseDatabase.getInstance().getReference(
                "data/rounds/");
        initRoundsDataListener(fbDatabaseReference);
        // wait for data
        Log.d(LOG_TAG, "rounds = " + rounds.size());

        // upload some data
        UploadData ud = new UploadData();
        ud.makeRound();
    }

    public void startRound(View view) {
        Intent intent = new Intent(MainActivity.this, RoundActivity.class);
        if (view.getId() == R.id.imgRosenknoppen) {
            intent.putExtra(ROUND, getRound(ROSENKNOPPEN));
        }
        if (view.getId() == R.id.imgPaarp) {
            intent.putExtra(ROUND, getRound(PAARP));
        }
        if (view.getId() == R.id.imgRydeback) {
            intent.putExtra(ROUND, getRound(RYDEBACKEN));
        }
        if (view.getId() == R.id.imgSkoldenborg) {
            intent.putExtra(ROUND, getRound(SKOLDENBORG));
        }
        startActivity(intent);
        //overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
    }

    private int getView(String roundName) {
        if(roundName.equals(ROSENKNOPPEN)) { return R.id.imgRosenknoppen; }
        if(roundName.equals(PAARP)) { return R.id.imgPaarp; }
        if(roundName.equals(RYDEBACKEN)) { return R.id.imgRydeback; }
        if(roundName.equals(SKOLDENBORG)) { return R.id.imgSkoldenborg; }
        return -1;
    }

    private Round getRound(String roundName) {
        for(Round r : rounds){
            if(r.getName().equals(roundName)){
                return r;
            }
        }
        return null;
    }

    public void initRoundsDataListener(DatabaseReference ref) {
        Log.d(LOG_TAG, "readRoundsData ");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Iterable<DataSnapshot> stuff = dataSnapshot.getChildren();
                for(DataSnapshot s : stuff){
                    Round r = s.getValue(Round.class);
                    Log.d(LOG_TAG, "Round is: " + r.toString());
                    rounds.add(r);
                    ImageView v = findViewById(getView(r.getName()));
                    v.setVisibility(View.VISIBLE);
                }
                if(rounds.isEmpty()){
                    Log.d(LOG_TAG, "No families available: " );
                }else{
                    Log.d(LOG_TAG, "Families available: " );
                    Toast.makeText(getApplicationContext(),
                            "Data downloaded successfully",
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(LOG_TAG, "Failed to read value.", error.toException());
            }
        });
    }
}