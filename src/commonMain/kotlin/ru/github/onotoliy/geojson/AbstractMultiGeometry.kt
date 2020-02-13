package ru.github.onotoliy.geojson

/**
 * Базовый абстрактный класс списка геометрий.
 *
 * @property coordinates Список геометрий.
 * @author Anatoliy Pokhresnyi
 */
abstract class AbstractMultiGeometry(private val coordinates: List<Geometry>) {
    override fun toString(): String = "$coordinates"
    override fun hashCode(): Int = coordinates.hashCode()
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null -> false
        other::class == this::class && other is AbstractMultiGeometry -> coordinates == other.coordinates
        else -> false
    }
}