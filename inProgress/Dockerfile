# Use a JDK base image to have Java and Maven available
FROM maven AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project directory into the container
COPY . .

# Compile the project
RUN mvn clean package

# Start a new stage to create a lightweight image
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Specify the command to run the application
CMD ["java", "-jar", "app.jar"]