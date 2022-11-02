package com.project.DisasterRecovery.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateException extends Exception {


    public DuplicateException(String message) {
        super(message);
    }
}


