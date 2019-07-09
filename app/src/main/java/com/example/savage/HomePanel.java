package com.example.savage;

import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.widget.Toolbar;

public class HomePanel extends AppCompatActivity implements Fragment_addAlarm.OnFragmentInteractionListener {


    private FragmentManager fragManager=getFragmentManager();
    private FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
    private FloatingActionButton fl;
    private int userCode;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_panel);
        Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        userCode=new Intent().getIntExtra("userCode",0);
        createActivityTable();
        fl=findViewById(R.id.add_activity_floating);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);
        return true;
    }




    protected void onStart(){
        super.onStart();

        fl.setOnClickListener(v -> {
            Fragment_addAlarm add_fragment=Fragment_addAlarm.newInstance(userCode);
            fragmentTransaction=fragManager.beginTransaction();
            add_fragment.show(fragManager,"add");
        });


    }




    private void createActivityTable(){
        SQLiteDatabase db= DatabaseUserHelper.loadDb('w',this,1);

        String sql="CREATE TABLE IF NOT EXISTS ActivityUser(ActivityCode int primary key UNIQUE, userCode varchar(10),alarmData text,descprition varchar(256))";
        db.execSQL(sql);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this,"msg:"+uri.getFragment(),Toast.LENGTH_LONG).show();
    }
}
