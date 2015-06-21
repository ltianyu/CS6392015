package com.example.litianyu.asynctaskproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends Activity {
    private static Button download;
    private static ImageView View;
    private static Bitmap image;
    private static ProgressDialog wait;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class LoadImage extends AsyncTask<String,String,Bitmap>{
        protected void onPreExecute(){
            wait = new ProgressDialog(MainActivity.this);
            wait.setMessage("the image is loading.");
            wait.show();
        }
        protected Bitmap doInBackground(String...args){
            try {
                image =BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
            } catch (Exception e){
                e.printStackTrace();
            }
            return image;
        }
        protected void onPostExecute(Bitmap image){
            if(image != null){
                View.setImageBitmap(image);
                wait.dismiss();
            }
            else {
                wait.dismiss();
                Toast.makeText(MainActivity.this,"some eorrors",Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void downloadclick(View view){
        download=(Button)findViewById(R.id.button);
        View=(ImageView)findViewById(R.id.imageView);
        download.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                new LoadImage().execute("https://raw.githubusercontent.com/ltianyu/CS6392015/master/qingdao.jpg");

            }
        });
    }



}
