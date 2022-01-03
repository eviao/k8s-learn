package cn.eviao.k8slearn.usercenter;

import com.google.common.collect.Maps;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException e) {
        var body = Maps.newHashMap();
        body.put("errors", e.getMessage());
        return ResponseEntity.internalServerError().body(body);
    }
}
