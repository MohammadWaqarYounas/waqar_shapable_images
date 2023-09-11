package com.calender.shapeableimageview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import jp.wasabeef.glide.transformations.MaskTransformation

class CustomMaskTransformation(private val maskId: Int) : MaskTransformation(maskId) {
    private val paint = Paint()

    override fun transform(
        @NonNull context: Context,
        @NonNull pool: BitmapPool,
        @NonNull toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap {
        val width = toTransform.width
        val height = toTransform.height
        val w: Int
        val h: Int

        if (width > height) {
            w = height
            h = height
        } else {
            w = width
            h = width
        }

        val bitmap = pool.get(w, h, Bitmap.Config.ARGB_8888)
        bitmap.setHasAlpha(true)
        val mask = getMaskDrawable(context.applicationContext, maskId)
        setCanvasBitmapDensity(toTransform, bitmap)
        val canvas = Canvas(bitmap)
        mask?.setBounds(0, 0, w, h)
        mask?.draw(canvas)

        // Assuming MainActivity.xFer is a valid PorterDuff mode
        when (MainActivity.xFer) {
            "IN" -> paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            "OUT" -> paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)
        }

        canvas.drawBitmap(
            toTransform,
            (w - width) / 2f,
            (h - height) / 2f,
            paint
        )

        return bitmap
    }

    private fun setCanvasBitmapDensity(toTransform: Bitmap, canvasBitmap: Bitmap) {
        canvasBitmap.density = toTransform.density
    }

    private fun getMaskDrawable(context: Context, maskId: Int): Drawable? {
        try {
            // Load the mask drawable from your resources or assets here
            return ContextCompat.getDrawable(context, maskId)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

}
