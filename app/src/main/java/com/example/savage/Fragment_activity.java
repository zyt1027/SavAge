package com.example.savage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment_activity extends Fragment {



    private ArrayList<AlarmActivity> todayActivityList=new ArrayList<>();
    private ListView listViewTodayActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void onStart(){
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.app_todayactivity_fragment, container, false);
        loadTodayActivity(view);
        return view;
    }



    private void loadTodayActivity(View view){

        SQLiteDatabase db=DatabaseUserHelper.loadDb('r', Fragment_activity.super.getContext(),1);
        Cursor c=db.rawQuery("SELECT * FROM ActivityUser WHERE userCode= ? AND Date(alarmData)=?",new String[]{String.valueOf(userCode), UtilFunction.todayDate()});

        while(c.moveToNext()){
            AlarmActivity a=new AlarmActivity();
            todayActivityList.add(a);
        }

        listViewTodayActivity = (ListView)view.findViewById(R.id.listViewActivityToday);
        AlarmActivityAdapter listAdapter=new AlarmActivityAdapter(getActivity().getApplicationContext(),R.layout.activity_list_item,todayActivityList);
        listViewTodayActivity.setAdapter(listAdapter);




    }



}
