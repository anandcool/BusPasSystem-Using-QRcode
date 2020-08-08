package com.example.anand.buspasssystem;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class conductor extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor);
        btn = findViewById(R.id.btn);
        final Activity activity = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                String validty = result.getContents(); // if validty is greater than 1 than fire the function of pass table
                String[] valid = validty.split(",");
                String valid1 = valid[0]; // validity
                String valid2 = valid[1];// user_id
                Toast.makeText(this, ""+valid1+":"+valid2, Toast.LENGTH_SHORT).show();
                if(valid1.equals("1") ){
                    //Toast.makeText(this, "User pass is expired", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "User Verified"+validty, Toast.LENGTH_SHORT).show();
                    String str = Mydata.verifyticket(valid2);
                       Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "User Verified"+validty, Toast.LENGTH_SHORT).show();
                    String str = Mydata.verifyuser(valid2);
                    Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();
                }
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
