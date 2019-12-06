package com.chatproject.listview_search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "Line 3", "Line 4"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Line 5", "Line 6"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 7", "Line 8"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "Line 9", "Line 10"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Line 11", "Line 12"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 13", "Line 14"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "Line 15", "Line 16"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Line 17", "Line 18"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 19", "Line 20"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "Line 21", "Line 22"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_foreground, "Line 23", "Line 24"));
    }

    private void setUpRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        System.out.println("실");
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
}
