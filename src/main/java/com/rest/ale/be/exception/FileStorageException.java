package com.rest.ale.be.exception;

import java.io.IOException;

public class FileStorageException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;

    public FileStorageException(String msg) {
        this.msg = msg;

    }

    public FileStorageException(String msg, Throwable cause) {
        super(msg,cause);
    }

    public String getMsg() {
        return msg;
    }
}
