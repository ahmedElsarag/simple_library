package com.example.books;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdabter extends RecyclerView.Adapter<RecyclerViewAdabter.MyViewHolder> {

    Context context;
    List<Book> mData;

    public RecyclerViewAdabter(Context context, List<Book> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_item_book,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder,final int i) {
        myViewHolder.txt.setText(mData.get(i).getTitle());
        myViewHolder.img.setImageResource(mData.get(i).getThumbnail());

        myViewHolder.cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Second.class);
                intent.putExtra("title",mData.get(i).getTitle());
                intent.putExtra("decription",mData.get(i).getDescription());
                intent.putExtra("thumbnail",mData.get(i).getThumbnail());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt;
        ImageView img;
        CardView cr;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.book_title_id);
            img = itemView.findViewById(R.id.book_img_id);
            cr = itemView.findViewById(R.id.card_view_id);
        }
    }
}
