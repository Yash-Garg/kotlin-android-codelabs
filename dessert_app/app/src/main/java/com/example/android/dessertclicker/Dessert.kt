package com.example.android.dessertclicker

/** Dessert Data **/

/**
 * Simple data class that represents a dessert. Includes the resource id integer associated with
 * the image, the price it's sold for, and the startProductionAmount, which determines when
 * the dessert starts to be produced.
 */
data class Dessert(val imageId: Int, val price: Int, val startProductionAmount: Int)

// Create a list of all desserts, in order of when they start being produced
val allDesserts = listOf(
    Dessert(R.drawable.cupcake, 5, 0),
    Dessert(R.drawable.donut, 10, 5),
    Dessert(R.drawable.eclair, 15, 20),
    Dessert(R.drawable.froyo, 30, 50),
    Dessert(R.drawable.gingerbread, 50, 100),
    Dessert(R.drawable.honeycomb, 100, 200),
    Dessert(R.drawable.icecreamsandwich, 500, 500),
    Dessert(R.drawable.jellybean, 1000, 1000),
    Dessert(R.drawable.kitkat, 2000, 2000),
    Dessert(R.drawable.lollipop, 3000, 4000),
    Dessert(R.drawable.marshmallow, 4000, 8000),
    Dessert(R.drawable.nougat, 5000, 16000),
    Dessert(R.drawable.oreo, 6000, 20000)
)