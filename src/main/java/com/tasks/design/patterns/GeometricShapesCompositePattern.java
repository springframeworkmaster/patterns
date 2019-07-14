package com.tasks.design.patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GraphicObject
{
  protected String name = "Group";

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public GraphicObject()
  {
  }

  public String color;
  public List<GraphicObject> children = new ArrayList<>();

  private void print(StringBuilder stringBuilder,  int depth)
  {
    stringBuilder.append(String.join("", Collections.nCopies(depth, "*")))
      .append(depth > 0 ? " " : "")
      .append((color == null || color.isEmpty()) ? "" : color + " ")
      .append(getName())
      .append(System.lineSeparator());
    for (GraphicObject child : children)
      child.print(stringBuilder,  depth+1);
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    print(sb, 0);
    return sb.toString();
  }
}

class Circles extends GraphicObject
{
  public Circles(String color)
  {
    name = "Circle";
    this.color = color;
  }
}

class Square extends GraphicObject
{
  public Square(String color)
  {
    name = "Square";
    this.color = color;
  }
}

public class GeometricShapesCompositePattern
{
  public static void main(String[] args)
  {
    GraphicObject drawing = new GraphicObject();
    drawing.setName("My Drawing");
    drawing.children.add(new Square("Red"));
    drawing.children.add(new Circles("Yellow"));

    GraphicObject group = new GraphicObject();
    group.children.add(new Circles("Blue"));
    group.children.add(new Square("Blue"));
    drawing.children.add(group);

    System.out.println(drawing);
  }
}
