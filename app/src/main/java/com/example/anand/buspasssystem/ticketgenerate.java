
package com.example.anand.buspasssystem;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class ticketgenerate extends AppCompatActivity {
    EditText et;
    Button btn,bus;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketgenerate);// manually give the permission of storage using phone
        iv = findViewById(R.id.iv);
        bus = findViewById(R.id.bus);
        Bundle bundle = getIntent().getExtras();
        String validity = bundle.getString("validity");
        final String user_id = bundle.getString("user_id");
        Toast.makeText(this, "user_id -:"+user_id+"Validity"+validity, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, ""+validity, Toast.LENGTH_SHORT).show();
        final String[] ImagePath = new String[1];
        final Uri[] URI = new Uri[1];
                String text = validity+","+user_id; // make text value is equal to seat_number
                if(text!=null){
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    BitMatrix bitMatrix = null;
                    try {
                        bitMatrix = multiFormatWriter.encode(text,BarcodeFormat.QR_CODE,1000,1500);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        iv.setImageBitmap(bitmap);
                        ImagePath[0] = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "demo_image", "demo_image");
                        URI[0] = Uri.parse(ImagePath[0]);
                //       Toast.makeText(ticketgenerate.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();
                       bus.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               Intent in = new Intent(ticketgenerate.this,thankyou.class);
                               startActivity(in);
                           }
                       });
                    }
                    catch (Exception ex){
                       Toast.makeText(ticketgenerate.this, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
    }

