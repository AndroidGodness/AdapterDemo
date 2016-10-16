package com.example.toluene.adapterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(adapter);
    }

    BaseAdapter adapter = new BaseAdapter() {
        private ListData[] data = new ListData[]{
                new ListData("路飞", "海贼王", R.drawable.lufei),
                new ListData("索隆", "副船长", R.drawable.suolong),
                new ListData("艾斯", "兄长", R.drawable.aisi),
                new ListData("罗宾", "考古家", R.drawable.luobing),
                new ListData("娜美", "航海家", R.drawable.namei),
                new ListData("鸣人", "火影", R.drawable.mingren),
                new ListData("汉库克", "九头蛇", R.drawable.nvdi)};


        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public ListData getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout ll = null;
            if (convertView != null) {
                ll = (LinearLayout) convertView;
            } else {
                ll = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.list_layout_new, null);
                ListData data = getItem(position);
                ImageView image = (ImageView) ll.findViewById(R.id.image);
                TextView name = (TextView) ll.findViewById(R.id.name);
                TextView dec = (TextView) ll.findViewById(R.id.dec);
                image.setImageResource(data.iconId);
                name.setText(data.name);
                dec.setText(data.dec);
            }
            return ll;
        }
    };
}
