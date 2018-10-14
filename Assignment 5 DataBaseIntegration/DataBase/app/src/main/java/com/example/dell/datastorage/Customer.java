package com.example.dell.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Customer extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName,editPassord,editEmail;
    Button btnAddData;
    boolean flag1,flag2,flag3,flag4=false;
    CheckBox cond_checkbox;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        myDb = new DatabaseHelper(this);
        editName = (EditText)findViewById(R.id.customerUserName);
        editPassord = (EditText)findViewById(R.id.customerPassord);
        editEmail = (EditText)findViewById(R.id.customerEmail);
        btnAddData = (Button)findViewById(R.id.btn_signUp);
        cond_checkbox = (CheckBox)findViewById(R.id.chkBox1);
        AddData();


    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if(editName.getText().toString().equals(""))
                        {
                            Toast.makeText(Customer.this, "Please Enter User_name", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag1=true;
                        }

                        if(editPassord.getText().toString().equals(""))
                        {
                            Toast.makeText(Customer.this, "Please Enter the Password", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag2=true;
                        }

                        if(editEmail.getText().toString().equals(""))
                        {
                            Toast.makeText(Customer.this, "Please Enter Email or Contact Number", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag3=true;
                        }



                        if(flag1==true && flag2==true && flag3==true )
                        {


                            if (cond_checkbox.isChecked())
                            {
                                // true,do the task

                                boolean isInserted = myDb.insertData(editName.getText().toString(),
                                        editPassord.getText().toString(),
                                        editEmail.getText().toString() );
                                if(isInserted == true) {
                                    Toast.makeText(Customer.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(Customer.this,CustomerData.class);
                                    startActivity(intent);
                                }
                                else
                                    Toast.makeText(Customer.this,"Data not Inserted",Toast.LENGTH_LONG).show();


                            } else {

                                Toast.makeText(getApplicationContext(), "Please Accept Terms and Conditions", Toast.LENGTH_SHORT).show();

                            }

                        }








                    }
                }
        );
    }


}
