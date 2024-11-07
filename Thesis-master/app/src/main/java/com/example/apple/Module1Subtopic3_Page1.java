package com.example.apple;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Module1Subtopic3_Page1 extends Fragment {

    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module1_subtopic3__page1, container, false);

        // Setup navigation buttons
        ImageButton continueButton = view.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module1Subtopic3_Page2());
            }
        });

        ImageButton closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module1Fragment());
            }
        });

        // Setup letter buttons with audio playback
        setupAudioButton(view, R.id.j_button, R.raw.j);
        setupAudioButton(view, R.id.q_button, R.raw.q);
        setupAudioButton(view, R.id.x_button, R.raw.x);
        setupAudioButton(view, R.id.zh_button, R.raw.zh);
        setupAudioButton(view, R.id.ch_button, R.raw.ch);
        setupAudioButton(view, R.id.sh_button, R.raw.sh);
        setupAudioButton(view, R.id.r_button, R.raw.r);
        setupAudioButton(view, R.id.z_button, R.raw.z);
        setupAudioButton(view, R.id.c_button, R.raw.c);
        setupAudioButton(view, R.id.s_button, R.raw.s);

        return view;
    }

    private void setupAudioButton(View view, int buttonId, final int audioResId) {
        ImageButton button = view.findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(getActivity(), audioResId);
                mediaPlayer.start();
            }
        });
    }

    private void navigateToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}