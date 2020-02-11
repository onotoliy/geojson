package ru.github.onotoliy.geojson

import kotlin.reflect.KClass

@JsName("JsUtils")

actual fun <T : Any> getSimpleClassName(clazz: KClass<T>): String = clazz.js.name

actual annotation class PJsonSerialize
actual annotation class PJsonDeserialize