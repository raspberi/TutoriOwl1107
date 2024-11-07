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

public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Find the CardViews and set OnClickListeners
        CardView cardViewModule0 = view.findViewById(R.id.dashboard_card_view_module_0);
        CardView cardViewModule1 = view.findViewById(R.id.dashboard_card_view_module_1);
        CardView cardViewModule2 = view.findViewById(R.id.dashboard_card_view_module_2);
        CardView cardViewModule3 = view.findViewById(R.id.dashboard_card_view_module_3);

        cardViewModule0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module0Fragment());
            }
        });

        cardViewModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module1Fragment());
            }
        });

        cardViewModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Fragment());
            }
        });

        cardViewModule3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module3Fragment());
            }
        });

        // Find the ImageButtons and set OnClickListeners
        ImageButton buttonStartModule0 = view.findViewById(R.id.dashboard_module0_button_start);
        ImageButton buttonStartModule1 = view.findViewById(R.id.dashboard_module1_button_start);
        ImageButton buttonStartModule2 = view.findViewById(R.id.dashboard_module2_button_start);
        ImageButton buttonStartModule3 = view.findViewById(R.id.dashboard_module3_button_start);

        buttonStartModule0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module0Fragment());
            }
        });

        buttonStartModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module1Fragment());
            }
        });

        buttonStartModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module2Fragment());
            }
        });

        buttonStartModule3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module3Fragment());
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

