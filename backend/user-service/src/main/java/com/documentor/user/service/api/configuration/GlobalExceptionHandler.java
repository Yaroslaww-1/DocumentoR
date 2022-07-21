package com.documentor.user.service.api.configuration;

import com.documentor.shared.domain.exceptions.BusinessRuleValidationException;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessRuleValidationException.class)
    protected ResponseEntity<Object> handle(BusinessRuleValidationException exception, WebRequest request) {
        var detail = ProblemDetail.builder()
                .type("https://documentor.com/business-rule-broken-error")
                .title("Business rule broken")
                .status(HttpStatus.CONFLICT.value())
                .detail(exception.getMessage())
                .build();
        return ResponseEntity.status(detail.getStatus())
                .contentType(ProblemDetail.JSON_MEDIA_TYPE)
                .body(detail);
    }

    @Override
    protected @NonNull ResponseEntity<Object> handleExceptionInternal(
            @NonNull Exception exception, Object body, @NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {
        var detail = ProblemDetail.builder()
                .type("https://documentor.com/internal-server-error")
                .title("Internal server error")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .detail(exception.getMessage())
                .build();
        return ResponseEntity.status(detail.getStatus())
                .contentType(ProblemDetail.JSON_MEDIA_TYPE)
                .body(detail);
    }

    @Override
    protected @NonNull ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception, @NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {
        List<String> errors = exception.getAllErrors()
                .stream()
                .map(objectError -> {
                    if (objectError instanceof FieldError) {
                        return ((FieldError) objectError).getField() + " " + objectError.getDefaultMessage();
                    }
                    if (objectError.getDefaultMessage() != null) {
                        return objectError.getDefaultMessage();
                    }
                    return "";
                }).toList();
        var detail = ValidationProblemDetail.builder()
                .type("https://documentor.com/validation-error")
                .title("Validation error")
                .status(HttpStatus.BAD_REQUEST.value())
                .detail(errors.get(0))
                .errors(errors)
                .build();
        return ResponseEntity.status(detail.getStatus())
                .contentType(ProblemDetail.JSON_MEDIA_TYPE)
                .body(detail);
    }
}

@Data
@SuperBuilder
class ProblemDetail {
    public static final MediaType JSON_MEDIA_TYPE =
            MediaType.valueOf("application/problem+json");

    private final String type;
    private final String title;
    private final Integer status;
    private final String detail;
    private final URI instance = URI.create("urn:uuid:" + UUID.randomUUID());
}

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
class ValidationProblemDetail extends ProblemDetail {
    private final List<String> errors;
}
