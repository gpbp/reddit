package com.trung.reddit.exceptions;

import org.springframework.mail.MailException;

public class SpringRedditException extends RuntimeException {
    public SpringRedditException(String message) {
        super(message);
    }
}
