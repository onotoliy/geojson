package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.FeatureCollectionJsonDeserializer
import ru.github.onotoliy.geojson.serializer.FeatureCollectionJsonSerializer

@JsonSerialize(using = FeatureCollectionJsonSerializer::class)
@JsonDeserialize(using = FeatureCollectionJsonDeserializer::class)
actual class FeatureCollection actual constructor(features: MultiFeature) : GeoJsonObject<MultiFeature>(features) {
    actual val features: MultiFeature
        get() = value
}