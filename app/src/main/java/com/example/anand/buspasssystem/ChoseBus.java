package com.example.anand.buspasssystem;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ChoseBus extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp,sp1;
    String[] busfrom,busto;
    Button btn;
    TextView tvdate,tvtime;
    public int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_bus);
        Bundle bundle = getIntent().getExtras();
        final String user_id = bundle.getString("user_id");
        final String validity = bundle.getString("validity");
       Toast.makeText(this, ""+user_id, Toast.LENGTH_SHORT).show();
        String busarrivalplaces = Mydata.busarrivalplaces();
        String busdestination = Mydata.busdestinationplaces();
        busfrom = busarrivalplaces.split(",");
        busto = busdestination.split(",");
        sp = findViewById(R.id.sp);
        sp1 = findViewById(R.id.sp1);
        tvdate=findViewById(R.id.datepicker);
        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                String formattedDate = df.format(c);
                String ddmmyyyy[] = formattedDate.split("-");
                DatePickerDialog datePickerDialog =
                        new DatePickerDialog(ChoseBus.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tvdate.setText(dayOfMonth +"/"+(month+1)+"/"+year);
                            }
                        }, Integer.parseInt(ddmmyyyy[2]), Integer.parseInt(ddmmyyyy[1])-1, Integer.parseInt(ddmmyyyy[0]));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()+1000);
                datePickerDialog.show();
            }
        });
        tvtime=findViewById(R.id.timepicker);
        tvtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("HH", Locale.US);
                final String formattedDate = df.format(c);
                TimePickerDialog timePickerDialog = new TimePickerDialog(ChoseBus.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvtime.setText(hourOfDay+":"+minute);
                    }
                },Integer.parseInt(formattedDate),0,false);
                timePickerDialog.show();
            }
        });
        btn = findViewById(R.id.btngonxt);
        sp.setOnItemSelectedListener(this);
        sp1.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,busto);
        ArrayAdapter adapter1 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,busfrom);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        adapter1.setDropDownViewResource(android.R.layout.select_dialog_item);
        sp.setAdapter(adapter);
        sp1.setAdapter(adapter1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ChoseBus.this,Availablebus.class);
                in.putExtra("to",sp.getSelectedItem().toString());
                in.putExtra("from",sp1.getSelectedItem().toString());
                in.putExtra("user_id",user_id);
                in.putExtra("validity",validity);
                startActivity(in);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    //    Toast.makeText(this, ""+adapterView.getItemIdAtPosition(i), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

