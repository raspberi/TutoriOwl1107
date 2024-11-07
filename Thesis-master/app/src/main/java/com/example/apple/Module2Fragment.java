package com.example.apple;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Module2Fragment extends Fragment {

    public Module2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module2, container, false);

        // Find the CardViews and set OnClickListeners
        CardView cardViewModule2Subtopic1 = view.findViewById(R.id.module2_subtopic1_card_view);
        CardView cardViewModule2Subtopic2 = view.findViewById(R.id.module2_subtopic2_card_view);
        CardView cardViewModule2Subtopic3 = view.findViewById(R.id.module2_subtopic3_card_view);
        CardView cardViewModule2Subtopic4 = view.findViewById(R.id.module2_subtopic4_card_view);

        cardViewModule2Subtopic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Subtopic1_Page1());
            }
        });

        cardViewModule2Subtopic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Subtopic2_Page1());
            }
        });

        cardViewModule2Subtopic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Subtopic3_Page1());
            }
        });

        cardViewModule2Subtopic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Subtopic4_Page1());
            }
        });


        // Find the ImageButtons and set OnClickListeners
        ImageButton buttonStartModule2Subtopic1 = view.findViewById(R.id.module2_subtopic1_button_start);
        ImageButton buttonStartModule2Subtopic2 = view.findViewById(R.id.module2_subtopic2_button_start);
        ImageButton buttonStartModule2Subtopic3 = view.findViewById(R.id.module2_subtopic3_button_start);
        ImageButton buttonStartModule2Subtopic4 = view.findViewById(R.id.module2_subtopic4_button_start);

        buttonStartModule2Subtopic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Subtopic1_Page1());
            }
        });

        buttonStartModule2Subtopic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Subtopic2_Page1());
            }
        });

        buttonStartModule2Subtopic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Subtopic3_Page1());
            }
        });

        buttonStartModule2Subtopic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Subtopic4_Page1());
            }
        });

        return view;
    }

    private void navigateToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
