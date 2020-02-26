package com.github.onotoliy.geojson

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

val FEATURE_JSON = """
{
  "type": "Feature",
  "geometry": {
    "type": "Polygon",
    "coordinates": [
      [
        [
          100.0,
          0.0
        ],
        [
          101.0,
          0.0
        ],
        [
          101.0,
          1.0
        ],
        [
          100.0,
          1.0
        ],
        [
          100.0,
          0.0
        ]
      ]
    ]
  }
}
""".formatted()
val FEATURE_OBJECT = com.github.onotoliy.geojson.Feature(
    com.github.onotoliy.geojson.Polygon(
        com.github.onotoliy.geojson.Ring(
            listOf(
                com.github.onotoliy.geojson.MultiPosition(
                    listOf(
                        com.github.onotoliy.geojson.Position(100.0, 0.0),
                        com.github.onotoliy.geojson.Position(101.0, 0.0),
                        com.github.onotoliy.geojson.Position(101.0, 1.0),
                        com.github.onotoliy.geojson.Position(100.0, 1.0),
                        com.github.onotoliy.geojson.Position(100.0, 0.0)
                    )
                )
            )
        )
    ),
    listOf(),
    mapOf()
)

val FEATURE_COLLECTION_JSON = """
{
  "type": "FeatureCollection",
  "features": [
    {
      "type": "Feature",
      "geometry": {
        "type": "Point",
        "coordinates": [
          102.0,
          0.5
        ]
      }
    },
    {
      "type": "Feature",
      "geometry": {
        "type": "LineString",
        "coordinates": [
          [
            102.0,
            0.0
          ],
          [
            103.0,
            1.0
          ],
          [
            104.0,
            0.0
          ],
          [
            105.0,
            1.0
          ]
        ]
      }
    },
    {
      "type": "Feature",
      "geometry": {
        "type": "Polygon",
        "coordinates": [
          [
            [
              100.0,
              0.0
            ],
            [
              101.0,
              0.0
            ],
            [
              101.0,
              1.0
            ],
            [
              100.0,
              1.0
            ],
            [
              100.0,
              0.0
            ]
          ]
        ]
      }
    }
  ]
}
""".formatted()
val FEATURE_COLLECTION_OBJECT = com.github.onotoliy.geojson.FeatureCollection(
    com.github.onotoliy.geojson.MultiFeature(
        listOf(
            com.github.onotoliy.geojson.Feature(
                com.github.onotoliy.geojson.Point(
                    com.github.onotoliy.geojson.Position(
                        102.0,
                        0.5
                    )
                ), listOf(), mapOf()
            ),
            com.github.onotoliy.geojson.Feature(
                com.github.onotoliy.geojson.LineString(
                    com.github.onotoliy.geojson.MultiPosition(
                        listOf(
                            com.github.onotoliy.geojson.Position(102.0, 0.0),
                            com.github.onotoliy.geojson.Position(103.0, 1.0),
                            com.github.onotoliy.geojson.Position(104.0, 0.0),
                            com.github.onotoliy.geojson.Position(105.0, 1.0)
                        )
                    )
                ),
                listOf(),
                mapOf()
            ),
            com.github.onotoliy.geojson.Feature(
                com.github.onotoliy.geojson.Polygon(
                    com.github.onotoliy.geojson.Ring(
                        listOf(
                            com.github.onotoliy.geojson.MultiPosition(
                                listOf(
                                    com.github.onotoliy.geojson.Position(100.0, 0.0),
                                    com.github.onotoliy.geojson.Position(101.0, 0.0),
                                    com.github.onotoliy.geojson.Position(101.0, 1.0),
                                    com.github.onotoliy.geojson.Position(100.0, 1.0),
                                    com.github.onotoliy.geojson.Position(100.0, 0.0)
                                )
                            )
                        )
                    )
                ),
                listOf(),
                mapOf()
            )
        )
    )
)

val GEOMETRY_COLLECTION_JSON = """
{
  "type": "GeometryCollection",
  "geometries": [
    {
      "type": "Point",
      "coordinates": [
        100.0,
        0.0
      ]
    },
    {
      "type": "LineString",
      "coordinates": [
        [
          101.0,
          0.0
        ],
        [
          102.0,
          1.0
        ]
      ]
    }
  ]
}
""".formatted()
val GEOMETRY_COLLECTION_OBJECT = com.github.onotoliy.geojson.GeometryCollection(
    com.github.onotoliy.geojson.MultiGeometry(
        listOf(
            com.github.onotoliy.geojson.Point(com.github.onotoliy.geojson.Position(100.0, 0.0)),
            com.github.onotoliy.geojson.LineString(
                com.github.onotoliy.geojson.MultiPosition(
                    listOf(
                        com.github.onotoliy.geojson.Position(
                            101.0,
                            0.0
                        ), com.github.onotoliy.geojson.Position(102.0, 1.0)
                    )
                )
            )
        )
    )
)

