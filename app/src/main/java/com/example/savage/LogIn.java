package com.example.savage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {


    EditText email;
    EditText password;
    Button logIn;
    Button signUp;
    User u;
    Button cancel;
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
                if(UtilFunction.inputControll(email.getText().toString(),password.getText().toString(), LogIn.this)){
                    SQLiteDatabase db=DatabaseUserHelper.loadDb('w', LogIn.this,1);
                    Cursor c=db.rawQuery("SELECT * FROM User WHERE email= ?",new String[]{email.getText().toString()});
                    if(c.getCount()==0){
                        new AlertDialog.Builder(LogIn.this)
                                .setMessage("Errore utente non esiste")
                                .setPositiveButton("OK",null)
                                .create()
                                .show();
                    }else {
                        while(c.moveToNext()){
                            Log.d("pass",c.getString(c.getColumnIndex("password")));
                            if(c.getString(c.getColumnIndex("password")).equals(password.getText().toString())) {
                                String id = c.getString(c.getColumnIndex("userCode"));
                                db.close();
                                Intent i=new Intent(LogIn.this,HomePanel.class);
                                i.putExtra("userCode",id);
                                startActivity(i);
                            }else{
                                new AlertDialog.Builder(LogIn.this)
                                        .setPositiveButton("Ok",null)
                                        .setMessage("Errore password non correto")
                                        .create()
                                        .show();
                            }

                        }
                    }



                }

            }
        });

        signUp.setOnClickListener(v -> {
            Intent i=new Intent(LogIn.this,Registrazione.class);
            startActivityForResult(i,123);
        });

        /*
        cancel.setOnClickListener((v)->{
            SQLiteDatabase db=DatabaseUserHelper.loadDb('w',LogIn.this,1);
            db.setVersion(1);
        });*/

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


