package com.riyanurdiansyah.omega.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.riyanurdiansyah.omega.helper.LoadingDialog;
import com.riyanurdiansyah.omega.R;
import com.riyanurdiansyah.omega.api.ApiClient;
import com.riyanurdiansyah.omega.api.ApiInterface;
import com.riyanurdiansyah.omega.model.LoginResponse;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    String username, password;
    LoadingDialog loadingDialog;
    Window window;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Build.VERSION.SDK_INT > 26) {
            window = Objects.requireNonNull(this.getWindow());
            window.setStatusBarColor(Color.parseColor("#0476E8"));
        }

        dialog = new Dialog(this);
        loadingDialog = new LoadingDialog(this);

        //inisialisasi
        etPassword = findViewById(R.id.etPassword);
        etUsername = findViewById(R.id.etUsername);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            loadingDialog.startLoadingDialog();
            dialog.setContentView(R.layout.layout_notice);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(false);

            Button btn_close = dialog.findViewById(R.id.btnClose);
            btn_close.setOnClickListener(v1 -> dialog.dismiss());
            username = etUsername.getText().toString();
            password = etPassword.getText().toString();

            //cek kondisi edit text
            if (username.isEmpty()) {
                loadingDialog.stopLoadingDialog();
                tampilToast("Username tidak boleh kosong");
            } else if (password.isEmpty()) {
                loadingDialog.stopLoadingDialog();
                tampilToast("Password tidak boleh kosong");
            } else {
                login(username, password);
            }
        });
    }

    private void login(String user, String pass) {
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> login = api.login(user, pass);
        login.enqueue(new Callback<LoginResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loadingDialog.stopLoadingDialog();
                String status = response.body().getStatus();
                if (status.equals("success")) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } else {
                    dialog.show();
                    etUsername.setText("");
                    etPassword.setText("");
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loadingDialog.stopLoadingDialog();
                tampilToast(""+t.toString());
            }
        });
    }

    private void tampilToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}