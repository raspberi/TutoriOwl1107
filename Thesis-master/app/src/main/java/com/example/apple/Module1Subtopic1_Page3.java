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

public class Module1Subtopic1_Page3 extends Fragment {

    private MediaPlayer mediaPlayer;

    public Module1Subtopic1_Page3() {
        // Required empty public constructor
    }

    public static Module1Subtopic1_Page3 newInstance(String param1, String param2) {
        Module1Subtopic1_Page3 fragment = new Module1Subtopic1_Page3();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString("param1");
            String mParam2 = getArguments().getString("param2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_module1_subtopic1__page3, container, false);

        // Setup continueButton to navigate to the next fragment
        ImageButton continueButton = view.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module1Fragment());
            }
        });

        ImageButton closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module1Fragment());
            }
        });

        ImageButton previousButton = view.findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module1Subtopic1_Page2());
            }
        });

        // Setup ImageButtons to play audio
        setupButton(view, R.id.b_button, R.raw.b);
        setupButton(view, R.id.p_button, R.raw.p);
        setupButton(view, R.id.d_button, R.raw.d);
        setupButton(view, R.id.t_button, R.raw.t);
        setupButton(view, R.id.g_button, R.raw.g);
        setupButton(view, R.id.k_button, R.raw.k);
        setupButton(view, R.id.j_button, R.raw.j);
        setupButton(view, R.id.q_button, R.raw.q);
        setupButton(view, R.id.zh_button, R.raw.zh);
        setupButton(view, R.id.ch_button, R.raw.ch);
        setupButton(view, R.id.z_button, R.raw.z);
        setupButton(view, R.id.c_button, R.raw.c);

        return view;
    }

    private void setupButton(View view, int buttonId, int audioResId) {
        ImageButton button = view.findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(audioResId);
            }
        });
    }

    private void playAudio(int audioResId) {
        // Release any previous MediaPlayer to avoid multiple sounds playing simultaneously
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(getContext(), audioResId);
        mediaPlayer.start();

        // Release the MediaPlayer when the audio completes
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
                mediaPlayer = null;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void navigateToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
