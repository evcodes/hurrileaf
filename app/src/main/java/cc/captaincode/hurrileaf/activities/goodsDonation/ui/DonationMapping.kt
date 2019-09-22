package cc.captaincode.hurrileaf.activities.goodsDonation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cc.captaincode.hurrileaf.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions

class DonationMapping : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation_mapping)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


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
        val fiu = com.google.android.gms.maps.model.LatLng(25.7574, -80.373)
        mMap.addMarker(MarkerOptions().position(fiu).title("Drop station in FIU"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fiu))

        val brickell = com.google.android.gms.maps.model.LatLng(25.7602, -80.1959)
        mMap.addMarker(MarkerOptions().position(brickell).title("Drop station in Brickell"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(brickell))

        val fll = com.google.android.gms.maps.model.LatLng(26.1224, -80.1373)
        mMap.addMarker(MarkerOptions().position(fll).title("Drop station in Fort Lauderdal"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fll))

        val lilHavana = com.google.android.gms.maps.model.LatLng(25.7776, -80.2377)
        mMap.addMarker(MarkerOptions().position(lilHavana).title("Drop station in Little Havana"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lilHavana))
        mMap.setMinZoomPreference(9.0f)
        mMap.setMaxZoomPreference(14.0f)
    }
}
