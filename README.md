# Quantity Measurement App

## UC1 – Feet Measurement Equality

## Description

This use case checks the equality of two numerical values measured in feet using proper object-oriented design principles.

## Objective

To compare two feet measurements and return `true` if equal, otherwise `false`.

## Preconditions

- `Feet.java` is instantiated
- Two numeric values (in feet) are provided

## Main Flow

1. User provides two feet values
2. Objects of `Feet` class are created
3. `equals()` method is invoked
4. Values are compared using `Double.compare()`
5. Result is returned

## Postcondition

Returns `true` if both values are equal, otherwise `false`.

## Key Concepts

- Overriding `equals()` correctly
- Floating-point comparison using `Double.compare()`
- Null and type safety checks
- Encapsulation and immutability
- Equality contract (reflexive, symmetric, transitive, consistent)

🔗 _Code Link:_
👉 [UC1 – Feet Measurement Equality](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC1-FeetEquality/src)

---
## UC2 – Feet and Inches Measurement Equality

## Description

This use case extends UC1 to support equality checks for both Feet and Inches measurements.  
Feet and Inches are treated as separate entities and compared independently.

## Objective

To validate and compare two Feet values and two Inches values using proper equality logic.

## Preconditions

- `Inches.java` is instantiated
- Two numeric values for Feet and Inches are provided

## Main Flow

1. Main method calls static method for Feet equality
2. Main method calls static method for Inches equality
3. Separate `Feet` and `Inches` objects are created
4. `equals()` method is invoked
5. Values are compared using `Double.compare()`
6. Result (`true` / `false`) is returned

## Postcondition

Returns equality result for Feet-to-Feet and Inches-to-Inches comparisons.

## Key Concepts

- Object Equality and equals() contract
- Floating-point comparison using `Double.compare()`
- Null and type safety checks
- Encapsulation and immutability
- DRY principle consideration (code duplication in Feet & Inches classes)

🔗 _Code Link:_
👉 [UC2 – Feet and Inches Measurement Equality](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC2-InchEquality/src)

---
## 📏 UC3 – Generic Quantity Class (DRY Principle)

## Description

