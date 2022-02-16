//package com.example.distractme.ui.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.fragment.app.FragmentActivity;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.distractme.R;
//
//import java.util.List;
//
//public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
//
//    private List<String> mData;
//    private ImageView mMoodAddedImage;
//    private String mMoodAdded;
//    private LayoutInflater mInflater;
//    private ItemClickListener mClickListener;
//
//    // data is passed into the constructor
//    public RecyclerViewAdapter(Context context, List<String> data, ImageView moodAddedImage, String moodAdded) {
//        this.mInflater = LayoutInflater.from(context);
//        this.mData = data;
//        this.mMoodAddedImage = moodAddedImage;
//        this.mMoodAdded = moodAdded;
//    }
//
//    // inflates the row layout from xml when needed
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
//        return new ViewHolder(view);
//    }
//
//    // binds the data to the TextView in each row
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        String mood = mData.get(position);
//        ImageView moodImage = mMoodAddedImage;
//        holder.myTextView.setText(mood);
//
//            switch(mMoodAdded) {
//            case "Upset":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.upset_face));
//                holder.myImageView.setImageResource(R.drawable.upset_face);
//                break;
//            case "Sad":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.sad_face));
//                holder.myImageView.setImageResource(R.drawable.sad_face);
//                break;
//            case "Neutral":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.neutral_face));
//                holder.myImageView.setImageResource(R.drawable.neutral_face);
//                break;
//            case "Happy":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.happy_face));
//                holder.myImageView.setImageResource(R.drawable.happy_face);
//                break;
//            case "Extremely Happy":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.extremely_happy_face));
//                holder.myImageView.setImageResource(R.drawable.extremely_happy_face);
//                break;
//        }
//    }
//
//    // total number of rows
//    @Override
//    public int getItemCount() {
//        return mData.size();
//    }
//
//
//    // stores and recycles views as they are scrolled off screen
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView myTextView;
//        ImageView myImageView;
//
//        ViewHolder(View itemView) {
//            super(itemView);
//            myTextView = itemView.findViewById(R.id.tvMood);
//            myImageView = itemView.findViewById(R.id.ivMoodAdded);
//            itemView.setOnClickListener(this);
//
////            mMoodAddedImage.setImageResource(R.drawable.neutral_face);
////
////            switch(mMoodAdded) {
////                case "Upset":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.upset_face));
////                    myImageView.setImageResource(R.drawable.upset_face);
////                    break;
////                case "Sad":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.sad_face));
////                    myImageView.setImageResource(R.drawable.sad_face);
////                    break;
////                case "Neutral":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.neutral_face));
////                    myImageView.setImageResource(R.drawable.neutral_face);
////                    break;
////                case "Happy":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.happy_face));
////                    myImageView.setImageResource(R.drawable.happy_face);
////                    break;
////                case "Extremely Happy":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.extremely_happy_face));
////                    myImageView.setImageResource(R.drawable.extremely_happy_face);
////                    break;
////            }
//
//        }
//
//        @Override
//        public void onClick(View view) {
//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
//        }
//    }
//
//    // convenience method for getting data at click position
//    public String getItem(int id) {
//        return mData.get(id);
//    }
//
//    // allows clicks events to be caught
//    public void setClickListener(FragmentActivity itemClickListener) {
//        this.mClickListener = (ItemClickListener) itemClickListener;
//    }
//
//    // parent activity will implement this method to respond to click events
//    public interface ItemClickListener {
//        void onItemClick(View view, int position);
//    }
//}
//
//
//
//
//









