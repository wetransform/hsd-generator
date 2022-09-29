import eu.esdihumboldt.cst.functions.geometric.GeometryHelperFunctions

def createGeometry(String wkt, Object crs) {
  return GeometryHelperFunctions._with([geometry: wkt, crs: crs])
}

def createPoint(lat, lon) {
  return createGeometry("POINT($lat $lon)", 4326)
}

createCollection {

  City {
    name('Berlin')

    def _lat = 52.5170365
    def _lon = 13.3888599
    def _geom = createPoint(_lat, _lon)

    lat(_lat)
    lon(_lon)
    the_geom(_geom)
  }

  City {
    name('Darmstadt')

    def _lat = 49.872775
    def _lon = 8.651177
    def _geom = createPoint(_lat, _lon)

    lat(_lat)
    lon(_lon)
    the_geom(_geom)
  }

  City {
    name('München')

    def _lat = 48.1371079
    def _lon = 11.5753822
    def _geom = createPoint(_lat, _lon)

    lat(_lat)
    lon(_lon)
    the_geom(_geom)
  }

  City {
    name('Hamburg')

    def _lat = 53.550341
    def _lon = 10.000654
    def _geom = createPoint(_lat, _lon)

    lat(_lat)
    lon(_lon)
    the_geom(_geom)
  }

  City {
    name('Köln')

    def _lat = 50.938361
    def _lon = 6.959974
    def _geom = createPoint(_lat, _lon)

    lat(_lat)
    lon(_lon)
    the_geom(_geom)
  }

  City {
    name('Zürich')

    def _lat = 47.3744489
    def _lon = 8.5410422
    def _geom = createPoint(_lat, _lon)

    lat(_lat)
    lon(_lon)
    the_geom(_geom)
  }

  City {
    name('Bensheim')

    def _lat = 49.6810158
    def _lon = 8.6227577
    def _geom = createPoint(_lat, _lon)

    lat(_lat)
    lon(_lon)
    the_geom(_geom)
  }

  City {
    name('Stuttgart')

    def _lat = 48.7784485
    def _lon = 9.1800132
    def _geom = createPoint(_lat, _lon)

    lat(_lat)
    lon(_lon)
    the_geom(_geom)
  }

}
