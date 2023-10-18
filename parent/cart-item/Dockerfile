FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/cart-item-0.0.1-snapshot.jar /app/cart-item-0.0.1-snapshot.jar

# Expose the port the application runs on
EXPOSE 8082

# Define the command to run your application
CMD ["java", "-jar", "cart-item-0.0.1-snapshot.jar"]