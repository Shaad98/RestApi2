FROM maven:3.9.11-eclipse-temurin-25
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
CMD ["java","-jar","target/myapp.jar"]