package com.randove.eslam.retrofitdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.randove.eslam.retrofitdagger.models.RestApi;
import com.randove.eslam.retrofitdagger.models.pojos.Post;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject Retrofit retrofit;//Auto Inject Retrofit from NetModule
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getNetComponent().injectMainActivity(this); //Link Main activity with modules through component
        Observable<List<Post>> call = retrofit.create(RestApi.class).getPosts();//get observable posts list from api

        //Observer which will take result from observable object
        Observer<List<Post>> observer = new Observer<List<Post>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(List<Post> posts) {
                for(Post post : posts){
                    Log.i("TEST",post.getTitle()); //Write post title at log
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
            }
        };

        call.subscribeOn(Schedulers.io())//run http get request at io Thread
                .observeOn(AndroidSchedulers.mainThread()) //get result at main Thread
                .subscribe(observer);//Fire observable


    }
}
