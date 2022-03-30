package ru.mirea.komissarchuk.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AlertDialogFragment  extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Hello MIREA")
                .setMessage("Where going?")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Going ahead", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((MainActivity)getActivity()).onOkClicked();
                        dialogInterface.cancel();
                    }
                })
                .setNeutralButton("Staying here", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((MainActivity)getActivity()).onNeutralClicked();
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("Going back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((MainActivity)getActivity()).onCancelClicked();
                        dialogInterface.cancel();
                    }
                });
        return builder.create();
    }
}
