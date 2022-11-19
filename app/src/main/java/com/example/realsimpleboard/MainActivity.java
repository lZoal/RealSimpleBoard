package com.example.realsimpleboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.realsimpleboard.SimpleDB.SimpleDB;
import com.example.realsimpleboard.vo.ArticleVO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareSimpleDB();
        LinearLayout li = (LinearLayout) findViewById(R.id.listView);

        for(int i=0;i< SimpleDB.getIndexes().size();i++) {
            Button button = new AppCompatButton(this);
            button.setText(SimpleDB.getIndexes().get(i));

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    String buttonText= (String)((Button) v).getText();
                    intent.putExtra("key",buttonText);
                    startActivity(intent);
                }
            });
            li.addView(button);
        }

    }
    private void prepareSimpleDB() {
        for (int i=1;i<50;i++) {
            SimpleDB.addArticle(i+"번글",new ArticleVO(i,i+"번글 제목",i+"번글 내용","내가"));
        }
    }
}