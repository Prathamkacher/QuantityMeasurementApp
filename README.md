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

  ### ⚙️ Description: UC12 extends the Quantity Measurement App by adding subtraction and division operations to the generic
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
# UC14: Temperature Measurement Equality and Conversion

### 📌 Overview

UC14 extends the Quantity Measurement App to support temperature measurements (Celsius and Fahrenheit). Unlike length, weight, and volume, temperature uses non-linear conversion formulas. The system supports equality and conversion only. Arithmetic operations like addition, subtraction, multiplication, and division are not allowed for temperature.

- Units & Conversion:
  - CELSIUS (°C) – base unit
  - FAHRENHEIT (°F) – °F = (°C × 9/5) + 32

  ### ⚙️ Implementation:
  - TemperatureUnit enum implements IMeasurable.
  - Uses conversion formulas instead of multiplication factors.
  - Supports cross-unit equality using epsilon precision.
  - Arithmetic operations throw UnsupportedOperationException.
  - Fully compatible with the existing generic Quantity class.
  - No changes required to LengthUnit, WeightUnit, or VolumeUnit.

  ### ⚙️ Example:
  - Quantity(0.0, CELSIUS).equals(Quantity(32.0, FAHRENHEIT)) → true
  - Quantity(100.0, CELSIUS).convertTo(FAHRENHEIT) → 212.0
  - Quantity(50.0, CELSIUS).add(Quantity(10.0, CELSIUS)) → UnsupportedOperationException

[UC14–Temperature Measurement](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC14-TemperatureMeasurement/src)

---

### 📅 UC15: N-Tier Architecture Refactoring

- Description: UC15 restructures the Quantity Measurement App into a layered architecture by introducing Controller, Service, Repository, DTO, Model, and Entity layers. This separation improves maintainability, modularity, and testability while preserving all measurement logic implemented in previous use cases.

- Architecture:

  - **Controller** – Handles requests and delegates operations to the service layer.
  - **Service** – Contains business logic and coordinates conversions and operations.
  - **Repository** – Provides a cache-based storage layer.
  - **DTO / Model / Entity** – Used for structured data transfer and internal representation.

- Implementation:

  - Introduced `QuantityMeasurementController`, `QuantityMeasurementServiceImpl`, and `QuantityMeasurementCacheRepository`.
  - Added `QuantityDTO`, `QuantityModel`, and `QuantityMeasurementEntity`.
  - Service performs **DTO → Model → Quantity → Model → DTO** transformation.
  - Reuses the existing generic `Quantity` engine and unit enums from previous UCs.

- Example:

  - `QuantityDTO(10, FEET, LENGTH) + QuantityDTO(12, INCHES, LENGTH) → QuantityDTO(11, FEET, LENGTH)`
  - `QuantityDTO(100, CELSIUS, TEMPERATURE).equals(QuantityDTO(212, FAHRENHEIT, TEMPERATURE)) → true`

[UC15–Architecture Refactoring](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC15-N-Tier)

---

### 📅 UC16: Database Integration with JDBC

- Description: UC16 extends the Quantity Measurement App by introducing database persistence using JDBC. Instead of storing measurement operations only in an in-memory cache (UC15), this use case stores all operations in a relational database for long-term persistence and history tracking.

- Architecture:

  - **Controller** – Handles requests and delegates operations to the service layer.
  - **Service** – Contains business logic and coordinates conversions and operations.
  - **Repository** – Adds a database-based repository for persistent storage.
  - **DTO / Model / Entity** – Used for structured data transfer and internal representation.
  - **Database Layer** – Uses JDBC to store measurement operations in the database.

- Implementation:

  - Introduced `QuantityMeasurementDatabaseRepository` for database persistence.
  - Added `ApplicationConfig` and `ConnectionPool` for database configuration and connection management.
  - Implemented **H2 database** for development and testing.
  - Added **SLF4J logging** for structured logging instead of `System.out.println`.
  - Created database tables `quantity_measurement_entity` and `quantity_measurement_history`.
  - Repository selection (cache or database) is configurable using `application.properties`.

