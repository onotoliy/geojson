package ru.github.onotoliy.geojson

/**
 * Координаты одной точки. Используется для геометрии типа [Point].
 *
 * @property x Широта.
 * @property y Долгота.
 * @author Anatoliy Pokhresnyi
 */
expect class Position(x: Double, y: Double) : AbstractPosition, GeometryCoordinate {
    val x: Double
    val y: Double
}

/**
 * Базовый абстрактный класс координат одной точки.
 * Используется для перереопределения методов [toString], [hashCode], [equals]
 *
 * @property x Широта.
 * @property y Долгота.
 * @author Anatoliy Pokhresnyi
 */
abstract class AbstractPosition(private val x: Double, private val y: Double) {
    override fun toString(): String = "[$x, $y]"
    override fun hashCode(): Int = x.toInt() + y.toInt()
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null -> false
        other::class == this::class && other is AbstractPosition -> x == other.x && y == other.y
        else -> false
    }
}
