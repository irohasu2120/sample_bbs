plugins {
	java
	id("org.springframework.boot") version "4.0.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.github.irohasu2120"
version = "1.0"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	compileOnly("org.projectlombok:lombok:1.18.44")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok:1.18.44")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// DB
	implementation("org.mybatis:mybatis:3.5.19")
	implementation("com.mysql:mysql-connector-j:9.6.0")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:4.0.1")
	implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:2.0.0")
//	implementation("org.mybatis.generator:mybatis-generator-core:1.4.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
//
//tasks.register("mybatisGenerator") {
//	doLast {
//		org.mybatis.generator.api.ShellRunner.main(
//
//		)
//	}
//}