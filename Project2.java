/*
Name: Collyn Lindley
Course: CNT 4714 Summer 2020
Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking
Due Date: June 14, 2020
*/

public class Project2
{
  private static Account account;

  public static void main(String args[])
  {
    account = new Account();
    account.withdraw(10);
    account.deposit(10);

    System.out.println(account.getBalance());
  }
}
