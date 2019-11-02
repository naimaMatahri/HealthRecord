package com.example.personalhealthrecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;

public class MainActivity extends AppCompatActivity {

    Button login, registerBtn;
    Toolbar toolbar;
    EditText editEmail, editPassword;
    FirebaseAuth firebaseAuth;
    DatabaseHelper databaseHelper;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Firebase connection", Toast.LENGTH_LONG).show();

        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle(getResources().getString(R.string.app_name));

        editEmail = (EditText) findViewById(R.id.editText_email);
        editPassword = (EditText) findViewById(R.id.editText_password);

        firebaseAuth = FirebaseAuth.getInstance();

        // check if the info already exist in the database, and check if the area is empty
        login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailEntry = editEmail.getText().toString();
                String passwordEntry = editPassword.getText().toString();

                firebaseAuth.fetchProvidersForEmail(editEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>() {
                            @Override
                            public void onComplete(@NonNull Task<ProviderQueryResult> task) {

                                boolean check = !task.getResult().getProviders().isEmpty();

                                if (check) {

                                    Toast.makeText(getApplicationContext(), "Email not found", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(getApplicationContext(), "Email exists ", Toast.LENGTH_LONG).show();
                                }
                            }

                        });

                firebaseAuth.signInWithEmailAndPassword(emailEntry, passwordEntry).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    startActivity(new Intent(MainActivity.this, ListActivity.class));
//                                    Intent intent = new Intent(MainActivity.this, MainActivity.this);
//                                    startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                openListActivity();
            }
        });
        registerBtn = (Button) findViewById(R.id.register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openListActivity1();
            }
        });

    }

    public void openListActivity() {

        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);

    }

    public void openListActivity1() {

        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);

    }
}