package com.force.cinemaline.module.detail.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.force.cinemaline.R;
import com.force.cinemaline.base.BaseActivity;
import com.force.cinemaline.module.MyApplication;
import com.force.cinemaline.module.detail.adapter.DetailRecyAdapter;
import com.force.cinemaline.module.detail.bean.FilmDetail;
import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by force on 16-7-20.
 */
public class DetailActivity extends BaseActivity {

    ImageView ivFilmLogo;       //封面
    TextView tvFilmName;        //名字
    TextView tvFilmType;        //类型
    TextView tvFilmDirector;     //导演
    TextView tvFilmActor;       //演员
    TextView tvFilmDuration;    //电影时长
    TextView tvLanguage;        //语言
    TextView tvShowDate;        //上映时间
    TextView tvFilmAttr;        //电影类型
    TextView tvDescription;     //简介
    TextView tvReview;          //综合评论

    ImageView imageViewBack;
    TextView tvMore;

    List<String> picUrls;
    RecyclerView recyclerView;


    @Override
    protected int getContentView() {
        return R.layout.activity_detail;
    }

    @Override
    protected void findViews() {

        recyclerView = (RecyclerView) findViewById(R.id.rv_detail_still_container);

        tvDescription = (TextView) findViewById(R.id.tv_detail_description);
        tvFilmAttr = (TextView) findViewById(R.id.tv_detail_file_attr);
        tvFilmName = (TextView) findViewById(R.id.tv_detail_film_name);
        ivFilmLogo = (ImageView) findViewById(R.id.iv_detail_file_logo);
        tvFilmType = (TextView) findViewById(R.id.tv_detail_film_type);
        tvFilmDirector = (TextView) findViewById(R.id.tv_detail_director);
        tvFilmActor = (TextView) findViewById(R.id.tv_detail_actor);
        tvFilmDuration = (TextView) findViewById(R.id.tv_detail_duration);
        tvLanguage = (TextView) findViewById(R.id.tv_detail_language);
        tvShowDate = (TextView) findViewById(R.id.tv_detail_show_date);
        tvReview = (TextView) findViewById(R.id.tv_detail_review);

        imageViewBack = (ImageView) findViewById(R.id.iv_detail_back);
        tvMore = (TextView) findViewById(R.id.tv_detail_more);
    }

    @Override
    protected void init() {
        load();
    }

    @Override
    protected void initEvent() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilmDetail.FilmsBean filmsBean = filmDetail.getFilms().get(0);
                String filmName = filmsBean.getFilmName();
                List<FilmDetail.FilmsBean.FilmPicsBean> filmPics = filmsBean.getFilmPics();

                ArrayList<String> picUrls = new ArrayList<>();

                for (int i = 0; i < filmPics.size(); i++) {
                    String picUrl = filmPics.get(i).getPicUrl();
                    picUrls.add(picUrl);
                }
                Intent intent = new Intent();
                intent.setClass(DetailActivity.this, StillActivity.class);
                intent.putExtra("filmName", filmName);
                intent.putStringArrayListExtra("picUrls", picUrls);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }

    private void setDataToView(FilmDetail filmDetail) {
        FilmDetail.FilmsBean filmsBean = filmDetail.getFilms().get(0);

        Picasso.with(this).load(filmsBean.getImgUrl()).into(ivFilmLogo);

        picUrls = new ArrayList<>();
        List<FilmDetail.FilmsBean.FilmPicsBean> filmPics = filmsBean.getFilmPics();
        for (int i = 0; i < filmPics.size(); i++) {
            FilmDetail.FilmsBean.FilmPicsBean filmPicsBean = filmPics.get(i);
            String picUrl = filmPicsBean.getPicUrl();

            picUrls.add(picUrl);

        }

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        DetailRecyAdapter adapter = new DetailRecyAdapter(this, picUrls);
        recyclerView.setAdapter(adapter);

        tvReview.setText(filmsBean.getReview());
        tvFilmName.setText(filmsBean.getFilmName());
        tvFilmType.setText(filmsBean.getFilmType());
        tvFilmDirector.setText(filmsBean.getDirector());
        tvFilmActor.setText(filmsBean.getActor());
        tvFilmDuration.setText(filmsBean.getDuration());
        tvFilmAttr.setText(filmsBean.getFilmAttr());
        tvLanguage.setText(filmsBean.getLanguage());
        tvShowDate.setText(filmsBean.getShowDate());
        tvDescription.setText(filmsBean.getDescription());
    }

    FilmDetail filmDetail;

    private void load() {
        String movieDetailUrl = "http://www.189mv.cn/qryFilm.htm";

        RequestParams requestParams = new RequestParams("UTF-8");
        requestParams.addBodyParameter("mid", "26958");
        MyApplication.httpUtils.send(HttpRequest.HttpMethod.POST,
                movieDetailUrl,
                requestParams,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String result = responseInfo.result;

                        Gson gson = new Gson();
                        filmDetail = gson.fromJson(result, FilmDetail.class);
                        setDataToView(filmDetail);
                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                        Toast.makeText(DetailActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
