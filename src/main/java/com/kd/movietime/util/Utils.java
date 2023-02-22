package com.kd.movietime.util;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class Utils {

	public static <T> ResponseEntity<T> buildResponseBody(T t) {

		HttpStatusCode statusCode = (t != null) ? HttpStatusCode.valueOf(OK.value())
				: HttpStatusCode.valueOf(NO_CONTENT.value());

		return new ResponseEntity<>(t, statusCode);
	}

}
