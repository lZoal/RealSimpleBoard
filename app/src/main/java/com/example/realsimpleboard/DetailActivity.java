package com.example.realsimpleboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.realsimpleboard.SimpleDB.SimpleDB;
import com.example.realsimpleboard.vo.ArticleVO;

public class DetailActivity extends AppCompatActivity {
    private TextView tvSubject;
    private TextView tvArticleNumber;
    private TextView tvAuthor;
    private TextView tvDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvSubject=(TextView) findViewById(R.id.tvSubject);
        tvArticleNumber=(TextView)findViewById(R.id.tvArticleNumber);
        tvAuthor=(TextView)findViewById(R.id.tvAuthor);
        tvDescription=(TextView)findViewById(R.id.tvDescription);


        Intent intent=getIntent();
        String key = intent.getStringExtra("key");

        ArticleVO articleVO= SimpleDB.getArticle(key);

        tvSubject.setText(articleVO.getSubject());
        tvArticleNumber.setText(articleVO.getArticleNo()+"");
        tvAuthor.setText(articleVO.getAuthor());
        tvDescription.setText(articleVO.getDescription());
    }
}