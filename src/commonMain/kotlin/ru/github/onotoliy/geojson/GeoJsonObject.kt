package ru.github.onotoliy.geojson

/**
 * Объект в формате GeoJson.
 *
 * @param T Тип координат.
 * @property value Координаты.
 * @author Anatoliy Pokhresnyi
 */
abstract class GeoJsonObject<T : Any>(protected val value: T) {
    /**
     * Тип объекта GeoJson.
     */
    val type: String
        get() = this::class.getType()

    override fun toString(): String = "GeoJsonObject(type=$type, value=$value)"
    override fun hashCode(): Int = 31 * (type.hashCode() + value.hashCode())
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null -> false
        other::class == this::class && other is GeoJsonObject<*> -> this.value == other.value
        else -> false
    }
}