import eu.esdihumboldt.hale.common.schema.geometry.GeometryProperty

/*
 * Example schema for attachment tests with a simple schema (e.g. CSV or Shapefile)
 *
 * Adapted to use similar namespaces and names as the Shapefile schema reader in hale studio.
 */

def typeNs = 'http://www.esdi-humboldt.eu/hale/shp'
def propertyNs = ''

schema(typeNs) {
  Example {
    name(String, namespace: propertyNs)

    // individual ordinates (e.g. for CSV)
    lat(Double, namespace: propertyNs, cardinality: 0..1)
    lon(Double, namespace: propertyNs, cardinality: 0..1)

    attachment(description: 'The property containing the attachment reference', namespace: propertyNs, cardinality: 1..1)
    type(description: 'Type of attachment reference', namespace: propertyNs, cardinality: 1..1)

    // geometry name used by Shapefile schema reader
    the_geom(GeometryProperty, namespace: propertyNs)
  }
}
