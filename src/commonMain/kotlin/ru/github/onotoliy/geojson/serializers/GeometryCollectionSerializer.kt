package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.GeometryCollection
import ru.github.onotoliy.geojson.LineString
import ru.github.onotoliy.geojson.MultiGeometry

/**
 * Kotlin сериализация/десериализация [GeometryCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
object GeometryCollectionSerializer : GeoJsonObjectSerializer<GeometryCollection, MultiGeometry>(
    "GeometryCollection", "geometries", GeometryCollection::geometries, MultiGeometrySerializer
) {

    override fun deserialize(json: Json, element: JsonElement): GeometryCollection =
        GeometryCollection(MultiGeometry((element as JsonArray).content.map {
            json.parse(
                GeometrySerializer,
                it.toString()
            )
        }))

}