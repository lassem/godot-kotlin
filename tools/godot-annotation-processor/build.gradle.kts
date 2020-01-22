plugins {
    id("org.jetbrains.kotlin.jvm")
    id("maven")
    id("kotlin-kapt")
}

group = "org.godotengine.kotlin"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenLocal()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":tools:annotations"))
    implementation("de.jensklingenberg:mpapt-runtime:0.8.4-SNAPSHOT") //TODO: bump
    implementation("com.squareup:kotlinpoet:1.5.0")

    compileOnly("org.jetbrains.kotlin:kotlin-compiler-embeddable")
    compileOnly("com.google.auto.service:auto-service:1.0-rc6")
    kapt("com.google.auto.service:auto-service:1.0-rc6")
}

kapt {
    includeCompileClasspath = true
}

tasks.build {
    finalizedBy(tasks.install)
}