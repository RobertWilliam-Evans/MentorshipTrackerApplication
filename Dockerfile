# Build stage
FROM openjdk:17-alpine AS build

WORKDIR /app

# Copy the Gradle Wrapper script and the Gradle build files and settings
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Make the Gradle Wrapper script executable
RUN chmod +x gradlew


# Build the project using the Gradle Wrapper script
RUN ./gradlew build -x test

# Runtime stage
FROM openjdk:17-alpine

WORKDIR /app

# Copy the JAR file from the build stage into the runtime stage
COPY --from=build /app/build/libs/MentorshipTrackerApplication-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application will listen on (default is 8080)
EXPOSE 8081

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]

