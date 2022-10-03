package com.example.helloworld.service;

import com.example.helloworld.domain.Empleado;
import com.example.helloworld.domain.InputEmp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("validate")
    Call<Empleado> login(@Body InputEmp inputEmp);

    @POST("guardar")
    Call<Empleado> register(@Body Empleado empleado);
}
