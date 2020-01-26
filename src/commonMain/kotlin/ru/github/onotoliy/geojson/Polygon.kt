package ru.github.onotoliy.geojson

expect class Polygon(coordinates: Ring) : Geometry {
    override val coordinates: Ring
}
