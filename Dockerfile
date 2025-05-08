# Use official Maven image with Java 17
FROM maven:3.9.4-eclipse-temurin-17

# Set the working directory inside the container
WORKDIR /app

# Copy only the pom.xml file to leverage Docker cache for dependencies
COPY pom.xml .

# Download project dependencies first to avoid rebuilding on every change
RUN mvn dependency:go-offline

# Copy the rest of the project files
COPY . .

# Ensure that mvn test runs when the container starts
CMD ["mvn", "clean", "test"]
