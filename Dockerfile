FROM openjdk:17-jdk-slim

WORKDIR /app
COPY . .

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/Book_Library-1.0.0.jar"]