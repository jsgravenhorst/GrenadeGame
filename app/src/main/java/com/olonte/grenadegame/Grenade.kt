package com.olonte.grenadegame

import android.graphics.Bitmap

class Grenade(var image: Bitmap) {
    var x: Int = 0
    var y: Int = 0
    var w: Int = 0
    var h: Int = 0
    private var xVelocity = 20
    private var yVelocity = 20

    init {
        w = image.width
        h = image.height
    }
}