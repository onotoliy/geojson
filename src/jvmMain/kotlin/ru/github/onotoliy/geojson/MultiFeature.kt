package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiFeatureJsonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiFeatureJsonSerializer

@JsonSerialize(using = MultiFeatureJsonSerializer::class)
@JsonDeserialize(using = MultiFeatureJsonDeserializer::class)
actual class MultiFeature actual constructor(actual val coordinates: List<Feature>) :
    GeoJsonCoordinateCommon<Feature>(coordinates)