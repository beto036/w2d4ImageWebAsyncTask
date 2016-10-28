package com.example.admin.w2d4imagewebasyntask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by admin on 10/27/2016.
 */

public class SaveFileTask extends AsyncTask<String, ImageView, Bitmap> {

    private static final String TAG = "TAG";
    ImageView imageView;
    ProgressBar progressBar;
    private String url;

    public SaveFileTask(ImageView imageView, ProgressBar progressBar) {
        this.imageView = imageView;
        this.progressBar = progressBar;
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Log.d(TAG, "doInBackground: ");
//        ImageView imageView = params[0];
//        publishProgress(imageView);
        url = params[0];
        Log.d(TAG, "doInBackground: " + url);
        return download_Image(url);
//        return null;
    }

    @Override
    protected void onProgressUpdate(ImageView... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
        super.onPostExecute(bitmap);
        progressBar.setVisibility(View.INVISIBLE);
    }

    private Bitmap download_Image(String url) {
        //---------------------------------------------------
        Bitmap bm = null;
        try {
            Log.d(TAG, "download_Image: " + url);
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e("Hub","Error getting the image from server : " + e.getMessage().toString());
        }
        return bm;
        //--z-------------------------------------------------
    }
}
