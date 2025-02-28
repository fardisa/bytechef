group = "com.bytechef.connection"
description = ""

springBoot {
    mainClass.set("com.bytechef.connection.ConnectionApplication")
}

dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation(libs.org.openapitools.jackson.databind.nullable)
    implementation(libs.org.springdoc.springdoc.openapi.starter.common)
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.retry:spring-retry")
    implementation(project(":server:libs:automation:automation-connection:automation-connection-rest"))
    implementation(project(":server:libs:automation:automation-swagger"))
    implementation(project(":server:libs:core:async-config"))
    implementation(project(":server:libs:core:commons:commons-data"))
    implementation(project(":server:libs:core:encryption:encryption-filesystem"))
    implementation(project(":server:libs:core:encryption:encryption-impl"))
    implementation(project(":server:libs:core:environment-config"))
    implementation(project(":server:libs:core:jackson-config"))
    implementation(project(":server:libs:core:jdbc-config"))
    implementation(project(":server:libs:core:liquibase-config"))
    implementation(project(":server:libs:core:rest:rest-impl"))
    implementation(project(":server:libs:core:tag:tag-service"))
    implementation(project(":server:libs:platform:platform-connection:platform-connection-service"))
    implementation(project(":server:libs:platform:platform-oauth2:platform-oauth2-service"))
    implementation(project(":server:libs:platform:platform-connection:platform-connection-rest:platform-connection-rest-impl"))
    implementation(project(":server:libs:platform:platform-swagger"))

    implementation(project(":ee:server:libs:automation:automation-configuration:automation-configuration-remote-client"))
    implementation(project(":ee:server:libs:core:discovery:discovery-redis"))
    implementation(project(":ee:server:libs:embedded:embedded-configuration:embedded-configuration-remote-client"))
    implementation(project(":ee:server:libs:platform:platform-component:platform-component-registry:platform-component-registry-remote-client"))
    implementation(project(":ee:server:libs:platform:platform-configuration:platform-configuration-remote-client"))
    implementation(project(":ee:server:libs:platform:platform-connection:platform-connection-remote-rest"))

    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("com.zaxxer:HikariCP")
    runtimeOnly(libs.org.springdoc.springdoc.openapi.starter.webmvc.ui)
    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("org.springframework.boot:spring-boot-starter-aop")
    runtimeOnly("org.springframework.boot:spring-boot-starter-data-redis")

    testImplementation(project(":server:libs:test:test-int-support"))
}
