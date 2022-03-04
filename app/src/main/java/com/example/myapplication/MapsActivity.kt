package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.myapplication.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.Marker

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        listView = findViewById(R.id.listview)
        val coordList = ArrayList<String>()
        val sydney = "Sydney"
        val gymn56 = "Gymnasium 56"
        val koktobe = "Koktobe"
        val visitAl = "Visit Almaty Hiking trail"
        val samuraiSushi = "Samurai Sushi"

        coordList.add(sydney)
        coordList.add(gymn56)
        coordList.add(koktobe)
        coordList.add(visitAl)
        coordList.add(samuraiSushi)

        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, coordList
        )
        listView.adapter = arrayAdapter
//         Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(43.252249, 76.948586)
        val gymn56 = LatLng(43.247640, 76.948282)
        val koktobe = LatLng(43.242013, 76.959379)
        val visitAl = LatLng(43.255378, 76.944462)
        val samuraiSushi = LatLng(43.2476403,76.9482823)
        mMap.addMarker(MarkerOptions().position(sydney).title("House Museum"))
        mMap.addMarker(MarkerOptions().position(gymn56).title("Marker in Gymnasium 56"))
        mMap.addMarker(MarkerOptions().position(koktobe).title("Marker in Koktobe"))
        mMap.addMarker(MarkerOptions().position(visitAl).title("Marker in Visit Almaty"))
        mMap.addMarker(MarkerOptions().position(samuraiSushi).title("Marker in Samurai Sushi"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gymn56,14f))
    }
}