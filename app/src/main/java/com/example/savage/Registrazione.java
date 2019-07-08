package com.example.savage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Registrazione extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    EditText dataNascita;
    EditText nomeUtente;
    EditText emailUtente;
    RadioGroup sessoUtent;
    EditText numTelUtente;
    EditText passwordUtente;
    EditText passwordRepeat;
    Button registrationUtente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);
        dataNascita=findViewById(R.id.editDataNascitaReg);
        nomeUtente=findViewById(R.id.editNomeReg);
        emailUtente=findViewById(R.id.editEmailReg);
        sessoUtent=findViewById(R.id.rdbGroupSessoReg);
        numTelUtente=findViewById(R.id.editNumTelReg);
        passwordUtente=findViewById(R.id.editPasswordReg);
        passwordRepeat=findViewById(R.id.editpasswordRepeatReg);
        registrationUtente=findViewById(R.id.btnNewRegisterReg);


    }


    protected void onStart(){
        super.onStart();
        dataNascita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                DatePickerDialog datePicker = new DatePickerDialog(Registrazione.this,Registrazione.this,c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));
                datePicker.show();
            }
        });

        registrationUtente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date d = new Date();
                try {
                    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
                    d = s.parse(dataNascita.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (UtilFunction.inputControll(emailUtente.getText().toString(), passwordUtente.getText().toString(), Registrazione.this)) {

                    final User u = new User(nomeUtente.getText().toString(), numTelUtente.getText().toString(),
                            d, emailUtente.getText().toString(), passwordUtente.getText().toString());

                    boolean error = false;

                    try {

                        insertDbNewUser(u, DatabaseUserHelper.loadDb('w', Registrazione.this, 1));

                    } catch (Exception e) {
                        error = true;
                        new AlertDialog.Builder(Registrazione.this).setMessage(e.getMessage())
                                .setPositiveButton("OK", null)
                                .create()
                                .show();
                    }

                    if (!error) {
                        new AlertDialog.Builder(Registrazione.this).setMessage("Ok utente registrato")
                                .setPositiveButton("ok nuovo utente: " + u.getUserCode(), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent i = new Intent();
                                        Bundle b = new Bundle();
                                        b.putParcelable("User", u);
                                        i.putExtras(b);
                                        setResult(RESULT_OK, i);
                                        finish();

                                    }
                                })
                                .create()
                                .show();
                    }
                }
            }
        });

    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String m,d,y;

        y=String.valueOf(year);

        month+=1;

        // Per usare simpleDateFormate, il formato della stringa deve essere costruita ad hoc
        if(month<10){
            m='0'+String.valueOf(month);
        }else {
            m=String.valueOf(month);
        }

        if(dayOfMonth<10){
            d='0'+String.valueOf(dayOfMonth);
        }else {
            d=String.valueOf(dayOfMonth);
        }

        String dataN=d+"/"+m+"/"+y;
        dataNascita.setText(dataN);
    }




    private void insertDbNewUser(User u,SQLiteDatabase dbUser){



        //String nome,String numtel,Date dataNasciata,String email,password

        String sql="Insert into User(userCode,nome,numtel,dataNascita, email, password) VALUES ('"+u.getUserCode()+"','"+u.getName()+"',"+u.getNumeroTel()+","+u.getDataNascita().getTime()+",'"+u.getEmail()+"','"+u.getPassword()+"')";

        /*ContentValues val=new ContentValues();
        val.put("userCode",u.getUserCode());
        val.put("email",u.getEmail());
        val.put("password",u.getPassword());
        dbUser.insert("User",null,val);*/

        dbUser.execSQL(sql);
        dbUser.close();

    }






}
