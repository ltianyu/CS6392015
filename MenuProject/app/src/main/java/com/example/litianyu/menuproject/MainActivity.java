package com.example.litianyu.menuproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

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
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_help){
            Intent intent = new Intent(this,HelpActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    public void btnsms(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + Uri.encode("3473343218")));
        intent.putExtra("sms_body", "TianyuLi");
        startActivity(intent);
    }
    public void btn_tele(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:3473343218"));
        startActivity(intent);
    }
    public void btn_web(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pace.edu"));
        startActivity(intent);
    }
    public void btn_map(View v){
        String geoLoc = String.format("geo:36.0668216,120.3562409");
        Uri geo = Uri.parse(geoLoc);
        Intent intent = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(intent);
    }
    public void btn_share(View v){
        Intent intent = new Intent(Intent.ACTION_CHOOSER);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Share the love!"));

    }
    public void btn_new(View v){
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

}
