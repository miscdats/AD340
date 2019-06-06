package com.example.deya.layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MovieDetails extends Activity {

    private static final String TAG = "MOVIE_DETAILS: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get intent passed in
        Intent intent = getIntent();
        // get details in
        String title = intent.getStringExtra("title");
        String year = intent.getStringExtra("year");
        String director = intent.getStringExtra("director");
        String image = intent.getStringExtra("image");
        String synopsis = intent.getStringExtra("synopsis");
        // set view
        setContentView(R.layout.activity_movie_details);
        Log.i(TAG, " has started.");

        // labels role call
        TextView viewTitle = (TextView) findViewById(R.id.title);
        TextView viewYear = (TextView) findViewById(R.id.year);
        TextView viewDirector = (TextView) findViewById(R.id.director);
        WebView viewImage = (WebView) findViewById(R.id.image);
        TextView viewSynopsis = (TextView) findViewById(R.id.synopsis);

        // set details
        viewTitle.setText(title);
        viewYear.setText(year);
        viewDirector.setText(director);
        viewImage.loadUrl(image);
        viewSynopsis.setText(synopsis);

        // web view client
        viewImage.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        viewImage.getSettings().setLoadWithOverviewMode(true);
        viewImage.getSettings().setUseWideViewPort(true);

    }
}
