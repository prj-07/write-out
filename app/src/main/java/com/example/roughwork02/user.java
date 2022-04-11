package com.example.roughwork02;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class user extends AppCompatActivity implements ReccylerViewInterface{
    BottomNavigationView bottomNavigationView;
    TextView textView;
    RecyclerView recyclerView;
    DatabaseReference database ,fvrtref,fvrt_list;
    DatabaseReference databaseReference;
    MyAdapter myAdapter;
    ArrayList<UserHelperClass>list;
    CheckBox check;


    @NonNull
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView = findViewById(R.id.userlist);
        database = FirebaseDatabase.getInstance().getReference("Users");


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        check = findViewById(R.id.checkBox);
       //     check.setOnCheckedChangeListener((compoundButton, b) -> {
        //   Toast.makeText(this, "Added to Favourites", Toast.LENGTH_SHORT).show();
        //});

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list,this);
        recyclerView.setAdapter(myAdapter);





        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              for(DataSnapshot dataSnapshot: snapshot.getChildren()) {
                 UserHelperClass user = dataSnapshot.getValue(UserHelperClass.class);
                 list.add(user);
              }
              myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        textView = (TextView) findViewById(R.id.textViewhome);

        bottomNavigationView.setSelectedItemId(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation:
                        return true;
                    case R.id.favourites:
                        startActivity(new Intent(getApplicationContext(),Favourites.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.myarticles:
                        startActivity(new Intent(getApplicationContext(),MyArticles.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem item = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
            myAdapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean Oncheck(int position) {
        return false;
    }

}




















