package com.example.frame;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //https://www.wanandroid.com/project/list/1/json?cid=294
    String Base_Url="https://www.wanandroid.com/";
    @GET("project/list/{path}/json")
    Observable<ProjectBean>getData(@Path("path") String path, @Query("cid") String cid);
}
