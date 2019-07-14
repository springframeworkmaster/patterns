package com.tasks.design.patterns;

import java.io.*;

class Singleton implements Serializable
{

  private static final long serialVersionUID = 5340348721308660058L;
  private Singleton() {
    System.out.println("Sigleton is Instantiating");
  }

  private static final Singleton INSTANCE = new Singleton();

  private int number = 0;

  public int getNumber()
  {
    return number;
  }
  public void setNumber(int number)
  {
    this.number = number;
  }

  public static Singleton getInstance()
  {
    return INSTANCE;
  }
}

public class BasicSingleton
{
  static void saveToFile(Singleton singleton, String filename)
    throws Exception
  {
    try (FileOutputStream fileOut = new FileOutputStream(filename);
         ObjectOutputStream out = new ObjectOutputStream(fileOut))
    {
      out.writeObject(singleton);
    }
  }

  static Singleton readFromFile(String filename)
    throws Exception
  {
    try (FileInputStream fileIn = new FileInputStream(filename);
         ObjectInputStream in = new ObjectInputStream(fileIn) )
    {
      return (Singleton)in.readObject();
    }
  }

  public static void main(String[] args) throws Exception
  {
    Singleton instance1 = Singleton.getInstance();
    instance1.setNumber(111);

    String filename = "singleton.bin";
    saveToFile(instance1, filename);

    instance1.setNumber(222);

    Singleton instance2 = readFromFile(filename);

    System.out.println(instance1 == instance2);

    System.out.println(instance1.getNumber());
    System.out.println(instance2.getNumber());
  }
}