- Example:

  - `QuantityDTO(10, FEET, LENGTH) + QuantityDTO(12, INCHES, LENGTH) → QuantityDTO(11, FEET, LENGTH)`
  - `QuantityDTO(2, KILOGRAM, WEIGHT) + QuantityDTO(500, GRAM, WEIGHT) → QuantityDTO(2.5, KILOGRAM, WEIGHT)`
  - Measurement operations are **persisted in the database** and can be retrieved for history tracking.

[UC16–Database Integration](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC16-Database-Integration-with-JDBC)

---

## 🚀 UC17 – Spring Boot REST + JPA Integration

## Description
UC17 transforms the Quantity Measurement Application into a **Spring Boot-based REST API** using **Spring Data JPA** for persistence.  
It replaces JDBC with ORM and exposes functionality via HTTP endpoints.

## Objective
Modernize the application with **Spring ecosystem**, enabling scalable, maintainable, and production-ready architecture.

## Key Enhancements
- Spring Boot auto-configuration and embedded Tomcat
- REST APIs using `@RestController`
- Spring Data JPA replacing JDBC
- Dependency Injection with `@Autowired`
- Global exception handling using `@ControllerAdvice`
- Validation using annotations (`@NotNull`, `@NotEmpty`)
- Swagger/OpenAPI for API documentation

## Architecture
- **Controller Layer** → REST endpoints  
- **Service Layer** → Business logic + transactions  
- **Repository Layer** → JPA repositories  
- **Model Layer** → Entities & DTOs  

## Key Components
- `QuantityMeasurementRepository` – JPA repository  
- `QuantityMeasurementServiceImpl` – Spring service  
- `QuantityMeasurementController` – REST API  
- `GlobalExceptionHandler` – centralized error handling  
- `QuantityMeasurementApplication` – Spring Boot entry point  

## Features
- Perform compare, convert, add operations via REST APIs
- Store and retrieve measurement history using JPA
- Query by operation type and measurement type
- Structured JSON responses with proper HTTP status codes
- Swagger UI for interactive API testing

## Postconditions
- Application runs on `http://localhost:8080`
- APIs available at `/api/v1/quantities/*`
- H2 database integrated for development
- Fully Spring-managed architecture
- Ready for future enhancements (Security, Microservices)

