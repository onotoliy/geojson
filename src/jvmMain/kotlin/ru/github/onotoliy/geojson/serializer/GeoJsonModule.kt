package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.databind.module.SimpleModule
import ru.github.onotoliy.geojson.Feature
import ru.github.onotoliy.geojson.FeatureCollection
import ru.github.onotoliy.geojson.Geometry
import ru.github.onotoliy.geojson.GeometryCollection
import ru.github.onotoliy.geojson.LineString
import ru.github.onotoliy.geojson.MultiLineString
import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.MultiPolygon
import ru.github.onotoliy.geojson.Point
import ru.github.onotoliy.geojson.Polygon

class GeoJsonModule : SimpleModule {

    constructor() {
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
