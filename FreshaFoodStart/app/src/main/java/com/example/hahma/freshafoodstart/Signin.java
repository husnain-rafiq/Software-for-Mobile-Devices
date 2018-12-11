package com.example.hahma.freshafoodstart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hahma.freshafoodstart.Common.Common;
import com.example.hahma.freshafoodstart.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signin extends AppCompatActivity {

    EditText phone_no,pass1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        phone_no=(EditText) findViewById(R.id.text2);
        pass1=(EditText)findViewById(R.id.text3);
        btn1=(Button)findViewById(R.id.button3);

        //firebase Init

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                table_user.addValueEventListener(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {

                        if(dataSnapshot.child(phone_no.getText().toString()).exists())
                        {
                            User user =dataSnapshot.child(phone_no.getText().toString()).getValue(User.class);
                            user.setPhone(phone_no.getText().toString());
                            if(user.getPassword().equals(pass1.getText().toString()))
                            {
                                Intent homeIntent= new Intent(Signin.this,Home.class);
                                Common.cuurentUser=user;
                                startActivity(homeIntent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(Signin.this,"Sign in Failed!",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Signin.this,"USER NOT EXIST!",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError)
                    {


                    }
                });
            }
        });
    }
}



