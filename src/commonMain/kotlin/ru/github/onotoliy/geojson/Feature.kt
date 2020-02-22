package ru.github.onotoliy.geojson

/**
 * Объект Feature.
 *
 * @property geometry Геометрия.
 * @property bbox Ограничивающий прямоугольник.
 * @property properties Параметры.
 * @author Anatoliy Pokhresnyi
 */
expect class Feature constructor(g: Geometry, b: List<Double>, p: Map<String, Any>) : GeoJsonObject<Geometry> {

    /**
     * Геометрия.
     */
    val geometry: Geometry

    /**
     * Ограничивающий прямоугольник.
     */
    val bbox: List<Double>

    /**
     * Параметры.
     */
    val properties: Map<String, Any>
}
