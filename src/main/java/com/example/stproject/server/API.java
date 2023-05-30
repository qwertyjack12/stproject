package com.example.stproject.server;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Hashtable;

public interface API {
    @GET("/get_studentRecord")
    Call<Hashtable<String, String>> greeting(@Query("studentId") Integer studentId);
}