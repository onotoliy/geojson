package com.github.onotoliy.geojson

/**
 * Списк объектов [Feature]. Используется для геометрии типа [FeatureCollection].
 *
 * @property coordinates Список геометрий.
 * @author Anatoliy Pokhresnyi
 */
actual class MultiFeature actual constructor(actual val coordinates: List<Feature>) :
    AbstractGeoJsonCoordinate<Feature>(coordinates)
