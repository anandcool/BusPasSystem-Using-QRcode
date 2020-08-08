package com.example.anand.buspasssystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class seatbooking extends AppCompatActivity {
    private GridView gridView;
    private Button button;
    String[] al;

    String seatstatus[] = {"y","y","y","y","y","y","y","y","y","y","y","y","y","y","y","y","y","y","y","y"};
    String seatid[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seatbooking);
        Bundle bundle = getIntent().getExtras();
        final String bus_name = bundle.getString("bus_name");
        final String user_id = bundle.getString("user_id");
        final String validity = bundle.getString("validity");
        Toast.makeText(this, "Hello"+user_id, Toast.LENGTH_SHORT).show();
        gridView = (GridView) findViewById(R.id.gridView);
        final GridAdapter adapter = new GridAdapter(seatbooking.this, seatstatus, seatid);
        gridView.setAdapter(adapter);
        final String seat_number  = Mydata.recseats();
        al = seat_number.split(",");
        for(int k=0;k<seatid.length;k++){
            for(int j=0;j<al.length;j++){
                if(seatid[k].equals(al[j])) {
                    //Toast.makeText(this, ""+al[j], Toast.LENGTH_SHORT).show();
                        seatstatus[k] = String.valueOf('n');
                }
            }
        }
        button = findViewById(R.id.selectbt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seatnumber="";
                for (int i=0;i<adapter.getCount();i++){
                    CheckBox checkBox = (CheckBox) adapter.getItem(i);
                    if (checkBox.isChecked()){
                        //seatnumber=seatnumber+","+(i+1);
                        seatnumber = ""+(i+1);
                        String str = Mydata.bookseat(""+bus_name,""+user_id,""+seatnumber);
                        Intent in = new Intent(seatbooking.this,ticketgenerate.class);
                        in.putExtra("seatnumber",""+seatnumber);
                        in.putExtra("bus_name",""+bus_name);
                        in.putExtra("validity",""+validity);
                        in.putExtra("user_id",""+user_id);
                        startActivity(in);
                    }
                    else{
                 //       Toast.makeText(seatbooking.this, "Please Chose any one of the seat", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}


