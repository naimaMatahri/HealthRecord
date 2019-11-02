package com.example.personalhealthrecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {


    EditText firstName, lastName, phoneNumber, password, email, username;
    Button submitRegister;
    DatabaseHelper databaseHelper;
    private static final String TAG = "Signup";
    DatabaseReference reference;
    UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        submitRegister = (Button) findViewById(R.id.btnSubmit);
        userInfo = new UserInfo();
        FirebaseApp.initializeApp(this);
        reference = FirebaseDatabase.getInstance().getReference().child("UserInfo");

        submitRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstNameEntry = firstName.getText().toString();
                String lastNameEntry = lastName.getText().toString();
                String usernameEntry = username.getText().toString();
                String passwordEntry = password.getText().toString();
                int phoneEntry = Integer.parseInt(phoneNumber.getText().toString());
                String emailEntry = email.getText().toString();

                userInfo.setFirstName(firstNameEntry);
                userInfo.setLastName(lastNameEntry);
                userInfo.setUsername(usernameEntry);
                userInfo.setPassword(passwordEntry);
                userInfo.setPhone(phoneEntry);
                userInfo.setEmail(emailEntry);

                reference.push().setValue(userInfo);

                Toast.makeText(Signup.this, "Firebase connection", Toast.LENGTH_LONG).show();

                if (firstName.length() != 0 && lastName.length() != 0 && username.length() != 0 && password.length() != 0 && phoneNumber.length() != 0 && email.length() != 0) {
                    AddData(firstNameEntry, lastNameEntry, usernameEntry, passwordEntry, phoneEntry, emailEntry);
                    firstName.setText("");
                    lastName.setText("");
                    username.setText("");
                    password.setText("");
                    phoneNumber.setText("");
                    email.setText("");
                } else {
                    toastMessage("Field is empty");
                }

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void AddData(String firstNameEntry, String lastNameEntry, String usernameEntry, String passwordEntry, int phoneEntry, String emailEntry) {
        boolean insertData = databaseHelper.addData(firstNameEntry, lastNameEntry, usernameEntry, passwordEntry, phoneEntry, emailEntry);

        if (insertData == true) {
            toastMessage("Data Successfully inserted");
        } else {
            toastMessage("Data not saved");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(Signup.this, message, Toast.LENGTH_LONG).show();
    }
}



