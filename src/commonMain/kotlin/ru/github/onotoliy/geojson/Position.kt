package ru.github.onotoliy.geojson

/**
 * Координаты одной точки. Используется для геометрии типа [Point].
 *
 * @property x Долгота (Ось X).
 * @property y Широта (Ось Y).
 * @property z Высота (Ось Z).
 * @author Anatoliy Pokhresnyi
 */
expect class Position(x: Double, y: Double, z: Double? = null) : AbstractPosition, GeometryCoordinate {
    /**
     * Широта (Ось Y).
     */
    val latitude: Double

    /**
     * Долгота (Ось X).
     */
    val longitude: Double

    /**
     * Высота (Ось Z).
     */
    val altitude: Double?
}

/**
 * Базовый абстрактный класс координат одной точки.
 * Используется для перереопределения методов [toString], [hashCode], [equals]
 *
 * @property x Широта (Ось Y).
 * @property y Долгота (Ось X).
 * @property z Высота (Ось Z).
 * @author Anatoliy Pokhresnyi
 */
abstract class AbstractPosition(protected val x: Double, protected val y: Double, protected val z: Double? = null) {
    override fun toString(): String = z?.let { "[$y, $x, $it]" } ?: "[$y, $x]"
    override fun hashCode(): Int = x.toInt() + x.toInt() + (z?.toInt() ?: 0)
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null -> false
        other::class == this::class && other is AbstractPosition -> y == other.y && x == other.x && z == other.z
        else -> false
    }
}
