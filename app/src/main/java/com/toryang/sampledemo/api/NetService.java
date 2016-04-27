package com.toryang.sampledemo.api;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by toryang on 16/4/26.
 */
public interface NetService {

    @GET("/v2/movie/us_box")
    Observable<Object> getHotMovie();
}
