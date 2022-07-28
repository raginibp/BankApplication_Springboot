package io.tntra.bankapplicationdemo.Controller;

import io.tntra.bankapplicationdemo.Exception.InsufficientBalanceException;
import io.tntra.bankapplicationdemo.Model.Account;
import io.tntra.bankapplicationdemo.Model.Account_Abst;
import io.tntra.bankapplicationdemo.Services.HDFC_Services;
import io.tntra.bankapplicationdemo.Services.ICICI_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class HDFC_controller  {
  public HDFC_controller(HDFC_Services hdfc_services) {
    this.hdfc_services = hdfc_services;
  }

  // @Autowired
  HDFC_Services hdfc_services;
  @PostMapping("/account_hdfc")
  public ResponseEntity<Object> CreateAccount( @RequestBody Account account){
    hdfc_services.Create_Account(account);
    return new ResponseEntity<>("Account Created Successfully in icici",HttpStatus.CREATED);
  }
@GetMapping("/account_hdfc")
  public ResponseEntity<Object> getAccount(@RequestBody Account account){
    return new ResponseEntity<>(hdfc_services.getAccount(), HttpStatus.OK);
  }
  @GetMapping("/account_hdfc/{owner}")
  public ResponseEntity<Object> getOwner(Account account){
    return new ResponseEntity<>(hdfc_services.get_Owner(account), HttpStatus.OK);
  }
  @GetMapping("/account_hdfc/{owner}/balance")
  public ResponseEntity<Object> getbalance(Account account){
    return new ResponseEntity<>(hdfc_services.get_Balance(account), HttpStatus.OK);
  }
  @PatchMapping("/account_hdfc/{owner}/{amount}/deposit")

  public ResponseEntity<Object> deposit(@PathVariable BigDecimal amount ,@PathVariable  String owner) {
    return new ResponseEntity<>("Deposited amount  is " + hdfc_services.Deposit(owner, amount), HttpStatus.OK);
  }
  @PatchMapping("/account_hdfc/{owner}/{amount}/withdraw")
  public ResponseEntity<Object> withdraw(@PathVariable BigDecimal amount ,@PathVariable  String owner){
    try {
      return new ResponseEntity<>("withdraw amount in "+owner+" is "+ hdfc_services.Withdraw(owner,amount ), HttpStatus.OK);
    } catch (InsufficientBalanceException e) {
      return new ResponseEntity<>("Not sufficient amount", HttpStatus.OK);
    }
  }
}
