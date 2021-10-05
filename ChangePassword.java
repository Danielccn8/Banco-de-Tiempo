package com.example.bancotiempo.user.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.example.bancotiempo.R;
import com.google.firebase.firestore.FirebaseFirestore;

public class ChangePassword extends AppCompatActivity {

    EditText alias, nexterior, descripcion, pais, estado, cpp, calle01, calle02, referencias;
    Button updPass;
    FirebaseAuth FAuth;
    FirebaseFirestore databaseReference;
    FirebaseDatabase firebaseDatabase;
    String ali, next, desc, country, cal01, cal02, ref, state;
    Usuarios usuarios;
    int pincode;
    String role = "Cliente";

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_password);


        databaseReference = FirebaseFirestore.getInstance();
        FAuth = FirebaseAuth.getInstance();


        updPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                createNewAddress();


            }
        });



    }

    private void createNewAddress()
    {

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        /*AddressDetails addetails = new AddressDetails(ali,next,desc,country,state,cal01,cal02,ref,pincode);
        String password = "meow";
        databaseReference.collection("usuarios").document(userId)
                .update(password).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(context,"Se ha modificado tu direccion!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });*/
    }


}