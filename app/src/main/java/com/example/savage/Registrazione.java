package com.example.savage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;

public class Registrazione extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    EditText dataNascita;
    EditText nomeUtente;
    EditText emailUtente;
    RadioGroup sessoUtent;
    EditText numTelUtente;
    EditText passwordUtente;
    EditText passwordRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);
        dataNascita=findViewById(R.id.editDataNascitaReg);
        nomeUtente=findViewById(R.id.editNomeReg);
        emailUtente=findViewById(R.id.editEmailLog);
        sessoUtent=findViewById(R.id.rdbGroupSessoReg);
        numTelUtente=findViewById(R.id.editNumTelReg);
        passwordUtente=findViewById(R.id.editPasswordReg);
        passwordRepeat=findViewById(R.id.editpasswordRepeatReg);

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
        User u=new User(nomeUtente.getText().toString(),numTelUtente.getText().toString(),dataNascita.getText().toString()
                ,emailUtente.getText().toString(),passwordUtente.getText().toString());
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month+=1;
        String dataN=dayOfMonth+"/"+month+"/"+year;
        dataNascita.setText(dataN);
    }



}
