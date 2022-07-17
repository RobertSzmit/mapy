package com.example.mapy;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapy.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(-34, 151); // koordynaty
        LatLng zulawy = new LatLng(50, 50);

        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")); // tytuł markera

        mMap.addMarker(new MarkerOptions()
                .position(zulawy)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logo_zulawy))  // tak się wywołuje metodę do logosów na mapie
                .title("ŻUŁAWY"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(zulawy)); // gdzie ma się skupić mapa na początku

    }
}