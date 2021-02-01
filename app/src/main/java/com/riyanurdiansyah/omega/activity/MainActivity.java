package com.riyanurdiansyah.omega.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.riyanurdiansyah.omega.R;
import com.riyanurdiansyah.omega.adapter.ByTanggalAdapter;
import com.riyanurdiansyah.omega.adapter.NotExistsAdapter;
import com.riyanurdiansyah.omega.adapter.SumAdapter;
import com.riyanurdiansyah.omega.api.ApiClient;
import com.riyanurdiansyah.omega.api.ApiInterface;
import com.riyanurdiansyah.omega.model.Penjualan;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MainActivity extends AppCompatActivity {

    ByTanggalAdapter adapterDate;
    NotExistsAdapter adapterEx;
    SumAdapter adapterSum;
    RecyclerView rvDate, rvEx, rvSum;
    LinearLayoutManager layoutManagerDate, layoutManagerEx, layoutManagerSum;
    ProgressBar progressBar;
    Window window;

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT > 26) {
            window = Objects.requireNonNull(this.getWindow());
            window.setStatusBarColor(Color.parseColor("#FFFFFF"));
        }

        progressBar = findViewById(R.id.pb);
        rvDate = findViewById(R.id.rvDate);
        rvEx = findViewById(R.id.rvEx);
        rvSum = findViewById(R.id.rvSum);

        layout = findViewById(R.id.layout);

        layoutManagerDate = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        layoutManagerEx = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        layoutManagerSum = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        rvDate.setLayoutManager(layoutManagerDate);
        rvEx.setLayoutManager(layoutManagerEx);
        rvSum.setLayoutManager(layoutManagerSum);

        tampilDataDate();
        tampilDataEx();
        tampilDataSum();
    }

    private void tampilDataSum() {
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Penjualan>> sum = api.getSum();
        sum.enqueue(new Callback<List<Penjualan>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<Penjualan>> call, Response<List<Penjualan>> response) {
                progressBar.setVisibility(View.GONE);
                List<Penjualan> data = response.body();
                adapterSum = new SumAdapter(data, getApplicationContext());
                rvSum.setAdapter(adapterSum);
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<Penjualan>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),
                        "" + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tampilDataEx() {
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Penjualan>> exists = api.getNotExists();
        exists.enqueue(new Callback<List<Penjualan>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<Penjualan>> call, Response<List<Penjualan>> response) {
                progressBar.setVisibility(View.GONE);
                layout.setVisibility(View.VISIBLE);
                List<Penjualan> data = response.body();
                adapterEx = new NotExistsAdapter(data, getApplicationContext());
                rvEx.setAdapter(adapterEx);
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<Penjualan>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),
                        "" + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void tampilDataDate() {

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Penjualan>> date = api.getDataByDate();
        date.enqueue(new Callback<List<Penjualan>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<Penjualan>> call, Response<List<Penjualan>> response) {
                progressBar.setVisibility(View.GONE);
                List<Penjualan> data = response.body();
                adapterDate = new ByTanggalAdapter(data, getApplicationContext());
                rvDate.setAdapter(adapterDate);
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<Penjualan>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),
                        "" + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}