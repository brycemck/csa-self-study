package com.bryce;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCoinCounter {
  
  @SuppressWarnings("deprecation")
  @Test
  public void testCoinCount() {
    double givenCents = 40;
    double expectedDimes = 4;
    assertEquals(CoinCounter.numberOfDimesFromCents(givenCents), expectedDimes);
  }
}
