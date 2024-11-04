plugins {
    id("java")
    id("jacoco")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

// JavaDoc
tasks.javadoc {
    setDestinationDir(layout.buildDirectory.dir("docs/javadoc").get().asFile)
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

// Jacoco
tasks.jacocoTestReport{
    dependsOn(tasks.test)
    reports {
        html.required.set(true)
        html.outputLocation.set(file("build/reports/jacoco"))
        //html.outputLocation.set(file("build/reports/jacoco/test/html"))
    }
}
/*tasks.check {
    dependsOn(tasks.jacocoTestReport)
}*/

tasks.build {
    dependsOn(tasks.javadoc)
    dependsOn(tasks.jacocoTestReport) // Tests de coverage
}


tasks.jar {
    archiveFileName.set("app.jar")
    manifest {
        attributes["Main-Class"] = "org.example.Main"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}