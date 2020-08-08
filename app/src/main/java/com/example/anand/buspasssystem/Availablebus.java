package com.example.anand.buspasssystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Availablebus extends AppCompatActivity {

    Spinner busname;
    String [] availablebus;
    Button btnbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availablebus);
        btnbook = findViewById(R.id.book);
        Bundle bundle = getIntent().getExtras();
       final String busto = bundle.getString("to");
        final String busfrom = bundle.getString("from");
        final String userid = bundle.getString("user_id");
        final String validity = bundle.getString("validity");
        String check = Mydata.checkbus(busfrom,busto);
        Toast.makeText(this, ""+userid, Toast.LENGTH_SHORT).show();
        if(check.equals("No Bus Available")){
            TextView tv = new TextView(Availablebus.this);
            tv.setText("Sorry! At that no service Available");
        }
        else {
        busname = findViewById(R.id.busname);
        String busname1 = Mydata.checkbus(""+busfrom,""+busto);//get the name from and also the value from the database
            availablebus = busname1.split(",");
     //       Toast.makeText(this, ""+availablebus[0], Toast.LENGTH_SHORT).show();
            ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,availablebus);
            adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
            busname.setAdapter(adapter);
        }
        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Availablebus.this,seatbooking.class);
                in.putExtra("user_id",""+userid);
                in.putExtra("bus_name",""+busname.getSelectedItem().toString());
                in.putExtra("validity",""+validity);
                startActivity(in);
            }
        });
    }
}
