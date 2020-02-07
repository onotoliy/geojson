package ru.github.onotoliy.geojson

import kotlin.reflect.KClass

@JsName("JsUtils")

actual fun <T : Any> getSimpleClassName(clazz: KClass<T>): String = clazz.js.name