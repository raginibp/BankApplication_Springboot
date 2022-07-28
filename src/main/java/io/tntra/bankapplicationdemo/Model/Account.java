package io.tntra.bankapplicationdemo.Model;
import io.tntra.bankapplicationdemo.Enum.Acc_type;

import java.math.BigDecimal;
import java.util.HashMap;

public class Account{
  private String owner;
  private BigDecimal balance;

  private Acc_type acc_type;

  private BigDecimal minbalance=BigDecimal.valueOf(0);
private BigDecimal Overdraftlimit=BigDecimal.valueOf(0);
  public Account() {
    this.owner = owner;
    this.balance = balance;
    this.Overdraftlimit=Overdraftlimit;
    this.minbalance=minbalance;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public  BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
  public BigDecimal getMinbalance() {
    return minbalance;
  }

  public void setMinbalance(BigDecimal minbalance) {
    this.minbalance = minbalance;
  }

  public BigDecimal getOverdraftlimit() {
    return Overdraftlimit;
  }

  public void setOverdraftlimit(BigDecimal overdraftlimit) {
    Overdraftlimit = overdraftlimit;
  }
  public Acc_type getAcc_type() {
    return acc_type;
  }

  public void setAcc_type(String type) {
    this.acc_type =Acc_type.create(type);
  }

}

