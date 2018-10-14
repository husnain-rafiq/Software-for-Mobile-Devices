package com.example.dell.datastorage;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import android.app.AlertDialog;

public class CustomerData extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName,editPassord,editEmail,editTextId;
    Button btnviewAll;
    Button btnDelete;
    Button btnviewUpdate;
    boolean flag1,flag2,flag3,flag4=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_data);


        myDb = new DatabaseHelper(this);
        editName = (EditText)findViewById(R.id.customerUserName);
        editPassord = (EditText)findViewById(R.id.customerPassord);
        editEmail = (EditText)findViewById(R.id.customerEmail);
        editTextId = (EditText)findViewById(R.id.customerId);

        btnviewAll = (Button)findViewById(R.id.btn_viewAll);
        btnDelete=(Button)findViewById(R.id.btn_Delete);
        btnviewUpdate=(Button)findViewById(R.id.btn_Update);

        viewAll();
        UpdateData();
        DeleteData();




    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if(editName.getText().toString().equals(""))
                        {
                            Toast.makeText(CustomerData.this, "Please Enter User_name", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag1=true;
                        }

                        if(editPassord.getText().toString().equals(""))
                        {
                            Toast.makeText(CustomerData.this, "Please Enter the Password", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag2=true;
                        }

                        if(editEmail.getText().toString().equals(""))
                        {
                            Toast.makeText(CustomerData.this, "Please Enter Email or Contact Number", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag3=true;
                        }
                        if(editTextId.getText().toString().equals(""))
                        {
                            Toast.makeText(CustomerData.this, "Please Enter the valid ID", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag4=true;
                        }

                        if(flag1==true && flag2==true && flag3==true && flag4==true)
                        {
                            Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                            if(deletedRows > 0)
                                Toast.makeText(CustomerData.this,"Data Deleted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(CustomerData.this,"Data not Deleted",Toast.LENGTH_LONG).show();

                        }

                    }
                }
        );
    }



    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {

                        if(editName.getText().toString().equals(""))
                        {
                            Toast.makeText(CustomerData.this, "Please Enter User_name", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag1=true;
                        }

                        if(editPassord.getText().toString().equals(""))
                        {
                            Toast.makeText(CustomerData.this, "Please Enter the Password", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag2=true;
                        }

                        if(editEmail.getText().toString().equals(""))
                        {
                            Toast.makeText(CustomerData.this, "Please Enter Email or Contact Number", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag3=true;
                        }
                        if(editTextId.getText().toString().equals(""))
                        {
                            Toast.makeText(CustomerData.this, "Please Enter the valid ID", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            flag4=true;
                        }

                        if(flag1==true && flag2==true && flag3==true && flag4==true)
                        {
                            boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                    editName.getText().toString(),
                                    editPassord.getText().toString(),editEmail.getText().toString());
                            if(isUpdate == true)
                                Toast.makeText(CustomerData.this,"Data Update",Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(CustomerData.this,"Data not Updated",Toast.LENGTH_LONG).show();

                        }

                    }
                }
        );
    }


    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Password :"+ res.getString(2)+"\n");
                            buffer.append("Email :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }


    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }






}
