package com.example.savage;

import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;


import androidx.appcompat.widget.Toolbar;

public class HomePanel extends AppCompatActivity {


    FragmentManager fragManager=getFragmentManager();
    FragmentTransaction fragmentTransaction = fragManager.beginTransaction();

    private ArrayList<AlarmActivity>todayActivityList=new ArrayList<>(1);
    private ListView listViewTodayActivity;
    private int userCode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_panel);
        Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        userCode=new Intent().getIntExtra("userCode",0);


        Log.d("time",UtilFunction.todayDate());


        createActivityTable();





    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);
        return true;
    }

    protected void onStart(){
        super.onStart();
        Home appFragment=new Home();
        fragmentTransaction.add(R.id.homePanel,appFragment);
        fragmentTransaction.commit();

        loadTodayActivity();



    }


    private void loadTodayActivity(){


        SQLiteDatabase db=DatabaseUserHelper.loadDb('r',this,1);
        Cursor c=db.rawQuery("SELECT * FROM ActivityUser WHERE userCode= ? AND Date(alarmData)=?",new String[]{String.valueOf(userCode), UtilFunction.todayDate()});
        while(c.moveToNext()){
            AlarmActivity a=new AlarmActivity();
            todayActivityList.add(a);
        }
        todayActivityList.add(new AlarmActivity(1, Calendar.getInstance().getTime(),2,"prova prova"));
        AlarmActivityAdapter listAdapter=new AlarmActivityAdapter(this,R.layout.activity_list_item,todayActivityList);

        //Il list view presente in fragment può essere presi con seguenti metodi
        View v=this.getLayoutInflater().inflate(R.layout.app_todayactivity_fragment,null);
        listViewTodayActivity=v.findViewById(R.id.listActivityToday);
        listViewTodayActivity.setAdapter(listAdapter);
    }


    private void createActivityTable(){
        SQLiteDatabase db= DatabaseUserHelper.loadDb('w',this,1);

        String sql="CREATE TABLE IF NOT EXISTS ActivityUser(ActivityCode int primary key UNIQUE, userCode varchar(10),alarmData text,descprition varchar(256))";
        db.execSQL(sql);

    }

}