//package com.example.distractme.ui.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.distractme.R;
//
//import java.util.List;
//
//public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
//
//    private List<String> mData;
//    private ImageView mMoodAddedImage;
//    private String mMoodAdded;
//    private LayoutInflater mInflater;
//    private ItemClickListener mClickListener;
//
//    // data is passed into the constructor
//    public RecyclerViewAdapter(Context context, List<String> data, ImageView moodAddedImage, String moodAdded) {
//        this.mInflater = LayoutInflater.from(context);
//        this.mData = data;
//        this.mMoodAddedImage = moodAddedImage;
//        this.mMoodAdded = moodAdded;
//    }
//
//    // inflates the row layout from xml when needed
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
//        return new ViewHolder(view);
//    }
//
//    // binds the data to the TextView in each row
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        String mood = mData.get(position);
////        ImageView moodImage = mMoodAddedImage.get(position);
//        holder.myTextView.setText(mood);
//
//        switch(mMoodAdded) {
//            case "Upset":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.upset_face));
//                holder.myImageView.setImageResource(R.drawable.upset_face);
//                break;
//            case "Sad":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.sad_face));
//                holder.myImageView.setImageResource(R.drawable.sad_face);
//                break;
//            case "Neutral":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.neutral_face));
//                holder.myImageView.setImageResource(R.drawable.neutral_face);
//                break;
//            case "Happy":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.happy_face));
//                holder.myImageView.setImageResource(R.drawable.happy_face);
//                break;
//            case "Extremely Happy":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.extremely_happy_face));
//                holder.myImageView.setImageResource(R.drawable.extremely_happy_face);
//                break;
//        }
//    }
//
//    // total number of rows
//    @Override
//    public int getItemCount() {
//        return mData.size();
//    }
//
//
//    // stores and recycles views as they are scrolled off screen
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView myTextView;
//        ImageView myImageView;
//
//        ViewHolder(View itemView) {
//            super(itemView);
//            myTextView = itemView.findViewById(R.id.tvMood);
//            myImageView = itemView.findViewById(R.id.ivMoodAdded);
//            itemView.setOnClickListener(this);
//
////            mMoodAddedImage.setImageResource(R.drawable.neutral_face);
////
////            switch(mMoodAdded) {
////                case "Upset":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.upset_face));
////                    myImageView.setImageResource(R.drawable.upset_face);
////                    break;
////                case "Sad":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.sad_face));
////                    myImageView.setImageResource(R.drawable.sad_face);
////                    break;
////                case "Neutral":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.neutral_face));
////                    myImageView.setImageResource(R.drawable.neutral_face);
////                    break;
////                case "Happy":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.happy_face));
////                    myImageView.setImageResource(R.drawable.happy_face);
////                    break;
////                case "Extremely Happy":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.extremely_happy_face));
////                    myImageView.setImageResource(R.drawable.extremely_happy_face);
////                    break;
////            }
//
//        }
//
//        @Override
//        public void onClick(View view) {
//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
//        }
//    }
//
//    // convenience method for getting data at click position
//    public String getItem(int id) {
//        return mData.get(id);
//    }
//
//    // allows clicks events to be caught
//    public void setClickListener(ItemClickListener itemClickListener) {
//        this.mClickListener = (ItemClickListener) itemClickListener;
//    }
//
//    // parent activity will implement this method to respond to click events
//    public interface ItemClickListener {
//        void onItemClick(View view, int position);
//    }
//}






















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
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public RecyclerViewAdapter(Context context, List<String> data, ImageView moodAddedImage, List<Integer> dataImg) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mMoodAddedImage = moodAddedImage;
//        this.mMoodAdded = moodAdded;
        this.mDataImg = dataImg;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String mood = mData.get(position);
//        ImageView moodImage = mMoodAddedImage.get(position);
        holder.myTextView.setText(mood);
        Integer moodImg = mDataImg.get(position);

        switch(moodImg) {
            case 1:
//                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.upset_face));
                holder.myImageView.setImageResource(R.drawable.upset_face);
                break;
            case 2:
//                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.sad_face));
                holder.myImageView.setImageResource(R.drawable.sad_face);
                break;
            case 3:
//                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.neutral_face));
                holder.myImageView.setImageResource(R.drawable.neutral_face);
                break;
            case 4:
//                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.happy_face));
                holder.myImageView.setImageResource(R.drawable.happy_face);
                break;
            case 5:
//                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.extremely_happy_face));
                holder.myImageView.setImageResource(R.drawable.extremely_happy_face);
                break;
        }
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageView myImageView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvMood);
            myImageView = itemView.findViewById(R.id.ivMoodAdded);
            itemView.setOnClickListener(this);

//            mMoodAddedImage.setImageResource(R.drawable.neutral_face);
//
//            switch(mMoodAdded) {
//                case "Upset":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.upset_face));
//                    myImageView.setImageResource(R.drawable.upset_face);
//                    break;
//                case "Sad":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.sad_face));
//                    myImageView.setImageResource(R.drawable.sad_face);
//                    break;
//                case "Neutral":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.neutral_face));
//                    myImageView.setImageResource(R.drawable.neutral_face);
//                    break;
//                case "Happy":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.happy_face));
//                    myImageView.setImageResource(R.drawable.happy_face);
//                    break;
//                case "Extremely Happy":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.extremely_happy_face));
//                    myImageView.setImageResource(R.drawable.extremely_happy_face);
//                    break;
//            }

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = (ItemClickListener) itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}