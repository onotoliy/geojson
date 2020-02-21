package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.Feature
import ru.github.onotoliy.geojson.FeatureCollection
import ru.github.onotoliy.geojson.Geometry
import ru.github.onotoliy.geojson.GeometryCollection
import ru.github.onotoliy.geojson.LineString
import ru.github.onotoliy.geojson.MultiFeature
import ru.github.onotoliy.geojson.MultiGeometry
import ru.github.onotoliy.geojson.MultiLineString
import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.MultiPolygon
import ru.github.onotoliy.geojson.MultiPosition
import ru.github.onotoliy.geojson.MultiRing
import ru.github.onotoliy.geojson.Point
import ru.github.onotoliy.geojson.Polygon
import ru.github.onotoliy.geojson.Position
import ru.github.onotoliy.geojson.Ring

private val json = Json(JsonConfiguration.Stable)

fun <T> decode(element: JsonElement, serializer: KSerializer<T>): T = json.fromJson(serializer, element)
fun <T> encode(
    structure: CompositeEncoder,
    descriptor: SerialDescriptor,
    idx: Int,
    serializer: KSerializer<T>,
    geometry: T
) = structure.encodeSerializableElement(descriptor, idx, serializer, geometry)

/**
 * Десериализация объекта [Position].
 *
 * @return Объект [Position].
 * @author Anatoliy Pokhresnyi
 */
fun String.toPosition(): Position = json.parse(PositionSerializer, this)

/**
 * Десериализация объекта [MultiPosition].
 *
 * @return Объект [MultiPosition].
 * @author Anatoliy Pokhresnyi
 */
fun String.toMultiPosition(): MultiPosition = json.parse(MultiPositionSerializer, this)

/**
 * Десериализация объекта [Ring].
 *
 * @return Объект [Ring].
 * @author Anatoliy Pokhresnyi
 */
fun String.toRing(): Ring = json.parse(RingSerializer, this)

/**
 * Десериализация объекта [MultiRing].
 *
 * @return Объект [MultiRing].
 * @author Anatoliy Pokhresnyi
 */
fun String.toMultiRing(): MultiRing = json.parse(MultiRingSerializer, this)

/**
 * Десериализация объекта [MultiGeometry].
 *
 * @return Объект [MultiGeometry].
 * @author Anatoliy Pokhresnyi
 */
fun String.toMultiGeometry(): MultiGeometry = json.parse(MultiGeometrySerializer, this)

/**
 * Десериализация объекта [MultiFeature].
 *
 * @return Объект [MultiFeature].
 * @author Anatoliy Pokhresnyi
 */
fun String.toMultiFeature(): MultiFeature = json.parse(MultiFeatureSerializer, this)

/**
 * Десериализация объекта [Geometry].
 *
 * @return Объект [Geometry].
 * @author Anatoliy Pokhresnyi
 */
fun String.toGeometry(): Geometry = json.parse(GeometrySerializer, this)

/**
 * Десериализация объекта [Point].
 *
 * @return Объект [Point].
 * @author Anatoliy Pokhresnyi
 */
fun String.toPoint(): Point = json.parse(PointSerializer, this)

/**
 * Десериализация объекта [MultiPoint].
 *
 * @return Объект [MultiPoint].
 * @author Anatoliy Pokhresnyi
 */
fun String.toMultiPoint(): MultiPoint = json.parse(MultiPointSerializer, this)

/**
 * Десериализация объекта [LineString].
 *
 * @return Объект [LineString].
 * @author Anatoliy Pokhresnyi
 */
fun String.toLineString(): LineString = json.parse(LineStringSerializer, this)

/**
 * Десериализация объекта [MultiLineString].
 *
 * @return Объект [MultiLineString].
 * @author Anatoliy Pokhresnyi
 */
fun String.toMultiLineString(): MultiLineString = json.parse(MultiLineStringSerializer, this)

/**
 * Десериализация объекта [Polygon].
 *
 * @return Объект [Polygon].
 * @author Anatoliy Pokhresnyi
 */
