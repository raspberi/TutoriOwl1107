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

public class Module2Subtopic1_Page2 extends Fragment {

    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Module2Subtopic1_Page2() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Module2Subtopic1_Page2 newInstance(String param1, String param2) {
        Module2Subtopic1_Page2 fragment = new Module2Subtopic1_Page2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module2_subtopic1__page2, container, false);

        // Setup navigation buttons
        ImageButton continueButton = view.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Subtopic1_Page3());
            }
        });

        ImageButton previousButton = view.findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Subtopic1_Page1());
            }
        });

        ImageButton closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Fragment());
            }
        });

        // Setup letter buttons with audio playback
        setupAudioButton(view, R.id.a_button, R.raw.a);
        setupAudioButton(view, R.id.o_button, R.raw.o);
        setupAudioButton(view, R.id.e_button, R.raw.e);
        setupAudioButton(view, R.id.i_button, R.raw.i);
        setupAudioButton(view, R.id.u_button, R.raw.u);
        setupAudioButton(view, R.id.uu_button, R.raw.u_umlaut);
        setupAudioButton(view, R.id.ai_button, R.raw.ai);
        setupAudioButton(view, R.id.ei_button, R.raw.ei);
        setupAudioButton(view, R.id.ao_button, R.raw.ao);
        setupAudioButton(view, R.id.ou_button, R.raw.ou);
        setupAudioButton(view, R.id.an_button, R.raw.an);
        setupAudioButton(view, R.id.en_button, R.raw.en);
        setupAudioButton(view, R.id.ang_button, R.raw.ang);
        setupAudioButton(view, R.id.eng_button, R.raw.eng);

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
