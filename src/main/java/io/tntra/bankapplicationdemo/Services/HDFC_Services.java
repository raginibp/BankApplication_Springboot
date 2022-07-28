package io.tntra.bankapplicationdemo.Services;
import io.tntra.bankapplicationdemo.Exception.InsufficientBalanceException;
import io.tntra.bankapplicationdemo.Model.Acc_Inter;
import io.tntra.bankapplicationdemo.Model.Account;
import io.tntra.bankapplicationdemo.Model.Account_Abst;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class HDFC_Services extends Account_Abst implements Acc_Inter {
  @Override
  public void Create_Account(Account account) {
    super.Create_Account(account);
  }

  @Override
  public Account get_Owner(Account account) {
    return super.get_Owner(account);
  }

  @Override
  public HashMap<String, Account> getAccount() {
    return super.getAccount();
  }

  @Override
  public BigDecimal get_Balance(Account account) {
    return super.get_Balance(account);
  }

  @Override
  public BigDecimal Deposit(String owner, BigDecimal Amount) {
    return super.Deposit(owner, Amount);
  }

  @Override
  public BigDecimal Withdraw(String owner, BigDecimal amount) throws InsufficientBalanceException {

    try {
      return super.Withdraw(owner, amount);
    } catch (InsufficientBalanceException e) {
      e.getMessage();
      throw new InsufficientBalanceException("Insufficient Balance!");
    }
  }
}
