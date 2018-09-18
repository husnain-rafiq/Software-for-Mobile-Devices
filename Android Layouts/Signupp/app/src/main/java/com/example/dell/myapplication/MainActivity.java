package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    Button relativeLayoutButton1,constraintLayoutButton1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        constraintLayoutButton1=(Button) findViewById(R.id.ConstraintLayoutbutton);
        relativeLayoutButton1=(Button) findViewById(R.id.RelativeLayoutbutton);

        constraintLayoutButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,ConstraintLayout.class);
                startActivity(intent);
            }
        });

        relativeLayoutButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,RealtiveLayout.class);
                startActivity(intent);
            }
        });



    }
}
