package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.PolygonJacksonDeserializer
import com.github.onotoliy.geojson.serializer.PolygonJacksonSerializer

/**
 * Объект Polygon.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = PolygonJacksonSerializer::class)
@JsonDeserialize(using = PolygonJacksonDeserializer::class)
actual class Polygon actual constructor(actual override val coordinates: Ring) : Geometry(coordinates)
