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

public class MainActivity extends AppCompatActivity {
       EditText etEmail, etPassword;
       TextView tvRegister;
       Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_passowrd);
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvRegister = (TextView) findViewById(R.id.tv_regsiter);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this,RegisterActivity.class);
                startActivity(i);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( TextUtils.isEmpty((etEmail.getText().toString())) ||TextUtils.isEmpty((etPassword.getText().toString())))
                {

                    String message ="all infos are requeired";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();

                }else {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setEmail(etEmail.getText().toString());
                    loginRequest.setPassword(etPassword.getText().toString());

                    loginUser(loginRequest);
                }

            }
        });


    }
    public void  loginUser(LoginRequest loginRequest){
        Call<LoginResponse> loginResponseCall=ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){

                    String message = "Successful";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(MainActivity.this,DashboardActivity.class));
                    finish();

                }else
                {
                    String message = "an error occurred make sure u use valid email and pass";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();


                }


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();


            }
        });


    }




}
