package com.example.savage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class StartActivity extends AppCompatActivity {


    EditText email;
    EditText password;
    Button logIn;
    Button signUp;
    User u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.editEmailLog);
        password=findViewById(R.id.editPasswordLog);
        logIn=findViewById(R.id.btnLogin);
        signUp=findViewById(R.id.btnNewRegister);
    }


    protected  void onStart(){

        super.onStart();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UtilFunction.inputControll(email.getText().toString(),password.getText().toString(),StartActivity.this)){
                    SQLiteDatabase db=DatabaseUserHelper.createDBUser('w',StartActivity.this,'1');
                    Cursor c=db.rawQuery("SELECT * FROM User WHERE email= ?",new String[]{u.getEmail()});
                    if(c.getCount()!=0){
                        String id=c.getString(c.getColumnIndex("userCode"));
                        Toast.makeText(StartActivity.this,id,Toast.LENGTH_LONG);
                    }
                }

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this,Registrazione.class);
                startActivityForResult(i,123);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==123){
            if(resultCode==RESULT_OK){
                u=data.getExtras().getParcelable("User");
                this.email.setText(u.getEmail());
                this.password.setText(u.getPassword());
            }

        }
    }
}


