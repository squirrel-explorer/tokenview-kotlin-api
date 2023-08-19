plugins {
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
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
	implementation("com.google.guava:guava:31.1-jre")
	implementation("io.netty:netty-all:4.1.86.Final")
	implementation("org.apache.commons:commons-lang3:3.12.0")
	implementation("commons-codec:commons-codec:1.15")
	implementation("org.slf4j:slf4j-api:2.0.3")
	compileOnly("org.projectlombok:lombok:1.18.24")
	implementation("com.squareup.okhttp3:okhttp:4.10.0")
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("com.squareup.retrofit2:converter-scalars:2.9.0")

	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
}
