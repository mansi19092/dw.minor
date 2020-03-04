package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private Spinner spinner1;
    Connection con;
    EditText Mail,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1=findViewById(R.id.Signup);
        Mail=(EditText)findViewById(R.id.loginEmail) ;
        pass=(EditText)findViewById(R.id.loginPassword) ;
//        ip="192.168.56.1";

        List<String> show=new ArrayList<>();
        show.add(0,"SignUp");
        show.add("Teacher");
        show.add("Student");
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,show);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).equals("SignUp"))
                {
                    //Do nothing
                }
                else
                {
                    String item=adapterView.getItemAtPosition(i).toString();
                    //on the basis of selected item do something
                    if (item=="Teacher")
                    {
                        Intent intent=new Intent(MainActivity.this,signup.class);
                        startActivity(intent);
                    }
                    if (item=="Student")
                    {
                        Intent intent=new Intent(MainActivity.this,signups.class);
                        startActivity(intent);
                    }
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

    }
    public void funclogin(View view)
    {
        String mail=Mail.getText().toString();
        String passw=pass.getText().toString();
        String type="login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,mail,passw);
    }
}
