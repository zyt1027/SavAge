package com.example.savage;

import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.widget.Toolbar;

public class HomePanel extends AppCompatActivity {


    FragmentManager fragManager=getFragmentManager();
    FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_panel);

        Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);
        return true;
    }

    protected void onStart(){
        super.onStart();
        appMenuBar appFragment=new appMenuBar();
        fragmentTransaction.add(R.id.homePanel,appFragment);
        fragmentTransaction.commit();
    }
}