val LINE_STRING_JSON = """
{
  "type": "LineString",
  "coordinates": [
    [
      100.0,
      0.0
    ],
    [
      101.0,
      1.0
    ]
  ]
}
""".formatted()
val LINE_STRING_OBJECT = com.github.onotoliy.geojson.LineString(
    com.github.onotoliy.geojson.MultiPosition(
        listOf(
            com.github.onotoliy.geojson.Position(
                100.0,
                0.0
            ), com.github.onotoliy.geojson.Position(101.0, 1.0)
        )
    )
)

val MULTI_LINE_STRING_JSON = """
{
  "type": "MultiLineString",
  "coordinates": [
    [
      [
        100.0,
        0.0
      ],
      [
        101.0,
        1.0
      ]
    ],
    [
      [
        102.0,
        2.0
      ],
      [
        103.0,
        3.0
      ]
    ]
  ]
}    
""".formatted()
val MULTI_LINE_STRING_OBJECT = com.github.onotoliy.geojson.MultiLineString(
    com.github.onotoliy.geojson.Ring(
        listOf(
            com.github.onotoliy.geojson.MultiPosition(
                listOf(
                    com.github.onotoliy.geojson.Position(100.0, 0.0),
                    com.github.onotoliy.geojson.Position(101.0, 1.0)
                )
            ),
            com.github.onotoliy.geojson.MultiPosition(
                listOf(
                    com.github.onotoliy.geojson.Position(102.0, 2.0),
                    com.github.onotoliy.geojson.Position(103.0, 3.0)
                )
            )
        )
    )
)

val MULTI_POINT_JSON = """
{
  "type": "MultiPoint",
  "coordinates": [
    [
      100.0,
      0.0
    ],
    [
      101.0,
      1.0
    ]
  ]
}    
""".formatted()
val MULTI_POINT_OBJECT = com.github.onotoliy.geojson.MultiPoint(
    com.github.onotoliy.geojson.MultiPosition(
        listOf(
            com.github.onotoliy.geojson.Position(
                100.0,
                0.0
            ), com.github.onotoliy.geojson.Position(101.0, 1.0)
        )
    )
)

val MULTI_POLYGON_JSON = """
{
  "type": "MultiPolygon",
  "coordinates": [
    [
      [
        [
          102.0,
          2.0
        ],
        [
          103.0,
          2.0
        ],
        [
          103.0,
          3.0
        ],
        [
          102.0,
          3.0
        ],
        [
          102.0,
          2.0
        ]
      ]
    ],
    [
      [
        [
          100.0,
          0.0
        ],
        [
          101.0,
          0.0
        ],
        [
          101.0,
          1.0
        ],
        [
          100.0,
          1.0
        ],
        [
          100.0,
          0.0
        ]
      ],
      [
        [
          100.2,
          0.2
        ],
        [
          100.2,
          0.8
        ],
        [
          100.8,
          0.8
        ],
        [
          100.8,
          0.2
        ],
        [
          100.2,
          0.2
        ]
      ]
    ]
  ]
}    
""".formatted()
val MULTI_POLYGON_OBJECT = com.github.onotoliy.geojson.MultiPolygon(
    com.github.onotoliy.geojson.MultiRing(
        listOf(
            com.github.onotoliy.geojson.Ring(
                listOf(
                    com.github.onotoliy.geojson.MultiPosition(
                        listOf(
                            com.github.onotoliy.geojson.Position(102.0, 2.0),
                            com.github.onotoliy.geojson.Position(103.0, 2.0),
                            com.github.onotoliy.geojson.Position(103.0, 3.0),
                            com.github.onotoliy.geojson.Position(102.0, 3.0),
                            com.github.onotoliy.geojson.Position(102.0, 2.0)
                        )
                    )
                )
            ),
            com.github.onotoliy.geojson.Ring(
                listOf(
                    com.github.onotoliy.geojson.MultiPosition(
                        listOf(
                            com.github.onotoliy.geojson.Position(100.0, 0.0),
                            com.github.onotoliy.geojson.Position(101.0, 0.0),
                            com.github.onotoliy.geojson.Position(101.0, 1.0),
                            com.github.onotoliy.geojson.Position(100.0, 1.0),
                            com.github.onotoliy.geojson.Position(100.0, 0.0)
                        )
                    ),
                    com.github.onotoliy.geojson.MultiPosition(
                        listOf(
                            com.github.onotoliy.geojson.Position(100.2, 0.2),
                            com.github.onotoliy.geojson.Position(100.2, 0.8),
                            com.github.onotoliy.geojson.Position(100.8, 0.8),
                            com.github.onotoliy.geojson.Position(100.8, 0.2),
                            com.github.onotoliy.geojson.Position(100.2, 0.2)
                        )
                    )
                )
            )
        )
    )
)

