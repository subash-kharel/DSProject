FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/eureka-server-0.0.1-snapshot.jar /app/eureka-server-0.0.1-snapshot.jar

# Expose the port the application runs on
EXPOSE 8070

# Define the command to run your application
CMD ["java", "-jar", "eureka-server-0.0.1-snapshot.jar"]
