@file:JvmName("JvmUtils")

package ru.github.onotoliy.geojson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import kotlin.reflect.KClass

actual fun <T : Any> getSimpleClassName(clazz: KClass<T>): String = clazz.java.name

fun <T> JsonParser?.fromJson(toObject: (String) -> T): T = this?.let {
    toObject(codec.readTree<TreeNode>(it).toString())
} ?: throw IllegalArgumentException()