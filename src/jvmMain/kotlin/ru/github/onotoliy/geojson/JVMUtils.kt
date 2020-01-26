package ru.github.onotoliy.geojson

import kotlin.reflect.KClass

actual fun <T : Any> getSimpleClassName(clazz: KClass<T>): String = clazz.java.name
