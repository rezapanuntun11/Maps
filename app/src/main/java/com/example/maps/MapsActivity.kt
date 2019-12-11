package com.example.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val latitude  = -7.747034
        val longitude =110.355398
        val latMonjali = -7.7508527
        val longMonjali = 110.3683039
        val latJcm = -7.7531088
        val longJcm = 110.3609823
        val zoomlevel =15f
        val overlaySize =110f

        val uty = LatLng(latitude,longitude )
        mMap.addMarker(MarkerOptions()
            .position(uty).title("Universitas Teknologi Yogyakarta").snippet("Terletak di Sendangadi, Mlati, Sleman").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uty,zoomlevel))

        val monjali = LatLng(latMonjali,longMonjali)
        mMap.addMarker(MarkerOptions().position(monjali).title("Monumen Jogja Kembali").snippet("Terletak di Sariharjo, Ngaglik, Sleman").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val jcm = LatLng(latJcm,longJcm)
        mMap.addMarker(MarkerOptions().position(jcm).title("Jogja City Mall").snippet("Terletak di Sendangadi, Mlati, Sleman").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))

        val googleOverlay= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.uty)).position(uty,overlaySize)
        mMap.addGroundOverlay(googleOverlay)

        val googleOverlay2= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.monjali)).position(monjali,overlaySize)
        mMap.addGroundOverlay(googleOverlay2)

        val googleOverlay3= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.jcm)).position(jcm,overlaySize)
        mMap.addGroundOverlay(googleOverlay3)


    }

}
