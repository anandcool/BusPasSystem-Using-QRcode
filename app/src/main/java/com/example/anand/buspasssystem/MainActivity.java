package com.example.anand.buspasssystem;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fname,pass,email,pno;
    Button btn,btnlgn;
    SmsManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.fname);
        pass = findViewById(R.id.pass);
        email = findViewById(R.id.email);
        pno = findViewById(R.id.pno);
        btn = findViewById(R.id.btnsignup);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
        sm = SmsManager.getDefault();
        btnlgn = findViewById(R.id.btnlogin);
        btnlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,login.class);
                startActivity(in);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // validaton process start here
                String MobilePattern = "[0-9]{10}";
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (fname.getText().toString().isEmpty()) {
                    fname.setError("Name Can't be blank");
                } else if (email.getText().toString().isEmpty()) {
                    email.setError("E-mail can't be blank");
                } else if (!email.getText().toString().matches(emailPattern)) {
                    email.setError("Please insert a valid E-mail");
                } else if (pno.getText().toString().isEmpty()) {
                    pno.setError("Phone Number Can't be blank");
                } else if (pno.getText().toString().length() != 10) {
                    pno.setError("Only 10 digit is allowed");
                } else if (!pno.getText().toString().matches(MobilePattern)) {
                    pno.setError("Please Insert a Correct Contact Number");

                } else if (pass.getText().toString().isEmpty()) {
                    pass.setError("Password Can't be blank"); // validation process end here
                }
                else {
                    String str = Mydata.signup(fname.getText().toString(), pass.getText().toString(), email.getText().toString(), pno.getText().toString());
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                    sm.sendTextMessage("" + pno.getText().toString(), null, "Dear " + fname.getText().toString() + " .Thanks for Signup we will respond as soon as possible", null, null);
                    String id = Mydata.getId(email.getText().toString(), pass.getText().toString());
                    Intent in = new Intent(MainActivity.this, payment.class);
                    in.putExtra("id", id);
                    startActivity(in);
                }
            }
        });
    }
}
