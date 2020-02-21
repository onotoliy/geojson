package ru.github.onotoliy.geojson

import kotlin.reflect.KClass

/**
 * Получение названия класса.
 *
 * @param clazz Класс.
 * @return Названия класса.
 */
expect fun <T : Any> getSimpleClassName(clazz: KClass<T>): String

/**
 * Получение названия класса без пакета.
 *
 * @return Названия класса без пакета.
 */
fun KClass<*>.getType(): String {
    val name = getSimpleClassName(this)

    return name.substring(name.lastIndexOf(".") + 1, name.length)
}
