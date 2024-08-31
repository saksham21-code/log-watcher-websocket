# Log Watcher WebSocket Application

This project is a Spring Boot-based application designed to perform real-time log monitoring and stream updates to connected clients using WebSocket technology. It is architected to efficiently watch a log file, detect changes, and broadcast the updates to any subscribed WebSocket clients.

## Architecture Overview
- **Spring Boot:** Serves as the backbone of the application, managing dependencies, configuration, and the embedded web server (Tomcat) for seamless execution.
- **WebSocket:** Implements full-duplex communication between the server and clients, enabling real-time log updates without the overhead of HTTP polling.
- **Java NIO (Non-blocking I/O):** Leverages the WatchService API for efficient, event-driven file monitoring, allowing the application to respond asynchronously to file changes.

## How to Run
1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/log-watcher-websocket.git
   cd log-watcher-websocket


## How to Run
1. Clone the repository.
2. Build the project using Maven.
3. Run the application.
4. Access the real-time log updates in your browser.

## Features
- Real-time log monitoring.
- WebSocket-based communication.
- Simple front-end for displaying logs.
