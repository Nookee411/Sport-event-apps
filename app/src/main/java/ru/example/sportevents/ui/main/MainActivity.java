package ru.example.sportevents.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.customview.widget.ViewDragHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

import ru.example.sportevents.R;

public class MainActivity extends AppCompatActivity {
        RecyclerView eventList;
        EventListAdapter eventsAdapter;
        CardView cardLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Log.d("MAIN", "onCreate: "+ myRef);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("MAIN", "onDataChange: "+ snapshot.getValue());
                HashMap<String,HashMap<String,String>> value = (HashMap<String,HashMap<String,String>>)snapshot.getValue();
                Log.d("MAIN", "Value is: " + value);

                value.values().forEach(ele->{
                    Log.d("MAIN", "onDataChange: "+ ele.get("name") + " "+ ele.get("location"));
                    eventsAdapter.events.add(new Event(ele.get("name"), ele.get("location"),ele.get("location")));
                    eventsAdapter.notifyDataSetChanged();
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        setContentView(R.layout.activity_main);
        eventsAdapter = new EventListAdapter();
        eventList = findViewById(R.id.EventList);
        eventList.setLayoutManager(new LinearLayoutManager(this));
        eventList.setAdapter(eventsAdapter);
        eventsAdapter.events.add(new Event("Первое событие", "Первое описание события","Киров"));
        eventsAdapter.notifyDataSetChanged();
        eventsAdapter.events.add(new Event("Второе событие", "Второе описание события","Киров"));
        eventsAdapter.notifyDataSetChanged();
    }


}