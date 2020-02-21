package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiPolygonJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiPolygonJacksonSerializer

@JsonSerialize(using = MultiPolygonJacksonSerializer::class)
@JsonDeserialize(using = MultiPolygonJacksonDeserializer::class)
actual class MultiPolygon actual constructor(actual override val coordinates: MultiRing) : Geometry(coordinates)
