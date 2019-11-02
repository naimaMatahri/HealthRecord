package com.example.personalhealthrecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Appointments extends AppCompatActivity {

    Toolbar toolBar;
    Button button;
    ListView futureListView;
    Button submitButton;
    EditText dateText, timeText, locationText, reasonText;
    String locationString, reasonString, time, date;

    ArrayList<AddAppointment> appointmentsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        toolBar = (Toolbar) findViewById(R.id.appointments);
        toolBar.setTitle("Appointments");

        futureListView = (ListView) findViewById(R.id.futureAppointmentList);

        dateText = (EditText) findViewById(R.id.date);
        timeText = (EditText) findViewById(R.id.time);
        locationText = (EditText) findViewById(R.id.location);
        reasonText = (EditText) findViewById(R.id.reason);

        submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                locationString = locationText.getText().toString();
                reasonString = reasonText.getText().toString();
                time = timeText.getText().toString();
                date = dateText.getText().toString();

                if (date.length() != 0 && time.length() != 0 && locationString.length() != 0 &&
                        reasonString.length() != 0) {

                    AddAppointment addAppointment = new AddAppointment(date, time, locationString, reasonString);
                    appointmentsList.add(addAppointment);
                    UserListAdapter adapter = new UserListAdapter(Appointments.this, R.layout.adapter1, appointmentsList);
                    futureListView.setAdapter(adapter);

                    locationText.getText().clear();
                    reasonText.getText().clear();
                    timeText.getText().clear();
                    dateText.getText().clear();

                } else {
                    toastMessage("Field is empty");
                }

                if (appointmentsList.contains(locationString) || appointmentsList.contains(reasonString) ||
                        appointmentsList.contains(time) || appointmentsList.contains(date)) {

                    Toast.makeText(getBaseContext(), "Date Already exists", Toast.LENGTH_LONG).show();

                }
            }
        });

        button = (Button) findViewById(R.id.addApointement);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Popup.class);
                startActivity(intent);
            }
        });
    }

    private void toastMessage(String message) {
        Toast.makeText(Appointments.this, message, Toast.LENGTH_LONG).show();
    }
}
