package ru.github.onotoliy.geojson

/**
 * Common GeoJson coordinate. Override methods [toString], [hashCode], [equals].
 *
 * @property values Coordinates
 * @author Anatoliy Pokhresnyi
 */
open class GeoJsonCoordinateCommon<T>(protected val values: List<T>) : GeoJsonCoordinate {
    override fun toString(): String = "$values"
    override fun hashCode(): Int = 31 * values.hashCode()
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null -> false
        other::class == this::class && other is GeoJsonCoordinateCommon<*> -> values == other.values
        else -> false
    }
}