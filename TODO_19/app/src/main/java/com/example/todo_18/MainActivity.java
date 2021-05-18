package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.media.MediaParser;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Sport> mSportsData;
    SportsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int gridColumnCount = getResources().getInteger(R.integer.gird_column_count);
        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //set the layout manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //Initilize array list to contain the data
        mSportsData = new ArrayList<>();
        //
        mAdapter = new SportsAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }
    private void initializeData() {
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);
        String[] sportList = getResources().getStringArray(R.array.sports_title);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);


        //clear the existing data to avoid duplication
        mSportsData.clear();
        for (int i = 0; i < sportList.length; i++){
            mSportsData.add(new Sport(sportList[i], sportsInfo[i], sportsImageResources.getResourceId(i,0)));

        }
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();

    }
}