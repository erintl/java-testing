package com.erintl.scratch;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.erintl.scratch.ConstrainsSidesTo.constrainsSidesTo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RectangleTest {
  private Rectangle rectangle;

  @AfterEach
  public void ensureInvariant() {
    assertThat(rectangle, constrainsSidesTo(125));
  }

  @Test
  @DisplayName("Answers area correctly")
  public void answersArea() {
    rectangle = new Rectangle(new Point(5, 5), new Point(15, 10));

    assertThat(rectangle.area(), equalTo(50));
  }

  @Test
  @DisplayName("Allows dynamically changing size")
  public void allowsDynamicallyChangingSize() {
    rectangle = new Rectangle(new Point(5, 5));

    rectangle.setOppositeCorner(new Point(130, 130));

    assertThat(rectangle.area(), equalTo(15625));
  }
}
