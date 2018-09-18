package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ConstraintLayout extends AppCompatActivity {

    EditText editText1,editText2,editText3;
    String name,email,password;

    Button registerButton;
    CheckBox cond_checkbox;

    RadioGroup radioGroup;

    boolean flag1,flag2,flag3,flag4=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        registerButton=(Button) findViewById(R.id.button);

        editText1 = (EditText) findViewById(R.id.editTextName);


        editText2 = (EditText) findViewById(R.id.editTextEmail);


        editText3 = (EditText) findViewById(R.id.editTextPassword);


        cond_checkbox = (CheckBox)findViewById(R.id.checkBox);

        radioGroup=(RadioGroup) findViewById(R.id.radioGender);

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(editText1.getText().toString().equals(""))
                {
                    Toast.makeText(ConstraintLayout.this, "Please Enter User_name", Toast.LENGTH_SHORT).show();
                }
                else {
                    flag1=true;
                }

                if(editText2.getText().toString().equals(""))
                {
                    Toast.makeText(ConstraintLayout.this, "Please Enter Email or Contact Number", Toast.LENGTH_SHORT).show();
                }
                else {
                    flag2=true;
                }

                if(editText3.getText().toString().equals(""))
                {
                    Toast.makeText(ConstraintLayout.this, "Please Enter the Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    flag3=true;
                }


                if (radioGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(ConstraintLayout.this, "Please Select the Gender", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    flag4=true;
                    // one of the radio buttons is checked
                }

                if(flag1==true && flag2==true && flag3==true && flag4==true) {

                    if (cond_checkbox.isChecked()) {
                        // true,do the task

                        name = editText1.getText().toString();
                        email = editText2.getText().toString();
                        password = editText3.getText().toString();

                        Toast.makeText(getApplicationContext(), "Name : " + name + "\nEmail : " + email + "\nPassword : " + password + "\n\nSuccessFul Sign Up", Toast.LENGTH_SHORT).show();


                    } else {

                        Toast.makeText(getApplicationContext(), "Please Accept Terms and Conditions", Toast.LENGTH_SHORT).show();

                    }
                }



            }
        });







    }
}
