package com.example.ujiangis_septaputriani;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng home = new LatLng(-0.786726622910357, 119.87580048050624);
        mMap.addMarker(new MarkerOptions().position(home).title("RUMAHKU"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));

        LatLng rs = new LatLng(-0.7891937380507967, 119.86952261177302);
        mMap.addMarker(new MarkerOptions().position(rs).title("Rumah sakit Madani"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rs));


        mMap.addPolyline(new PolylineOptions().add(
                home,
                new LatLng( -0.786726622910357, 119.87580048050624),
                new LatLng(-0.7876755135177607, 119.87567638310455),
                new LatLng(-0.7890331566316263, 119.86942041401201),
                new LatLng( -0.7891937380507967, 119.86952261177302),
                rs
                ).width(10)
                        .color(Color.GREEN)

        );
    }
}