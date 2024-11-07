package ru.didorenko.lunchvote.common.error;

import static ru.didorenko.lunchvote.common.error.ErrorType.BAD_REQUEST;

public class IllegalRequestDataException extends AppException {
    public IllegalRequestDataException(String msg) {
        super(msg, BAD_REQUEST);
    }
}