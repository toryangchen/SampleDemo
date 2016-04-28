package com.toryang.sampledemo.api;

import com.toryang.sampledemo.model.entities.usbox.UsBoxEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by toryang on 16/4/26.
 */
public interface NetService {

    @GET("/v2/movie/us_box")
    Observable<UsBoxEntity> getHotMovie();
}
