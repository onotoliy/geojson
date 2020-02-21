package ru.github.onotoliy.geojson.serializer

import com.fasterxml.jackson.databind.module.SimpleModule
import ru.github.onotoliy.geojson.*

class GeoJsonModule: SimpleModule {

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