package com.github.onotoliy.geojson

/**
 * Объект Feature.
 *
 * @property geometry Геометрия.
 * @property bbox Ограничивающий прямоугольник.
 * @property properties Параметры.
 * @author Anatoliy Pokhresnyi
 */
actual class Feature actual constructor(g: Geometry, b: List<Double>, p: Map<String, Any>) : AbstractFeature(g, b, p) {

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
