package com.onisq.phez;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Theme> mData;

    public RecyclerViewAdapter(Context mContext, List<Theme> data) {
        this.mContext = mContext;
        this.mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.book_item, viewGroup, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        vHolder.book_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Clicked " + String.valueOf(vHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_name.setText(mData.get(i).getName());
        myViewHolder.img.setImageResource(mData.get(i).getImg());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private ImageView img;
        private LinearLayout book_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            book_item = (LinearLayout) itemView.findViewById(R.id.item_book);
            tv_name = (TextView) itemView.findViewById(R.id.txt_theme);
            img = (ImageView) itemView.findViewById(R.id.img_theme);
        }
    }
}
