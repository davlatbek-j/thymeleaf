# =========================
# 1️⃣ BUILD STAGE
# =========================
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /build

# dependency cache uchun avval pom.xml ni copy qilamiz
COPY pom.xml .

RUN mvn dependency:go-offline

# endi source ni copy qilamiz
COPY src ./src

# jar build qilamiz
RUN mvn clean package -DskipTests


# =========================
# 2️⃣ RUNTIME STAGE
# =========================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /thymeleaf

RUN mkdir photo-uploads

# builder stage dan jar ni olib kelamiz
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 1984

ENTRYPOINT ["java", "-jar", "app.jar"]
#ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]