import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("org.asciidoctor.jvm.convert") version "3.1.0" // rest docs
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "me.practice"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

val asciidoctorExt by configurations.creating // rest docs

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
        exclude(module = "mockito-core")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.ninja-squad:springmockk:3.0.1")

    // rest docs
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    asciidoctorExt("org.springframework.restdocs:spring-restdocs-asciidoctor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

//    asciidoctor("org.springframework.restdocs:spring-restdocs-asciidoctor")
}

// rest docs
val snippetsDir by extra {
    file("build/generated-snippets")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

// rest docs
tasks {
    asciidoctor {
        dependsOn(test)
        configurations("asciidoctorExt")
        baseDirFollowsSourceFile()  // 3
        inputs.dir(snippetsDir)
    }
    register<Copy>("copyDocument") {  // 4
        dependsOn(asciidoctor)
        from(file("build/docs/asciidoc/index.html"))
        into(file("src/main/resources/static/docs"))
    }
    bootJar {
        dependsOn("copyDocument")  // 5
    }
}


tasks.withType<Test> {
    useJUnitPlatform()
}
