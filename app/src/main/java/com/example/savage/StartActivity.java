package com.example.savage;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.regex.Pattern;

public class StartActivity extends AppCompatActivity {


    EditText email;
    EditText password;
    Button logIn;
    Button signUp;
    private static RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.editTEmail);
        password=findViewById(R.id.editTPassword);
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
