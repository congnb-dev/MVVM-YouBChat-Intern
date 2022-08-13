package com.thuanpx.mvvm_architecture.feature.home.maps

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.thuanpx.mvvm_architecture.R
import com.thuanpx.mvvm_architecture.base.fragment.BaseFragment
import com.thuanpx.mvvm_architecture.databinding.FragmentMapsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsFragment :
    BaseFragment<MapsViewModel, FragmentMapsBinding>(MapsViewModel::class), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMapsBinding {
        return FragmentMapsBinding.inflate(inflater, container, false)
    }

    override fun initialize() {
        (childFragmentManager.findFragmentById(R.id.homeMaps) as SupportMapFragment).getMapAsync(
            this
        )
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val ninePlus = LatLng(16.0311766, 108.2077387)
        val dongAUni = LatLng(16.0321138, 108.218873)

        mMap.addMarker(
            MarkerOptions().position(dongAUni).title("Marker in Dong A Uni")
                .icon(activity?.let { bitmapDescriptorFromVector(it, R.drawable.ic_school) })
        )

        mMap.addMarker(
            MarkerOptions().position(ninePlus).title("Marker in Nine Plus")
                .icon(activity?.let { bitmapDescriptorFromVector(it, R.drawable.ic_job) })
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ninePlus))

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16f), 5000, null)
    }

    private fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
        return ContextCompat.getDrawable(context, vectorResId)?.run {
            setBounds(0, 0, intrinsicWidth, intrinsicHeight)
            val bitmap =
                Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
            draw(Canvas(bitmap))
            BitmapDescriptorFactory.fromBitmap(bitmap)
        }
    }

}




