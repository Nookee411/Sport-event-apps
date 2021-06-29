package ru.example.sportevents.ui.main;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ru.example.sportevents.R;

public class EventViewHolder extends RecyclerView.ViewHolder {
    protected TextView eventName;
    protected TextView eventDate;
    public String eventHash;
    protected MaterialButton button;
    protected FirebaseAuth instance;
    protected FirebaseUser user;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        eventName =itemView.findViewById(R.id.event_name);
        eventDate =itemView.findViewById(R.id.event_desc);
        button = itemView.findViewById(R.id.buttonGo);

    }

    public void bind(Event event) {
        eventHash = event.getHash();
        eventName.setText(event.getName());
        eventDate.setText(event.getDate());
//        instance = FirebaseAuth.getInstance();
//        user = instance.getCurrentUser();
//        Log.d("DATABASE", "bind: "+user/.getEmail());
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("BUTTON", event.getHash() + " to "+ user.getDisplayName());
//            }
//        });
    }
}
