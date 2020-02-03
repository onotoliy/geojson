package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.PolygonJsonDeserializer
import ru.github.onotoliy.geojson.serializer.PolygonJsonSerializer

@JsonSerialize(using = PolygonJsonSerializer::class)
@JsonDeserialize(using = PolygonJsonDeserializer::class)
actual class Polygon actual constructor(actual override val coordinates: Ring) : Geometry(coordinates)