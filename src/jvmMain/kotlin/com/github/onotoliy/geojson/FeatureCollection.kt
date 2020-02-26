package com.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.github.onotoliy.geojson.serializer.FeatureCollectionJacksonDeserializer
import com.github.onotoliy.geojson.serializer.FeatureCollectionJacksonSerializer

/**
 * Объект FeatureCollection.
 *
 * @property features Список объектов Features.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = FeatureCollectionJacksonSerializer::class)
@JsonDeserialize(using = FeatureCollectionJacksonDeserializer::class)
actual class FeatureCollection actual constructor(features: MultiFeature) : GeoJsonObject<MultiFeature>(features) {

    /**
     * Список объектов Features.
     */
    actual val features: MultiFeature
        get() = value
}
