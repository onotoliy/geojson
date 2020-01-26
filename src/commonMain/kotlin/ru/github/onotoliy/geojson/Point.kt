package ru.github.onotoliy.geojson

expect class Point(coordinates: Position) : Geometry {
    override val coordinates: Position
}