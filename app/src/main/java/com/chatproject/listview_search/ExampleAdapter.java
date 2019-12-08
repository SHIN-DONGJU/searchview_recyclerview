package com.chatproject.listview_search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> implements Filterable {
    private List<ExampleItem> exampleList;
    private List<ExampleItem> exampleListFull;

    private OnCookListener mOnCookListener;

    class  ExampleViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener {
        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;
        RatingBar ratingBar;
        OnCookListener onCookListener;

        ExampleViewHolder(@NonNull View itemView, OnCookListener onCookListener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            ratingBar = itemView. findViewById(R.id.ratingBar);

            this.onCookListener = onCookListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCookListener.onCookClick(getAdapterPosition());
        }
    }

    public interface OnCookListener{
        void onCookClick(int position);
    }

    ExampleAdapter(List<ExampleItem> exampleList, OnCookListener onCookListener) {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
        this.mOnCookListener = onCookListener;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mOnCookListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = exampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
        holder.ratingBar.setRating(currentItem.getRate());
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constrant) {
            List<ExampleItem> filteredList = new ArrayList<>();

            if(constrant == null || constrant.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constrant.toString().toLowerCase().trim();

                for (ExampleItem item : exampleListFull) {
                    if (item.getText1().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            exampleList.clear();
            exampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}