fun String.toPolygon(): Polygon = json.parse(PolygonSerializer, this)

/**
 * Десериализация объекта [MultiPolygon].
 *
 * @return Объект [MultiPolygon].
 * @author Anatoliy Pokhresnyi
 */
fun String.toMultiPolygon(): MultiPolygon = json.parse(MultiPolygonSerializer, this)

/**
 * Десериализация объекта [GeometryCollection].
 *
 * @return Объект [GeometryCollection].
 * @author Anatoliy Pokhresnyi
 */
fun String.toGeometryCollection(): GeometryCollection = json.parse(GeometryCollectionSerializer, this)

/**
 * Десериализация объекта [Feature].
 *
 * @return Объект [Feature].
 * @author Anatoliy Pokhresnyi
 */
fun String.toFeature(): Feature = json.parse(FeatureSerializer, this)

/**
 * Десериализация объекта [FeatureCollection].
 *
 * @return Объект [FeatureCollection].
 * @author Anatoliy Pokhresnyi
 */
fun String.toFeatureCollection(): FeatureCollection = json.parse(FeatureCollectionSerializer, this)

/**
 * Сериализация объекта [Position].
 *
 * @return Объект [Position] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun Position.stringify(): String = json.stringify(PositionSerializer, this)

/**
 * Сериализация объекта [MultiPosition].
 *
 * @return Объект [MultiPosition] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun MultiPosition.stringify(): String = json.stringify(MultiPositionSerializer, this)

/**
 * Сериализация объекта [Ring].
 *
 * @return Объект [Ring] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun Ring.stringify(): String = json.stringify(RingSerializer, this)

/**
 * Сериализация объекта [MultiRing].
 *
 * @return Объект [MultiRing] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun MultiRing.stringify(): String = json.stringify(MultiRingSerializer, this)

/**
 * Сериализация объекта [MultiGeometry].
 *
 * @return Объект [MultiGeometry] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun MultiGeometry.stringify(): String = json.stringify(MultiGeometrySerializer, this)

/**
 * Сериализация объекта [MultiFeature].
 *
 * @return Объект [MultiFeature] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun MultiFeature.stringify(): String = json.stringify(MultiFeatureSerializer, this)

/**
 * Сериализация объекта [Geometry].
 *
 * @return Объект [Geometry] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun Geometry.stringify(): String = json.stringify(GeometrySerializer, this)

/**
 * Сериализация объекта [Point].
 *
 * @return Объект [Point] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun Point.stringify(): String = json.stringify(PointSerializer, this)

/**
 * Сериализация объекта [MultiPoint].
 *
 * @return Объект [MultiPoint] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun MultiPoint.stringify(): String = json.stringify(MultiPointSerializer, this)

/**
 * Сериализация объекта [LineString].
 *
 * @return Объект [LineString] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun LineString.stringify(): String = json.stringify(LineStringSerializer, this)

/**
 * Сериализация объекта [MultiLineString].
 *
 * @return Объект [MultiLineString] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun MultiLineString.stringify(): String = json.stringify(MultiLineStringSerializer, this)

/**
 * Сериализация объекта [Polygon].
 *
 * @return Объект [Polygon] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun Polygon.stringify(): String = json.stringify(PolygonSerializer, this)

/**
 * Сериализация объекта [MultiPolygon].
 *
 * @return Объект [MultiPolygon] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun MultiPolygon.stringify(): String = json.stringify(MultiPolygonSerializer, this)

/**
 * Сериализация объекта [GeometryCollection].
 *
 * @return Объект [GeometryCollection] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun GeometryCollection.stringify(): String = json.stringify(GeometryCollectionSerializer, this)

/**
 * Сериализация объекта [Feature].
 *
 * @return Объект [Feature] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun Feature.stringify(): String = json.stringify(FeatureSerializer, this)

/**
 * Сериализация объекта [FeatureCollection].
 *
 * @return Объект [FeatureCollection] в формате GeoJson.
 * @author Anatoliy Pokhresnyi
 */
fun FeatureCollection.stringify(): String = json.stringify(FeatureCollectionSerializer, this)
