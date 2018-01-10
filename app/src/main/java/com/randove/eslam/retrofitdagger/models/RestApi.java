package com.randove.eslam.retrofitdagger.models;

import com.randove.eslam.retrofitdagger.models.pojos.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Eslam on 1/10/2018.
 */

public interface RestApi {
    @GET("/posts")
    Observable<List<Post>> getPosts();
}
