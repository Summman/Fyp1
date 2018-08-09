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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CareTakerLogin extends AppCompatActivity implements View.OnClickListener {

    private Button btnReg;
    private EditText TextEmail;
    private EditText TextPass;
    private TextView TvSignIn;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.care_taker_login);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){


        }

        btnReg = (Button) findViewById(R.id.btnReg);
        TextEmail = (EditText) findViewById(R.id.TextEmail);
        TextPass = (EditText) findViewById(R.id.TextPass);
        TvSignIn = (TextView) findViewById(R.id.TvSignIn);


        btnReg.setOnClickListener(this);
        TvSignIn.setOnClickListener(this);
    }

    private void registerUser() {
        String email = TextEmail.getText().toString().trim();
        String password = TextPass.getText().toString().trim();

      if (TextUtils.isEmpty(email)){
          // email is empty
          Toast.makeText(this, "Please enter Email",Toast.LENGTH_SHORT).show();
          return;
      }

      if (TextUtils.isEmpty(password)){
          //password is empty
          Toast.makeText(this,"Please enter Password",Toast.LENGTH_SHORT).show();
          return;
      }

      progressDialog.setMessage("Registering User ...");
      progressDialog.show();

      firebaseAuth.createUserWithEmailAndPassword(email,password)
              .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()){


                          Toast.makeText(CareTakerLogin.this,"Register User Successfully",Toast.LENGTH_SHORT).show();

                      }else{
                          Toast.makeText(CareTakerLogin.this,"Could not Register.. please try again",Toast.LENGTH_SHORT).show();
                      }
                  }
              });
    }

    @Override
    public void onClick(View view) {
        if (view == btnReg) {
            registerUser();
        }

     if (view == TvSignIn){
            startActivity(new Intent(this,LoginActivity.class));
        }


}
}
