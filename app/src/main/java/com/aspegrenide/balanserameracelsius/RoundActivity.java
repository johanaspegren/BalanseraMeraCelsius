package com.aspegrenide.balanserameracelsius;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.aspegrenide.balanserameracelsius.support.Round;
import com.aspegrenide.balanserameracelsius.support.Station;
import com.aspegrenide.balanserameracelsius.support.StationsAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class RoundActivity extends FragmentActivity
        implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private static final String LOG_TAG = "BALANSERA";
    private GoogleMap mMap;
    TextView tvRoundName;
    TextView tvRoundLength;
    TextView tvRoundDuration;
    TextView tvRoundDescription;

    private StationsAdapter stationsAdapter;

    // Use FireBase database to handle family details
    private DatabaseReference fbDatabaseReference;
    Round round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("BalanseraMera");

        // get the round from the intent
        Intent i = getIntent();
        round = (Round) i.getSerializableExtra(MainActivity.ROUND);
        Log.d(LOG_TAG, "round received " + round.toString());
        ArrayList<Station> stations = round.getStations();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        tvRoundName = (TextView) findViewById(R.id.tvRoundName);
        tvRoundDuration = (TextView) findViewById(R.id.tvRoundDuration);
        tvRoundLength = (TextView) findViewById(R.id.tvRoundLength);
        tvRoundDescription = (TextView) findViewById(R.id.tvStationDescription);

        tvRoundName.setText(round.getName());
        tvRoundDuration.setText(String.valueOf(round.getDurationInMinutes()) + " minuter");
        tvRoundLength.setText(String.valueOf(round.getDistance()));
        tvRoundDescription.setText(String.valueOf(round.getDescription()));

        // lista stationer
        stationsAdapter = new StationsAdapter(this, stations);
        ListView stationsListView;
        stationsListView = (ListView)findViewById(R.id.listViewStations);
        stationsListView.setAdapter(stationsAdapter);
        stationsListView.setOnItemClickListener(((parent, view, position, id) -> {
            //Toast.makeText(this, "Clicked " + stations.get(position), Toast.LENGTH_SHORT).show();
            startStation(stations.get(position));
        }));
    }

    private void startStation(Station station) {
        Intent intent = new Intent(RoundActivity.this, StationActivity.class);
        intent.putExtra(MainActivity.STATION, station);
        startActivity(intent);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker marker) {
                // TODO Auto-generated method stub
                Log.d(LOG_TAG, "clicked marker " + marker.getTitle());
                Station s = lookUpStation(marker.getTitle());
                startStation(s);
            }
        });
        // show me
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //Location Permission already granted
                mMap.setMyLocationEnabled(true);
            } else {
                //Request Location Permission
                checkLocationPermission();
            }
        } else {
            mMap.setMyLocationEnabled(true);
        }
        // make it clickable
        mMap.setOnMarkerClickListener(this);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        float zoomLevel = 18.0f; //This goes up to 21'


        // startplace
        LatLng start = generateLatLng(round.getStations().get(0));

        for (Station station: round.getStations()) {
            BitmapDescriptor iconTick = getIcon(station);
            mMap.addMarker(new MarkerOptions().
                    position(generateLatLng(station)).
                    icon(iconTick).
                    title(station.getTitle()));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start, zoomLevel));
    }

    private LatLng generateLatLng(Station station) {
        LatLng ll = new LatLng(station.getLat(), station.getLng());
        return ll;
    }


    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(RoundActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION );
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION );
            }
        }
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Log.d(LOG_TAG, "clicked " + marker.toString());

        marker.showInfoWindow();
        return true;
    }

    private Station lookUpStation(String title) {
        for(Station s : round.getStations()) {
            if (title.equals(s.getTitle())) {
                return s;
            }
        }
        return null;
    }

    private BitmapDescriptor getIcon(Station station) {
        return BitmapDescriptorFactory.fromResource(R.drawable.tick);
    }

}