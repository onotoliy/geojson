package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.github.onotoliy.geojson.serializers.*
import java.io.FileInputStream
import com.fasterxml.jackson.databind.module.SimpleModule
import ru.github.onotoliy.geojson.serializer.*
import ru.github.onotoliy.geojson.serializer.FeatureCollectionJsonSerializer

class GeoJsonTest {

    private fun getOriginalJson(name: String): String = Json(JsonConfiguration.Stable)
        .parseJson(String(FileInputStream("C:\\Workspace\\geojson\\src\\jvmTest\\resources\\$name.json").readAllBytes()))
        .toString()

//    @Test
    fun test() {
        println("123113123123")

        val mapper = ObjectMapper()

        val point = Point(Position(100.0, 0.0))
        val multiPoint = MultiPoint(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))))
        val lineString = LineString(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))))
        val multilineString =  MultiLineString(Ring(listOf(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))), MultiPosition(listOf(Position(102.0, 2.0), Position(103.0, 3.0))))))
        val polygonNoHoles = Polygon(Ring(listOf(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 0.0), Position(101.0, 1.0), Position(100.0, 1.0), Position(100.0, 0.0))))))
        val polygonWithHoles = Polygon(Ring(listOf(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 0.0), Position(101.0, 1.0), Position(100.0, 1.0), Position(100.0, 0.0))), MultiPosition(listOf(Position(100.8, 0.8), Position(100.8, 0.2), Position(100.2, 0.2), Position(100.2, 0.8), Position(100.8, 0.8))))))
        val multiPolygon = MultiPolygon(MultiRing(listOf(Ring(listOf(MultiPosition(listOf(Position(102.0, 2.0), Position(103.0, 2.0), Position(103.0, 3.0), Position(102.0, 3.0), Position(102.0, 2.0))))), Ring(listOf(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 0.0), Position(101.0, 1.0), Position(100.0, 1.0), Position(100.0, 0.0))), MultiPosition(listOf(Position(100.2, 0.2), Position(100.2, 0.8), Position(100.8, 0.8), Position(100.8, 0.2), Position(100.2, 0.2))))))))
        val geometryCollection = GeometryCollection(MultiGeometry(listOf(Point(Position(100.0, 0.0)), LineString(MultiPosition(listOf(Position(101.0, 0.0), Position(102.0, 1.0)))))))
        val feature = Feature(Polygon(Ring(listOf(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 0.0), Position(101.0, 1.0), Position(100.0, 1.0), Position(100.0, 0.0)))))))
        val featureCollection = FeatureCollection(MultiFeature(listOf(Feature(Point(Position(102.0, 0.5))), Feature(LineString(MultiPosition(listOf(Position(102.0, 0.0), Position(103.0, 1.0), Position(104.0, 0.0), Position(105.0, 1.0))))), Feature(Polygon(Ring(listOf(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 0.0), Position(101.0, 1.0), Position(100.0, 1.0),Position(100.0, 0.0))))))))))

        val module = SimpleModule()
        module.addSerializer(Point::class.java, PointJsonSerializer())
        module.addSerializer(MultiPoint::class.java, MultiPointJsonSerializer())
        module.addSerializer(LineString::class.java, LineStringJsonSerializer())
        module.addSerializer(MultiLineString::class.java, MultiLineStringJsonSerializer())
        module.addSerializer(Polygon::class.java, PolygonJsonSerializer())
        module.addSerializer(MultiPolygon::class.java, MultiPolygonJsonSerializer())
        module.addSerializer(Geometry::class.java, GeometryJsonSerializer())
        module.addSerializer(GeometryCollection::class.java, GeometryCollectionJsonSerializer())
        module.addSerializer(Feature::class.java, FeatureJsonSerializer())
        module.addSerializer(FeatureCollection::class.java, FeatureCollectionJsonSerializer())

        module.addDeserializer(Point::class.java, PointJsonDeserializer())
        module.addDeserializer(MultiPoint::class.java,
            MultiPointJsonDeserializer()
        )
        module.addDeserializer(LineString::class.java,
            LineStringJsonDeserializer()
        )
        module.addDeserializer(MultiLineString::class.java,
            MultiLineStringJsonDeserializer()
        )
        module.addDeserializer(Polygon::class.java, PolygonJsonDeserializer())
        module.addDeserializer(MultiPolygon::class.java,
            MultiPolygonJsonDeserializer()
        )
        module.addDeserializer(Geometry::class.java, GeometryJsonDeserializer())
        module.addDeserializer(GeometryCollection::class.java,
            GeometryCollectionJsonDeserializer()
        )
        module.addDeserializer(Feature::class.java, FeatureJsonDeserializer())
        module.addDeserializer(FeatureCollection::class.java,
            FeatureCollectionJsonDeserializer()
        )
        mapper.registerModule(module)

        assertEquals(getOriginalJson("Point"), mapper.writeValueAsString(point))
        assertEquals(point, mapper.readValue(getOriginalJson("Point"), Point::class.java))

        assertEquals(getOriginalJson("MultiPoint"), mapper.writeValueAsString(multiPoint))
        assertEquals(multiPoint, mapper.readValue(getOriginalJson("MultiPoint"), MultiPoint::class.java))

        assertEquals(getOriginalJson("LineString"), mapper.writeValueAsString(lineString))
        assertEquals(lineString, mapper.readValue(getOriginalJson("LineString"), LineString::class.java))

        assertEquals(getOriginalJson("MultiLineString"), mapper.writeValueAsString(multilineString))
        assertEquals(multilineString, mapper.readValue(getOriginalJson("MultiLineString"), MultiLineString::class.java))

        assertEquals(getOriginalJson("PolygonNoHoles"), mapper.writeValueAsString(polygonNoHoles))
        assertEquals(polygonNoHoles, mapper.readValue(getOriginalJson("PolygonNoHoles"), Polygon::class.java))

        assertEquals(getOriginalJson("PolygonWithHoles"), mapper.writeValueAsString(polygonWithHoles))
        assertEquals(polygonWithHoles, mapper.readValue(getOriginalJson("PolygonWithHoles"), Polygon::class.java))

        assertEquals(getOriginalJson("MultiPolygon"), mapper.writeValueAsString(multiPolygon))
        assertEquals(multiPolygon, mapper.readValue(getOriginalJson("MultiPolygon"), MultiPolygon::class.java))

        assertEquals(getOriginalJson("GeometryCollection"), mapper.writeValueAsString(geometryCollection))
        assertEquals(geometryCollection, mapper.readValue(getOriginalJson("GeometryCollection"), GeometryCollection::class.java))

        assertEquals(getOriginalJson("Feature"), mapper.writeValueAsString(feature))
        assertEquals(feature, mapper.readValue(getOriginalJson("Feature"), Feature::class.java))

        assertEquals(getOriginalJson("FeatureCollection"), mapper.writeValueAsString(featureCollection))
        assertEquals(featureCollection, mapper.readValue(getOriginalJson("FeatureCollection"), FeatureCollection::class.java))

        val geometry: Geometry = Point(Position(100.0, 0.0))

        println("$geometry 51551151")

        assertEquals(getOriginalJson("Point"), mapper.writeValueAsString(geometry))
    }

//    @Test
    fun testPoint() {
        val geometry = Point(Position(100.0, 0.0))
        val json = getOriginalJson("Point")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toPoint())
    }

//    @Test
    fun testMultiPoint() {
        val geometry = MultiPoint(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))))
        val json = getOriginalJson("MultiPoint")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toMultiPoint())
    }

//    @Test
    fun testLineString() {
        val geometry = LineString(MultiPosition(listOf(Position(100.0, 0.0), Position(101.0, 1.0))))
        val json = getOriginalJson("LineString")

        assertEquals(json, geometry.stringify())
        assertEquals(geometry, json.toLineString())
    }

//    @Test
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

//    @Test
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

//    @Test
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

//    @Test
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

//    @Test
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

//    @Test
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

//    @Test
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