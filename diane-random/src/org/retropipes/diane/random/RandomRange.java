/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.random;

/**
 * Generates random integers or long integers in a range.
 */
public class RandomRange {
    /**
     * Generate.
     *
     * @return the generated integer
     */
    public static int generate(final int minimum, final int maximum) {
	if (maximum - minimum + 1 == 0) {
	    return Math.abs(RandomnessSource.nextInt()) + minimum;
	}
	return Math.abs(RandomnessSource.nextInt() % (maximum - minimum + 1)) + minimum;
    }

    /**
     * Generate.
     *
     * @return the long
     */
    public static long generateLong(final long minimumLong, final long maximumLong) {
	if (maximumLong - minimumLong + 1 == 0) {
	    return Math.abs(RandomnessSource.nextLong()) + minimumLong;
	}
	return Math.abs(RandomnessSource.nextLong() % (maximumLong - minimumLong + 1)) + minimumLong;
    }

    /**
     * Generate raw.
     *
     * @return the int
     */
    public static int generateRaw() {
	return RandomnessSource.nextInt();
    }

    /**
     * Generate raw long.
     *
     * @return the long
     */
    public static long generateRawLong() {
	return RandomnessSource.nextLong();
    }

    /** The minimum. */
    // Fields
    private int minimum;
    /** The maximum. */
    private int maximum;
    /** The minimum long. */
    // Fields
    private long minimumLong;
    /** The maximum long. */
    private long maximumLong;

    /**
     * Instantiates a new random range.
     *
     * @param min the min
     * @param max the max
     */
    // Constructor
    public RandomRange(final int min, final int max) {
	this.minimum = min;
	this.maximum = max;
    }

    /**
     * Instantiates a new random range for long integers.
     *
     * @param min the min
     * @param max the max
     */
    // Constructor
    public RandomRange(final long min, final long max) {
	this.minimumLong = min;
	this.maximumLong = max;
    }

    /**
     * Generate.
     *
     * @return the generated integer
     */
    public int generate() {
	if (this.maximum - this.minimum + 1 == 0) {
	    return Math.abs(RandomnessSource.nextInt()) + this.minimum;
	}
	return Math.abs(RandomnessSource.nextInt() % (this.maximum - this.minimum + 1)) + this.minimum;
    }

    /**
     * Generate.
     *
     * @return the long
     */
    public long generateLong() {
	if (this.maximumLong - this.minimumLong + 1 == 0) {
	    return Math.abs(RandomnessSource.nextLong()) + this.minimumLong;
	}
	return Math.abs(RandomnessSource.nextLong() % (this.maximumLong - this.minimumLong + 1)) + this.minimumLong;
    }

    /**
     * Sets the maximum.
     *
     * @param newMax the new maximum
     */
    public void setMaximum(final int newMax) {
	this.maximum = newMax;
    }

    /**
     * Sets the minimum.
     *
     * @param newMin the new minimum
     */
    public void setMinimum(final int newMin) {
	this.minimum = newMin;
    }

    /**
     * Sets the maximum long.
     *
     * @param newMax the new maximum
     */
    public void setMaximumLong(final long newMax) {
	this.maximumLong = newMax;
    }

    /**
     * Sets the minimum long.
     *
     * @param newMin the new minimum
     */
    public void setMinimumLong(final long newMin) {
	this.minimumLong = newMin;
    }
}
