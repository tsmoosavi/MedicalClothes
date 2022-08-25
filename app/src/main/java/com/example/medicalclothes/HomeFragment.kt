package com.example.medicalclothes

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.medicalclothes.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        binding.apply {
            clothePicture.loadImage(requireContext(),R.drawable.mc, isRoundedCorner = true)
            picture1.loadImage(requireContext(),R.drawable.pic1, isRoundedCorner = true)
            picture2.loadImage(requireContext(),R.drawable.pic2, isRoundedCorner = true)
            picture3.loadImage(requireContext(),R.drawable.pic3, isRoundedCorner = true)
            picture4.loadImage(requireContext(),R.drawable.pic4, isRoundedCorner = true)
            picture5.loadImage(requireContext(),R.drawable.pic5, isRoundedCorner = true)
            profile.loadImage(requireContext(),R.drawable.profile, isRoundedCorner = true)
            ratingBar.rating= "5".toFloat()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
//        binding.imageRecycler.adapter = null
        _binding = null
    }
    fun <T, F> ImageView.loadImage(
        receiver: T,
        data: F,
        placeholder: Int? = null,
        errorPicture: Int? = null,
        isCircular: Boolean = false,
        isCrossFade: Boolean = false,
        isRoundedCorner: Boolean = false,
        defaultRoundCorner: Int = 30,
        defaultCrossFadeDuration: Int = 500
    ) {
        if (receiver !is Context && receiver !is View)
            return
        (if (receiver is Context) Glide.with(receiver) else Glide.with(receiver as View))
            .load(data)
            .apply {
                if (placeholder != null) placeholder(placeholder)
                if (errorPicture != null) error(errorPicture)
                if (isCircular) circleCrop()
                if (isCrossFade) transition(DrawableTransitionOptions.withCrossFade(defaultCrossFadeDuration))
                if (isRoundedCorner) transform(RoundedCorners(defaultRoundCorner))
            }
            .into(this)
    }


}