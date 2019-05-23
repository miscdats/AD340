package com.example.deya.seawatch;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SDOTCameraAdapter extends RecyclerView.Adapter<SDOTCameraAdapter.ViewHolder>
        implements LoaderManager.LoaderCallbacks<String> {

    private final static String TAG = "CAM_ADAPTER: ";
    private String SDOTBaseUrl = "http://www.seattle.gov/trafficcams/images/";
    private String WSDOTBaseUrl = "http://images.wsdot.wa.gov/nw/";
    private TrafficCamera[] trafficCameras;
    private Listener listener;

    public SDOTCameraAdapter(TrafficCamera[] trafficCameras) {
        this.trafficCameras = trafficCameras;
    }

    @NonNull
    @Override
    public SDOTCameraAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_recycler, viewGroup, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int pos) {
        CardView cardView = viewHolder.layout;
        final Context context = cardView.getContext();

        TextView cameraInfo = (TextView)cardView.findViewById(R.id.text_results);
        ImageView imageView = (ImageView)cardView.findViewById(R.id.image_camera);

        final TrafficCamera trafficCamera = trafficCameras[pos];
        cameraInfo.setText(trafficCamera.getDescription());

        Picasso.get().load(trafficCamera.getImageUrl()).into(imageView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(pos);
                    trafficCamera.viewCoordinatesString(MainActivity.getTextLocation());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return trafficCameras.length;
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView layout;

        public ViewHolder(CardView v) {
            super(v);
            layout = v;
        }
    }

    interface Listener {
        void onClick(int pos);
    }
}
