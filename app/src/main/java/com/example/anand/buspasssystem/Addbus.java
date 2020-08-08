package com.example.anand.buspasssystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addbus extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    Button btnsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbus);
        et1 = findViewById(R.id.busname);
        et2 = findViewById(R.id.bfrom);
        et3 = findViewById(R.id.bto);
        et4 = findViewById(R.id.btiming);
        btnsubmit = findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et1.getText().toString().isEmpty()){
                  et1.setError("Please Enter the Bus Name");
                }else if(et2.getText().toString().isEmpty()){
                    et2.setError("Please Enter the Location where the Bus Start ");
                }else if(et3.getText().toString().isEmpty()) {
                    et3.setError("Please Enter the Location where the Bus Reached ");
                }else if(et4.getText().toString().isEmpty()){
                    et4.setError("Please Enter the Timing");
                }
                else {
                    String str = Mydata.busadd(et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString());
                    Toast.makeText(Addbus.this, "" + str, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
