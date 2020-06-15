import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Account implements Buffer
{
  private Lock accessLock = new ReentrantLock();

  private Condition canDeposit = accessLock.newCondition();
  private Condition canWithdraw = accessLock.newCondition();

  private static int balance = 0;

  public void deposit(int deposit, String tName)
  {

    try
    {
      accessLock.lock();
      balance += deposit;
      System.out.println("Thread " + tName + " deposits $" + deposit + "\t\t\t\t\t\t   (+) Balance is $" + balance);
      canWithdraw.signal();
      canDeposit.await();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    finally
    {
      accessLock.unlock();
    }
  }

  public void withdraw(int withdraw, String tName)
  {
    try
    {
      accessLock.lock();
      if (this.balance < withdraw)
      {
        System.out.println("\t\t\t\t\tThread " + tName + " withdraws $" + withdraw + "\t   (***) Withdraw - Blocked - Insufficient Funds!!!");
        canDeposit.signal();
      }
      else
      {
        this.balance -= withdraw;
        System.out.println("\t\t\t\t\tThread " + tName + " withdraws $" + withdraw + "\t   (-) Balance is $" + balance);
        canWithdraw.await();
        canDeposit.signal();
      }
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    finally
    {
      accessLock.unlock();
    }
  }
}
