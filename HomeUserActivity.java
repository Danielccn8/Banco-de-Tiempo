package com.example.bancotiempo.user.home;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bancotiempo.R;
import com.example.bancotiempo.user.user.ChangePassword;
import com.example.bancotiempo.user.user.HorasActivity;
import com.example.bancotiempo.user.user.Usuarios;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class HomeUserActivity extends Fragment {


    private Button changePass,viewHoras;
    private Context context;
    private RecyclerView direcciones,mpago,rcupones;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.home_user,null);

        setText(v);

        context = container.getContext();
        viewHoras = (Button) v.findViewById(R.id.button3);
        changePass = (Button) v.findViewById(R.id.button2);

        viewHoras(v);
        changePass(v);
        return v;
    }



    public void viewHoras(View view)
    {


        viewHoras.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, HorasActivity.class);
                startActivity(intent);
            }
        });
    }

    public void changePass(View view)
    {


        changePass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, ChangePassword.class);
                startActivity(intent);
            }
        });
    }


    public void setText(View view)
    {
        TextView textView = (TextView) view.findViewById(R.id.userNameTitle);
        textView.setText(Usuarios.getInstance().getNombre());

        TextView textView02 = (TextView) view.findViewById(R.id.textView17);
        textView02.setText(Usuarios.getInstance().getNombre());

        TextView textView03 = (TextView) view.findViewById(R.id.textView19);
        textView03.setText(Usuarios.getInstance().getEmail());

        TextView textView04 = (TextView) view.findViewById(R.id.textView21);
        textView04.setText("722 621 3615");

        TextView textView05 = (TextView) view.findViewById(R.id.textView12);
        textView05.setText("4.8" + " Puntuación");
    }





}