package com.kevinkadakas.memorygame;

import android.app.Person;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.Inflater;

public class userAdaptor extends RecyclerView.Adapter<userAdaptor.ViewHolder> {

    private List<Leaders> users;
    private LayoutInflater inflater;

    userAdaptor(Context context, List<Leaders> Data) {
        this.inflater = LayoutInflater.from(context);

        Collections.sort(Data, new Comparator<Leaders>() {
            @Override
            public int compare(Leaders o1, Leaders o2) {
                return Double.compare(o2.getrArg(), o1.getrArg());
            }
        });

        this.users = Data;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView username, rTime, rPoints;

        ViewHolder(View view) {
            super(view);
            username = view.findViewById(R.id.Name);
            rTime = view.findViewById(R.id.Time);
            rPoints = view.findViewById(R.id.Points);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;
        String name = users.get(pos).getUsername();
        String rTime = users.get(pos).getrTime();
        String rPoints = users.get(pos).getrPoints();
        holder.username.setText(name);
        holder.rPoints.setText(rPoints);
        holder.rTime.setText(rTime);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = inflater.inflate(R.layout.list_users, viewGroup, false);
        return new ViewHolder(view);
    }
}
