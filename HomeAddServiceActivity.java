package com.example.bancotiempo.user.home;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.bancotiempo.R;
import com.example.bancotiempo.user.servicio.AddServicio;


public class HomeAddServiceActivity extends Fragment {

    Button postService;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_publicar_servicio,null);
        getActivity().setTitle("Publicar Servicio");

        postService =  (Button)v.findViewById(R.id.postservicio);

        postService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddServicio.class));
            }
        });

        return v;
    }
}