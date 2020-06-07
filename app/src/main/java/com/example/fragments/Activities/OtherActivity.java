package com.example.fragments.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragments.Fragments.DetailsFragment;
import com.example.fragments.R;

public class OtherActivity extends AppCompatActivity {

    private String text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        if (getIntent().getExtras() != null){
            text = getIntent().getStringExtra("name");
        }

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(text);
    }
}
