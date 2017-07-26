package com.example.pc.calcapp;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        //gridview 가져오고
        GridView gridView = (GridView)findViewById(R.id.gridview);

        //gridview에 넘겨줄 데이터 생성
        DataBean db1 = new DataBean(R.drawable.img1, "강아지1");
        DataBean db2 = new DataBean(R.drawable.img2, "강아지2");
        DataBean db3 = new DataBean(R.drawable.img3, "강아지3");
        DataBean db4 = new DataBean(R.drawable.img4, "강아지4");

        //데이터 리스트 생성
        List<DataBean> list = new ArrayList<DataBean>();
        list.add(db1);
        list.add(db2);
        list.add(db3);
        list.add(db4);

        //반드시! Adapter를 통해 여러개의 반복되는 형태를 출력시켜야함
        //Adapter 객체 생성
        GridViewAdapter adapter = new GridViewAdapter(this, list);
        //GridView가 사용할 Adapter를 지정
        gridView.setAdapter(adapter);
    }


}
