package com.toryang.sampledemo.api;

import com.toryang.sampledemo.model.entities.comingSoon.ComingSoon;
import com.toryang.sampledemo.model.entities.inthreat.InThreatEntity;
import com.toryang.sampledemo.model.entities.top250.Top250Entity;
import com.toryang.sampledemo.model.entities.usbox.UsBoxEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by toryang on 16/4/26.
 */
public interface NetService {

    @GET("/v2/movie/us_box")
    Observable<UsBoxEntity> getHotMovie();

    @GET("/v2/movie/in_theaters")
    Observable<InThreatEntity> getInTheaters ();

    @GET("/v2/movie/coming_soon")
    Observable<ComingSoon> getComingSoon();


    @GET("/v2/movie/top250")
    Observable<Top250Entity> getTop250();


}
