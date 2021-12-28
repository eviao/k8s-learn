package cn.eviao.k8slearnusercenter;

import com.google.common.collect.Maps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@SpringBootApplication
public class K8sLearnUsercenterApplication {

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
