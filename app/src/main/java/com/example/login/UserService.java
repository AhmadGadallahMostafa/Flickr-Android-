package com.example.login;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("user/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("user/signup")
    Call<RegisterResponse> registerUsers(@Body RegisterRequest registerRequest);



}
