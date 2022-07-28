package io.tntra.bankapplicationdemo.Model;

import io.tntra.bankapplicationdemo.Exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.HashMap;

public interface Acc_Inter {
void Create_Account(Account account);
  Account get_Owner(Account account);
  HashMap<String, Account> getAccount();
  BigDecimal get_Balance(Account account);
  BigDecimal Deposit(String owner, BigDecimal Amount);
  BigDecimal Withdraw(String owner, BigDecimal amount) throws InsufficientBalanceException;
}
