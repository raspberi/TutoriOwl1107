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

public class Module1Subtopic2_Page1 extends Fragment {

    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module1_subtopic2__page1, container, false);

        // Setup navigation buttons
        ImageButton continueButton = view.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module1Subtopic2_Page2());
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
        setupAudioButton(view, R.id.b_button, R.raw.b);
        setupAudioButton(view, R.id.p_button, R.raw.p);
        setupAudioButton(view, R.id.m_button, R.raw.m);
        setupAudioButton(view, R.id.f_button, R.raw.f);
        setupAudioButton(view, R.id.d_button, R.raw.d);
        setupAudioButton(view, R.id.t_button, R.raw.t);
        setupAudioButton(view, R.id.n_button, R.raw.n);
        setupAudioButton(view, R.id.l_button, R.raw.l);
        setupAudioButton(view, R.id.g_button, R.raw.g);
        setupAudioButton(view, R.id.k_button, R.raw.k);
        setupAudioButton(view, R.id.h_button, R.raw.h);

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

