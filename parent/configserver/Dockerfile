FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/configserver-0.0.1-snapshot.jar /app/configserver-0.0.1-snapshot.jar

# Expose the port the application runs on
EXPOSE 8888

# Define the command to run your application
CMD ["java", "-jar", "configserver-0.0.1-snapshot.jar"]
