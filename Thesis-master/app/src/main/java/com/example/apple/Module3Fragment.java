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

public class Module3Fragment extends Fragment {

    public Module3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module3, container, false);

        // Find the CardViews and set OnClickListeners
        CardView cardViewModule3Subtopic1 = view.findViewById(R.id.module3_subtopic1_card_view);
        CardView cardViewModule3Subtopic2 = view.findViewById(R.id.module3_subtopic2_card_view);
        CardView cardViewModule3Subtopic3 = view.findViewById(R.id.module3_subtopic3_card_view);

        cardViewModule3Subtopic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module3Subtopic1_Page1());
            }
        });

        cardViewModule3Subtopic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module3Subtopic2_Page1());
            }
        });

        cardViewModule3Subtopic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module3Subtopic3_Page1());
            }
        });


        // Find the ImageButtons and set OnClickListeners
        ImageButton buttonStartModule3Subtopic1 = view.findViewById(R.id.module3_subtopic1_button_start);
        ImageButton buttonStartModule3Subtopic2 = view.findViewById(R.id.module3_subtopic2_button_start);
        ImageButton buttonStartModule3Subtopic3 = view.findViewById(R.id.module3_subtopic3_button_start);

        buttonStartModule3Subtopic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module3Subtopic1_Page1());
            }
        });

        buttonStartModule3Subtopic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module3Subtopic2_Page1());
            }
        });

        buttonStartModule3Subtopic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module3Subtopic3_Page1());
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
