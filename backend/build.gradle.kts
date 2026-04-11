plugins {
	java
	id("org.springframework.boot") version "3.5.13"
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
	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-security")

	// Spring Boot (test)
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// Spring Boot (dev only)
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// lombok
	compileOnly("org.projectlombok:lombok:1.18.44")
	annotationProcessor("org.projectlombok:lombok:1.18.44")

	// Security
	implementation("io.jsonwebtoken:jjwt-api:0.13.0")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.13.0")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.13.0")

	// other library
	implementation("org.apache.commons:commons-lang3:3.20.0")

	// Spring Boot (DB)
	implementation("org.springframework.boot:spring-boot-starter-jdbc")

	// DB (Driver)
//	implementation("com.mysql:mysql-connector-j:9.6.0")
	runtimeOnly("com.mysql:mysql-connector-j:9.6.0")

	// DB (MyBatis)
	implementation("org.mybatis:mybatis:3.5.19")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.5")
	implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:2.0.0")
//	implementation("org.mybatis.generator:mybatis-generator-core:1.4.2")

	// DB (flyway)
	implementation("org.flywaydb:flyway-core:11.14.1")
	implementation("org.flywaydb:flyway-mysql:11.14.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
//
//flyway {
//	url = "jdbc:mysql://localhost:3306/appdb?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=UTF-8&serverTimezone=Asia/Tokyo"
//	user = "app_user"
//	password = "app_pass"
//	driver = "com.mysql.cj.jdbc.Driver"
//}
