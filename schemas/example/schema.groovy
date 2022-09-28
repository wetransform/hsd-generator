import eu.esdihumboldt.hale.common.schema.model.constraint.*
import eu.esdihumboldt.hale.common.schema.model.constraint.type.*
import eu.esdihumboldt.hale.common.schema.model.constraint.property.*

import eu.esdihumboldt.hale.common.schema.geometry.GeometryProperty

import eu.esdihumboldt.util.validator.*

import java.time.*

import javax.xml.namespace.QName

def ns = 'defaultnamespace' //XXX needed?

schema(ns) {

  /*
   * Found this note (so it seems enum validation requires currently a validation constraint to be present): https://github.com/halestudio/hale/blob/44e54a9dfd067bdf51db427a50de9803213ffb1c/common/plugins/eu.esdihumboldt.hale.common.instancevalidator/src/eu/esdihumboldt/hale/common/instancevalidator/validators/ValidationConstraintValidator.java#L32
   *
   * Validators have not been used with schemabuilder yet, so handling could be definitely improved
   *
   * List of validators
   * https://github.com/halestudio/hale/tree/44e54a9dfd067bdf51db427a50de9803213ffb1c/util/plugins/eu.esdihumboldt.util/src/eu/esdihumboldt/util/validator
   */
  def codeType = CodeType(enum: ['foo', 'bar'])
  def codeValidator = new OrValidator([
    new EnumerationValidator(['foo', 'bar']),
    new PatternValidator(/^custom:/)
  ])
  codeType.setConstraint(new ValidationConstraint(codeValidator, codeType))

  /*
   * City type from GeoPackage tests extended with more examples
   */
  city([
    new PrimaryKey([new QName(ns, 'id')]) // mark primary key property
  ]) {
    id(Integer)
    name(String)
    a_date(LocalDate)
    a_timestamp(Instant)
    legacy_date(Date)
    location(GeometryProperty)
    code(codeType) // use code type defined before, sadly right now property 
  }

  /*
   * Constraint example from unit tests
   *
   * Type definition or binding is by default the first argument.
   *
   * Constraints can be defined in two ways:
   * (a) list arugment that contains constraint objects as created with the hale studio API
   * (b) map notation with the factory name as key, see
   *     - https://github.com/halestudio/hale/blob/44e54a9dfd067bdf51db427a50de9803213ffb1c/common/plugins/eu.esdihumboldt.hale.common.schema.groovy/src/eu/esdihumboldt/hale/common/schema/groovy/SchemaBuilder.groovy#L99
   *     - https://github.com/halestudio/hale/tree/master/common/plugins/eu.esdihumboldt.hale.common.schema.groovy/src/eu/esdihumboldt/hale/common/schema/groovy/constraints
   */
  def itemType = ItemType([
    AbstractFlag.ENABLED,
    new DisplayName('Item')
  ]) {
    id(Long, nillable: false, [Cardinality.CC_EXACTLY_ONCE]) 
    name(String)
    price(Double, [NillableFlag.ENABLED])
    description(String, nillable: true)
  }


  OrderType {
    _ (cardinality: '1..n') { // a group
      item(itemType, cardinality: 1)
      quantity(Integer, cardinality: 1..1)
    }
  }
}