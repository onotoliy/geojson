package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.RingJacksonDeserializer
import com.github.onotoliy.geojson.serializer.RingJacksonSerializer

/**
 * Список координат. Используется для геометрий типа [Polygon] или [MultiLineString].
 *
 * @property coordinates Координаты.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = RingJacksonSerializer::class)
@JsonDeserialize(using = RingJacksonDeserializer::class)
actual class Ring actual constructor(actual val coordinates: List<MultiPosition>) :
    AbstractGeoJsonCoordinate<MultiPosition>(coordinates), GeometryCoordinate
