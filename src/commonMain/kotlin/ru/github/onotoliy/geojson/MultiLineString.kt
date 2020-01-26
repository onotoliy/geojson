package ru.github.onotoliy.geojson

expect class MultiLineString(coordinates: Ring) : Geometry {
    override val coordinates: Ring
}