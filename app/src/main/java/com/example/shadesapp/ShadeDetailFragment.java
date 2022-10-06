package com.example.shadesapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShadeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShadeDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "description";
    private static final String ARG_PARAM2 = "color_id";

    // TODO: Rename and change types of parameters
    private String description;
    private int colorID;

    public ShadeDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ShadeDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShadeDetailFragment newInstance(String param1, int param2) {
        ShadeDetailFragment fragment = new ShadeDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            description = getArguments().getString(ARG_PARAM1);
            colorID = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shade_detail, container, false);
        int color = colorID != 0 ? requireActivity().getColor(colorID) : requireActivity().getColor(R.color.black);

        TextView detail = view.findViewById(R.id.description_text);
        detail.setText(description);
        detail.setBackgroundColor(color);
        if(colorID == R.color.yellow) detail.setTextColor(requireActivity().getColor(R.color.black));
        else{detail.setTextColor(requireActivity().getColor(R.color.white));}
        Button button = view.findViewById(R.id.back_button);
        if(button != null){
            button.setOnClickListener(this::goBack);
            button.setBackgroundColor(color);
        }
        return view;
    }

    public void goBack(View view){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.portrait_container, new ShadeListFragment()).commit();
    }
}