package com.example.swipevideoapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /**
         * Allows for the first video to be generated/played on the app
         */
        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItemsList = new ArrayList<>();

        VideoItem videoCreeperAwMan = new VideoItem();

        videoCreeperAwMan.videoURL = "https://firebasestorage.googleapis.com/v0/b/testing-6c206.appspot.com/o/high%20quality%20video%20yes%20yes.mp4?alt=media&token=aef24e74-f5cb-4e0e-99b8-e6d2071ffb9e";

        videoCreeperAwMan.videoTitle = "Awww Man!";

        videoCreeperAwMan.videoDescription = "A high quality video. This is not a prank, this is actually the best video.";

        videoCreeperAwMan.videoID = "ID: 14141414";

        videoItemsList.add(videoCreeperAwMan);

        /**
         * Allows for the second video to be generated/played on the app
         */

        VideoItem videoHappyTrollsErza = new VideoItem();

        videoHappyTrollsErza.videoURL = "https://firebasestorage.googleapis.com/v0/b/testing-6c206.appspot.com/o/high%20quality%20video%20part%202%20lolol.mp4?alt=media&token=737fa061-18cf-4891-8425-ad5592217b3b";

        videoHappyTrollsErza.videoTitle = "Get Pranked!";

        videoHappyTrollsErza.videoDescription = "Happy pulls off the bestest of pranks! Don't miss it!";

        videoHappyTrollsErza.videoID = "ID: 01428071";

        videoItemsList.add(videoHappyTrollsErza);

        /**
         * Allows for the third video to be generated/played on the app
         */

        VideoItem coolestBattleEver = new VideoItem();

        coolestBattleEver.videoURL = "https://firebasestorage.googleapis.com/v0/b/testing-6c206.appspot.com/o/Coolest%20Battle%20in%20History.mp4?alt=media&token=9540f69d-7f22-43cd-b1c9-8325f54c9744";

        coolestBattleEver.videoTitle = "The Coolest Battle in History";

        coolestBattleEver.videoDescription = "This is single handedly the best battle of all time no lie no scam";

        coolestBattleEver.videoID = "ID: 110735";

        videoItemsList.add(coolestBattleEver);

        /**
         * Gives the data to display the videos and prepares this to play on the app
         */
        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));

    }
}