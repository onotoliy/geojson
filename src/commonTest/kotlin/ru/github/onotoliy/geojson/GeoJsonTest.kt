package ru.github.onotoliy.geojson

import ru.github.onotoliy.geojson.serializers.*
import kotlin.test.Test
import kotlin.test.assertEquals

class GeoJsonTest {

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