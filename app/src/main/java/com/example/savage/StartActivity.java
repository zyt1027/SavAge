package com.example.savage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class StartActivity extends AppCompatActivity {


    EditText email;
    EditText password;
    Button logIn;
    Button signUp;
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
                if(inputControll(email.getText().toString(),password.getText().toString())){

                }


            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this,Registrazione.class);
                startActivity(i);
            }
        });

    }

    private boolean inputControll(String email,String password) {
        if (email.isEmpty() || password.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setMessage("Campi non possono essere vuoti")
                    .setPositiveButton("OK", null)
                    .create()
                    .show();
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            new AlertDialog.Builder(this)
                    .setMessage("formato email non supportato")
                    .setPositiveButton("OK", null)
                    .create()
                    .show();
            return false;
        }else if( password.length() < 8){
            new AlertDialog.Builder(this)
                    .setMessage("password deve essere almeno di 8 caratteri")
                    .setPositiveButton("OK", null)
                    .create()
                    .show();
            return false;
        }
        return true;
    }





}


