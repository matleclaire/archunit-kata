package codekata.archunit.layered_architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "codekata.archunit.layered_architecture")
class LayeredArchitectureTests {

    //FIXME
    @ArchTest
    static final ArchRule api_layer_should_not_depend_on_repository_layer = classes()
            .that().resideInAPackage("..api..")
            .should().dependOnClassesThat()
            .resideInAPackage("..repository..");


    //TODO
    // - Add rule to check that the service layer should only be accessed by the API layer or itself
    // - Add rule to check that the controller layer returns only DTOs or void


}
