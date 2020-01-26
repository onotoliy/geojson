package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import ru.github.onotoliy.geojson.*

private val json = Json(JsonConfiguration.Stable)

fun String.toGeometry() : Geometry = json.parse(GeometrySerializer, this)
fun String.toPoint() : Point = json.parse(PointSerializer, this)
fun String.toMultiPoint() : MultiPoint = json.parse(MultiPointSerializer, this)
fun String.toLineString() : LineString = json.parse(LineStringSerializer, this)
fun String.toMultiLineString() : MultiLineString = json.parse(MultiLineStringSerializer, this)
fun String.toPolygon() : Polygon = json.parse(PolygonSerializer, this)
fun String.toMultiPolygon() : MultiPolygon = json.parse(MultiPolygonSerializer, this)
fun String.toGeometryCollection() : GeometryCollection = json.parse(GeometryCollectionSerializer, this)
fun String.toFeature() : Feature = json.parse(FeatureSerializer, this)
fun String.toFeatureCollection() : FeatureCollection = json.parse(FeatureCollectionSerializer, this)

fun Geometry.stringify() : String = json.stringify(GeometrySerializer, this)
fun Point.stringify() : String = json.stringify(PointSerializer, this)
fun MultiPoint.stringify() : String = json.stringify(MultiPointSerializer, this)
fun LineString.stringify() : String = json.stringify(LineStringSerializer, this)
fun MultiLineString.stringify() : String = json.stringify(MultiLineStringSerializer, this)
fun Polygon.stringify() : String = json.stringify(PolygonSerializer, this)
fun MultiPolygon.stringify() : String = json.stringify(MultiPolygonSerializer, this)
fun GeometryCollection.stringify() : String = json.stringify(GeometryCollectionSerializer, this)
fun Feature.stringify() : String = json.stringify(FeatureSerializer, this)
fun FeatureCollection.stringify() : String = json.stringify(FeatureCollectionSerializer, this)

