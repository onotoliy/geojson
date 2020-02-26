package com.github.onotoliy.geojson

/**
 * Координаты одной точки. Используется для геометрии типа [Point].
 *
 * @property x Долгота (Ось X).
 * @property y Широта (Ось Y).
 * @property z Высота (Ось Z).
 * @author Anatoliy Pokhresnyi
 */
actual class Position actual constructor(x: Double, y: Double, z: Double?) :
    AbstractPosition(x, y, z), GeometryCoordinate {

    /**
     * Широта (Ось Y).
     */
    actual val latitude: Double
        get() = y

    /**
     * Долгота (Ось X).
     */
    actual val longitude: Double
        get() = x

    /**
     * Высота (Ось Z).
     */
    actual val altitude: Double?
        get() = z
}
