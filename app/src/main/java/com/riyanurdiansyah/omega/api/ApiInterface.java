package com.riyanurdiansyah.omega.api;

import com.riyanurdiansyah.omega.model.LoginResponse;
import com.riyanurdiansyah.omega.model.Penjualan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@Field("email") String email,
                              @Field("password") String password);

    //ambil data penjualan by date
    @GET("bydate")
    Call<List<Penjualan>> getDataByDate();

    //ambil data berdasarkan nama
    @GET("notexists")
    Call<List<Penjualan>> getNotExists();

    //ambil data transaksi terbanyak
    @GET("sum")
    Call<List<Penjualan>> getSum();
}
