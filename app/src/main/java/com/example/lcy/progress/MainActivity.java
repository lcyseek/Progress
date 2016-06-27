package com.example.lcy.progress;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

/**
 * style="?android:attr/progressBarStyleLarge" 大号圆形ProgressBar的风格
 * style="?android:attr/progressBarStyleSmall" 小号圆形ProgressBar的风格
 * 不加style为中型圆形风
 * style="?android:attr/progressBarStyleHorizontal" 水平进度条
 *
 * android:indeterminate="true" 不明确进度条
 */
public class MainActivity extends Activity {

    ProgressBar progressBar;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.pb);
        progressBar.setMax(100);
    }

    int progress = 0;
    int secondProgress = 0;

    public void updateProgress(View view) {

        progressBar.setProgress(progress+=5);

        if(progress >= 100) {
            progress = 0;
            //progressBar.setVisibility(View.GONE);
        }

        if(secondProgress<100){
            progressBar.setSecondaryProgress(secondProgress+=15);
        }


        //每次固定增加某个进度值 可以为负值
//        progressBar.incrementProgressBy(10);
//        progressBar.incrementSecondaryProgressBy(15);
    }

    public void getInfo(View view) {
        boolean b = progressBar.isIndeterminate();//是否是不确定模式
        int max = progressBar.getMax();
        int progress = progressBar.getProgress();
        int secondProgress = progressBar.getSecondaryProgress();
        Log.i(TAG, "getInfo: isIndeterminate="+b+" max="+max+" progress="+progress+" second="+secondProgress);
    }
}
