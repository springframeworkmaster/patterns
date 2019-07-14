package com.tasks.design.patterns;

interface Shapee
{
  String info();
}

class Circlee implements Shapee
{
  private float radius;

  Circlee(){}

  public Circlee(float radius)
  {
    this.radius = radius;
  }

  void resize(float factor)
  {
    radius *= factor;
  }

  @Override
  public String info()
  {
    return "A circle of radius " + radius;
  }
}

class Squaree implements Shapee
{
  private float side;

  public Squaree()
  {
  }

  public Squaree(float side)
  {
    this.side = side;
  }

  @Override
  public String info()
  {
    return "A square with side " + side;
  }
}

class ColoredShape implements Shapee
{
  private Shapee shape;
  private String color;

  public ColoredShape(Shapee shape, String color)
  {
    this.shape = shape;
    this.color = color;
  }

  @Override
  public String info()
  {
    return shape.info() + " has the color " + color;
  }
}

class TransparentShape implements Shapee
{
  private Shapee shape;
  private int transparency;

  public TransparentShape(ColoredShape coloredShape, int transparency)
  {
    this.shape = coloredShape;
    this.transparency = transparency;
  }

  @Override
  public String info()
  {
    return shape.info() + " has " + transparency + "% transparency";
  }
}

public class DynamicDecoratorPattern
{
  public static void main(String[] args)
  {
    Circlee circle = new Circlee(10);
    System.out.println(circle.info());

    ColoredShape blueSquare = new ColoredShape(new Squaree(20), "blue");
    System.out.println(blueSquare.info());

    TransparentShape myCircle = new TransparentShape(new ColoredShape(new Circlee(5), "green"), 50);
    System.out.println(myCircle.info());
  }
}
