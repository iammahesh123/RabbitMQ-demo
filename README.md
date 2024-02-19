# EventDrivenDemo

EventDrivenDemo is a Spring Boot application that demonstrates event-driven architecture using RabbitMQ as a message broker. It includes components for producing and consuming messages, as well as custom message conversion.

# Requirements
- Java 8 or higher
- Maven
- RabbitMQ (Make sure RabbitMQ is installed and running locally or on a reachable server)
# Setup
### Step 1: Clone the Project

1. Open a terminal on your computer.

2. Clone the project repository by running the following command:
   ```bash
   git clone [<repository-url>](https://github.com/iammahesh123/RabbitMQ-demo.git)
   cd EventDrivenDemo

### Step 2: Run Eureka Server

1. Start the Eureka Server using the following command::
   ```bash
   cd EventDrivenDemo
   mvn clean install
2. Run the application using below command:
   ```bash
   mvn spring-boot:run
3.Open your web browser and visit http://localhost:8081 to access the Application.

## Configuration
RabbitMQ connection properties can be configured in the application.properties file.
Usage
## Producer
The producer component (RegisterPublisher) sends messages of type CourseDTO to a RabbitMQ topic exchange.
Modify the CourseDTO class or RegisterPublisher component to customize the message payload.
## Consumer
The consumer component (CourseAdmin) listens to messages from the RabbitMQ queue and processes them.
Implement custom logic in the CourseAdmin component to handle received messages.
## Custom Message Conversion
The CustomMessageConverter class provides custom message conversion logic for serializing CourseDTO objects to JSON format before sending them to RabbitMQ and deserializing JSON messages back to CourseDTO objects.
Customize the message converter as needed for other payload types or formats.
## Troubleshooting
If you encounter any issues, ensure that RabbitMQ is running and accessible from the application.
Check the application logs for any error messages or exceptions.
## Contributing
Contributions are welcome! If you find any bugs or have suggestions for improvements, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

