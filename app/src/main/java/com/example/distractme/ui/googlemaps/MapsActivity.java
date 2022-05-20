package com.example.distractme.ui.googlemaps;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {


    private GoogleMap mMap;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location lastlocation;
    private Marker currentLocationmMarker;
    public static final int REQUEST_LOCATION_CODE = 99;
    int PROXIMITY_RADIUS = 10000;
    double latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            checkLocationPermission();

        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case REQUEST_LOCATION_CODE:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=  PackageManager.PERMISSION_GRANTED)
                    {
                        if(client == null)
                        {
                            bulidGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else
                {
                    Toast.makeText(this,"Permission Denied" , Toast.LENGTH_LONG).show();
                }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            bulidGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }


    protected synchronized void bulidGoogleApiClient() {
        client = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        client.connect();

    }

    @Override
    public void onLocationChanged(Location location) {

        latitude = location.getLatitude();
        longitude = location.getLongitude();
        lastlocation = location;
        if(currentLocationmMarker != null)
        {
            currentLocationmMarker.remove();

        }
        Log.d("lat = ",""+latitude);
        LatLng latLng = new LatLng(location.getLatitude() , location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        currentLocationmMarker = mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(10));

        if(client != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(client, this);
        }
    }

    public void onClick(View v)
    {
        Object dataTransfer[] = new Object[2];
        NearbyPlacesData NearbyPlacesData = new NearbyPlacesData();

        switch(v.getId())
        {
            case R.id.btn_search:
                EditText tf_location =  findViewById(R.id.TF_location);
                String location = tf_location.getText().toString();
                List<Address> addressList;


                if(!location.equals(""))
                {
                    Geocoder geocoder = new Geocoder(this);

                    try {
                        addressList = geocoder.getFromLocationName(location, 5);

                        if(addressList != null)
                        {
                            for(int i = 0;i<addressList.size();i++)
                            {
                                LatLng latLng = new LatLng(addressList.get(i).getLatitude() , addressList.get(i).getLongitude());
                                MarkerOptions markerOptions = new MarkerOptions();
                                markerOptions.position(latLng);
                                markerOptions.title(location);
                                mMap.addMarker(markerOptions);
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.btn_aquarium:
                mMap.clear();
                String aquarium = "aquarium";
                String url = getUrl(latitude, longitude, aquarium);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;

                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Aquariums", Toast.LENGTH_SHORT).show();
                break;


            case R.id.btn_artgallery:
                mMap.clear();
                String artgallery = "art_gallery";
                url = getUrl(latitude, longitude, artgallery);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;

                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Art Galleries", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_bakery:
                mMap.clear();
                String bakery = "bakery";
                url = getUrl(latitude, longitude, bakery);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Bakeries", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_beautysalon:
                mMap.clear();
                String beautysalon = "beauty_salon";
                url = getUrl(latitude, longitude, beautysalon);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Bakeries", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_bookshop:
                mMap.clear();
                String bookshop = "book_store";
                url = getUrl(latitude, longitude, bookshop);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Book Shops", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_bowling_alley:
                mMap.clear();
                String bowling = "bowling_alley";
                url = getUrl(latitude, longitude, bowling);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Bowling Alleys", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_cafe:
                mMap.clear();
                String cafe = "cafe";
                url = getUrl(latitude, longitude, cafe);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Cafés", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_gym:
                mMap.clear();
                String gym = "gym";
                url = getUrl(latitude, longitude, gym);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Gyms", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_haircare:
                mMap.clear();
                String haircare = "hair_care";
                url = getUrl(latitude, longitude, haircare);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Hairdressers", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_library:
                mMap.clear();
                String library = "library";
                url = getUrl(latitude, longitude, library);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Libraries", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_movietheater:
                mMap.clear();
                String cinema = "movie_theater";
                url = getUrl(latitude, longitude, cinema);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Cinemas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_museum:
                mMap.clear();
                String museum = "museum";
                url = getUrl(latitude, longitude, museum);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Museums", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_park:
                mMap.clear();
                String park = "park";
                url = getUrl(latitude, longitude, park);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Restaurants", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_spa:
                mMap.clear();
                String spa = "spa";
                url = getUrl(latitude, longitude, spa);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Spas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_touristattraction:
                mMap.clear();
                String touristattraction = "tourist_attraction";
                url = getUrl(latitude, longitude, touristattraction);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Tourist Attractions", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_zoo:
                mMap.clear();
                String zoo = "zoo";
                url = getUrl(latitude, longitude, zoo);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;
                Log.d("MoodLog", url);
                NearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Zoos", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    private String getUrl(double latitude , double longitude , String nearbyPlace)
    {

        StringBuilder googlePlaceUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlaceUrl.append("location="+latitude+","+longitude);
        googlePlaceUrl.append("&radius="+PROXIMITY_RADIUS);
        googlePlaceUrl.append("&type="+nearbyPlace);
        googlePlaceUrl.append("&sensor=true");
        googlePlaceUrl.append("&key="+getString(R.string.google_maps_key));

        Log.d("MapsActivity", "url = "+googlePlaceUrl.toString());

        return googlePlaceUrl.toString();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        locationRequest = new LocationRequest();
        locationRequest.setInterval(100);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, this);
        }
    }


    public boolean checkLocationPermission()
    {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)  != PackageManager.PERMISSION_GRANTED )
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_LOCATION_CODE);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_LOCATION_CODE);
            }
            return false;

        }
        else
            return true;
    }


    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    public void startActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);

    }
}
