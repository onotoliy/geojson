package ru.github.onotoliy.geojson

expect class MultiPoint(coordinates: MultiPosition) : Geometry {
    override val coordinates: MultiPosition
}