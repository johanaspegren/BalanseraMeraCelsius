package com.aspegrenide.balanserameracelsius;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.aspegrenide.balanserameracelsius.support.Exercise;
import com.aspegrenide.balanserameracelsius.support.Station;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class StationActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    private static final String LOG_TAG = "BALANSERA_MERA";
    TextView tvStationName;
    TextView tvStationDescription;
    TextView tvExerciseName;
    TextView tvExerciseDescription;
    TextView tvMakeItHarder;
    String nameOfRound = null;
    MediaController mediaController;
    VideoView videoView;
    ProgressBar progressBar;

    // Use firebase storage to store the video clips
    private StorageReference fbStorageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);

        videoView = (VideoView) findViewById(R.id.videoExercise);
        // get the round from the intent
        Intent i = getIntent();
        Station station = (Station) i.getSerializableExtra(MainActivity.STATION);
        Log.d(LOG_TAG, "station received " + station.toStringFull());

        tvStationName = (TextView) findViewById(R.id.tvStationName);
        tvStationDescription = (TextView) findViewById(R.id.tvStationDescription);

        tvExerciseName = (TextView) findViewById(R.id.tvExerciseName);
        tvExerciseDescription = (TextView) findViewById(R.id.tvExerciseDescription);
        tvMakeItHarder = (TextView) findViewById(R.id.tvMakeItHarder);
        progressBar = (ProgressBar) findViewById(R.id.progressBarVideo);

        tvStationName.setText(station.getTitle());
        tvStationDescription.setText(station.getDescription());
        tvExerciseName.setText(station.getExercise().getName());
        tvExerciseName.setTypeface(null, Typeface.BOLD);
        tvExerciseDescription.setText(station.getExercise().getDescription());
        if(!station.getExercise().getMakeItHarder().equals("")){
            String title = "Försvåra: \n";
            tvMakeItHarder.setText(title + station.getExercise().getMakeItHarder());
        }
        // prepare video
        prepareVideo(station);
    }

    private void prepareVideo(Station station) {
        Log.d(LOG_TAG, "latest is : " + station.toStringFull());
        Exercise exercise = station.getExercise();
        // download clip from firebase storage
        // dir needed?
        File internalMovies = createDirectories("intMov");
        File destination = new File(internalMovies, exercise.getVideoStorageReference());
        destination.toString();
        destination.canRead();
        try {
            if (destination.exists()) {
                Log.d(LOG_TAG, "file already exists: " + destination.toString());
                loadVideoView(Uri.fromFile(destination));

            } else {
                Log.d(LOG_TAG, "create file: " + destination.toString());
                if (!destination.getParentFile().exists()) destination.getParentFile().mkdirs();
                if (!destination.exists()) destination.createNewFile();

                Log.d(LOG_TAG, "file created: " + destination.toString());
                downloadFromCloud(exercise, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createDirectories(String mDir) {
        File dir = new File(this.getFilesDir(), mDir);
        if(!dir.exists()){
            dir.mkdir();
        }
        return dir;
    }

    private void downloadFromCloud(Exercise exercise, File destination) {
        final File dest = destination;
        Log.d(LOG_TAG, "download  : " + dest.toString());
        progressBar.setVisibility(View.VISIBLE);
        Toast.makeText(StationActivity.this, "Downloading video", Toast.LENGTH_SHORT).show();

        fbStorageReference = FirebaseStorage.getInstance().getReference("video");
        StorageReference ref =
                fbStorageReference.child("exercises/" + exercise.getVideoStorageReference());
        ref.getFile(destination).addOnSuccessListener(
            new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Local temp file has been created
                        //Log.d(TAG, "file fetched : " + destination.getAbsolutePath());
                        Toast.makeText(StationActivity.this, "File downloaded", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                        loadVideoView(Uri.fromFile(dest));
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(StationActivity.this, "Fail" + exception.toString(),
                        Toast.LENGTH_LONG).show();
                Log.d(LOG_TAG, "getfile failed Fail" + exception.toString());
                // Handle any errors
            }
        });

    }

    private void loadVideoView(Uri videoUri) {
        Log.d(LOG_TAG, "Load video " + videoUri.toString());

        videoView.setVideoURI(videoUri);

        videoView.seekTo(1);
        videoView.start();
        videoView.setZOrderOnTop(true);
    }

    public void startVideo(View view) {
        Log.d(LOG_TAG, "start video");
        toggleClip((VideoView) view);
    }

    private void toggleClip(VideoView vv){
        Log.d(LOG_TAG, "toggleClip  is playing: " + vv.isPlaying());
        if(vv.isPlaying()){
            Log.d(LOG_TAG, "toggleClip  IN isplaying?: " + vv.isPlaying());
            vv.pause();
            return;
        }
        vv.seekTo(0);
        vv.start();
        videoView.setZOrderOnTop(true);
    }

    public void doneExercise(View view) {
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }
}