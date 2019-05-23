package com.example.deya.seawatch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class SeattleCamerasAsyncTaskLoader extends AsyncTaskLoader<String> {

    private String queryString;

    public SeattleCamerasAsyncTaskLoader(Context context, String queryString) {
        super(context);
        this.queryString = queryString;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        String url = "https://web6.seattle.gov/Travelers/api/Map/Data?zoomId=13&type=2";
        return NetworkConnection.getData(url, queryString);
    }

    protected void onStartLoading() {
        forceLoad();
    }
}
