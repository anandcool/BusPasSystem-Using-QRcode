package com.example.anand.buspasssystem;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class payment extends AppCompatActivity {

    Button btn_pass,btn_ticket;

    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        id = sharedpreferences.getString("id","");
        Toast.makeText(this, "id"+id, Toast.LENGTH_SHORT).show();
//        Bundle bundle = getIntent().getExtras();
//        final String id = bundle.getString("id");
      //  final String seatnumber = bundle.getString("seatnumber");
     //   final String bus_name = bundle.getString("bus_name");
      //  Toast.makeText(this, ""+seatnumber, Toast.LENGTH_SHORT).show();
        btn_pass = findViewById(R.id.pass);
        btn_ticket = findViewById(R.id.ticket);
        btn_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validity = Mydata.ticketcreate(id);// seat_number using Intent
                Toast.makeText(payment.this, ""+validity, Toast.LENGTH_SHORT).show();
                Intent in = new Intent(payment.this,ChoseBus.class);
                in.putExtra("validity",validity);
                in.putExtra("user_id",id);
                startActivity(in);
            }
        });
        btn_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String validity = Mydata.passcreate(id);// seat_number using Intent
                Toast.makeText(payment.this, "validity"+validity, Toast.LENGTH_SHORT).show();
                Intent in = new Intent(payment.this,ticketgenerate.class);
                in.putExtra("validity",validity);
                in.putExtra("user_id",id);
                startActivity(in);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.logout){
            Toast.makeText(this, "Logout Succeessful", Toast.LENGTH_SHORT).show();
            sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.remove("id");
            editor.commit();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        if(item.getItemId() == R.id.stauts){
            String str = Mydata.checkpassstatus(id);
            //Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();
            String[] str1 =str.split(",");
            String rides = str1[0];
            String[] date = str1[1].split(" ");
           // Toast.makeText(this, ""+date[0], Toast.LENGTH_SHORT).show();
            AlertDialog.Builder b=new AlertDialog.Builder(payment.this);
            b.setTitle("Status");
            b.setMessage("You have "+rides+" rides left and your pass is expired at "+date[0]);
            b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            b.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
