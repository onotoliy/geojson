package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.FeatureCollectionJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.FeatureCollectionJacksonSerializer

@JsonSerialize(using = FeatureCollectionJacksonSerializer::class)
@JsonDeserialize(using = FeatureCollectionJacksonDeserializer::class)
actual class FeatureCollection actual constructor(features: MultiFeature) : GeoJsonObject<MultiFeature>(features) {
    actual val features: MultiFeature
        get() = value
}