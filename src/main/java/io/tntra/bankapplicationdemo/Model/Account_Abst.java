package io.tntra.bankapplicationdemo.Model;

import io.tntra.bankapplicationdemo.Enum.Acc_type;
import io.tntra.bankapplicationdemo.Exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class Account_Abst implements Acc_Inter{
  private  HashMap<String,Account> AccountRepo=new HashMap<>();
  public void Create_Account(Account account){
    AccountRepo.put(account.getOwner(), account);
  }

  public HashMap<String, Account> getAccount() {
    return AccountRepo;
  }
  public Account get_Owner(Account account){
    return AccountRepo.get(account.getOwner());
  }
  public BigDecimal get_Balance(Account account){
    return get_Owner(account).getBalance();
  }
  public BigDecimal Deposit(String owner,BigDecimal Amount){
    Account acc = AccountRepo.get(owner);
    BigDecimal Total_balance;
    Total_balance= acc.getBalance().add(Amount);
    acc.setBalance(Total_balance);
    return Total_balance;
  }
  public BigDecimal Withdraw(String owner,BigDecimal amount) throws InsufficientBalanceException {
    Account account= AccountRepo.get(owner);

      if (checkbalance(owner, amount)) {
        BigDecimal Total_balance;
      Total_balance = account.getBalance().subtract(amount);
      account.setBalance(Total_balance);
      return Total_balance;
      } else {
        throw new InsufficientBalanceException("Insufficient Balance!");
      }
  }
  public boolean checkbalance(String owner,BigDecimal amount){
    Account account= AccountRepo.get(owner);
    if(account.getAcc_type()== Acc_type.CURRENT){
      account.setOverdraftlimit(BigDecimal.valueOf(0.5));
      BigDecimal overdraft = account.getOverdraftlimit().multiply(get_Balance(account));
      BigDecimal Total_balance= account.getBalance().add(overdraft);
      return Total_balance.compareTo(amount)>=0;
    }else{
      return account.getBalance().compareTo(amount)>=0;
    }
  }
}
