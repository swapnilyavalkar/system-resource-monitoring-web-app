# SystemMetrics-Dashboard

SystemMetrics-Dashboard is a real-time system resource monitoring web application that provides live metrics such as CPU usage and memory availability. The application uses Spring Boot and Chart.js to create an interactive dashboard, giving users insight into their host's system health through graphical doughnut charts. This is just a sample web application, I have created for my students.

## Features:
- **Real-time CPU Usage Monitoring**
- **Real-time Memory Usage (Free vs Total) Monitoring**
- **Responsive Web UI for Data Visualization**
- **Doughnut charts to visualize resource usage**
- **System hostname and resource summary**

## How to Use:

### Prerequisites:
- Java 17 or higher
- Maven
- Docker (if deploying via Docker)

### Step-by-Step Deployment:

#### 1. Clone the Repository:
```bash
git clone https://github.com/yourusername/system-resource-monitoring-web-app.git
cd system-resource-monitoring-web-app
```

#### 2. Build the Application:
Make sure you have Java 17 or higher and Maven installed. Run the following Maven command to build the project:

```bash
mvn clean install
```

#### 3. Run the Application:
To run the application using Maven:
```bash
mvn spring-boot:run
```

#### 4. Access the Dashboard:
Once the application is running, open your browser and go to:

```
http://localhost:8080/index.html
```

This will automatically redirect you to the system overview dashboard. The dashboard provides:
- **Hostname**: The system’s hostname.
- **CPU Usage**: The current CPU load percentage.
- **Free Memory**: The available memory out of the total memory.

Additionally, the resource usage is visualized through doughnut charts:
- **CPU Doughnut**: Displays the proportion of CPU used vs available.
- **Memory Doughnut**: Shows the used memory vs free memory.

#### 5. Docker Deployment:

##### Build Docker Image:
```bash
docker build -t system-resource-monitoring-web-app .
```

##### Run the Docker Container:
```bash
docker run -d -p 8080:8080 system-resource-monitoring-web-app
```

You can now access the application at `http://localhost:8080/index.html`.

### Additional Information:

- The application refreshes every 5 seconds, updating the CPU and memory statistics dynamically.
- The data is fetched through a REST API (`/info`) that provides real-time information about the system.

### How to Contribute:
Feel free to fork the repository, make improvements, and open a pull request. Any contribution to improve the application is welcome!
