# Etapa de compilación - Build
FROM gradle:jdk21-alpine AS build

WORKDIR /app

# Copiamos archivos necesarios
COPY build.gradle.kts .
COPY gradlew .
COPY gradle gradle
COPY src src

# RUN ./gradlew build -x test -x jacocoTestReport -x javadoc // Si queremos evitar alguna tarea concreta
RUN ./gradlew build

# Etapa de ejecución. Utiliza la etapa anterior, copia en el contenedor que finalmente se
# ejecuta con run
# FROM openjdk:21-jdk AS run
FROM eclipse-temurin:21-jre-alpine AS run

WORKDIR /app

# Copiamos los archivos que nos interesan de la etapa de compilación para que estén disponibles
# en el contenedor de ejecución
COPY --from=build /app/build/libs/*.jar /app/app-run.jar
# Documentación javadoc
COPY --from=build /app/build/docs/javadoc /app/documentation
# Informes de test
COPY --from=build /app/build/reports/tests/test /app/reports/tests
# Informes de coverage de Jacoco
COPY --from=build /app/build/reports/jacoco /app/reports/coverage

# Ejecutamos el jar
ENTRYPOINT ["java","-jar","app-run.jar"]
