package com.example.anand.buspasssystem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class login extends AppCompatActivity {

    EditText email,pass;
    Button btnlogin;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String sp = sharedpreferences.getString("id","");
        Toast.makeText(this, ""+sp, Toast.LENGTH_SHORT).show();
        if(!sp.isEmpty()){
            Intent in = new Intent(login.this,payment.class);
            startActivity(in);
        }
        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(email.getText().toString().isEmpty()){
                    email.setError("Please Enter the email Id");
                }else if (!email.getText().toString().matches(emailPattern)) {
                    email.setError("Please Enter valid emailId");
                }
                else if(pass.getText().toString().isEmpty()){
                    pass.setError("Please Enter the Password");
                }
                else {
                    String str = Mydata.login(email.getText().toString(), pass.getText().toString());
                    if (str.equals("admin")) { // if email and password is equal to admin credintails then user go to admin panel
                        Intent in = new Intent(login.this, Addbus.class);
                        startActivity(in);
                    } else if (str.equals("conductor")) { //  if email and password is equal to conductor credintails then user go to conductor panel
                        Intent in = new Intent(login.this, conductor.class);
                        startActivity(in);
                    }else if(str.equals("invalid")){
                        Toast.makeText(login.this, "Email and Password is not Match", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        String id = Mydata.getId(email.getText().toString(), pass.getText().toString());
                        editor.putString("id",id);
                        editor.commit();
                        final String id1 = sharedpreferences.getString("id","");
                     //   Toast.makeText(login.this, ""+id1, Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(login.this, payment.class);
                       // in.putExtra("id+", id);
                        startActivity(in);
                    }
                }
            }
        });
    }
}
