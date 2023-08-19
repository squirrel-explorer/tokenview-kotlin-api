plugins {
	application
	kotlin("jvm")
}

group = "io.mokuan"
version = "0.1.0-SNAPSHOT"

sourceSets {
	getByName("main").java.srcDirs("src/main/kotlin")
	getByName("test").java.srcDirs("src/test/kotlin")
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(project(":tokenview-api"))

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
	implementation("com.squareup.okhttp3:okhttp:4.10.0")
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
}

application {
	mainClass.set("io.mokuan.tokenview.runner.Main")
}
