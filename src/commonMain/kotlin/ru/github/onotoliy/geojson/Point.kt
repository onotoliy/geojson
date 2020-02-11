package ru.github.onotoliy.geojson

//expect class Point(coordinates: Position) : Geometry {
//    override val coordinates: Position
//}

@PJsonSerialize
@PJsonDeserialize
class Point(coordinates: Position) : Geometry(coordinates)