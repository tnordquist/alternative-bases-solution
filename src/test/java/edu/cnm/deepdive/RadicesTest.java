package edu.cnm.deepdive;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class RadicesTest {

  static final long[] value =
      {-250, 1000, -5_000, 7_500, -100_000, 2_000_000, 5_000_000_000l, 0, 0};

  static final int[] radix = {2, 5, 7, 8, 16, 20, 36, 2, 10};

  static final String[] expected =
      {"-11111010", "13000", "-20402", "16514", "-186a0", "ca000", "2aovcow", "0", "0"};

  @Test
  void testToStringLongInt() {
    String actual = "";
    for (int j = 0; j < expected.length; j++) {
      actual = Radices.toString(value[j], radix[j]);
      assertEquals(expected[j], actual);
    }
  }

}
