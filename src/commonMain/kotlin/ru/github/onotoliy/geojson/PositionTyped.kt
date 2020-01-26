package ru.github.onotoliy.geojson

open class PositionTyped(private val x: Double, private val y: Double) {
    override fun toString(): String = "[$x, $y]"
    override fun hashCode(): Int = x.toInt() + y.toInt()
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null -> false
        other::class == this::class && other is PositionTyped -> x == other.x && y == other.y
        else -> false
    }
}