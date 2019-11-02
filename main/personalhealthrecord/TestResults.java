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

public class TestResults extends AppCompatActivity {

    Button buttonSubmitTestResults;
    ListView testResultsListView;
    EditText testNameText, dateDoneText, yourValuesText, normalRangeText;
    String testNameString, dateDoneString, yourValuesString, normalRangeString;
    ArrayList<AddTestResult> testResultArrayList = new ArrayList<>();

    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);
        toolBar = (Toolbar) findViewById(R.id.testResults);
        toolBar.setTitle("Test Results");

        testNameText = (EditText) findViewById(R.id.bloodWork);
        dateDoneText = (EditText) findViewById(R.id.dateOfService);
        yourValuesText = (EditText) findViewById(R.id.yourValues);
        normalRangeText = (EditText) findViewById(R.id.normalRange);


        testResultsListView = (ListView) findViewById(R.id.testResultsListView);


        buttonSubmitTestResults = (Button) findViewById(R.id.submitTestResults);
        buttonSubmitTestResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                testNameString = testNameText.getText().toString();
                dateDoneString = dateDoneText.getText().toString();
                yourValuesString = yourValuesText.getText().toString();
                normalRangeString = normalRangeText.getText().toString();

                if (testNameString.length() != 0 && dateDoneString.length() != 0 && yourValuesString.length() != 0 &&
                        normalRangeString.length() != 0) {


                    AddTestResult addTestResult = new AddTestResult(testNameString, dateDoneString, yourValuesString, normalRangeString);
                    testResultArrayList.add(addTestResult);
                    UserTestResultsAdapter adapter = new UserTestResultsAdapter(TestResults.this, R.layout.bloodworkadapter, testResultArrayList);
                    testResultsListView.setAdapter(adapter);

                    testNameText.getText().clear();
                    dateDoneText.getText().clear();
                    yourValuesText.getText().clear();
                    normalRangeText.getText().clear();


                } else {
                    toastMessage("Field is empty");
                }

                if (testResultArrayList.contains(testNameString) || testResultArrayList.contains(dateDoneString) ||
                        testResultArrayList.contains(yourValuesString) || testResultArrayList.contains(normalRangeString)) {

                    Toast.makeText(getBaseContext(), "Date Already exists", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    private void toastMessage(String message) {
        Toast.makeText(TestResults.this, message, Toast.LENGTH_LONG).show();
    }
}
