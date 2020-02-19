package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.*

private val json = Json(JsonConfiguration.Stable)

private fun <T> decode(element: JsonElement, serializer: KSerializer<T>): T = json.fromJson(serializer, element)
private fun <T> encode(structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int, serializer: KSerializer<T>, geometry: T) =
    structure.encodeSerializableElement(descriptor, idx, serializer, geometry)

fun JsonElement.toPoint() = Point(decode(this, PositionSerializer))
fun Point.stringify(structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, PositionSerializer, coordinates)
fun JsonElement.toMultiPoint() = MultiPoint(decode(this, MultiPositionSerializer))
fun MultiPoint.stringify(structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiPositionSerializer, coordinates)
fun JsonElement.toPolygon() = Polygon(decode(this, RingSerializer))
fun Polygon.stringify(structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, RingSerializer, coordinates)
fun JsonElement.toMultiPolygon() = MultiPolygon(decode(this, MultiRingSerializer))
fun MultiPolygon.stringify(structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiRingSerializer, coordinates)
fun JsonElement.toLineString() = LineString(decode(this, MultiPositionSerializer))
fun LineString.stringify(structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiPositionSerializer, coordinates)
fun JsonElement.toMultiLineString() = MultiLineString(decode(this, RingSerializer))
fun MultiLineString.stringify(structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, RingSerializer, coordinates)
fun JsonElement.toFeature() = Feature(decode(this, GeometrySerializer))
fun Feature.stringify(structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, GeometrySerializer, geometry)
fun JsonElement.toGeometryCollection() = GeometryCollection(decode(this, MultiGeometrySerializer))
fun GeometryCollection.stringify(structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiGeometrySerializer, geometries)
fun JsonElement.toFeatureCollection() = FeatureCollection(decode(this, MultiFeatureSerializer))
fun FeatureCollection.stringify(structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiFeatureSerializer, features)

fun String.toPosition() : Position = json.parse(PositionSerializer, this)
fun String.toMultiPosition() : MultiPosition = json.parse(MultiPositionSerializer, this)
fun String.toRing() : Ring = json.parse(RingSerializer, this)
fun String.toMultiRing() : MultiRing = json.parse(MultiRingSerializer, this)
fun String.toMultiGeometry() : MultiGeometry = json.parse(MultiGeometrySerializer, this)
fun String.toMultiFeature() : MultiFeature = json.parse(MultiFeatureSerializer, this)
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

fun Position.stringify() : String = json.stringify(PositionSerializer, this)
fun MultiPosition.stringify() : String = json.stringify(MultiPositionSerializer, this)
fun Ring.stringify() : String = json.stringify(RingSerializer, this)
fun MultiRing.stringify() : String = json.stringify(MultiRingSerializer, this)
fun MultiGeometry.stringify() : String = json.stringify(MultiGeometrySerializer, this)
fun MultiFeature.stringify() : String = json.stringify(MultiFeatureSerializer, this)
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