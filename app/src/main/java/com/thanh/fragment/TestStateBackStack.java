package com.thanh.fragment;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class TestStateBackStack extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstack);
        Button btn1=findViewById(R.id.btn_1);
        Button btn2=findViewById(R.id.btn_2);
        Button btn3=findViewById(R.id.btn_3);
        Button btnBack=findViewById(R.id.btn_back);
        FragmentManager fragmentManager=getSupportFragmentManager();
        btn1.setOnClickListener(v->{
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_host,new FirstFragment())
                    .addToBackStack("1")
                    .commit();
        });
        btn2.setOnClickListener(v->{

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_host,new SecondFragment())
                    .addToBackStack("2")
                    .commitAllowingStateLoss();
        });
        btn3.setOnClickListener(v->{

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_host,new ThirdFragment())
                    .addToBackStack("3")
                    .commit();
        });
        btnBack.setOnClickListener(v->{
            fragmentManager.beginTransaction().remove(fragmentManager.getFragments().get(fragmentManager.getFragments().size()-1)).commit();
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
