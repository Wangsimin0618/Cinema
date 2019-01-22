package com.bwie.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_time)
    TextView txtTime;
    int times = 3;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    if (times<=0){
                        Intent intent = new Intent(MainActivity.this,GuideActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        times--;
                        Message message = new Message();
                        message.what = 0;
                        handler.sendMessageDelayed(message, 1000);
                    }
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        handler.sendEmptyMessage(0);

    }
}
