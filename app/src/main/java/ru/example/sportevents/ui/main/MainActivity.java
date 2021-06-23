package ru.example.sportevents.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import ru.example.sportevents.R;

public class MainActivity extends AppCompatActivity {
        RecyclerView eventList;
        EventListAdapter eventsAdapter;
        CardView cardLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventsAdapter = new EventListAdapter();
        eventList = findViewById(R.id.EventList);
        eventList.setLayoutManager(new LinearLayoutManager(this));
        eventList.setAdapter(eventsAdapter);
//        chatMessageList.scrollToPosition(messageListAdapter.messageList.size()-1);

        eventsAdapter.events.add(new Event("Первое событие", "Первое описание события","Киров"));
        eventsAdapter.notifyDataSetChanged();
    }
}