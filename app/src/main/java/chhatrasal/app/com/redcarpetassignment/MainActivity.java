package chhatrasal.app.com.redcarpetassignment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import chhatrasal.app.com.redcarpetassignment.adapters.RecyclerViewAdapter;
import chhatrasal.app.com.redcarpetassignment.interfaces.ClickListener;
import chhatrasal.app.com.redcarpetassignment.javaClass.CountryPopulation;
import chhatrasal.app.com.redcarpetassignment.javaClass.RecyclerTouchListener;
import chhatrasal.app.com.redcarpetassignment.javaClass.RxJavaResponse;
import chhatrasal.app.com.redcarpetassignment.webService.APIService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private APIService apiService;
    private List<CountryPopulation> list;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getPopulationList();
    }

    private void onClickEvents() {
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(MainActivity.this, recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(MainActivity.this, R.anim.fade_in, R.anim.fade_out);
                CountryPopulation countryPopulation = list.get(position);
                startActivity(new Intent(MainActivity.this, ImageViewActivity.class)
                        .putExtra("url",countryPopulation.getImageUrl()),options.toBundle());
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        list = new ArrayList<>();
        list.clear();
        apiService = new Retrofit.Builder()
                .baseUrl("http://www.androidbegin.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(APIService.class);
    }

    public void getPopulationList() {

        try {
            Observable<RxJavaResponse> call = apiService
                    .getPopulationData()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());

            call.subscribe(new Observer<RxJavaResponse>() {
                @Override
                public void onCompleted() {
//                    adapter.notifyDataSetChanged();
                    adapter = new RecyclerViewAdapter(list,MainActivity.this);
                    recyclerView.setAdapter(adapter);
                    onClickEvents();
                }

                @Override
                public void onError(Throwable e) {
                    System.out.println(e.getMessage());
                    Log.i("######RxJava Error", e.getMessage());
                }

                @Override
                public void onNext(RxJavaResponse rxJavaResponse) {
                    System.out.println(rxJavaResponse.toString());
                    Log.i("###RxJava Exception", rxJavaResponse.toString());
                    list.addAll(rxJavaResponse.getWorldPopulation());

                }
            });
        }catch(Exception e){
            System.out.println(e.getMessage());
            Log.i("###RxJava Exception", e.getMessage());
        }
    }
}
