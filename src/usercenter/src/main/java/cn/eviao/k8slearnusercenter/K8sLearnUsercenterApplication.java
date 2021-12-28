package cn.eviao.k8slearnusercenter;

import com.google.common.collect.Maps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@SpringBootApplication
public class K8sLearnUsercenterApplication {

	@GetMapping("/hello")
	public String hello() {
		return "hello, world!";
	}

	@ExceptionHandler(ParamsBindingException.class)
	public ResponseEntity handleParamBindException(ParamsBindingException e) {
		var body = Maps.newHashMap();
		body.put("errors", e.getAllMessages());
		return ResponseEntity.internalServerError().body(body);
	}

	public static void main(String[] args) {
		SpringApplication.run(K8sLearnUsercenterApplication.class, args);
	}

}
