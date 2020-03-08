package com.olonte.grenadegame

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context, attributeSet: AttributeSet) : SurfaceView(context, attributeSet), SurfaceHolder.Callback {
    private val thread: GameThread

    init {

        //add callback
        holder.addCallback(this)

        // instantiate the game thread
        thread = GameThread(holder, this)
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        var retry = true
        while (retry) {
            try {
                thread.setRunning(false)
                thread.join()
            }catch (e: Exception){
                e.printStackTrace()
            }
            retry = false
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        // start the game thread
        thread.setRunning(true)
        thread.start()
    }
    /**
     * Function to update the positions of player and game objects
     */
    fun update(){

    }

    /**
     * Everything that has to be drawn on Canvas
     */
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
    }
}