package com.example.personalhealthrecord;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Medications extends AppCompatActivity {

    Button buttonSubmitMedications;
    ListView medicationListView;
    EditText medNameText, daysSupplyText, doseText, dateDispensedText;
    String medNameString, daysSupplyString, doseString, dateDispensedString;
    ArrayList<AddMedication> medicationArrayList = new ArrayList<>();
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medications);

        toolBar = (Toolbar) findViewById(R.id.medications);
        toolBar.setTitle("Medications");


        medNameText = (EditText) findViewById(R.id.medName);
        daysSupplyText = (EditText) findViewById(R.id.daysSupply);
        doseText = (EditText) findViewById(R.id.dose);
        dateDispensedText = (EditText) findViewById(R.id.dateDispensed);

        medicationListView = (ListView) findViewById(R.id.currentMedicationsListView);

        buttonSubmitMedications = (Button) findViewById(R.id.submitMedications);
        buttonSubmitMedications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                medNameString = medNameText.getText().toString();
                daysSupplyString = daysSupplyText.getText().toString();
                doseString = doseText.getText().toString();
                dateDispensedString = dateDispensedText.getText().toString();

                if (medNameString.length() != 0 && daysSupplyString.length() != 0 && doseString.length() != 0 &&
                        dateDispensedString.length() != 0) {

                    AddMedication addMedication = new AddMedication(medNameString, daysSupplyString, doseString, dateDispensedString);
                    medicationArrayList.add(addMedication);
                    UserMedicationsAdapter adapter = new UserMedicationsAdapter(Medications.this, R.layout.medicationadapter, medicationArrayList);
                    medicationListView.setAdapter(adapter);

                    medNameText.getText().clear();
                    daysSupplyText.getText().clear();
                    doseText.getText().clear();
                    dateDispensedText.getText().clear();

                } else {
                    toastMessage("Field is empty");
                }

                if (medicationArrayList.contains(medNameString) || medicationArrayList.contains(daysSupplyString) ||
                        medicationArrayList.contains(doseString) || medicationArrayList.contains(dateDispensedString)) {

                    Toast.makeText(getBaseContext(), "Date Already exists", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void toastMessage(String message) {
        Toast.makeText(Medications.this, message, Toast.LENGTH_LONG).show();
    }
}
