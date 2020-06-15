/*
Name: Collyn Lindley
Course: CNT 4714 Summer 2020
Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking
Due Date: June 14, 2020
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Project2
{
  public static void main(String args[])
  {
    ExecutorService app = Executors.newFixedThreadPool(14);

    Buffer sharedLocal = new Account();

    System.out.printf( "%-40s%s\t%s\n%-40s%s\n\n", "Deposit Threads",
      "Withdraw Threads", "      Balanace", "---------------", "----------------\t   --------------" );

    try
    {
      app.execute(new Deposit(sharedLocal, "D1"));
      app.execute(new Deposit(sharedLocal, "D2"));
      app.execute(new Deposit(sharedLocal, "D3"));
      app.execute(new Deposit(sharedLocal, "D4"));
      app.execute(new Deposit(sharedLocal, "D5"));
      app.execute(new Withdraw(sharedLocal, "W1"));
      app.execute(new Withdraw(sharedLocal, "W2"));
      app.execute(new Withdraw(sharedLocal, "W3"));
      app.execute(new Withdraw(sharedLocal, "W4"));
      app.execute(new Withdraw(sharedLocal, "W5"));
      app.execute(new Withdraw(sharedLocal, "W6"));
      app.execute(new Withdraw(sharedLocal, "W7"));
      app.execute(new Withdraw(sharedLocal, "W8"));
      app.execute(new Withdraw(sharedLocal, "W9"));
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    app.shutdown();
  }
}
