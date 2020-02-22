@file:JvmName("JvmUtils")

package ru.github.onotoliy.geojson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import kotlin.reflect.KClass

/**
 * Получение названия класса.
 *
 * @param clazz Класс.
 * @return Названия класса.
 */
actual fun <T : Any> getSimpleClassName(clazz: KClass<T>): String = clazz.java.name

/**
 * Jackson десериализация.
 */
fun <T> JsonParser?.fromJson(toObject: (String) -> T): T = this?.let {
    toObject(codec.readTree<TreeNode>(it).toString())
} ?: throw IllegalArgumentException()
