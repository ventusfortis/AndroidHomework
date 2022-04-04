package ru.mirea.komissarchuk.mireaproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentCalculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentCalculator extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView result;
    private EditText first;
    private EditText second;
    private EditText operation;
    private Button button;

    public BlankFragmentCalculator() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentCalculator.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentCalculator newInstance(String param1, String param2) {
        BlankFragmentCalculator fragment = new BlankFragmentCalculator();
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
        return inflater.inflate(R.layout.fragment_blank_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        first = (EditText) view.findViewById(R.id.editTextFirstValue);
        second = (EditText) view.findViewById(R.id.editTextSecondValue);
        operation = (EditText) view.findViewById(R.id.editTextOperation);
        result = (TextView) view.findViewById(R.id.textViewResult);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        String op = operation.getText().toString();
        String res;
        switch (op) {
            case "+":
                res = Double.toString(Double.parseDouble(first.getText().toString())
                        + Double.parseDouble(second.getText().toString()));
                break;
            case "-":
                res = Double.toString(Double.parseDouble(first.getText().toString())
                        - Double.parseDouble(second.getText().toString()));
                break;
            case "/":
                res = Double.toString(Double.parseDouble(first.getText().toString())
                        / Integer.parseInt(second.getText().toString()));
                break;
            case "*":
                res = Double.toString(Double.parseDouble(first.getText().toString())
                        * Double.parseDouble(second.getText().toString()));
                break;
            default:
                res = "";
                break;
        }
        result.setText("Результат: " + res);
        result.setVisibility(View.VISIBLE);
    }
}