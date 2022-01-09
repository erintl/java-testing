package com.erintl.transmission;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransmissionTest {
  private Transmission transmission;
  private Car car;

  @BeforeEach
  public void setup() {
    car = new Car();
    transmission = new Transmission(car);
  }

  @Test
  @DisplayName("remains in drive after acceleration")
  public void remainsInDriveAfterAcceleration() {
    transmission.shift(Gear.DRIVE);

    car.accelerateTo(30);

    assertThat(transmission.getGear(), equalTo(Gear.DRIVE));
  }

  @Test
  @DisplayName("ignores shift to park while in drive") 
  public void ignoresShiftToParWhileInDrive() {
    transmission.shift(Gear.DRIVE);
    car.accelerateTo(30);

    transmission.shift(Gear.PARK);

    assertThat(transmission.getGear(), equalTo(Gear.DRIVE));
  }

  @Test
  @DisplayName("allows shift to park while not moving")
  public void allowsShiftToParkWhileNotMoving() { 
    transmission.shift(Gear.DRIVE);
    car.accelerateTo(30);
    car.brakeToStop();

    transmission.shift(Gear.PARK);

    assertThat(transmission.getGear(), equalTo(Gear.PARK));
  }
}
