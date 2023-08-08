package sg.edu.rp.c346.id22015529.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnEx3, btnDemo4, btnDemo5 ;
    TextView tvDemo2, tvDemo3, tvEx3, tvDemo4, tvDemo5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1) ;
        btnDemo2 = findViewById(R.id.buttonDemo2) ;
        tvDemo2 = findViewById(R.id.textViewDemo2) ;
        btnDemo3 = findViewById(R.id.buttonDemo3) ;
        tvDemo3 = findViewById(R.id.textViewDemo3) ;
        btnEx3 = findViewById(R.id.buttonExercise3) ;
        tvEx3 = findViewById(R.id.textViewExercise3) ;
        btnDemo4 = findViewById(R.id.buttonDemo4) ;
        tvDemo4 = findViewById(R.id.textViewDemo4) ;
        btnDemo5 = findViewById(R.id.buttonDemo5) ;
        tvDemo5 = findViewById(R.id.textViewDemo5) ;

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this) ;
/*
                myBuilder.setTitle("Demo 1-Simple Dialog") ;
                myBuilder.setMessage("I can develop Android App") ;
                myBuilder.setCancelable(false) ;
                myBuilder.setPositiveButton("Close", null) ;
*/
                myBuilder.setTitle("Congratulations") ;
                myBuilder.setMessage("You have completed a simple Dialog Box") ;
                myBuilder.setCancelable(false) ;
                myBuilder.setPositiveButton("Dismiss", null) ;

                AlertDialog myDialog = myBuilder.create() ;
                myDialog.show() ;
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this) ;
                myBuilder.setTitle("Demo 2 Buttons Dialog") ;
                myBuilder.setMessage("Select one of the Buttons below.") ;
                myBuilder.setCancelable(false) ;

                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.") ;
                    }
                });

                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.") ;
                    }
                });

                myBuilder.setNeutralButton("Cancel", null) ;
                AlertDialog myDialog = myBuilder.create() ;
                myDialog.show() ;
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
                View viewDialog = inflater.inflate(R.layout.input, null) ;

                final EditText etInput = viewDialog.findViewById(R.id.editTextInput) ;

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this) ;
                myBuilder.setView(viewDialog) ;
                myBuilder.setTitle("Demo 3 - Text Input Dialog" ) ;
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = etInput.getText().toString() ;
                        tvDemo3.setText(message) ;
                    }
                });

                myBuilder.setNeutralButton("CANCEL", null) ;
                AlertDialog myDialog = myBuilder.create() ;
                myDialog.show() ;
            }
        });

        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
                View viewDialog = inflater.inflate(R.layout.input2, null) ;

                final EditText etNum1 = viewDialog.findViewById(R.id.editTextNumber1) ;
                final EditText etNum2 = viewDialog.findViewById(R.id.editTextNumber2) ;

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this) ;
                myBuilder.setView(viewDialog) ;
                myBuilder.setTitle("Demo 3 - Text Input Dialog" ) ;
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int num1 = Integer.parseInt(etNum1.getText().toString()) ;
                        int num2 = Integer.parseInt(etNum2.getText().toString()) ;
                        int message = num1 + num2 ;
                        tvEx3.setText("The sum is " + message) ;
                    }
                });

                myBuilder.setNegativeButton("CANCEL", null) ;
                AlertDialog myDialog = myBuilder.create() ;
                myDialog.show() ;
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year) ;
                    }
                };

                Calendar c = Calendar.getInstance() ;
                int currentDay = c.get(Calendar.DAY_OF_MONTH) ;
                int currentMonth = c.get(Calendar.MONTH) ;
                int currentYear = c.get(Calendar.YEAR) ;

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, currentYear, currentMonth, currentDay) ;
                myDateDialog.show() ;
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute) ;
                    }
                };

                Calendar c = Calendar.getInstance() ;
                int currentHour = c.get(Calendar.HOUR) ;
                int currentMinute = c.get(Calendar.MINUTE) ;

                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, currentHour, currentMinute, false) ;
                myTimeDialog.show() ;
            }
        });
    }
}