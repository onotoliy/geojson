package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.github.onotoliy.geojson.serializer.GeoJsonModule

class GeoJsonModuleTest {

    @Test
    fun test() {
        val mapper = ObjectMapper()

        mapper.registerModule(GeoJsonModule())

        assertEquals(POINT_JSON, mapper.writeValueAsString(POINT_OBJECT))
        assertEquals(POINT_OBJECT, mapper.readValue(POINT_JSON, Point::class.java))

        assertEquals(MULTI_POINT_JSON, mapper.writeValueAsString(MULTI_POINT_OBJECT))
        assertEquals(MULTI_POINT_OBJECT, mapper.readValue(MULTI_POINT_JSON, MultiPoint::class.java))

        assertEquals(LINE_STRING_JSON, mapper.writeValueAsString(LINE_STRING_OBJECT))
        assertEquals(LINE_STRING_OBJECT, mapper.readValue(LINE_STRING_JSON, LineString::class.java))

        assertEquals(MULTI_LINE_STRING_JSON, mapper.writeValueAsString(MULTI_LINE_STRING_OBJECT))
        assertEquals(MULTI_LINE_STRING_OBJECT, mapper.readValue(MULTI_LINE_STRING_JSON, MultiLineString::class.java))

        assertEquals(POLYGON_NO_HOLES_JSON, mapper.writeValueAsString(POLYGON_NO_HOLES_OBJECT))
        assertEquals(POLYGON_NO_HOLES_OBJECT, mapper.readValue(POLYGON_NO_HOLES_JSON, Polygon::class.java))

        assertEquals(POLYGON_WITH_HOLES_JSON, mapper.writeValueAsString(POLYGON_WITH_HOLES_OBJECT))
        assertEquals(POLYGON_WITH_HOLES_OBJECT, mapper.readValue(POLYGON_WITH_HOLES_JSON, Polygon::class.java))

        assertEquals(MULTI_POLYGON_JSON, mapper.writeValueAsString(MULTI_POLYGON_OBJECT))
        assertEquals(MULTI_POLYGON_OBJECT, mapper.readValue(MULTI_POLYGON_JSON, MultiPolygon::class.java))

        assertEquals(GEOMETRY_COLLECTION_JSON, mapper.writeValueAsString(GEOMETRY_COLLECTION_OBJECT))
        assertEquals(GEOMETRY_COLLECTION_OBJECT, mapper.readValue(GEOMETRY_COLLECTION_JSON, GeometryCollection::class.java))

        assertEquals(FEATURE_JSON, mapper.writeValueAsString(FEATURE_OBJECT))
        assertEquals(FEATURE_OBJECT, mapper.readValue(FEATURE_JSON, Feature::class.java))

        assertEquals(FEATURE_COLLECTION_JSON, mapper.writeValueAsString(FEATURE_COLLECTION_OBJECT))
        assertEquals(FEATURE_COLLECTION_OBJECT, mapper.readValue(FEATURE_COLLECTION_JSON, FeatureCollection::class.java))

        val geometry: Geometry = Point(Position(100.0, 0.0))

        assertEquals(POINT_JSON, mapper.writeValueAsString(geometry))
    }
}
