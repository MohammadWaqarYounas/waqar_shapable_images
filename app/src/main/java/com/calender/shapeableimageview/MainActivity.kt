package com.calender.shapeableimageview

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.calender.shapeableimageview.databinding.ActivityMainBinding
import com.calender.waqar_shapable_images.CustomMaskTransformation

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var drawable: Int=R.drawable.ic_circle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeImage(xFer)

        binding.btnCircle.setOnClickListener {
            drawable=R.drawable.ic_circle
            changeImage(xFer)
        }
        binding.btnHeart.setOnClickListener {
            drawable=R.drawable.ic_heart
            changeImage(xFer)
        }
        binding.btnStar.setOnClickListener {
            drawable=R.drawable.ic_star
            changeImage(xFer)
        }
        binding.btnIn.setOnClickListener {
            xFer="IN"
            changeImage(xFer)
        }
        binding.btnOut.setOnClickListener {
            xFer="OUT"
            changeImage(xFer)
        }

    }

    fun changeImage(xFer: String) {
        Glide.with(this)
            .load(R.drawable.ic_launcher_background)
            .apply(
                RequestOptions.bitmapTransform(CustomMaskTransformation(drawable,xFer))
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
            )
            .into(binding.imageView)

    }

    companion object {
        var xFer: String = "IN"
    }
}