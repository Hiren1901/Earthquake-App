package com.example.earthquacke;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;



public class EarthQuakeLoader extends AsyncTaskLoader<List<quackeinfo>> {
    private  String urls;



    public EarthQuakeLoader(@NonNull Context context, String urls) {
        super(context);
        this.urls=urls;
    }

    public EarthQuakeLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<quackeinfo> loadInBackground() {
        // Don't perform the request if there are no URLs, or the first URL is null.


        List<quackeinfo> result = Queryutils.fetchEarthquakeData(urls);
        return result;

    }
}
