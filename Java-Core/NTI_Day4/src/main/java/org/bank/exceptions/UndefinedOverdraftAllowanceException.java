package org.bank.exceptions;

public class UndefinedOverdraftAllowanceException extends RuntimeException {
    public UndefinedOverdraftAllowanceException(String message) {
        super(message);
    }
}