🔗 _Code Link:_ 
👉 [UC17 – Spring Boot REST + JPA Integration](https://github.com/Prathamkacher/QuantityMeasurementApp/tree/feature/UC17-Spring-Backend)

---

---

## 🔐 UC18 – Google Authentication and User Management

## Description
UC18 implements comprehensive **OAuth2 authentication with Google** and advanced **user management** features.  
The system supports both local email/password authentication and Google OAuth2, with seamless user registration and profile management.

## Objective
Provide secure, scalable authentication with Google OAuth2 integration and complete user lifecycle management.

## Key Features
- **Dual Authentication**: Local (email/password) + Google OAuth2
- **Automatic User Registration**: First-time Google users auto-created
- **Profile Management**: User details, profile pictures, email verification
- **Session Management**: JWT tokens with refresh token rotation
- **Security**: Password strength validation, email OTP for password reset
- **Audit Trail**: Track authentication events and user activities

## Authentication Flow

### Local Authentication
1. **Registration**: User provides email, password, name, mobile
2. **Validation**: Strong password requirements enforced
3. **Storage**: Password BCrypt hashed, email marked unverified
4. **Welcome Email**: Sent asynchronously after registration
5. **Login**: Email/password validation, JWT generation
6. **Session**: Access token (10 days) + Refresh token (30 days)

### Google OAuth2 Authentication
1. **Redirect**: User redirected to Google OAuth2 consent screen
2. **Authorization**: Google authenticates user and returns authorization code
3. **Token Exchange**: Backend exchanges code for access/id tokens
4. **User Lookup**: Find existing user by Google provider ID
5. **Auto Registration**: Create new user if not found
6. **JWT Generation**: Generate access and refresh tokens
7. **Frontend Redirect**: Redirect to frontend with JWT

### Password Reset Flow
1. **Request**: User provides email address
2. **Validation**: Check email exists and is verified
3. **OTP Generation**: 6-digit OTP with 15-minute expiry
4. **Email Delivery**: Send OTP to user's email
5. **Verification**: User provides OTP and new password
6. **Update**: Validate OTP, update password, invalidate sessions

## User Management Features

### Profile Management
- **Personal Information**: First name, last name, email, mobile
- **Profile Picture**: URL from OAuth2 provider or custom
- **Email Verification**: Track verification status
- **Authentication Provider**: Track local vs Google authentication
- **Provider ID**: Store OAuth2 provider's unique user ID

### Security Features
- **Password Strength**: 8+ chars, uppercase, lowercase, number, special character
- **Email Validation**: Format validation and domain verification
- **Mobile Validation**: 10-digit number validation
- **Session Security**: JWT with 512-bit signing key
- **Token Rotation**: Refresh tokens rotated on each use
- **Blacklisting**: Access tokens blacklisted on logout

### Audit and Monitoring
- **Authentication Events**: Log successful/failed logins
- **Password Changes**: Track password reset events
- **OAuth2 Events**: Log Google authentication attempts
- **User Activity**: Track measurement operations per user
- **Error Tracking**: Comprehensive error logging

## API Endpoints

### Authentication Endpoints
```http
POST /api/auth/register          # Local user registration
POST /api/auth/login             # Local user login
POST /api/auth/logout            # Secure logout with token blacklisting
POST /api/auth/refresh           # Refresh access token
POST /api/auth/forgotPassword/{email}  # Request password reset OTP
POST /api/auth/resetPassword/{email}   # Reset password with OTP
GET  /oauth2/authorize/google    # Google OAuth2 authorization
GET  /login/oauth2/code/google   # Google OAuth2 callback
```

### User Management Endpoints
```http
GET  /api/user/me               # Get current user profile
PUT  /api/user/profile          # Update user profile
DELETE /api/user/account        # Delete user account
GET  /api/user/history          # Get user's measurement history
GET  /api/user/statistics       # Get user's usage statistics
```

## Security Implementation

### JWT Token Structure
```json
{
  "sub": "123",                    // User ID
  "jti": "uuid",                   // JWT ID for blacklisting
  "iat": 1640995200,              // Issued at
  "exp": 1640998800,              // Expires at
  "roles": ["ROLE_USER"],         // User roles
  "provider": "google",           // Authentication provider
  "email": "user@example.com"     // User email
}
```

### OAuth2 Configuration
```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: ${GOOGLE_CLIENT_ID}
            client-secret: ${GOOGLE_CLIENT_SECRET}
            scope: email,profile
        provider:
          google:
            user-name-attribute: sub
```

### Password Security
- **BCrypt Hashing**: 12 rounds for secure password storage
- **Strength Validation**: Comprehensive password policy
- **Reset Token**: 6-digit OTP with 15-minute expiry
- **Email Verification**: Track email verification status

## Integration Points

### Frontend Integration
- **OAuth2 Redirect**: Seamless redirect to Google consent screen
- **Token Storage**: Secure JWT storage in HTTP-only cookies or localStorage
- **Session Management**: Automatic token refresh and logout handling
- **Profile Sync**: Synchronize user profile from Google on login

### Email Service Integration
- **Welcome Emails**: Send welcome email after registration
- **Password Reset**: Send OTP via email for password reset
- **Email Templates**: Professional email templates for all communications
- **Async Processing**: Non-blocking email sending

### Monitoring Integration
- **Actuator Endpoints**: Health checks and metrics
- **Logging**: Structured logging for authentication events
- **Error Tracking**: Comprehensive error handling and logging
- **Performance Monitoring**: Track authentication performance

## Postconditions
- Users can authenticate via email/password or Google OAuth2
- Seamless user registration for first-time Google users
- Secure password reset with email OTP
- Complete audit trail of authentication events
- Scalable user management for enterprise use
- All UC1–UC17 functionality preserved with authenticated access

## Key Concepts
- **OAuth2 Authorization Code Flow** with PKCE
- **JWT-based Stateless Authentication**
- **Refresh Token Rotation** for security
- **Email OTP** for password reset
- **User Profile Management** with OAuth2 integration
- **Security Best Practices** (BCrypt, JWT, HTTPS)
- **Audit Trail** for compliance and monitoring
- **Scalable User Management** for enterprise deployment

🔗 _Code Link:_ 
👉 [UC18 – Google Authentication and User Management](https://github.com/Prathamkacher/QuantityMeasurementApp)

---
