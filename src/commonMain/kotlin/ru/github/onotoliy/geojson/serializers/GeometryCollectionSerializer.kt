package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.GeometryCollection
import ru.github.onotoliy.geojson.MultiGeometry

/**
 * Kotlin сериализация/десериализация [GeometryCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
object GeometryCollectionSerializer : GeoJsonObjectSerializer<GeometryCollection>(
    "geometries", JsonElement::toGeometryCollection, GeometryCollection::stringify
)