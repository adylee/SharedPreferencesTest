package com.example.administrator.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("crazyit", MODE_WORLD_READABLE);
        editor = preferences.edit();
        Button read = (Button)findViewById(R.id.read);
        Button write = (Button)findViewById(R.id.write);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = preferences.getString("time",null);
                int randNum = preferences.getInt("random", 0);
                String result = time == null ? "您暂时还未写入数据":"写入时间为:"+time+"\n上次生成的随机数为:"+randNum;
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
               // Toast.makeText(MainActivity.this,result,5000).show();
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("2016.7.12 "+"hh:mm:ss");
                editor.putString("time",sdf.format(new Date()));
                editor.putInt("random", (int) (Math.random() * 100));
                editor.commit();
            }
        });
    }
}
