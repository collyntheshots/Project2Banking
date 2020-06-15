import java.util.Random;

public class Withdraw implements Runnable
{
  private static Random rand = new Random();
  private Buffer sharedLocal;
  private String name;

  public Withdraw(Buffer sharedLocal, String name)
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
        Thread.sleep((rand.nextInt(1000) + 1));
        sharedLocal.withdraw(((rand.nextInt(49)) + 1), this.name);
      }
      catch ( InterruptedException exception )
      {
         exception.printStackTrace();
      }
    }
  }
}
