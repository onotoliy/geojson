package ru.github.onotoliy.geojson

open class GeoJsonCoordinateTyped<T>(protected val values: List<T>) : GeoJsonCoordinate {
    override fun toString(): String = "$values"
    override fun hashCode(): Int = 31 * values.hashCode()
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null -> false
        other::class == this::class && other is GeoJsonCoordinateTyped<*> -> values == other.values
        else -> false
    }
}