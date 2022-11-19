package com.example.realsimpleboard;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.realsimpleboard.Custom.CustomButton;
import com.example.realsimpleboard.SimpleDB.SimpleDB;
import com.example.realsimpleboard.vo.ArticleVO;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private String[] items = {"IT","항공","농업"};
    private String tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareSimpleDB();
        LinearLayout li = (LinearLayout) findViewById(R.id.listView);

        Spinner spn=(Spinner) findViewById(R.id.spinner);
        spn.setAdapter(ArrayAdapter.createFromResource(this,R.array.spner,
                android.R.layout.simple_spinner_item));

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String a = spn.getItemAtPosition(i).toString();
                tag=items[i];
                li.removeAllViews();
                for(int j=0;j< SimpleDB.getIndexes().size();j++) {
                    String idx= SimpleDB.getArticle(j+"번글").getTag();
                     if(idx != tag) continue;
                    Button button = new AppCompatButton(MainActivity.this);
                    button.setText(SimpleDB.getIndexes().get(j));
//                    button.setText(tag+"태그"+SimpleDB.getIndexes().get(j)+"번버튼");

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

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

//        for(int i=0;i< SimpleDB.getIndexes().size();i++) {
//            String idx= SimpleDB.getArticle(i+"번글").getTag();
//           if(!Objects.equals(SimpleDB.getArticle(idx).getTag(), tag)) continue;
//            Button button = new AppCompatButton(this);
//            button.setText(SimpleDB.getIndexes().get(i));
//
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
//                    String buttonText= (String)((Button) v).getText();
//                    intent.putExtra("key",buttonText);
//                    startActivity(intent);
//                }
//            });
//
//            li.addView(button);
//        }

    }
    private void prepareSimpleDB() {
        for (int i=0;i<9;i++) {
            SimpleDB.addArticle(i+"번글",new ArticleVO(i,i+"번글 제목",i+"번글 내용","임동휘","IT"));
        }
        for (int i=9;i<19;i++) {
            SimpleDB.addArticle(i+"번글",new ArticleVO(i,i+"번글 제목",i+"번글 내용","임동휘","농업"));
        }
        for (int i=19;i<29;i++) {
            SimpleDB.addArticle(i+"번글",new ArticleVO(i,i+"번글 제목",i+"번글 내용","임동휘","항공"));
        }
    }
}