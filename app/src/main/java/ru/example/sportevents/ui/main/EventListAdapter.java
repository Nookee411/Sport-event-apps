package ru.example.sportevents.ui.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import ru.example.sportevents.R;

public class EventListAdapter extends RecyclerView.Adapter {
    public ArrayList<Event> events = new ArrayList<>();
    private FirebaseAuth instance;
    private FirebaseUser user;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_card,parent,false);
        view.findViewById(R.id.buttonGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DATABASE", "onClick: " + v);
            }
        });
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Event eventItem= events.get(position);
        ((EventViewHolder)holder).bind(eventItem);
    }



    @Override
    public int getItemCount() {
        return events.size();
    }
}
