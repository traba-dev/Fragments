package com.example.fragments.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragments.R;
import com.example.fragments.Utils.Utils;


public class DataFragment extends Fragment {

    private EditText name;
    private Button btnSend;
    private DataListener callback;
    private Context cont;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            cont = context;
            callback = (DataListener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_data,container,false);

        name = (EditText) v.findViewById(R.id.editName);
        btnSend = (Button) v.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNameEmpty(name.getText().toString()))
                    sendText(name.getText().toString());
                else
                    Toast.makeText(cont, Utils.messageEmpty(cont),Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    private boolean isNameEmpty(String name){
        return TextUtils.isEmpty(name);
    }

    private void sendText(String text) {
        callback.sendData(text);
    }

    public interface DataListener {
        void sendData(String text);
    }
}