UC3 refactors separate Feet and Inches classes into a single `QuantityLength` class using an enum.  
This eliminates code duplication and follows the DRY (Don't Repeat Yourself) principle.

## Objective

To compare measurements across units (e.g., 1 ft == 12 inches) using a common base unit conversion.

## Preconditions

- `QuantityMeasurementApp` is instantiated
- Two numeric values with unit types are provided
- Conversion factors are defined in `LengthUnit` enum

## Main Flow

1. User provides value and unit
2. Input and unit are validated
3. Values are converted to base unit (feet)
4. Converted values are compared using `Double.compare()`
5. Equality result is returned

## Postcondition

Returns `true` if converted values are equal, otherwise `false`.  
All UC1 and UC2 functionality remains preserved.

## Key Concepts

- DRY Principle (no duplicate unit classes)
- Enum for type-safe units
- Cross-unit comparison (1 ft = 12 inches)
- Encapsulation and abstraction
- Equality contract and null safety
- Scalable design for adding new units

🔗 _Code Link:_
👉 [UC3 – Generic Quantity Class (DRY Principle)](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC3-GenericLength/src)

---
## UC4 – Extended Unit Support (Yards & Centimeters)

## Description

UC4 extends UC3 by adding YARDS and CENTIMETERS to the `LengthUnit` enum.  
The generic `QuantityLength` class now supports feet, inches, yards, and centimeters without code duplication.

## Objective

To compare measurements across multiple units (ft, in, yd, cm) using common base conversion.

## Preconditions

- Refactored `QuantityLength` class from UC3 is used
- Units supported: FEET, INCHES, YARDS, CENTIMETERS
- Conversion factors are defined in the enum

## Main Flow

1. User provides value and unit
2. Input and unit are validated
3. Values are converted to a common base unit
4. Converted values are compared using `Double.compare()`
5. Equality result is returned

## Postcondition

Returns `true` if converted values are equal across any unit combination.  
All UC1–UC3 functionality remains intact.

## Key Concepts

- Scalable generic design
- Enum extensibility
- Cross-unit conversion (1 yd = 3 ft = 36 in, 1 cm = 0.393701 in)
- DRY principle validation
- Mathematical accuracy in conversions
- Backward compatibility

🔗 _Code Link:_
👉 [UC4 – Extended Unit Support (Yards & Centimeters)](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC4-YardEquality/src)

---
## 📏 UC5 – Unit-to-Unit Conversion (Same Measurement Type)

## Description

UC5 extends UC4 by adding explicit unit-to-unit conversion functionality.  
The `QuantityLength` API now provides a `convert()` method to transform values between supported units.

## Objective

To convert a numeric value from one LengthUnit to another using centralized conversion factors.

## Preconditions

- `QuantityLength` class and `LengthUnit` enum exist
- Supported units: FEET, INCHES, YARDS, CENTIMETERS
- Conversion factors are defined relative to a base unit

## Main Flow

1. Client calls `convert(value, sourceUnit, targetUnit)`
2. Validate value (finite number) and units (non-null)
3. Normalize value to base unit
4. Convert base value to target unit
5. Return converted numeric result

## Postcondition

Returns mathematically equivalent value in target unit.  
Invalid inputs throw `IllegalArgumentException`.

## Key Concepts

- Enum-based conversion factor management
- Base unit normalization formula
- Immutability and value object design
- Method overloading and API usability
- Floating-point precision handling
- Bidirectional and round-trip conversion accuracy
- Clean, scalable conversion API

🔗 _Code Link:_
👉 [UC5 – Unit-to-Unit Conversion](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC5-UnitConversion/src)

---
## UC6 – Addition of Two Length Units (Same Category)

## Description

UC6 extends UC5 by introducing addition between two length measurements.  
Two lengths (possibly different units) can be added, and the result is returned in the unit of the first operand.

## Objective

To add two QuantityLength objects using base unit normalization and return a new immutable result.

## Preconditions

- `QuantityLength` class and `LengthUnit` enum exist
- Units supported: FEET, INCHES, YARDS, CENTIMETERS
- Both operands belong to the same measurement category (length)

## Main Flow

1. Validate operands and units (non-null, finite values)
2. Convert both values to a common base unit
3. Add the normalized values
4. Convert the sum to the unit of the first operand
5. Return a new `QuantityLength` object

## Postcondition

Returns a new immutable object representing the sum.  
Original objects remain unchanged.  
Invalid inputs throw `IllegalArgumentException`.

## Key Concepts

- Arithmetic on value objects
- Base unit normalization for cross-unit addition
- Immutability and factory-style method design
- Commutative property (A + B = B + A)
- Identity element (adding zero)
- Precision handling with floating-point tolerance
- Reuse of conversion logic from UC5

🔗 _Code Link:_
👉 [UC6 – Addition of Two Length Units](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC6-UnitAddition/src)

---
# UC7 - Addition with Target Unit Specification

### 📌 Overview

- This module extends UC6 by allowing the caller to explicitly specify a `target unit` for addition results.
- Instead of defaulting to the first operand’s unit, the result can be returned in any supported unit.
- Example: `1 foot` + `12 inches` with target unit `YARDS ≈ 0.667 yards`.

### ⚙️ Use Case: UC7 – Addition with Target Unit Specification

- Accepts two numerical values with their respective units and a target unit.
- Adds them and returns the sum in the `explicitly specified target unit`.

### ⚙️ Key Implementation Points (UC7 – Explicit Target Unit Addition)

- Uses the same `immutable Length class` and LengthUnit enum.
- Overloaded `add()` method:
   - UC6: `add(A, B)` → result in the first operand’s unit.
   - UC7: `add(A, B, targetUnit)` → result in explicitly specified unit.
- Private utility method handles `conversion → addition → target` unit conversion.
- Validation added: target unit must be non-null and valid.
- Preserves immutability, precision, and commutativity.
- Maintains backward compatibility with the UC6 addition.

🔗 _Code Link:_
👉 [UC7 – Addition with Target Unit Specification](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC7-TargetUnitAddition/src)

---
# UC8 - Standalone LengthUnit Refactoring

### 📌 Overview

- This module refactors the `LengthUnit enum` to a `standalone`, `top-level class` with full responsibility for unit conversions.
- QuantityLength is simplified to focus on value comparison and arithmetic, delegating all conversion logic to LengthUnit.
- The change improves cohesion, eliminates circular dependencies, and establishes a scalable pattern for `multiple measurement categories`.

### ⚙️ Use Case: UC8 – Refactoring Unit Enum to Standalone with Conversion Responsibility

- `LengthUnit` manages all conversion logic (to/from base unit).
- `QuantityLength` handles equality, addition, and arithmetic only.
- Supports all functionality from UC1–UC7 without modifying client code.

### ⚙️ Key Implementation Points

- LengthUnit handles all unit conversion logic.
- `QuantityLength` delegates conversions → focuses on comparisons/addition.
- Methods:
   - `convertToBaseUnit`(double value)
   - `convertFromBaseUnit`(double baseValue)
- Preserves immutability, precision, and commutativity.
- `Public API` unchanged → `backward compatibility`.
- Establishes scalable design pattern for other measurement categories.

🔗 _Code Link:_
👉 [UC8 – Standalone LengthUnit Refactoring](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC8-StandaloneUnit/src)

---
# UC9 - Weight Equality, Conversion, and Addition

### 📌 Overview

- This module extends the Quantity Measurement App to support `weight measurements` (kilogram, gram, pound).
- It focuses on correct object equality, unit conversion, addition operations, and safe floating-point comparisons while maintaining immutability and type safety.

### ⚙️ Use Case: UC9 – Weight Measurement Equality, Conversion, and Addition

- Accepts two or more numerical values with `weight units` (kg, g, lb)
- Compares weights for equality
- Converts weights between units
- Adds two weight measurements and returns a new object

### ⚙️ Key Implementation Points

- Uses a **WeightUnit enum** for conversion responsibility (base unit: kilogram)
- Uses a **QuantityWeight class** to represent weight measurements
- Measurement value and unit are **private and final** (immutable)
- `equals()` is overridden to handle cross-unit comparisons
- `convertTo()` method normalises via the base unit
- `add()` methods support implicit (default) and explicit target unit addition
- **Double.compare()** ensures safe floating-point comparison
- Handles null, type mismatch, same reference, and category incompatibility safely
- Weight and length measurements are **distinct categories** and cannot be compared

🔗 _Code Link:_
👉 [UC9 - Weight Equality, Conversion, and Addition](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC9-WeightMeasurement/src)

---
# UC10 - Generic Quantity Class with Unit Interface

### 📌 Overview

- This module refactors the previous category-specific Quantity classes into a single, generic `Quantity<U>` class that works with any measurement category implementing the `IMeasurable` interface.
- It eliminates code duplication, simplifies demonstration methods, and ensures type-safe operations across multiple measurement categories like length and weight.

### ⚙️ Use Case: UC10 – Generic Quantity and Multi-Category Support

- Accepts two numerical values with their respective units
- Supports equality comparison, unit conversion, and addition
- Prevents invalid cross-category comparisons (e.g., length vs. weight)
- Returns a new `Quantity` object for conversion or addition; equality returns a boolean

### ⚙️ Key Implementation Points

- Uses a single generic class: `Quantity<U extends IMeasurable>`
- Holds private final fields: `value` and `unit` (immutable)
- `IMeasurable` interface standardises unit behaviour across categories
- Enums (`LengthUnit`, `WeightUnit`) implement `IMeasurable` and encapsulate conversion logic
- `equals()` compares base unit values using `Double.compare()` and validates unit types
- `convertTo(U targetUnit)` delegates to the unit’s conversion methods and returns new instance
- `add(Quantity<U> other)` and `add(Quantity<U> other, U targetUnit)` perform arithmetic safely
- `hashCode()` and `toString()` overridden for collections and readable output
- Type safety ensured at compile-time via generics; runtime unit class checks prevent cross-category errors
- Demonstration methods in `QuantityMeasurementApp` are generic and unified for all categories

---
# UC11 - Volume Equality, Conversion, and Addition

### 📌 Overview

- This module extends the Quantity Measurement Application to support **volume measurements** (litres, millilitres, gallons).
- It demonstrates equality comparison, unit conversion, and addition operations for volume, leveraging the generic `Quantity<U>` class and `IMeasurable` interface. - Volume is treated as a separate category from length and weight, validating the scalability of the generic architecture.

### ⚙️ Use Case:  UC11 – Volume Measurement Equality, Conversion, and Addition

- Accepts numerical values with their respective volume units (LITRE, MILLILITRE, GALLON)
- Compares volumes for equality
- Converts between volume units
- Adds two volume quantities, optionally specifying a target unit

### ⚙️ Key Implementation Points

- `VolumeUnit` enum implements `IMeasurable` with LITRE as the base unit
- Conversion factors: MILLILITRE = 0.001 L, GALLON ≈ 3.78541 L
- Equality uses base unit comparison with epsilon tolerance
- Generic `Quantity<U>` handles conversion and addition without modification
- Maintains type safety: volume cannot be mixed with length or weight
- Objects are immutable; addition and conversion return new instances

[UC11-VolumeEquality](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC11-VolumeEquality/src)

---

# UC12: Quantity Subtraction and Division

  ### 📌 Overview
  
  UC12 extends the Quantity Measurement App by adding subtraction and division operations to the generic
  Quantity<T> class. These operations work across all measurement categories (length, weight, volume) while maintaining
  strict type safety.

  ### ⚙️ Features:
  - Subtraction with implicit and explicit target units
  - Cross-unit operations within the same category
  - Division returns a unitless ratio (double)
  - Cross-category operations prevented by generics
  - Null validation and division-by-zero handling
  - Immutability and precision maintained

  ### ⚙️ Example:
  - Quantity(10.0, FEET).subtract(Quantity(6.0, INCH)) → 9.5 FEET
  - Quantity(5.0, LITRE).subtract(Quantity(2.0, LITRE)) → 3.0 LITRE
  - Quantity(10.0, FEET).divide(Quantity(2.0, FEET)) → 5.0

[UC12-Subtraction and Division](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC12-SubtractionDivision/src)

---
# UC13: Centralized Arithmetic Operations Using Enum Strategy

### 📌 Overview

UC14 refactors the Quantity Measurement App by introducing an ArithmeticOperation enum (ADD, SUBTRACT, DIVIDE) to centralize arithmetic behavior. All operations now delegate to a single private helper method, eliminating duplicate validation and conversion logic while preserving existing functionality.

  ### ⚙️ Implementation:
  - ArithmeticOperation enum handles operation-specific computation.
  - Private helper method performs validation, base unit conversion, enum dispatch, and result conversion.
  - Add and subtract results are rounded to two decimals.
  - Divide returns a dimensionless raw double value.
  - No changes required to existing unit enums (LengthUnit, WeightUnit, VolumeUnit).
  - Full backward compatibility with UC12 maintained.

  ### ⚙️ Example:
  - Quantity(10.0, FEET).add(Quantity(5.0, FEET)) → 15.00 FEET
  - Quantity(10.0, FEET).subtract(Quantity(5.0, FEET)) → 5.00 FEET
  - Quantity(10.0, FEET).divide(Quantity(5.0, FEET)) → 2.0

[UC13-Centralized Arithmetic Operations](https://github.com/Prathamkacher/QuantityMeasurementApp/blob/feature/UC13-CentralizedArithmetic/src)

---
