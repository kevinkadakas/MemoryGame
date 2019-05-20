package com.kevinkadakas.memorygame;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaderBoard extends AppCompatActivity {

    List<Leaders> usersList = new ArrayList<>();
    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("User");
    userAdaptor adaptor;
    Button back;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        pb = findViewById(R.id.progressBar);
        pb.setVisibility(View.VISIBLE);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map <String, Map> map = (HashMap<String, Map>)dataSnapshot.getValue();

                List<Map> obj = new ArrayList<>(map.values());

                for (long p = 0; p < dataSnapshot.getChildrenCount();) {
                    String Name = String.valueOf(obj.get((int)p).get("Name"));
                    String Time = String.valueOf(obj.get((int)p).get("Time"));
                    String Points = String.valueOf(obj.get((int)p).get("Points"));
                    Double arg = Double.parseDouble(String.valueOf(obj.get((int)p).get("arg")));

                    Leaders leaders = new Leaders(Name, Time, Points, arg);
                    usersList.add(leaders);

                    p++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                resume();
                pb.setVisibility(View.GONE);
            }
        }, 3500);
    }
    public void resume() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(LeaderBoard.this));
        adaptor = new userAdaptor(LeaderBoard.this, usersList);
        recyclerView.setAdapter(adaptor);
        back = findViewById(R.id.button32);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(LeaderBoard.this, StartActivity.class);
                startActivity(back);
                finish();
            }
        });
    }
}
