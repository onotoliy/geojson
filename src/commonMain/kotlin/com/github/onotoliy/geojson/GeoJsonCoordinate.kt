package com.github.onotoliy.geojson

/**
 * Координаты в формате GeoJson.
 *
 * @author Anatoliy Pokhresnyi
 */
interface GeoJsonCoordinate

/**
 * Базовый абстрактный класс координат в формате GeoJson.
 * Используется для перереопределения методов [toString], [hashCode], [equals]
 *
 * @param T Тип координат.
 * @property values Список координат.
 * @author Anatoliy Pokhresnyi
 */
abstract class AbstractGeoJsonCoordinate<T>(protected val values: List<T>) : GeoJsonCoordinate {
    override fun toString(): String = "$values"
    override fun hashCode(): Int = 31 * values.hashCode()
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null -> false
        other::class == this::class && other is AbstractGeoJsonCoordinate<*> -> values == other.values
        else -> false
    }
}
