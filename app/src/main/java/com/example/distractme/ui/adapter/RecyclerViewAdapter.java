package com.example.distractme.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.distractme.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> mData;
    private List<Integer> mDataImg;
    private ImageView mMoodAddedImage;
    private String mMoodAdded;
    private LayoutInflater mInflater;
    private final MyClickListener mMyClickListener;

    // data is passed into the constructor
    public RecyclerViewAdapter(Context context, List<String> data, ImageView moodAddedImage, List<Integer> dataImg, MyClickListener myClickListener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mMoodAddedImage = moodAddedImage;
        mMyClickListener = myClickListener;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        ViewHolder view2 = new ViewHolder(view);
        view2.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the position of this Vh
                int position = view2.getAdapterPosition();
                if (mMyClickListener != null) mMyClickListener.onItemClick(position);
            }
        });
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String mood = mData.get(position);
        holder.myTextView.setText(mood);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        ImageView myImageView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvMood);
            myImageView = itemView.findViewById(R.id.ivMoodAdded);
        }
    }

    public interface MyClickListener {
        void onItemClick(int position);
    }
    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData.get(id);
    }
}