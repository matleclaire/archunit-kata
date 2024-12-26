# Layered Architecture Solution

## [LayeredArchitectureTests.java](../../archunit-kata/src/test/java/codekata/archunit/layered_architecture/LayeredArchitectureTests.java)

### Services should only be accessed by API

```java
@ArchTest
static final ArchRule api_layer_should_not_depend_on_repository_layer = noClasses()  // <-- use predicate noClasses() 
        .that().resideInAPackage("..api..")
        .should().dependOnClassesThat()
        .resideInAPackage("..repository..");

```
### The service layer should only be accessed by the API layer or itself

```java
@ArchTest
static final ArchRule service_layer_should_only_be_accessed_by_api_layer_or_itself = classes()
            .that().resideInAPackage("..service..")
            .should().onlyBeAccessed().byAnyPackage("..api..", "..service..");
```


### Controllers expose only DTO or void

> **Tips:**  `void.class` is the return type of a method that returns nothing

```java
@ArchTest
static final ArchRule controller_layer_should_return_only_dtos_or_void = methods()
        .that().areDeclaredInClassesThat().resideInAPackage("..api..")
        .and().arePublic()
        .should().haveRawReturnType(JavaClass.Predicates.resideInAPackage("..dto.."))
        .orShould().haveRawReturnType(void.class);

```

### Bonus - Enforce layer architecture 

> **Tips:**  ArchUnit offers to enforce typical architectures like onion or layered.
> See https://www.archunit.org/userguide/html/000_Index.html#_architectures

```java
@ArchTest
static final ArchRule enforce_layered_architecture = Architectures.layeredArchitecture()
        .consideringAllDependencies()
        .layer("Api").definedBy("..api..")
        .layer("Service").definedBy("..service..")
        .layer("Repository").definedBy("..repository..")

        .whereLayer("Api").mayNotBeAccessedByAnyLayer()
        .whereLayer("Service").mayOnlyBeAccessedByLayers("Api")
        .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");
```

## [CodingRulesTests.java](../../archunit-kata/src/test/java/codekata/archunit/layered_architecture/CodingRulesTests.java)

### Loggers should be `private static final`

```java
@ArchTest
static final ArchRule loggers_should_be_private_static_final = fields()
        .that().haveRawType(org.slf4j.Logger.class)
        .should().bePrivate()
        .andShould().beStatic()
        .andShould().beFinal()
        .because("we agreed on this convention");
```
### No `java.util.logging`

> **Tips:**  ArchUnit already offers a set of very general rules and conditions for coding.

```java
 @ArchTest
static final ArchRule no_class_should_use_java_util_logging = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
```

### No  class throws generic exceptions

```java
@ArchTest
static final ArchRule no_class_should_throw_generic_exceptions = GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
```

## [NamingConventionTests.java](../../archunit-kata/src/test/java/codekata/archunit/layered_architecture/NamingConventionTests.java)

### Services should be suffixed by Service

```java
 @ArchTest
static final ArchRule service_classes_should_be_suffixed_by_service =   classes()
        .that().resideInAPackage("..service..")
        .should().haveSimpleNameEndingWith("Service");
```

### Controllers should be in package api

```java
 @ArchTest
static final ArchRule classes_named_controller_should_be_in_api_package = classes()
        .that().haveSimpleNameContaining("Controller")
        .should().resideInAPackage("..api..");
```
