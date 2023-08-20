package com.example.earthquacke;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<List<quackeinfo>> {
ListView listView;
quackeAdapter mAdapter;
List<quackeinfo> a;
TextView textView;
    private static final String SAMPLE_JSON_RESPONSE = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.l1);
        textView=findViewById(R.id.empty_view);
        listView.setEmptyView(textView);
        a=new ArrayList<quackeinfo>();
        mAdapter=new quackeAdapter(this,0, (ArrayList) a);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mAdapter.getItem(i).getUrl()));
                startActivity(intent);
            }
        });
        getLoaderManager().initLoader(1,null,this);

    }


    @Override
    public android.content.Loader<List<quackeinfo>> onCreateLoader(int id, Bundle args) {

        return new EarthQuakeLoader(this,SAMPLE_JSON_RESPONSE);
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<quackeinfo>> loader, List<quackeinfo> data) {

        mAdapter.clear();
        textView.setText("NO Information Found");
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);


        }
    }

    @Override
    public void onLoaderReset(android.content.Loader<List<quackeinfo>> loader) {
        mAdapter.clear();
    }







}