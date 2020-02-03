package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiPolygonJsonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiPolygonJsonSerializer

@JsonSerialize(using = MultiPolygonJsonSerializer::class)
@JsonDeserialize(using = MultiPolygonJsonDeserializer::class)
actual class MultiPolygon actual constructor(actual override val coordinates: MultiRing) : Geometry(coordinates)