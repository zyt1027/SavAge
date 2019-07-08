package com.example.savage;

import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;


import androidx.appcompat.widget.Toolbar;

public class HomePanel extends AppCompatActivity {


    FragmentManager fragManager=getFragmentManager();
    FragmentTransaction fragmentTransaction = fragManager.beginTransaction();

    private int userCode;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_panel);
        Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        userCode=new Intent().getIntExtra("userCode",0);
        createActivityTable();


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);
        return true;
    }




    protected void onStart(){
        super.onStart();
        Fragment_activity appFragment=new Fragment_activity();
        //passaggio dei parametri tra fragment e activity
        Bundle b=new Bundle();
        b.putInt("userCode",userCode);
        appFragment.setArguments(b);
        fragmentTransaction.add(R.id.homePanel,appFragment);
        fragmentTransaction.commit();




    }



    private void createActivityTable(){
        SQLiteDatabase db= DatabaseUserHelper.loadDb('w',this,1);

        String sql="CREATE TABLE IF NOT EXISTS ActivityUser(ActivityCode int primary key UNIQUE, userCode varchar(10),alarmData text,descprition varchar(256))";
        db.execSQL(sql);

    }

}
