import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	application
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
}

group = "io.mikael.poc"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(15))
	}
}

repositories {
	mavenCentral()
	maven {
		url = uri("https://dl.bintray.com/webjars/maven")
	}
	maven {
		url = uri("https://repo.spring.io/milestone")
	}
	jcenter()
}

configurations.all {
	withDependencies {
		this.filter { it.group == "org.webjars.npm" }
			.map { it as ExternalModuleDependency }
			.forEach { it.isTransitive = false }
	}
}

dependencies {
	implementation(enforcedPlatform("org.jetbrains.kotlin:kotlin-bom"))

	implementation("org.springframework.boot:spring-boot-starter-web") {
		exclude(group = "org.springframework.boot", module="spring-boot-starter-tomcat")
		implementation("org.springframework.boot:spring-boot-starter-undertow")
	}

	implementation("org.springframework.fu:spring-fu-kofu:0.4.3")

	implementation("de.mpicbg.scicomp:krangl:0.15")

	implementation("org.webjars:webjars-locator-core:0.46")
	implementation("org.webjars.npm:coreui__coreui:3.4.0")
	implementation("org.webjars.npm:coreui__utils:1.3.1")
	implementation("org.webjars.npm:coreui__icons:2.0.0-rc.0")
	implementation("org.webjars.npm:coreui__chartjs:2.0.0")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("io.pebbletemplates:pebble-spring-boot-starter:3.1.4")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
