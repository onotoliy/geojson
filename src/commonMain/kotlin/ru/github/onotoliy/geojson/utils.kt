package ru.github.onotoliy.geojson

import kotlin.reflect.KClass

expect fun <T : Any> getSimpleClassName(clazz: KClass<T>): String

fun KClass<*>.getType(): String {
    val name = getSimpleClassName(this)

    return name.substring(name.lastIndexOf(".") + 1, name.length)
}