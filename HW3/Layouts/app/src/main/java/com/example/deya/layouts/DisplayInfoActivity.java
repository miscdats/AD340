package com.example.deya.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class DisplayInfoActivity extends AppCompatActivity {

    private static final String TAG = "DISPLAY_INFO_ACT : ";

    private Movie[] movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Log.i(TAG, " has started.");

        // use recycler with fixed size
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        // layout manager
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        // pull up helper method with ready list
        this.movies = Movie.initMovies();

        // set recycler view adapter to movies list
        ReViewAdapter adapter = new ReViewAdapter(movies);
        recyclerView.setAdapter(adapter);
        adapter.setListener(new ReViewAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Log.i(TAG, movies[position].getTitle() + " has been clicked.");

                // send intent if movie clicked on
                Intent intent
                        = new Intent(getApplicationContext(), MovieDetails.class);

                // get details for movie clicked
                String title = movies[position].getTitle();
                String year = movies[position].getYear();
                String director = movies[position].getDirector();
                String image = movies[position].getImage();
                String synopsis = movies[position].getSynopsis();


                // send intent with details
                intent.putExtra("title", title);
                intent.putExtra("year", year);
                intent.putExtra("image", image);
                intent.putExtra("director", director);
                intent.putExtra("synopsis", synopsis);

                // start movie details page activity
                startActivity(intent);
            }
        });

    }

}
