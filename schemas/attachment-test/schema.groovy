import eu.esdihumboldt.hale.common.schema.geometry.GeometryProperty

/*
 * Example schema for attachment tests with a simple schema (e.g. CSV or Shapefile)
 */

schema('http://www.esdi-humboldt.eu/hale/test') {
  Example {
    name(String)

    // individual ordinates (e.g. for CSV)
    lat(Double)
    lon(Double)

    attachment(description: 'The property containing the attachment reference', cardinality: 1..1)
    type(description: 'Type of attachment reference', cardinality: 1..1)

    // geometry (e.g. for Shapefile)
    geom(GeometryProperty)
  }
}
