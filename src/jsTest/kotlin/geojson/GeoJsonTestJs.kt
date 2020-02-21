package geojson

import kotlin.test.Test
import kotlin.test.assertEquals
import ru.github.onotoliy.geojson.FEATURE_COLLECTION_JSON
import ru.github.onotoliy.geojson.FEATURE_COLLECTION_OBJECT
import ru.github.onotoliy.geojson.FEATURE_JSON
import ru.github.onotoliy.geojson.FEATURE_OBJECT
import ru.github.onotoliy.geojson.GEOMETRY_COLLECTION_JSON
import ru.github.onotoliy.geojson.GEOMETRY_COLLECTION_OBJECT
import ru.github.onotoliy.geojson.LINE_STRING_JSON
import ru.github.onotoliy.geojson.LINE_STRING_OBJECT
import ru.github.onotoliy.geojson.MULTI_LINE_STRING_JSON
import ru.github.onotoliy.geojson.MULTI_LINE_STRING_OBJECT
import ru.github.onotoliy.geojson.MULTI_POINT_JSON
import ru.github.onotoliy.geojson.MULTI_POINT_OBJECT
import ru.github.onotoliy.geojson.MULTI_POLYGON_JSON
import ru.github.onotoliy.geojson.MULTI_POLYGON_OBJECT
import ru.github.onotoliy.geojson.POINT_JSON
import ru.github.onotoliy.geojson.POINT_OBJECT
import ru.github.onotoliy.geojson.POLYGON_NO_HOLES_JSON
import ru.github.onotoliy.geojson.POLYGON_NO_HOLES_OBJECT
import ru.github.onotoliy.geojson.POLYGON_WITH_HOLES_JSON
import ru.github.onotoliy.geojson.POLYGON_WITH_HOLES_OBJECT
import ru.github.onotoliy.geojson.serializers.stringify
import ru.github.onotoliy.geojson.serializers.toFeature
import ru.github.onotoliy.geojson.serializers.toFeatureCollection
import ru.github.onotoliy.geojson.serializers.toGeometryCollection
import ru.github.onotoliy.geojson.serializers.toLineString
import ru.github.onotoliy.geojson.serializers.toMultiLineString
import ru.github.onotoliy.geojson.serializers.toMultiPoint
import ru.github.onotoliy.geojson.serializers.toMultiPolygon
import ru.github.onotoliy.geojson.serializers.toPoint
import ru.github.onotoliy.geojson.serializers.toPolygon

class GeoJsonTestJs {

    @Test
    fun testPoint() {
        println("Test Point")

        assertEquals(POINT_JSON, POINT_OBJECT.stringify())
        assertEquals(POINT_OBJECT, POINT_JSON.toPoint())
    }

    @Test
    fun testMultiPoint() {
        println("Test Point")

        assertEquals(MULTI_POINT_JSON, MULTI_POINT_OBJECT.stringify())
        assertEquals(MULTI_POINT_OBJECT, MULTI_POINT_JSON.toMultiPoint())
    }

    @Test
    fun testLineString() {
        println("Test Point")

        assertEquals(LINE_STRING_JSON, LINE_STRING_OBJECT.stringify())
        assertEquals(LINE_STRING_OBJECT, LINE_STRING_JSON.toLineString())
    }

    @Test
    fun testMultiLineString() {
        println("Test Point")

        assertEquals(MULTI_LINE_STRING_JSON, MULTI_LINE_STRING_OBJECT.stringify())
        assertEquals(MULTI_LINE_STRING_OBJECT, MULTI_LINE_STRING_JSON.toMultiLineString())
    }

    @Test
    fun testPolygonNoHoles() {
        println("Test Point")

        assertEquals(POLYGON_NO_HOLES_JSON, POLYGON_NO_HOLES_OBJECT.stringify())
        assertEquals(POLYGON_NO_HOLES_OBJECT, POLYGON_NO_HOLES_JSON.toPolygon())
    }

    @Test
    fun testPolygonWithHoles() {
        println("Test Point")

        assertEquals(POLYGON_WITH_HOLES_JSON, POLYGON_WITH_HOLES_OBJECT.stringify())
        assertEquals(POLYGON_WITH_HOLES_OBJECT, POLYGON_WITH_HOLES_JSON.toPolygon())
    }

    @Test
    fun testMultiPolygon() {
        println("Test Point")

        assertEquals(MULTI_POLYGON_JSON, MULTI_POLYGON_OBJECT.stringify())
        assertEquals(MULTI_POLYGON_OBJECT, MULTI_POLYGON_JSON.toMultiPolygon())
    }

    @Test
    fun testGeometryCollection() {
        println("Test Point")

        assertEquals(GEOMETRY_COLLECTION_JSON, GEOMETRY_COLLECTION_OBJECT.stringify())
        assertEquals(GEOMETRY_COLLECTION_OBJECT, GEOMETRY_COLLECTION_JSON.toGeometryCollection())
    }

    @Test
    fun testFeature() {
        println("Test Point")

        assertEquals(FEATURE_JSON, FEATURE_OBJECT.stringify())
        assertEquals(FEATURE_OBJECT, FEATURE_JSON.toFeature())
    }

    @Test
    fun testFeatureCollection() {
        println("Test Point")

        assertEquals(FEATURE_COLLECTION_JSON, FEATURE_COLLECTION_OBJECT.stringify())
        assertEquals(FEATURE_COLLECTION_OBJECT, FEATURE_COLLECTION_JSON.toFeatureCollection())
    }
}
