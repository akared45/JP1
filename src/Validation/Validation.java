package Validation;

public class Validation {
  public static boolean isProductCode(String code) {
    String preg="^(MS|NE|SE)\\d{6}$";
    return code.matches(preg);
  }

  public static boolean isProductName(String name) {
    String preg="^[a-zA-Z ]+$";
    return name.matches(preg);
  }

  public static boolean isCustomerName(String name) {
    String preg="^[a-zA-Z ]{3,50}$";
    return name.matches(preg);
  }

  public static boolean isOrderCode(String code) {
    String preg="^(ORDPM)\\d{8}$";
    return code.matches(preg);
  }

  public static boolean isNumberInteger(String id){
    String preg="^[1-9][0-9]*$";
    return id.matches(preg);
  }
}
