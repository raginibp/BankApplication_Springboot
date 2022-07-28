package io.tntra.bankapplicationdemo.Controller;

import io.tntra.bankapplicationdemo.Exception.InsufficientBalanceException;
import io.tntra.bankapplicationdemo.Model.Account;
import io.tntra.bankapplicationdemo.Services.ICICI_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class ICICI_controller {
  public ICICI_controller(ICICI_Services icici_services) {
    this.icici_services = icici_services;
  }

  // @Autowired
ICICI_Services icici_services;
  @PostMapping("/account_icici")
  public ResponseEntity<Object> CreateAccount( @RequestBody Account account){
    icici_services.Create_Account(account);
    return new ResponseEntity<>("Account Created Successfully in icici",HttpStatus.CREATED);
  }
  @GetMapping("/account_icici")
  public ResponseEntity<Object> getAccount(@RequestBody Account account){
   return new ResponseEntity<>(icici_services.getAccount(), HttpStatus.OK);
  }
  @GetMapping("/account_icici/{owner}")
 public ResponseEntity<Object> getOwner(Account account){
   return new ResponseEntity<>(icici_services.get_Owner(account), HttpStatus.OK);
  }
  @GetMapping("/account_icici/{owner}/balance")
  public ResponseEntity<Object> getbalance(Account account){
    return new ResponseEntity<>(icici_services.get_Balance(account), HttpStatus.OK);
  }
 @PatchMapping("/account_icici/{owner}/{amount}/deposit")

  public ResponseEntity<Object> deposit(@PathVariable BigDecimal amount ,@PathVariable  String owner) {
   return new ResponseEntity<>("Deposited amount  is " + icici_services.Deposit(owner, amount), HttpStatus.OK);
 }
 @PatchMapping("/account_icici/{owner}/{amount}/withdraw")
  public ResponseEntity<Object> withdraw(@PathVariable BigDecimal amount ,@PathVariable  String owner){
    try {
      return new ResponseEntity<>("withdraw amount in "+owner+" is "+ icici_services.Withdraw(owner,amount ), HttpStatus.OK);
    } catch (InsufficientBalanceException e) {
      return new ResponseEntity<>("Not sufficient amount", HttpStatus.OK);
    }
  }
}
