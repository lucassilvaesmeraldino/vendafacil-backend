package br.com.wmw.vendafacil_backend.core.configs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.wmw.vendafacil_backend.core.exceptions.NotFoundException;
import br.com.wmw.vendafacil_backend.core.exceptions.ValidationException;
import br.com.wmw.vendafacil_backend.core.response.CustomFieldError;
import br.com.wmw.vendafacil_backend.core.response.ValidationError;

@ControllerAdvice
public class PedidoExceptionHandlers {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<Object> handleUserMethodFieldErrors(final MethodArgumentNotValidException me,
			final WebRequest request) {
		final List<FieldError> fieldErrors = me.getBindingResult().getFieldErrors();

		final List<CustomFieldError> customFieldErrors = new ArrayList<>();

		for (final FieldError fieldError : fieldErrors) {

			final String field = fieldError.getField();

			final String message = fieldError.getDefaultMessage();

			final CustomFieldError customFieldError = CustomFieldError.builder().field(field).message(message).build();

			customFieldErrors.add(customFieldError);

		}

		return ResponseEntity.badRequest().body(customFieldErrors);

	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleUserMethodFieldErrors(final NotFoundException ve,
			final WebRequest request) {

		final ValidationError valitionError = ValidationError.builder().message(ve.getMessage()).build();

		return ResponseEntity.badRequest().body(valitionError);

	}

	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<Object> handleUserMethodFieldErrors(final ValidationException ve,
			final WebRequest request) {

		final ValidationError valitionError = ValidationError.builder().message(ve.getMessage()).build();

		return ResponseEntity.badRequest().body(valitionError);

	}
}
