public class Account
{
  private static final int DEFAULT_BALANCE = 250;
  private static int balance;

  public Account(int balance)
  {
    this.balance = balance;
  }

  public Account()
  {
    this(DEFAULT_BALANCE);
  }

  public static boolean withdraw(int amount)
  {
    if (amount > balance)
    {
      return false;
    }
    else
    {
      balance -= amount;
      return true;
    }
  }

  public static boolean deposit(int amount)
  {
    balance += amount;
    return true;
  }

  public static int getBalance()
  {
    return balance;
  }

}
