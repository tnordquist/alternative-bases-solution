package edu.cnm.deepdive;

/**
 * Defines the static method {@link #toString(long, int)}, which constructs and returns a
 * representation of a {@code long} value, using a specified {@code int} <em>radix</em> (number
 * base). Implementation of this method is included in the practical exam problems of the Deep Dive
 * Coding Java + Android Bootcamp.
 */
public class Radices {

  private Radices() {
    // NOTE: There is NO need to do anything with this constructor! The method you will implement in
    // this class is static; thus, there is no need to create instances of this class.
  }

  /**
   * Constructs and returns a representation of {@code value} using {@code radix} as a number base.
   * The characters used for the digits of the representation are {@code '0'} through {@code '9'},
   * supplemented (as necessary) by {@code 'a'} through {@code 'z'} (for {@code radix > 10}). This
   * gives a maximum of 36 digit characters; thus, an {@link IllegalArgumentException} is thrown if
   * {@code radix > 36}, or if {@code radix <= 1}. If {@code value < 0}, then the representation
   * returned is the same as the representation that would be returned for {@link Math#abs(long)
   * Math.abs(value)}, but with "-" prepended.
   *
   * @param value Quantity to be represented using {@code radix} as a number base.
   * @param radix Number base to use in the representation of {@code value}.
   * @return Representation of {@code value} using {@code radix} as a number base.
   * @throws IllegalArgumentException If {@code radix <= 1}, or if {@code radix > 36}.
   */
  public static String toString(long value, int radix) throws IllegalArgumentException {

    if (radix < 2 || radix > 36) {
      throw new IllegalArgumentException();
    }

    String basis = "0123456789abcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder();
    long testVal = value;
    boolean negative = false;
    if (Long.signum(testVal) == -1) {
      negative = true;
      testVal = -testVal;
    }

    do {
      long adder = testVal % radix;
      sb.append(basis.charAt((int) adder));
      testVal /= radix;
    } while (testVal != 0);

    if (negative) {
      sb.append("-");
    }

    sb.reverse();
    return sb.toString();
  }

}
