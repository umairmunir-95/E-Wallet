package com.example.umairmunirahmad.e_wallet.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.umairmunirahmad.e_wallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogueManager {

    public static void showCategoryDialog(Context context,String categoryType)
    {
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.dialog_category, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptsView);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        ImageView closeImageView = promptsView.findViewById(R.id.iv_close);
        TextView titleTextView = promptsView.findViewById(R.id.tv_option);
        EditText bodyEditText = promptsView.findViewById(R.id.et_body);
        Button cancelButton = promptsView.findViewById(R.id.btn_cancel);
        Button saveButton = promptsView.findViewById(R.id.btn_save);
        closeImageView.setVisibility(View.GONE);
        if(categoryType.equals("INCOMING"))
        {
            titleTextView.setText(context.getResources().getString(R.string.add_incoming_category));
        }
        else if(categoryType.equals("OUTGOING"))
        {
            titleTextView.setText(context.getResources().getString(R.string.add_outgoing_category));
        }
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        alertDialogBuilder.setCancelable(true);
        alertDialog.show();

    }

}
