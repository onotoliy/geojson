package ru.github.onotoliy.geojson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import kotlin.reflect.KClass

@JvmName("JvmUtils")

actual fun <T : Any> getSimpleClassName(clazz: KClass<T>): String = clazz.java.name

fun <T> JsonParser?.fromJson(toObject: (String) -> T): T = if (this == null) {
    throw IllegalArgumentException()
} else {
    toObject(codec.readTree<TreeNode>(this).toString())
}