package ru.mirea.komissarchuk.mireaproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlackFragmentPlayer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlackFragmentPlayer extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button buttonPlay;
    private Button buttonStop;
    private TextView textView;

    public BlackFragmentPlayer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment player.
     */
    // TODO: Rename and change types and number of parameters
    public static BlackFragmentPlayer newInstance(String param1, String param2) {
        BlackFragmentPlayer fragment = new BlackFragmentPlayer();
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
        // Inflate the layout for this fragment*
        return inflater.inflate(R.layout.fragment_player, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonPlay = (Button) view.findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this::onClickPlay);
        buttonStop = (Button) view.findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(this::onClickStop);
        textView = (TextView) view.findViewById(R.id.textViewDisplay);
    }

    public void onClickPlay(View view) {
        ((MainActivity)getActivity()).startService(
                new Intent((MainActivity)getActivity(), PlayerService.class)
        );
        textView.setText("Playing in progress");

    }
    public void onClickStop(View view) {
        ((MainActivity)getActivity()).stopService(
                new Intent((MainActivity)getActivity(), PlayerService.class)
        );
        textView.setText("Stopped");
    }

}