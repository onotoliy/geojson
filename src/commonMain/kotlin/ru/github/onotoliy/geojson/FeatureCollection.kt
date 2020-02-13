package ru.github.onotoliy.geojson

/**
 * Объект FeatureCollection.
 *
 * @property features Список объектов Features.
 * @author Anatoliy Pokhresnyi
 */
expect class FeatureCollection(features: MultiFeature) : GeoJsonObject<MultiFeature> {

    /**
     * Список объектов Features.
     */
    val features: MultiFeature
}
