package com.example.soha.model;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soha.note.Note_detail;
import com.example.soha.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder>{
    List<String> titles;
    List<String> content;
    public Adapter(List<String> title,List<String> content){
        this.titles=title;
        this.content=content;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_view_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.noteTitle.setText(titles.get(position));
        holder.noteContent.setText(content.get(position));
        //holder.mCardView.setCardBackgroundColor(holder.view.getResources().getColor(getRandomcolor(),null));
       final Integer code = getRandomcolor();
        holder.mCardView.setBackgroundResource(code);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Note_detail.class);
                i.putExtra("title",titles.get(position));
                i.putExtra("content",content.get(position));
                i.putExtra("code",code);

                v.getContext().startActivity(i);
            }
        });
    }

    private int getRandomcolor() {
        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.blue);
        colorCode.add(R.color.yellow);
        //colorCode.add(R.drawable.common_google_signin_btn_icon_dark);
        //colorCode.add(R.drawable.common_google_signin_btn_icon_disabled);
        //colorCode.add(R.drawable.common_google_signin_btn_icon_light_normal);

        Random randomColor = new Random();

        int number = randomColor.nextInt(colorCode.size());
        return colorCode.get(number);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView noteTitle,noteContent;
       View view;
       CardView mCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.titles);
            noteContent=itemView.findViewById(R.id.content);
            mCardView = itemView.findViewById((R.id.noteCard));
            view=itemView;
        }
    }
}
