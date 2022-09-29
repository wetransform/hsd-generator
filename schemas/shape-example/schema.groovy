import eu.esdihumboldt.hale.common.schema.geometry.GeometryProperty

/*
 * Example schema for generating Shapefiles.
 *
 * Used to test automated type association in hale connect.
 */

def typeNs = 'http://www.esdi-humboldt.eu/hale/shp'
def propertyNs = ''

schema(propertyNs) {
  /*
   * Main type we create instances for
   */
  City(namespace: typeNs) {
    name(String)

    // individual ordinates
    lat(Double, cardinality: 0..1)
    lon(Double, cardinality: 0..1)

    // geometry name used by Shapefile schema reader
    the_geom(GeometryProperty)
  }

  /*
   * Additional types we create as rivals for automated type association.
   */

  // type with additional mandatory property
  Event(namespace: typeNs) {
    name(String)

    date(Date)

    // individual ordinates
    lat(Double, cardinality: 0..1)
    lon(Double, cardinality: 0..1)

    // geometry name used by Shapefile schema reader
    the_geom(GeometryProperty)
  }

  // type with optional properties removed
  PointOfInterest(namespace: typeNs) {
    name(String)

    // geometry name used by Shapefile schema reader
    the_geom(GeometryProperty)
  }

  // type with additional optional properties
  CityExtended(namespace: typeNs) {
    name(String)

    // individual ordinates
    lat(Double, cardinality: 0..1)
    lon(Double, cardinality: 0..1)

    // additional properties
    population(Integer, cardinality: 0..1)
    postcode(String, cardinality: 0..1)

    // geometry name used by Shapefile schema reader
    the_geom(GeometryProperty)
  }
}
