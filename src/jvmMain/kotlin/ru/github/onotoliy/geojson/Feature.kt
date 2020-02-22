package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.FeatureJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.FeatureJacksonSerializer

/**
 * Объект Feature.
 *
 * @property geometry Геометрия.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = FeatureJacksonSerializer::class)
@JsonDeserialize(using = FeatureJacksonDeserializer::class)
actual class Feature actual constructor(g: Geometry, private val b: List<Double>, private val p: Map<String, Any>) : GeoJsonObject<Geometry>(g) {

    /**
     * Геометрия.
     */
    actual val geometry: Geometry
        get() = value
    /**
     * Ограничивающий прямоугольник.
     */
    actual val bbox: List<Double>
        get() = b
    /**
     * Параметры.
     */
    actual val properties: Map<String, Any>
        get() = p
}
