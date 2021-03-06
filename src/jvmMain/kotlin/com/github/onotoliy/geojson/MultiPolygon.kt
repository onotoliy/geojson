package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.MultiPolygonJacksonDeserializer
import com.github.onotoliy.geojson.serializer.MultiPolygonJacksonSerializer

/**
 * Объект MultiPolygon.
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = MultiPolygonJacksonSerializer::class)
@JsonDeserialize(using = MultiPolygonJacksonDeserializer::class)
actual class MultiPolygon actual constructor(actual override val coordinates: MultiRing) : Geometry(coordinates)
