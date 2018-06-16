package com.example.chaitanya.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
GridView gridView;
String[] name={"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN"};
int[] colorname={R.color.one,R.color.two,R.color.three,R.color.four,R.color.five,R.color.six,R.color.seven,R.color.eight,R.color.nine,R.color.ten};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridview);
        CustomAdapter customAdapter=new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),GridActivity.class);
                intent.putExtra("name",name[position]);
                intent.putExtra("image",colorname[position]);
                startActivity(intent);
            }
        });

    }
    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return colorname.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=getLayoutInflater().inflate(R.layout.grid_list,null);
            TextView name1=view.findViewById(R.id.text);
            ImageView image=view.findViewById(R.id.image);
           name1.setText(name[position]);
            image.setImageResource(colorname[position]);
            return view;
        }
    }
}
