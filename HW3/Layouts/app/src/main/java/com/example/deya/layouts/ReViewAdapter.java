package com.example.deya.layouts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ReViewAdapter extends RecyclerView.Adapter<ReViewAdapter.ViewHolder> {
    private List<String>    rvData;
    private LayoutInflater  rvInflater;
    private ItemClickListener rvClickListener;

    /**
     * Constructor.
     * @param context
     * @param data
     */
    ReViewAdapter(Context context, List<String> data) {
        this.rvInflater = LayoutInflater.from(context);
        this.rvData = data;
    }

    /**
     * Inflates the row layout from xml as needed.
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = rvInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Binds the data for row to the TextView using its position
     * @param viewHolder
     * @param pos
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        String movie = rvData.get(pos);
        viewHolder.rvTextView.setText(movie);
    }

    /**
     * Finds the size of the data
     * @return total number of rows
     */
    @Override
    public int getItemCount() {
        return rvData.size();
    }

    /**
     * Holds views to be recycled as they go off-screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView rvTextView;

        ViewHolder(View itemView) {
            super(itemView);
            rvTextView = itemView.findViewById(R.id.movieTitleView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (rvClickListener != null) rvClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    /**
     * Gets ID of the clicked position
     * @param posId
     * @return String int id
     */
    private String getItem(int posId) {
        return rvData.get(posId);
    }

    /**
     * listens for click, is grabbed event
     * @param itemClickListener
     */
    void setClickListener(ItemClickListener itemClickListener) {
        this.rvClickListener = itemClickListener;
    }

    /**
     * interface for when there are clicks to respond to
     * implementation will grab view and position
     */
    public interface ItemClickListener {
        void onItemClick(View view, int pos);
    }
}
