package ru.github.onotoliy.geojson

expect class Ring(coordinates: List<MultiPosition>) : GeometryCoordinateCommon<MultiPosition> {
    val coordinates: List<MultiPosition>
}