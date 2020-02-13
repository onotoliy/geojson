package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.PointJsonDeserializer
import ru.github.onotoliy.geojson.serializer.PointJsonSerializer

@JsonSerialize(using = PointJsonSerializer::class)
@JsonDeserialize(using = PointJsonDeserializer::class)
actual class Point actual constructor(actual override val coordinates: Position) : Geometry(coordinates)