package ru.github.onotoliy.geojson

open class MultiGeometryTyped(private val coordinates: List<Geometry>) {
    override fun toString(): String = "$coordinates"
    override fun hashCode(): Int = coordinates.hashCode()
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null -> false
        other::class == this::class && other is MultiGeometryTyped -> coordinates == other.coordinates
        else -> false
    }
}