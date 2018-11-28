package com.bage.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exceptionhandler")
public class ExceptionHandlerController {

        // @RequestMapping methods omitted ...
		// The @ExceptionHandler value can be set to an array of Exception types.
        @ExceptionHandler(IOException.class)
        public ResponseEntity<String> handleIOException(IOException ex) {
                ResponseEntity<String> responseEntity = new ResponseEntity<String>("ex", null);
				// prepare responseEntity
                System.out.println("IOException...");
                return responseEntity ;
        }

}
