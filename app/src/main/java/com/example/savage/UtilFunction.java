package com.example.savage;

import android.content.Context;
import android.util.Patterns;

import androidx.appcompat.app.AlertDialog;

public class UtilFunction {

    public static boolean inputControll(String email, String password, Context c) {
        if (email.isEmpty() || password.isEmpty()) {
            new AlertDialog.Builder(c)
                    .setMessage("Campi non possono essere vuoti")
                    .setPositiveButton("OK", null)
                    .create()
                    .show();
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            new AlertDialog.Builder(c)
                    .setMessage("formato email non supportato")
                    .setPositiveButton("OK", null)
                    .create()
                    .show();
            return false;
        }else if( password.length() < 8){
            new AlertDialog.Builder(c)
                    .setMessage("password deve essere almeno di 8 caratteri")
                    .setPositiveButton("OK", null)
                    .create()
                    .show();
            return false;
        }
        return true;
    }
}
