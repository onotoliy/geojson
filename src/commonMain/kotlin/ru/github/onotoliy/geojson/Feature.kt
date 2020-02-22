package ru.github.onotoliy.geojson

/**
 * Объект Feature.
 *
 * @property geometry Геометрия.
 * @property bbox Ограничивающий прямоугольник.
 * @property properties Параметры.
 * @author Anatoliy Pokhresnyi
 */
expect class Feature constructor(g: Geometry, b: List<Double>, p: Map<String, Any>) : AbstractFeature {

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

/**
 * Объект Feature.
 *
 * @property value Геометрия.
 * @property b Ограничивающий прямоугольник.
 * @property p Параметры.
 * @author Anatoliy Pokhresnyi
 */
abstract class AbstractFeature(g: Geometry, protected val b: List<Double>, protected val p: Map<String, Any>) :
    GeoJsonObject<Geometry>(g) {

    override fun toString(): String = "Feature(t=Feature,g=$value,b=$b, p=$p)"
    override fun equals(other: Any?): Boolean =
        super.equals(other) && other is AbstractFeature && p == other.p && b == other.b
    override fun hashCode(): Int = 31 * (super.hashCode() + b.hashCode() + p.hashCode())
}
