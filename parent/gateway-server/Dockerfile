FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/gateway-server-0.0.1-snapshot.jar /app/gateway-server-0.0.1-snapshot.jar

# Expose the port the application runs on
EXPOSE 8075

# Define the command to run your application
CMD ["java", "-jar", "gateway-server-0.0.1-snapshot.jar"]