package com.example.fragments.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.fragments.Fragments.DataFragment;
import com.example.fragments.Fragments.DetailsFragment;
import com.example.fragments.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultiPanel();
    }

    @Override
    public void sendData(String name) {
        //Recibe los datos del DataFragment y se los envía al detailsFragment

        if (isMultiPanel){
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(name);
        }else {
            Intent intent = new Intent(MainActivity.this, OtherActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);
        }
    }

    private void setMultiPanel(){
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }
}
