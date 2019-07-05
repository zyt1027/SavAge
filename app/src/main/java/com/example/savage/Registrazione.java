package com.example.savage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

                Date d=new Date();
                try {
                    SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");
                    d= s.parse(dataNascita.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                User u=new User(nomeUtente.getText().toString(),numTelUtente.getText().toString(),
                        d,emailUtente.getText().toString(),passwordUtente.getText().toString());






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



}
