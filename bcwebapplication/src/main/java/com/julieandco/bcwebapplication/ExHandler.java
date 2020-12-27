package com.julieandco.bcwebapplication;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExHandler {

    /** Provides handling for exceptions throughout this service. */
    @ExceptionHandler({ HttpClientErrorException.Forbidden.class })
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof HttpClientErrorException.Forbidden) {
            HttpStatus status = HttpStatus.FORBIDDEN;
            System.out.println("FORBIDDEN TRIGGERED");
            HttpClientErrorException.Forbidden cnae = (HttpClientErrorException.Forbidden) ex;

            return handleContentForbiddenException(cnae, headers, status, request);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, headers, status, request);
        }
    }

    @ExceptionHandler({ NoSuchElementException.class })
    public final ModelAndView handleExceptionNoEl(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof NoSuchElementException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            System.out.println("NOT FOUND TRIGGERED");
            NoSuchElementException cnae = (NoSuchElementException) ex;

            ResponseEntity<ApiError> er= handleContentNoElException(cnae, headers, status, request);
            System.out.println("error: "+er.toString());
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            ResponseEntity<ApiError> er = handleExceptionInternal(ex, null, headers, status, request);
            System.out.println("error: "+er.toString());

        }
        return new ModelAndView("nosuchelement");
    }


    /** Customize the response for ContentNotAllowedException. */
    protected ResponseEntity<ApiError> handleContentForbiddenException(HttpClientErrorException.Forbidden ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        System.out.println("MESSAGE FORBID");
        return handleExceptionInternal(ex, new ApiError(errors), headers, status, request);
    }

    protected ResponseEntity<ApiError> handleContentNoElException(NoSuchElementException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        System.out.println("MESSAGE NO SUCH ELEMENT");
        return handleExceptionInternal(ex, new ApiError(errors), headers, status, request);
    }


    /** A single place to customize the response body of all Exception types. */
    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }
}