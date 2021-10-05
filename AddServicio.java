package com.example.bancotiempo.user.servicio;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.bancotiempo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.util.UUID;


public class AddServicio extends AppCompatActivity {

    ImageButton imageButton;
    Button post_service;
    EditText ty,Ubi,Descrip, category,Nombre;
    String tipo,ubicacion,descripcion,nombre,imgurl;
    Uri imageuri;
    private Uri mcropimageuri;
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseFirestore databaseReference;
    FirebaseAuth Fauth;
    StorageReference ref;
    String ChefId , RandomUID, userid, cat;
    CheckBox isportada;
    Boolean bencurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_service);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        Nombre = (EditText)findViewById(R.id.name);
        ty = (EditText)findViewById(R.id.type);
        Ubi = (EditText)findViewById(R.id.location);
        Descrip = (EditText)findViewById(R.id.description);
        post_service = (Button) findViewById(R.id.post);
        category = (EditText) findViewById(R.id.Category);

        isportada=(CheckBox)findViewById(R.id.checkBoxPortada);
        Fauth = FirebaseAuth.getInstance();

        databaseReference = FirebaseFirestore.getInstance();

        try {
            userid = FirebaseAuth.getInstance().getCurrentUser().getUid();

            imageButton = (ImageButton) findViewById(R.id.image_upload);

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //onSelectImageclick(v);
                }
            });

            post_service.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nombre = Nombre.getText().toString().trim();
                    tipo = ty.getText().toString().trim();
                    ubicacion = Ubi.getText().toString().trim();
                    descripcion = Descrip.getText().toString().trim();
                    cat = category.getText().toString().trim();
                    imgurl = "No disponible";


                    if(isportada.isChecked())
                    {
                        bencurso = true;
                    }
                    else
                    {
                        bencurso = false;
                    }

                    if(isValid()){
                        addService();
                    }
                }
            });
        }catch (Exception e){
            Log.e("Error: ",e.getMessage());
        }

    }

    private void addService() {

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Servicio servicio = new Servicio(nombre, tipo, ubicacion, descripcion, cat, bencurso, imgurl);
        databaseReference.collection("usuarios").document(userid).collection("servicios").document()
                .set(servicio.getMap()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(AddServicio.this, "Se ha agregado nuevo servicio!", Toast.LENGTH_SHORT).show();
                finish();
            }

        });
    }


    private boolean isValid() {


        ty.setError("");

        Ubi.setError("");

        Descrip.setError("");

        boolean isValidDescription = false,isValidPrice=false,isValidQuantity=false,isValid=false, isValidCat = false;
        if(TextUtils.isEmpty(tipo)){

            ty.setError("Se requiere descripción");
        }else{
            ty.setError(null);
            isValidDescription=true;
        }
        if(TextUtils.isEmpty(ubicacion)){

            Ubi.setError("Por favor ingresa ubicacion");
        }else{
            isValidQuantity=true;
        }
        if(TextUtils.isEmpty(descripcion)){

            Descrip.setError("Se requiere descripcion");
        }else{
            isValidPrice=true;
        }
        if(TextUtils.isEmpty(cat)){

            Descrip.setError("Se requiere categoria");
        }else{
            isValidCat=true;
        }
        isValid = (isValidDescription && isValidQuantity && isValidPrice && isValidCat)?true:false;
        return isValid;
    }

}