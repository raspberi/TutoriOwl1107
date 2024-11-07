package com.example.apple;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Module0Subtopic1_Page1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Module0Subtopic1_Page1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Module0Subtopic1_Page1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Module0Subtopic1_Page1.
     */
    // TODO: Rename and change types and number of parameters
    public static Module0Subtopic1_Page1 newInstance(String param1, String param2) {
        Module0Subtopic1_Page1 fragment = new Module0Subtopic1_Page1();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_module0_subtopic1__page1, container, false);

        // Setup TextView with HTML content
        TextView textView = view.findViewById(R.id.module0_subtopic1_page1_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(getString(R.string.module0_subtopic1_page1_content), Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(getString(R.string.module0_subtopic1_page1_content)));
        }

        // Setup continueButton to navigate to the next fragment
        ImageButton continueButton = view.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module0Subtopic1_Page2());
            }
        });

        // Setup closeButton to navigate back to the module0 fragment
        ImageButton closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFragment(new Module0Fragment());
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
