package com.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.databind.module.SimpleModule
import com.github.onotoliy.geojson.Feature
import com.github.onotoliy.geojson.FeatureCollection
import com.github.onotoliy.geojson.Geometry
import com.github.onotoliy.geojson.GeometryCollection
import com.github.onotoliy.geojson.LineString
import com.github.onotoliy.geojson.MultiLineString
import com.github.onotoliy.geojson.MultiPoint
import com.github.onotoliy.geojson.MultiPolygon
import com.github.onotoliy.geojson.Point
import com.github.onotoliy.geojson.Polygon

/**
 * Jackson модуль сериализации/десериализации GeoJson.
 *
 * @author Anatoliy Pokhresnyi
 */
class GeoJsonModule : SimpleModule() {

    /**
     * Инициализация Jackson модуля.
     */
    init {
        addSerializer(Point::class.java, PointJacksonSerializer())
        addSerializer(MultiPoint::class.java, MultiPointJacksonSerializer())
        addSerializer(LineString::class.java, LineStringJacksonSerializer())
        addSerializer(MultiLineString::class.java, MultiLineStringJacksonSerializer())
        addSerializer(Polygon::class.java, PolygonJacksonSerializer())
        addSerializer(MultiPolygon::class.java, MultiPolygonJacksonSerializer())
        addSerializer(Geometry::class.java, GeometryJacksonSerializer())
        addSerializer(GeometryCollection::class.java, GeometryCollectionJacksonSerializer())
        addSerializer(Feature::class.java, FeatureJacksonSerializer())
        addSerializer(FeatureCollection::class.java, FeatureCollectionJacksonSerializer())
        addDeserializer(Point::class.java, PointJacksonDeserializer())
        addDeserializer(MultiPoint::class.java, MultiPointJacksonDeserializer())
        addDeserializer(LineString::class.java, LineStringJsonDeserializer())
        addDeserializer(MultiLineString::class.java, MultiLineStringJacksonDeserializer())
        addDeserializer(Polygon::class.java, PolygonJacksonDeserializer())
        addDeserializer(MultiPolygon::class.java, MultiPolygonJacksonDeserializer())
        addDeserializer(Geometry::class.java, GeometryJacksonDeserializer())
        addDeserializer(GeometryCollection::class.java, GeometryCollectionJacksonDeserializer())
        addDeserializer(Feature::class.java, FeatureJacksonDeserializer())
        addDeserializer(FeatureCollection::class.java, FeatureCollectionJacksonDeserializer())
    }
}
