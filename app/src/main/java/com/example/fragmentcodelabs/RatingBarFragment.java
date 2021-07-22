package com.example.fragmentcodelabs;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;


public class RatingBarFragment extends Fragment {

    private RatingBar ratingBar;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RatingBarFragment() {
        // Required empty public constructor
    }

    public static RatingBarFragment newInstance(String param1, String param2) {
        RatingBarFragment fragment = new RatingBarFragment();
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
        final View rootView = inflater.inflate(R.layout.fragment_raiting_bar,container,false);
        ratingBar = (RatingBar)rootView.findViewById(R.id.ratingBar);
        addListennerOnButton(ratingBar);
        return rootView;
    }
    public void addListennerOnButton(RatingBar ratingBar)
    {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getActivity(), "RATING IS: " + rating, Toast.LENGTH_LONG).show();
            }
        });
    }

}