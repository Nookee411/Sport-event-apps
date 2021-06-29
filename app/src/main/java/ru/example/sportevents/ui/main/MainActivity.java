package ru.example.sportevents.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import ru.example.sportevents.R;

public class MainActivity extends AppCompatActivity {
        RecyclerView eventList;
        EventListAdapter eventsAdapter;
        FirebaseAuth instance;
        FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        instance = FirebaseAuth.getInstance();
        user = instance.getCurrentUser();
        Log.d("DATABASE", "onCreate: "+ user.getEmail());
        eventList = findViewById(R.id.EventList);
        eventsAdapter = new EventListAdapter();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public synchronized void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("MAIN", "onDataChange: "+ snapshot.getValue());
                HashMap<String,HashMap<String,String>> value = (HashMap<String,HashMap<String,String>>)snapshot.getValue();
                Log.d("MAIN", "Value is: " + value);
                value.forEach((key, val)->{
                    Log.d("MAIN", "onDataChange: "+ val.get("name") + " "+ val.get("location"));
                    eventsAdapter.events.add(new Event(val.get("name"), val.get("location"),val.get("location"),key));
//                    MaterialButton button =  eventList.getChildAt(index.getAndIncrement()).findViewById(R.id.buttonGo);
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Log.d("DATABASE", "onClick: " + user.getDisplayName());
//                        }
//                    });
                });
                eventsAdapter.notifyDataSetChanged();
                Log.d("DATABASE", "onDataChange: " + eventList.getChildCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("DATABASE", "onCancelled: " + error.getMessage());
            }
        });
        setContentView(R.layout.activity_main);
        eventsAdapter = new EventListAdapter();
        eventList = findViewById(R.id.EventList);
        eventList.setLayoutManager(new LinearLayoutManager(this));
        eventList.setAdapter(eventsAdapter);
    }



}