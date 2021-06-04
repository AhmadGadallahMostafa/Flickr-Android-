package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText etName,etSName ,etAge ,etEmail, etPassword, etRPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.et_name);
        etSName =(EditText) findViewById(R.id.et_sname);
        etAge =  (EditText) findViewById(R.id.et_Age);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_pass);
        etRPassword = (EditText) findViewById(R.id.et_rep_pass);
        btnRegister = (Button) findViewById(R.id.button_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty((etEmail.getText().toString())) || TextUtils.isEmpty((etSName.getText().toString())) ||TextUtils.isEmpty((etName.getText().toString())) || TextUtils.isEmpty((etAge.getText().toString())) ||TextUtils.isEmpty((etPassword.getText().toString())) || TextUtils.isEmpty((etRPassword.getText().toString())) )
                {
                    String message ="all infos are requeired";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();


                /*else if(etPassword.getText()!=etRPassword.getText())
                {
                    String message ="password not match..try again";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();*/
                }
                else {

                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setEmail(etEmail.getText().toString());
                    registerRequest.setFirstName(etName.getText().toString());

                    registerRequest.setSecondName(etSName.getText().toString());

                    String value = etAge.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    registerRequest.setAge(finalValue);
                    registerRequest.setPassword(etPassword.getText().toString());

                    registerUser(registerRequest);
                }

            }
        });


    }
    public  void registerUser(RegisterRequest registerRequest){
        Call<RegisterResponse> registerResponseCall = ApiClient.getService().registerUsers(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if(response.isSuccessful()){
                    String message = "Successful";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                finish();


                }else{
                    String message = "an error occurred try again later";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();



                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();

            }
        });
    }
}