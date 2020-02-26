package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.MultiGeometryJacksonDeserializer
import com.github.onotoliy.geojson.serializer.MultiGeometryJacksonSerializer

/**
 * Списк геометрий. Используется для геометрии типа [GeometryCollection].
 *
 * @property coordinates Список геометрий.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = MultiGeometryJacksonSerializer::class)
@JsonDeserialize(using = MultiGeometryJacksonDeserializer::class)
actual class MultiGeometry actual constructor(actual val coordinates: List<Geometry>) :
    AbstractGeoJsonCoordinate<Geometry>(coordinates), GeometryCoordinate
