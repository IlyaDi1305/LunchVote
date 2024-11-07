package ru.didorenko.lunchvote.common.error;

public class NotFoundException extends AppException {
    public NotFoundException(String msg) {
        super(msg, ErrorType.NOT_FOUND);
    }
}