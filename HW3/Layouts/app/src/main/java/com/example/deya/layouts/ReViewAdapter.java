package com.example.deya.layouts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Recycle view adapter fit for displaying custom Movie objects.
 */
public class ReViewAdapter extends RecyclerView.Adapter<ReViewAdapter.ViewHolder> {

    private Movie[] movies;

    /**
     * Constructor.
     */
    public ReViewAdapter(Movie[] movies) {
        this.movies = movies;
    }

    /**
     * Inflates the row layout from xml as needed.
     *
     * @param parent
     * @param viewType
     * @return new viewholder for cardview
     */
    @NonNull
    @Override
    public ReViewAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {

        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_recycler_item, parent, false);
        return new ViewHolder(cardView);
    }

    /**
     * Binds the data for row to the TextView using its position
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.layout;
        TextView title = (TextView) cardView.findViewById(R.id.card_title);
        TextView year = (TextView) cardView.findViewById(R.id.card_year);

        Context context = cardView.getContext();

        // take position of movies and get movie
        Movie movie = movies[position];

        // get details for that movie and set in views
        title.setText(movie.getTitle());
        year.setText(movie.getYear());

        // listener
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    /**
     * Finds the size of the data
     *
     * @return total number of rows
     */
    @Override
    public int getItemCount() {
        return movies.length;
    }

    // listener set to stun
    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    interface Listener {
        void onClick(int position);
    }

    /**
     * Holds views to be recycled as they go off-screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView layout;

        public ViewHolder(CardView v) {
            super(v);
            layout = v;
        }
    }

}