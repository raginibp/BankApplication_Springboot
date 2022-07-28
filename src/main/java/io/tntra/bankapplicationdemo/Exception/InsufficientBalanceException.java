package io.tntra.bankapplicationdemo.Exception;

public class InsufficientBalanceException extends Exception {
  public InsufficientBalanceException(String message) {
    super(message);
  }
}
