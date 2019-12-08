package com.chatproject.listview_search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ExampleAdapter.OnCookListener {
    private static final String TAG = "MainActivity";
    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillExampleList();
        setUpRecyclerView();
    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.ic_android, "김수미의 김치찌개", "소요시간 : 20분"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "마카나이 덮밥", "소요시간 : 10분"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "돈부리부리", "소요시간 : 15분"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "소고기 김밥", "소요시간 : 18분"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "어쩌구 저쩌구", "소요시간 : 5분"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "계란후라이", "소요시간 : 1분"));
    }

    private void setUpRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList, this);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public void onCookClick(int position) {
        Log.d(TAG, "onCookClick: clicked" + position); // 위치 확인 코

        if(position == 0) {
            Intent intent = new Intent(this, NextPage.class);
            startActivity(intent);
        }

        if(position == 1) {
            Intent intent = new Intent(this, NextPage2.class);
            startActivity(intent);
        }

        if(position == 2) {
            Intent intent = new Intent(this, NextPage3.class);
            startActivity(intent);
        }

        if(position == 3) {
            Intent intent = new Intent(this, NextPage4.class);
            startActivity(intent);
        }

        if(position == 4) {
            Intent intent = new Intent(this, NextPage5.class);
            startActivity(intent);
        }
    }
}
