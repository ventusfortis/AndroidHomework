package ru.mirea.komissarchuk.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ru.mirea.komissarchuk.mireaproject.databinding.FragmentSettingsBinding;

public class Settings extends Fragment {
    private SharedPreferences preferences;
    private FragmentSettingsBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        preferences = getActivity().getPreferences(Context.MODE_PRIVATE);

        binding.seekBarVolume.setOnSeekBarChangeListener(seekBarChangeListener);


        binding.buttonLoad.setOnClickListener(this::onLoadText);

        return root;
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            TextView textView = binding.textNumber;
            textView.setText(String.valueOf(progress));
            preferences.edit().putInt("volume", progress).apply();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public void onLoadText(View view) {
        Integer savedVolume = preferences.getInt("volume", 0);
        String savedText = preferences.getString("label", "");

        binding.seekBarVolume.setProgress(savedVolume);
        binding.textNumber.setText(String.valueOf(savedVolume));
        binding.editTextLabel.setText(savedText);
    }

    @Override
    public void onDestroyView() {
        binding.editTextLabel.getText();
        preferences.edit().putString("label_text", binding.editTextLabel.getText().toString()).apply();
        super.onDestroyView();
        binding = null;
    }
}