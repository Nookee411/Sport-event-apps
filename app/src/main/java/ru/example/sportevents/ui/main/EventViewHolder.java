package ru.example.sportevents.ui.main;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ru.example.sportevents.R;

public class EventViewHolder extends RecyclerView.ViewHolder {

    protected TextView eventName;
    protected TextView eventDescription;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        eventName = itemView.findViewById(R.id.event_name);
        eventDescription = itemView.findViewById(R.id.event_desc);
    }

    public void bind(Event event) {
        eventName.setText(event.getName());
        eventDescription.setText(event.getDescription());
    }

}
