package com.oglcnkrty.exception.handler;

import com.oglcnkrty.dto.ApiError;
import com.oglcnkrty.dto.ExceptionModel;
import com.oglcnkrty.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError<?>> handleException(BaseException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(createApiError(ex, request));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<?>> MethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        HashMap<String, List<String>> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();

            errors.computeIfAbsent(fieldName, key -> new ArrayList<>()).add(errorMessage);
        });
        return ResponseEntity.badRequest().body(createApiError(errors, request));
    }

    private <E> ApiError<E> createApiError(E message, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        ExceptionModel exception = new ExceptionModel();
        exception.setCreationDate(new Date());
        exception.setMessage(message);
        exception.setPath(request.getDescription(false).substring(4));
        exception.setHostName(getHostName());
        apiError.setException(exception);

        return apiError;
    }

    private String getHostName() {
        try {
            return Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

}
