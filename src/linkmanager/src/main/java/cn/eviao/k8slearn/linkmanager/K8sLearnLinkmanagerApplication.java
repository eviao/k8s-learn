package cn.eviao.k8slearn.linkmanager;

import com.google.common.collect.Maps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOriginPatterns("*")
				.allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
				.maxAge(3600)
				.allowCredentials(true);
	}
}

@ControllerAdvice
class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity handleRuntimeException(RuntimeException e) {
		var body = Maps.newHashMap();
		body.put("errors", e.getMessage());
		return ResponseEntity.internalServerError().body(body);
	}
}

@SpringBootApplication
public class K8sLearnLinkmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sLearnLinkmanagerApplication.class, args);
	}
}
