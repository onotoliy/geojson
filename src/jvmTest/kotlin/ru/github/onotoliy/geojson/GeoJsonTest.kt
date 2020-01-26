package ru.github.onotoliy.geojson

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.github.onotoliy.geojson.serializers.*
import java.io.FileInputStream

class GeoJsonTest {

    private fun getOriginalJson(name: String): String = Json(JsonConfiguration.Stable)
        .parseJson(String(FileInputStream("C:\\Workspace\\geojson\\src\\jvmTest\\resources\\$name.json").readAllBytes()))
        .toString()

    @Test
    fun testPoint() {
        val geometry = Point(Position(100.0, 0.0))
        val json = getOriginalJson("Point")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toPoint())
    }

    @Test
    fun testMultiPoint() {
        val geometry = MultiPoint(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))))
        val json = getOriginalJson("MultiPoint")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toMultiPoint())
    }

    @Test
    fun testLineString() {
        val geometry = LineString(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))))
        val json = getOriginalJson("LineString")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toLineString())
    }

    @Test
    fun testMultiLineString() {
        val geometry = MultiLineString(
            Ring(
                listOf(
                    MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))),
                    MultiPosition(listOf(Position(102.0, 2.0), Position(103.0, 3.0)))
                )
            )
        )
        val json = getOriginalJson("MultiLineString")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toMultiLineString())
    }

    @Test
    fun testPolygonNoHoles() {
        val geometry = Polygon(
            Ring(
                listOf(
                    MultiPosition(
                        listOf(
                            Position(100.0, 0.0),
                            Position(101.0, 0.0),
                            Position(101.0, 1.0),
                            Position(100.0, 1.0),
                            Position(100.0, 0.0)
                        )
                    )
                )
            )
        )
        val json = getOriginalJson("PolygonNoHoles")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toPolygon())
    }

    @Test
    fun testPolygonWithHoles() {
        val geometry = Polygon(
            Ring(
                listOf(
                    MultiPosition(
                        listOf(
                            Position(100.0, 0.0),
                            Position(101.0, 0.0),
                            Position(101.0, 1.0),
                            Position(100.0, 1.0),
                            Position(100.0, 0.0)
                        )
                    ),
                    MultiPosition(
                        listOf(
                            Position(100.8, 0.8),
                            Position(100.8, 0.2),
                            Position(100.2, 0.2),
                            Position(100.2, 0.8),
                            Position(100.8, 0.8)
                        )
                    )
                )
            )
        )
        val json = getOriginalJson("PolygonWithHoles")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toPolygon())
    }

    @Test
    fun testMultiPolygon() {
        val geometry = MultiPolygon(
            MultiRing(
                listOf(
                    Ring(
                        listOf(
                            MultiPosition(
                                listOf(
                                    Position(102.0, 2.0),
                                    Position(103.0, 2.0),
                                    Position(103.0, 3.0),
                                    Position(102.0, 3.0),
                                    Position(102.0, 2.0)
                                )
                            )
                        )
                    ),
                    Ring(
                        listOf(
                            MultiPosition(
                                listOf(
                                    Position(100.0, 0.0),
                                    Position(101.0, 0.0),
                                    Position(101.0, 1.0),
                                    Position(100.0, 1.0),
                                    Position(100.0, 0.0)
                                )
                            ),
                            MultiPosition(
                                listOf(
                                    Position(100.2, 0.2),
                                    Position(100.2, 0.8),
                                    Position(100.8, 0.8),
                                    Position(100.8, 0.2),
                                    Position(100.2, 0.2)
                                )
                            )
                        )
                    )
                )
            )
        )
        val json = getOriginalJson("MultiPolygon")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toMultiPolygon())
    }

    @Test
    fun testGeometryCollection() {
        val geometry = GeometryCollection(
            MultiGeometry(
                listOf(
                    Point(Position(100.0, 0.0)),
                    LineString(MultiPosition(listOf(Position(101.0, 0.0), Position(102.0, 1.0))))
                )
            )
        )
        val json = getOriginalJson("GeometryCollection")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toGeometryCollection())
    }

    @Test
    fun testFeature() {
        val geometry = Feature(
            Polygon(
                Ring(
                    listOf(
                        MultiPosition(
                            listOf(
                                Position(100.0, 0.0),
                                Position(101.0, 0.0),
                                Position(101.0, 1.0),
                                Position(100.0, 1.0),
                                Position(100.0, 0.0)
                            )
                        )
                    )
                )
            )
        )
        val json = getOriginalJson("Feature")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toFeature())
    }

    @Test
    fun testFeatureCollection() {
        val geometry = FeatureCollection(
            MultiFeature(
                listOf(
                    Feature(Point(Position(102.0, 0.5))),
                    Feature(
                        LineString(
                            MultiPosition(
                                listOf(
                                    Position(102.0, 0.0),
                                    Position(103.0, 1.0),
                                    Position(104.0, 0.0),
                                    Position(105.0, 1.0)
                                )
                            )
                        )
                    ),
                    Feature(
                        Polygon(
                            Ring(
                                listOf(
                                    MultiPosition(
                                        listOf(
                                            Position(100.0, 0.0),
                                            Position(101.0, 0.0),
                                            Position(101.0, 1.0),
                                            Position(100.0, 1.0),
                                            Position(100.0, 0.0)
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
        val json = getOriginalJson("FeatureCollection")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toFeatureCollection())
    }
}