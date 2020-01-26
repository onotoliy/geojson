package ru.github.onotoliy.geojson

expect class LineString(coordinates: MultiPosition) : Geometry {
    override val coordinates: MultiPosition
}