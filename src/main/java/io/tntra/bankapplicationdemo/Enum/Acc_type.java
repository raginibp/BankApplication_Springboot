package io.tntra.bankapplicationdemo.Enum;

 public enum Acc_type {
  SAVING("Saving"),
  CURRENT("Current Account"),
  FIXED_DEPOSIT("Fixed Deposit");
  public final String values;

   Acc_type(String values) {
    this.values = values;
  }
  public String getValues() {
   return this.values;
  }
  public static Acc_type create(String value){
   Acc_type accountTypes[] = Acc_type.values();
   for(Acc_type type:accountTypes){
    if(type.getValues().equalsIgnoreCase(value)){
     return type;
    }
   }
   return CURRENT;
  }
 }
