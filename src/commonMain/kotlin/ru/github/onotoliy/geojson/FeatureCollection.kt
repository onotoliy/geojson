package ru.github.onotoliy.geojson

/**
 * FeatureCollection Object.
 *
 * @property features Features.
 * @author Anatoliy Pokhresnyi
 */
expect class FeatureCollection(features: MultiFeature) : GeoJsonObject<MultiFeature> {

    /**
     * Features.
     */
    val features: MultiFeature
}
