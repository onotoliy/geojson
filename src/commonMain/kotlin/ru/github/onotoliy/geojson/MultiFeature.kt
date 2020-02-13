package ru.github.onotoliy.geojson

/**
 * Списк объектов [Feature]. Используется для геометрии типа [FeatureCollection].
 *
 * @property coordinates Список геометрий.
 * @author Anatoliy Pokhresnyi
 */
expect class MultiFeature(coordinates: List<Feature>) : AbstractGeoJsonCoordinate<Feature> {
    val coordinates: List<Feature>
}