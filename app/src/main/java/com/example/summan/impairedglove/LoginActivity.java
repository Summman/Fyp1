package com.example.summan.impairedglove;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnSignIn;
    private EditText TextEmail;
    private EditText TextPass;
    private TextView TvSignUp;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {

            finish();
            startActivity(new Intent(getApplicationContext(),Location.class));

        }
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        TextEmail = (EditText) findViewById(R.id.TextEmail);
        TextPass = (EditText) findViewById(R.id.TextPass);
        TvSignUp = (TextView) findViewById(R.id.TvSignUp);

        progressDialog = new ProgressDialog(this);

        btnSignIn.setOnClickListener(this);
        TvSignUp.setOnClickListener(this);
    }


    private void userLogin() {

        String email = TextEmail.getText().toString().trim();
        String password = TextPass.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            // email is empty
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Login User ...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(),Location.class));
                        }
                    }
                });
    }


    @Override
    public void onClick(View view) {
        if (view ==btnSignIn){
            userLogin();
        }
        if (view == TvSignUp){
            finish();
            startActivity(new Intent(this,CareTakerLogin.class));
        }
    }
}
