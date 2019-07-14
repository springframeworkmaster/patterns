package com.tasks.design.patterns;

class Person
{
  public String name;

  public String position;

  @Override
  public String toString()
  {
    return "Person{" +
      "name='" + name + '\'' +
      ", position='" + position + '\'' +
      '}';
  }
}

class PersonBuilder<SELF extends PersonBuilder<SELF>>
{
  protected Person person = new Person();

  public SELF withName(String name)
  {
    person.name = name;
    return self();
  }

  protected SELF self()
  {
    return (SELF) this;
  }

  public Person build()
  {
    return person;
  }
}

class EmployeeBuilder
  extends PersonBuilder<EmployeeBuilder>
{
  public EmployeeBuilder worksAs(String position)
  {
    person.position = position;
    return self();
  }

  @Override
  protected EmployeeBuilder self()
  {
    return this;
  }
}

public class FluentBuilderWithRecursiveGenerics
{
  public static void main(String[] args)
  {
    EmployeeBuilder eb = new EmployeeBuilder()
      .withName("Krish")
      .worksAs("Software Engineer");
    System.out.println(eb.build());
  }
}