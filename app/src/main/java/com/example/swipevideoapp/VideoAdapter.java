package com.example.swipevideoapp;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private List<VideoItem> videoItems;

    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    /**
     * helps find what is displayed on the screen and interacts with the rest of the components
     */
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video,parent,false)
        );
    }

    /**
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     * sets up the position of each video
     */
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        holder.setVideoData(videoItems.get(position));

    }

    @Override
    public int getItemCount() {

        return videoItems.size();

    }

    /**
     * Helps swipe the screen upwards by generating the videos
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder {

        TextView textVideoTitle1, textVideoDescription1, textVideoID1;

        VideoView videoView;

        ProgressBar progressBar;

        public VideoViewHolder(@NonNull View itemView) {

            super(itemView);

            videoView = itemView.findViewById(R.id.videoView);

            textVideoTitle1 = itemView.findViewById(R.id.textVideoTitle);

            textVideoDescription1 = itemView.findViewById(R.id.textVideoDescription);

            textVideoID1 = itemView.findViewById(R.id.textVideoID);

            progressBar = itemView.findViewById(R.id.videoProgressBar);

        }

        /**
         *
         * @param videoItem Prepares the video before swiping to the next video
         */
        void setVideoData(VideoItem videoItem) {

            textVideoTitle1.setText((videoItem.videoTitle));

            textVideoDescription1.setText(videoItem.videoDescription);

            textVideoID1.setText(videoItem.videoID);

            videoView.setVideoPath(videoItem.videoURL);

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(View.GONE);

                    mp.start();

                    float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();

                    float screenRatio = videoView.getWidth()/(float) videoView.getHeight();

                    float scale = videoRatio / screenRatio;

                    if (scale >=1f) {

                        videoView.setScaleX(scale);

                    } else {

                        videoView.setScaleY(1f / scale);

                    }
                }

            });

            /**
             * Allows for the media to be played on the app
             */
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });

        }

    }
}
