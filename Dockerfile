# Use an official OpenJDK runtime as a parent image
FROM maven:3.8-openjdk-17

# Set the working directory in the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Run the Maven build command
RUN mvn clean package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Define the command to run your app
ENTRYPOINT ["java", "-jar", "target/email-writer-sb-0.0.1-SNAPSHOT.jar"]