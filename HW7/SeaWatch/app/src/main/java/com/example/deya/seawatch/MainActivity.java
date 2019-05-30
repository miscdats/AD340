package com.example.deya.seawatch;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        LoaderManager.LoaderCallbacks<String>, OnMapReadyCallback {

    private static final String TAG = "MAIN_ACTIVITY : ";
    static TextView textLocation;
    static Context context;
    private SDOTCameraAdapter cameraAdapter;
    private FusedLocationProviderClient mLocationClient;
    private boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLocation = (TextView)findViewById(R.id.text_location);
        Button button = findViewById(R.id.btn_data_get);
        button.setOnClickListener(this);

        mLocationClient = LocationServices.getFusedLocationProviderClient(this);
        SupportMapFragment mapFragment
                = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map_fragment);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            Bundle bundle = new Bundle();
            getSupportLoaderManager().restartLoader(0, bundle, this);
        } else {
            Toast.makeText(this,
                    getResources().getString(R.string.no_connection),
                    Toast.LENGTH_SHORT).show();
        }

        Bundle bundle = new Bundle();
        bundle.putString("queryString", "Fauntleroy_SW_Cloverdale_NS.jpg");
        getSupportLoaderManager().restartLoader(0, bundle, this);

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
//        String queryString = "";
//        if (bundle != null) {
//            queryString = bundle.getString("queryString");
//        }
//        the above code used if querying something specific!
        return new SeattleCamerasAsyncTaskLoader(this, "");
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        try {
            // the JSON object itself
            JSONObject rootObject = new JSONObject(s);
            JSONArray features = rootObject.getJSONArray("Features");

            // create list of all data in object
            final TrafficCamera[] trafficCameras = new TrafficCamera[features.length()];

            for (int i = 0; i < features.length(); i++) {
                JSONObject current = features.getJSONObject(i);

                JSONArray coordinates = current.getJSONArray("PointCoordinate");
                double latitude = coordinates.getDouble(0);
                double longitude = coordinates.getDouble(1);

                JSONArray cameras = current.getJSONArray("Cameras");
                JSONObject camera = cameras.getJSONObject(0);

                String id = camera.getString("Id");
                String description = camera.getString("Description");
                String imageUrl = camera.getString("ImageUrl");
                String type = camera.getString("Type");

                TrafficCamera trafficCamera = new TrafficCamera(latitude, longitude, id, description, imageUrl, type);
                trafficCameras[i] = trafficCamera;
            }

            final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_data_view);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(linearLayoutManager);

            // lay it all out in recycler view
            cameraAdapter = new SDOTCameraAdapter(trafficCameras);
            recyclerView.setAdapter(cameraAdapter);

            // click on item shows coordinates
            cameraAdapter.setOnClickListener(new SDOTCameraAdapter.ClickListener() {
                @Override
                public void onClick(int pos, View view) {
                    trafficCameras[recyclerView.getChildAdapterPosition(view)]
                            .viewCoordinatesString(textLocation);
                }
            });

            // long click on item sends position to log
            cameraAdapter.setOnLongClickListener(new SDOTCameraAdapter.LongClickListener() {
                @Override
                public void onLongClick(int position, View v) {
                    Log.d(TAG, "onLongClick pos = " + position);
                }
            });

        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public static TextView getTextLocation() {
        return textLocation;
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        if (mLocationPermissionGranted) {
            try {
                Task location = mLocationClient.getLastLocation();

                location.addOnCompleteListener(new OnCompleteListener<Location>() {

                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location actualLocation = task.getResult();

                        if (actualLocation != null) {
                            String latlong = String.format("Lat: %f, Long: %f",
                                    actualLocation.getLatitude(),
                                    actualLocation.getLongitude());
                            mMap.setMyLocationEnabled(true);
                            mMap.getUiSettings().setMyLocationButtonEnabled(true);

                            // Update the map
                            LatLng here = new LatLng(actualLocation.getLatitude(),
                                    actualLocation.getLongitude());
                            mMap.addMarker(new MarkerOptions().position(here).title("WHERE I BE"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(here, 10));
                            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));

                        } else {
                            Log.e(TAG, "Location is null ...");
                        }
                    }
                });
            } catch (Exception e) {
                Log.e(TAG, e.getLocalizedMessage());
            }
        }
    }

    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.ACCESS_COARSE_LOCATION },
                    1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            // requestCode: request ID
            case 1: {
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                    getLocation();
                }
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getLocationPermission();
        getLocation();
    }
}
