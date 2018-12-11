package com.example.hahma.freshafoodstart;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hahma.freshafoodstart.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity
{
    EditText signup_phone_no,signup_name,signup_password;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup_phone_no=(EditText)findViewById(R.id.text4);
        signup_name=(EditText)findViewById(R.id.text5);
        signup_password=(EditText)findViewById(R.id.text6);

        button4=(Button)findViewById(R.id.button4);

        //firebase Init

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                final ProgressDialog mDialog= new ProgressDialog(Signup.this);
                mDialog.setMessage("Please wait!!");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        if (dataSnapshot.child(signup_phone_no.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(Signup.this, "Phone Number already registered", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDialog.dismiss();
                            User user = new User(signup_name.getText().toString(), signup_password.getText().toString());
                            table_user.child(signup_phone_no.getText().toString()).setValue(user);
                            Toast.makeText(Signup.this, "SIGNUP SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }
        });




    }
}
