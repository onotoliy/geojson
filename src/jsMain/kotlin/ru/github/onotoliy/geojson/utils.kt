package ru.github.onotoliy.geojson

import kotlin.reflect.KClass

/**
 * Получение названия класса.
 *
 * @param clazz Класс.
 * @return Названия класса.
 */
actual fun <T : Any> getSimpleClassName(clazz: KClass<T>): String = clazz.js.name
