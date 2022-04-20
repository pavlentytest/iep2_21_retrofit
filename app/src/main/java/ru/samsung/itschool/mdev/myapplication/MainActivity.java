package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.samsung.itschool.mdev.myapplication.api.AnekdotAPI;
import ru.samsung.itschool.mdev.myapplication.model.Anekdot;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://umorili.herokuapp.com/";
    private AnekdotAPI api;
    private ArrayList<Anekdot> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(arrayList);
        recyclerView.setAdapter(myAdapter);

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = retrofit.create(AnekdotAPI.class);

        api.getAnekdot("anekdot.ru",10,"new anekdot").enqueue(new Callback<ArrayList<Anekdot>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<ArrayList<Anekdot>> call, Response<ArrayList<Anekdot>> response) {
                if(response.code() == 200) {
                    arrayList.addAll(response.body());
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Anekdot>> call, Throwable t) {
                Log.d("RRR",t.getMessage());
            }
        });


    }
}