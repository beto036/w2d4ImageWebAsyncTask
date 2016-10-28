package com.example.admin.w2d4imagewebasyntask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.aMainImg);
        progressBar = (ProgressBar)findViewById(R.id.aMainProg);
    }

    public void download(View view) {
        imageView.setTag("http://weknowyourdreams.com/images/space/space-02.jpg");
        new SaveFileTask(imageView,progressBar).execute(imageView.getTag().toString());
    }
}
