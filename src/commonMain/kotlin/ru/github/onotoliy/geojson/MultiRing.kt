package ru.github.onotoliy.geojson

expect class MultiRing(coordinates: List<Ring>) : GeometryCoordinateTyped<Ring> {
    val coordinates: List<Ring>
}