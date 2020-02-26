package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.PointJacksonDeserializer
import com.github.onotoliy.geojson.serializer.PointJacksonSerializer

/**
 * Объект Point.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = PointJacksonSerializer::class)
@JsonDeserialize(using = PointJacksonDeserializer::class)
actual class Point actual constructor(actual override val coordinates: Position) : Geometry(coordinates)
