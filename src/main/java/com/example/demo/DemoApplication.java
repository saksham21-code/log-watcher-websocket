package com.example.demo;

import com.example.demo.service.LogWatcherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final LogWatcherService logWatcherService;

	public DemoApplication(LogWatcherService logWatcherService) {
		this.logWatcherService = logWatcherService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String logFilePath = "src/main/resources/log/logfile.log";
		logWatcherService.watchLogFile(logFilePath);
	}
}
