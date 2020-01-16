package com.example.sdkmapasgoogle;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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

        // Metodo p mudar o mapa
       // mMap.setMapType(googleMap.MAP_TYPE_SATELLITE);

        // Adicionando evento de clic no mapa

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this,
                        "onCLick Lat: " + latitude + "long: " + longitude,
                        Toast.LENGTH_SHORT).show();

                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Local")
                        .snippet("Descrição")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.spaceship))
                );
            }
        });


        // Adicione um marcador em Blumenau e mova a câmera
        LatLng blumenau = new LatLng(-26.9150432, -49.0656267);
        //-26.9150432,-49.0656267

        mMap.addMarker(new MarkerOptions()
                .position(blumenau)
                .title("\n" + "Marcador em Blumenau")
               // Trocando a cor do icone
               /* .icon(
                        BitmapDescriptorFactory.defaultMarker(
                                BitmapDescriptorFactory.HUE_MAGENTA)
                )*/
               // Colocando uma img como icone
               .icon(BitmapDescriptorFactory.fromResource(R.drawable.spaceship))
        );


        mMap.moveCamera(CameraUpdateFactory.newLatLng(blumenau));
    }
}
