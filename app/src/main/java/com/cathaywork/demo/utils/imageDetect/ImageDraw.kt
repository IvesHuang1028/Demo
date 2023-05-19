package com.cathaywork.demo.utils.imageDetect

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class ImageDraw {
    private lateinit var bitmap:Bitmap
    private lateinit var canvas: Canvas
    private lateinit var paint: Paint
    constructor(bmp: Bitmap){
        this.bitmap = bmp
    }
    /**
     * draw rectangle function
     * @input : x,y min and max position
     * @result : green rectangle area on Bitmap
     */
    fun drawRectangle(max_x:Float,min_x:Float,max_y:Float,min_y:Float){
        //init paint
        canvas =Canvas(this.bitmap)
        paint = Paint()
        paint.color = Color.GREEN
        paint.strokeWidth = 10F
        // four line
        canvas.drawLine(min_x,max_y,max_x,max_y,paint)
        canvas.drawLine(min_x,min_y,max_x,min_y,paint)
        canvas.drawLine(min_x,max_y,min_x,min_y,paint)
        canvas.drawLine(max_x,max_y,max_x,min_y,paint)
    }
    /**
     * return  Bitmap function
     * @input : none
     * @return : now bitmap data
     */
    fun getBitmap():Bitmap{
        return bitmap
    }
}