package com.coursework.forhealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private Toolbar toolBar;
    private String[] arraysList;
    private ArrayAdapter<String> adapter;
    private int categoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ListView listItem = findViewById(R.id.list_item);
        listItem.setAdapter(adapter);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,TextContentActivity.class);
                intent.putExtra("categoryIndex",categoryIndex);
                intent.putExtra("positionIndex",position);
                startActivity(intent);

            }
        });
    }

    private void init() {
        drawer = findViewById(R.id.drawer_layout);
        toolBar = findViewById(R.id.toolbar);
        arraysList = getResources().getStringArray(R.array.exercises);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(arraysList)));
        setSupportActionBar(toolBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        toolBar.setTitle(R.string.menu_exercises);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_exercises) {
            toolBar.setTitle(R.string.menu_exercises);
            arraysList = getResources().getStringArray(R.array.exercises);
            adapter.clear();
            adapter.addAll(arraysList);
            adapter.notifyDataSetChanged();
            categoryIndex = 0;
        } else if (id == R.id.nav_food) {
            toolBar.setTitle(R.string.menu_food);
            arraysList = getResources().getStringArray(R.array.food);
            adapter.clear();
            adapter.addAll(arraysList);
            adapter.notifyDataSetChanged();
            categoryIndex =1;
        } else if (id == R.id.nav_equipment) {
            toolBar.setTitle(R.string.menu_equipment);
            arraysList = getResources().getStringArray(R.array.equipment);
            adapter.clear();
            adapter.addAll(arraysList);
            adapter.notifyDataSetChanged();
            categoryIndex = 2;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}