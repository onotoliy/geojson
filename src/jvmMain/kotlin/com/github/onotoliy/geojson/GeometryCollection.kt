package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.GeometryCollectionJacksonDeserializer
import com.github.onotoliy.geojson.serializer.GeometryCollectionJacksonSerializer

/**
 * Объект GeometryCollection.
 *
 * @property geometries Список геометрий.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = GeometryCollectionJacksonSerializer::class)
@JsonDeserialize(using = GeometryCollectionJacksonDeserializer::class)
actual class GeometryCollection actual constructor(geometries: MultiGeometry) :
    GeoJsonObject<MultiGeometry>(geometries) {

    /**
     * Список геометрий.
     */
    actual val geometries: MultiGeometry
        get() = value
}
