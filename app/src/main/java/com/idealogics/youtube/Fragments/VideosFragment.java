package com.idealogics.youtube.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.security.identity.IdentityCredentialStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.idealogics.youtube.R;
import com.idealogics.youtube.Utils.Constants;


public class VideosFragment extends YoutubeFragment {
    YouTubePlayerView mYouTubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializatedListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_videos, container, false);
        mYouTubePlayerView = (YouTubePlayerView) rootView.findViewById(R.id.youtube_frag);
        mYouTubePlayerView.initialize(Constants.YOUTUBE_API_KEY, mOnInitializatedListener);

        Toast.makeText(getActivity(), "lol", Toast.LENGTH_SHORT).show();

        mOnInitializatedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("_XgQA9Ab0Gw");
                Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getActivity(), "failure "+youTubeInitializationResult.name(), Toast.LENGTH_SHORT).show();
            }
        };

        return rootView;
    }
}
