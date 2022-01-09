package com.erintl.scratch;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.Matcher;

public class ConstrainsSidesTo extends TypeSafeMatcher<Rectangle> {
  private int length;

  public ConstrainsSidesTo(int length) {
    this.length = length;
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("both sides must be <= " + length);
  }

  @Override
  protected boolean matchesSafely(Rectangle rectangle) {
    return Math.abs(rectangle.getOrigin().x - rectangle.getOpposite().x) <= length &&
      Math.abs(rectangle.getOrigin().y - rectangle.getOpposite().y) <= length;
  }

  public static Matcher<Rectangle> constrainsSidesTo(int length) {
    return new ConstrainsSidesTo(length);
  }
}
