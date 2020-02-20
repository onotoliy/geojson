package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import ru.github.onotoliy.geojson.Feature
import ru.github.onotoliy.geojson.MultiFeature
import ru.github.onotoliy.geojson.MultiGeometry

/**
 * Kotlin сериализация/десериализация [MultiFeature].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiFeatureSerializer : GeoJsonCoordinateSerializer<MultiFeature>(
    ::decode, ::encode
)

private fun decode(decoder: Decoder) = decoder.decode(FeatureSerializer.list).let(::MultiFeature)
private fun encode(obj: MultiFeature, encoder: Encoder) = encoder.encode(FeatureSerializer.list, obj.coordinates)