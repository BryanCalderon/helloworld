package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.domain.Empleado;
import com.example.helloworld.domain.InputEmp;
import com.example.helloworld.service.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText user, password;
    Button buttonLogin, buttonRegister;
    public static final String EXTRA_MESSAGE = "com.example.helloworld.MESSAGE";
    Empleado empleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = findViewById(R.id.password);
        user = findViewById(R.id.username);
        buttonLogin = findViewById(R.id.signinButton);
        buttonRegister = findViewById(R.id.registrarse);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(createRequest());
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegister();
            }
        });
    }

    public void goToRegister() {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    public void gotToHome() {
        Intent intent = new Intent(this, IconsActivity.class);
//        intent.putExtra(EXTRA_MESSAGE, empleado.getNombre());
        startActivity(intent);
    }

    public InputEmp createRequest() {
        InputEmp inputEmp = new InputEmp();
        inputEmp.setEmail(user.getText().toString());
        inputEmp.setPassword(password.getText().toString());
        return inputEmp;
    }

    public void loginUser(InputEmp inputEmp) {
//        Call<Empleado> empleadoCall = ApiClient.getUserService().login(inputEmp);
//
//        empleadoCall.enqueue(new Callback<Empleado>() {
//            @Override
//            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
//                System.out.println("response.isSuccessful > " + response.isSuccessful());
//                System.out.println(response.body());
//                if (response.isSuccessful()) {
//                    empleado = response.body();
                    gotToHome();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Empleado> call, Throwable t) {
//                System.out.println("FALLO > " + t.getLocalizedMessage());
//            }
//        });
    }
}