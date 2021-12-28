package cn.eviao.k8slearn.usercenter;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collectors;

public class ParamsBindingException extends RuntimeException {
    private Errors result;

    public ParamsBindingException(Errors result) {
        this.result = result;
    }

    public Map<String, String> getAllMessages() {
        return result.getAllErrors().stream()
                .map(it -> (FieldError)it)
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage
                ));
    }
}
