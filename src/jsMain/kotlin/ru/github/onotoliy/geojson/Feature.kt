package ru.github.onotoliy.geojson

/**
 * Объект Feature.
 *
 * @property geometry Геометрия.
 * @property bbox Ограничивающий прямоугольник.
 * @property properties Параметры.
 * @author Anatoliy Pokhresnyi
 */
actual class Feature actual constructor(g: Geometry, private val b: List<Double>, private val p: Map<String, Any>) :
    GeoJsonObject<Geometry>(g) {

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
