package ru.github.onotoliy.geojson

expect class MultiPolygon(coordinates: MultiRing) : Geometry {
    override val coordinates: MultiRing
}