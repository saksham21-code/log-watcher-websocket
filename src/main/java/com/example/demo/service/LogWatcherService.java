package com.example.demo.service;

import com.example.demo.websocket.LogWebSocketHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;

@Service
public class LogWatcherService {

    private final LogWebSocketHandler logWebSocketHandler;

    public LogWatcherService(LogWebSocketHandler logWebSocketHandler) {
        this.logWebSocketHandler = logWebSocketHandler;
    }

    public void watchLogFile(String logFilePath) throws IOException {
        Path path = Paths.get(logFilePath);
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        new Thread(() -> {
            try {
                WatchKey key;
                while ((key = watchService.take()) != null) {
                    for (WatchEvent<?> event : key.pollEvents()) {
                        if (event.context().toString().equals(path.getFileName().toString())) {
                            // Read the new log content and send to WebSocket clients
                            String logContent = new String(Files.readAllBytes(path));
                            logWebSocketHandler.sendMessageToAll(logContent);
                        }
                    }
                    key.reset();
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
