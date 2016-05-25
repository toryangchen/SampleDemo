package com.toryang.sampledemo.api;

import com.toryang.sampledemo.entities.movieEntitiy.Movieinfo;
import com.toryang.sampledemo.entities.usbox.UsBoxEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by toryang on 16/4/26.
 */
public interface NetService {

    @GET("/v2/movie/us_box")
    Observable<UsBoxEntity> getHotMovie();

    @GET("/v2/movie/in_theaters")
    Observable<Movieinfo> getInTheaters ();

    @GET("/v2/movie/coming_soon")
    Observable<Movieinfo> getComingSoon();

    @GET("/v2/movie/top250")
    Observable<Movieinfo> getTop250();


}
