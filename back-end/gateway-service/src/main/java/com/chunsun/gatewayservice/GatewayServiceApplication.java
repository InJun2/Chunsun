package com.chunsun.gatewayservice;

import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class GatewayServiceApplication implements ApplicationListener<ApplicationReadyEvent> {
	private final Environment environment;

	public static void main(String[] args) {
		init();
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info("applicationReady status{}", Arrays.toString(environment.getActiveProfiles()));
	}

	private static void init() {
		log.info("Spring Server TimeZone : Asia/Seoul");
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}
}
