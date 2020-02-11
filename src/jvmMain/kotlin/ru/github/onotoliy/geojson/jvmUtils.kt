@file:JvmName("JvmUtils")

package ru.github.onotoliy.geojson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import kotlin.reflect.KClass



actual fun <T : Any> getSimpleClassName(clazz: KClass<T>): String = clazz.java.name

fun <T> JsonParser?.fromJson(toObject: (String) -> T): T = if (this == null) {
    throw IllegalArgumentException()
} else {
    toObject(codec.readTree<TreeNode>(this).toString())
}

actual typealias PJsonSerialize = JsonSerialize
actual typealias PJsonDeserialize = JsonDeserialize