package com.example.personalhealthrecord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Popup extends Activity {

    String locationString, reasonString, time, date;
    ListView listView;
    Button submitButton;
    EditText dateText, timeText, locationText, reasonText;

    UserListAdapter userListAdapter;
    ArrayList<AddAppointment> appointmentsList = appointmentsList = new ArrayList<>();
    ;

    Appointments appointmentsActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        dateText = (EditText) findViewById(R.id.date);
        timeText = (EditText) findViewById(R.id.time);
        locationText = (EditText) findViewById(R.id.location);
        reasonText = (EditText) findViewById(R.id.reason);
        listView = (ListView) findViewById(R.id.futureAppointmentList);


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
                    UserListAdapter adapter = new UserListAdapter(Popup.this, R.layout.adapter1, appointmentsList);
                    listView.setAdapter(adapter);

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

                Intent intent = new Intent(getApplicationContext(), AddAppointment.class);
                startActivity(intent);

            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .7));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);

    }

    private void toastMessage(String message) {
        Toast.makeText(Popup.this, message, Toast.LENGTH_LONG).show();
    }
}
