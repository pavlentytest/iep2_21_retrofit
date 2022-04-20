package ru.samsung.itschool.mdev.myapplication.api;


import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.samsung.itschool.mdev.myapplication.model.Anekdot;

public interface AnekdotAPI {
    // https://umorili.herokuapp.com/api/get?site=anekdot.ru&num=10&name=new%20anekdot
    // https://umorili.herokuapp.com -> в конст
    // @ /api/get
    // site = "anekdot.ru"
    // num = 10
    // name = "new anekdot"

    @GET("/api/get")
    Call<ArrayList<Anekdot>> getAnekdot(@Query("site") String site,
                                        @Query("num") Integer num,
                                        @Query("name") String name);

}
