package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.domain.Empleado;
import com.example.helloworld.service.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity {

    Button cancelButton, saveButton;
    EditText name, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        cancelButton = findViewById(R.id.cancelButton);
        saveButton = findViewById(R.id.saveButton);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.new_password);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser(createEmpleado());
            }
        });
    }

    public void goToLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public Empleado createEmpleado() {
        Empleado empleado = new Empleado();
        empleado.setNombre(name.getText().toString());
        empleado.setEmail(email.getText().toString());
        empleado.setPassword(password.getText().toString());
        return empleado;
    }

    public void registerUser(Empleado empleado) {
        Call<Empleado> empleadoCall = ApiClient.getUserService().register(empleado);
        empleadoCall.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegistroActivity.this, "Saved succesfully", Toast.LENGTH_LONG).show();
                    goToLogin();
                } else {
                    Toast.makeText(RegistroActivity.this, "Request failed", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Toast.makeText(RegistroActivity.this, "Request failed " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}