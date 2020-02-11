package ru.github.onotoliy.geojson

expect class MultiRing(coordinates: List<Ring>) : GeometryCoordinateCommon<Ring> {
    val coordinates: List<Ring>
}