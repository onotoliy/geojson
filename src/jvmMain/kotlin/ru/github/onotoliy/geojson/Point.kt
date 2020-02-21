package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.PointJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.PointJacksonSerializer

@JsonSerialize(using = PointJacksonSerializer::class)
@JsonDeserialize(using = PointJacksonDeserializer::class)
actual class Point actual constructor(actual override val coordinates: Position) : Geometry(coordinates)