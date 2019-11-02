package com.example.personalhealthrecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ListActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    Button logoutBtn;
    ListView listview;
    String[] activities = {"Appointments", "Test Results", "Medications", "Health Summary", "Messages", "To Do"};
    int[] icons = {R.drawable.appointement,
            R.drawable.test,
            R.drawable.medication,
            R.drawable.summary,
            R.drawable.message,
            R.drawable.todolist};

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        listview = (ListView) findViewById(R.id.listview);
        pageAdapter pageAadapter1 = new pageAdapter(ListActivity.this, activities, icons);
        listview.setAdapter(pageAadapter1);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    Intent intent = new Intent(ListActivity.this, Appointments.class);
                    startActivityForResult(intent, 0);
                } else if (i == 1) {
                    Intent intent = new Intent(ListActivity.this, TestResults.class);
                    startActivityForResult(intent, 1);
                } else if (i == 2) {
                    Intent intent = new Intent(ListActivity.this, Medications.class);
                    startActivityForResult(intent, 2);
                } else if (i == 3) {
                    Intent intent = new Intent(ListActivity.this, HealthSummary.class);
                    startActivityForResult(intent, 3);
                } else if (i == 4) {
                    Intent intent = new Intent(ListActivity.this, Messages.class);
                    startActivityForResult(intent, 4);
                } else if (i == 5) {
                    Intent intent = new Intent(ListActivity.this, ToDo.class);
                    startActivityForResult(intent, 5);
                }
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        logoutBtn = (Button) findViewById(R.id.logout);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                backTomainActivity();
            }

        });
    }

    public void backTomainActivity() {

        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
}