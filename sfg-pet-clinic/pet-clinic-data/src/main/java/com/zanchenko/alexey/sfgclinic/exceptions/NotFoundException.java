package com.zanchenko.alexey.sfgclinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.http.HttpResponse;
//  So we did add in a new
//NotFoundException that just extends the RuntimeException and we are
//annotating that with ResponseStatus. And then in our service implementation,
//we change to throw that exception type and that's what's
//going to kick in the 404 coming back.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super();
    }

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}

// with @ResponseStatus(HttpStatus.NOT_FOUND) we get 404 error
// but without we get 500
//  So we are in
//fact changing that HTTP status code that's coming back to the browser.