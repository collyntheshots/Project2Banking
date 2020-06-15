import java.util.Random;

public class Deposit implements Runnable
{
  private static Random rand = new Random();
  private Buffer sharedLocal;
  private String name;

  public Deposit(Buffer sharedLocal, String name)
  {
    this.name = name;
    this.sharedLocal = sharedLocal;
  }

  public void run()
  {
    while (true)
    {
      try
      {
        Thread.sleep((rand.nextInt(1000)) + 1);
        sharedLocal.deposit(((rand.nextInt(249)) + 1), this.name);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
