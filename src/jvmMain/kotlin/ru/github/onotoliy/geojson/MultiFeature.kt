package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiFeatureJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiFeatureJacksonSerializer

/**
 * Списк объектов [Feature]. Используется для геометрии типа [FeatureCollection].
 *
 * @property coordinates Список геометрий.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = MultiFeatureJacksonSerializer::class)
@JsonDeserialize(using = MultiFeatureJacksonDeserializer::class)
actual class MultiFeature actual constructor(actual val coordinates: List<Feature>) :
    AbstractGeoJsonCoordinate<Feature>(coordinates)
