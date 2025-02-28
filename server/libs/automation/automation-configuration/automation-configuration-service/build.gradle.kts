dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation("org.apache.commons:commons-lang3")
    implementation("org.springframework:spring-context")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.springframework.data:spring-data-jdbc")
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-repository:atlas-configuration-repository-api"))
    implementation(project(":server:libs:core:commons:commons-data"))
    implementation(project(":server:libs:core:commons:commons-util"))
    implementation(project(":server:libs:automation:automation-configuration:automation-configuration-api"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-execution:platform-workflow-execution-api"))

    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    testImplementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-repository:atlas-configuration-repository-jdbc"))
    testImplementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-service"))
    testImplementation(project(":server:libs:core:category:category-service"))
    testImplementation(project(":server:libs:core:tag:tag-service"))
    testImplementation(project(":server:libs:platform:platform-component:platform-component-registry:platform-component-registry-service"))
    testImplementation(project(":server:libs:platform:platform-configuration:platform-configuration-service"))
    testImplementation(project(":server:libs:platform:platform-connection:platform-connection-api"))
    testImplementation(project(":server:libs:core:liquibase-config"))
    testImplementation(project(":server:libs:test:test-int-support"))
}
