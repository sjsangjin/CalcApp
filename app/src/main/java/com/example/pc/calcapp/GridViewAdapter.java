package com.example.pc.calcapp;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by pc on 2017-07-05.
 */

public class GridViewAdapter extends BaseAdapter{

    private Context context;
    private List<DataBean> dataList;

    public GridViewAdapter(Context context, List<DataBean> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {     //getCount의 갯수만큼 getView호출
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {       //해당 리스트의 포지션값을 통해 아이템을 넘겨줘야함
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {       //중복X 포지션값넘겨주면됨
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater lf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //inflater 소스에 있는 레이아웃을 뷰 객체로 사용할수 있게

        //레이아웃 가져오고
        //inflate : 동적으로 레이아웃 할당 -> xml은 하나밖에 표시안되므로 동적으로 레이아웃을 할당하여 여러개의 레이아웃을 볼 수 있게끔!
        convertView =  lf.inflate(R.layout.lay_img, null); //핵심

        //데이터 가져오고
        DataBean bean = dataList.get(position);

        ImageView imgPhoto = (ImageView)convertView.findViewById(R.id.imgPhoto);
        TextView txtDesc = (TextView)convertView.findViewById(R.id.txtDesc);

        //데이터 뿌려주고
        imgPhoto.setImageResource(bean.getResImg());
        txtDesc.setText(bean.getImgText());

        //이미지 클릭시
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "이미지 눌러짐", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