val POINT_JSON = """
{
  "type": "Point",
  "coordinates": [
    100.0,
    0.0
  ]
}    
""".formatted()
val POINT_OBJECT = com.github.onotoliy.geojson.Point(com.github.onotoliy.geojson.Position(100.0, 0.0))

val POLYGON_NO_HOLES_JSON = """
{
  "type": "Polygon",
  "coordinates": [
    [
      [
        100.0,
        0.0
      ],
      [
        101.0,
        0.0
      ],
      [
        101.0,
        1.0
      ],
      [
        100.0,
        1.0
      ],
      [
        100.0,
        0.0
      ]
    ]
  ]
}    
""".formatted()
val POLYGON_NO_HOLES_OBJECT = com.github.onotoliy.geojson.Polygon(
    com.github.onotoliy.geojson.Ring(
        listOf(
            com.github.onotoliy.geojson.MultiPosition(
                listOf(
                    com.github.onotoliy.geojson.Position(100.0, 0.0),
                    com.github.onotoliy.geojson.Position(101.0, 0.0),
                    com.github.onotoliy.geojson.Position(101.0, 1.0),
                    com.github.onotoliy.geojson.Position(100.0, 1.0),
                    com.github.onotoliy.geojson.Position(100.0, 0.0)
                )
            )
        )
    )
)

val POLYGON_WITH_HOLES_JSON = """
{
  "type": "Polygon",
  "coordinates": [
    [
      [
        100.0,
        0.0
      ],
      [
        101.0,
        0.0
      ],
      [
        101.0,
        1.0
      ],
      [
        100.0,
        1.0
      ],
      [
        100.0,
        0.0
      ]
    ],
    [
      [
        100.8,
        0.8
      ],
      [
        100.8,
        0.2
      ],
      [
        100.2,
        0.2
      ],
      [
        100.2,
        0.8
      ],
      [
        100.8,
        0.8
      ]
    ]
  ]
}    
""".formatted()
val POLYGON_WITH_HOLES_OBJECT = com.github.onotoliy.geojson.Polygon(
    com.github.onotoliy.geojson.Ring(
        listOf(
            com.github.onotoliy.geojson.MultiPosition(
                listOf(
                    com.github.onotoliy.geojson.Position(100.0, 0.0),
                    com.github.onotoliy.geojson.Position(101.0, 0.0),
                    com.github.onotoliy.geojson.Position(101.0, 1.0),
                    com.github.onotoliy.geojson.Position(100.0, 1.0),
                    com.github.onotoliy.geojson.Position(100.0, 0.0)
                )
            ),
            com.github.onotoliy.geojson.MultiPosition(
                listOf(
                    com.github.onotoliy.geojson.Position(100.8, 0.8),
                    com.github.onotoliy.geojson.Position(100.8, 0.2),
                    com.github.onotoliy.geojson.Position(100.2, 0.2),
                    com.github.onotoliy.geojson.Position(100.2, 0.8),
                    com.github.onotoliy.geojson.Position(100.8, 0.8)
                )
            )
        )
    )
)

val FEATURE_FULL_JSON = """
{
  "type": "Feature",
  "geometry": {
  "type": "Point",
    "coordinates": [
      102.0,
      0.5,
      100.0
    ]
  },
  "bbox": [0.1, 0.2, 0.3, 0.4],
  "properties": {
    "prop0": "value0",
    "prop2": ["1", "2", "3", "4"],
    "prop1": {
      "this": "that"
    }
  }
}
""".formatted()
val FEATURE_FULL_OBJECT = com.github.onotoliy.geojson.Feature(
    com.github.onotoliy.geojson.Point(com.github.onotoliy.geojson.Position(102.0, 0.5, 100.0)),
    listOf(0.1, 0.2, 0.3, 0.4),
    linkedMapOf(
        "prop0" to "value0",
        "prop2" to arrayListOf("1", "2", "3", "4"),
        "prop1" to linkedMapOf("this" to "that")
    )
)

fun String.formatted() = Json(JsonConfiguration.Stable).parseJson(this).toString()
