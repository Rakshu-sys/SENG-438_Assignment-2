package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Range class in JFreeChart.
 * This test suite verifies the correctness of various Range methods.
 * 
 * Types of tests used:
 * - Boundary Tests: Checking edge cases such as upper and lower bounds.
 * - Equivalence Class Tests: Checking values inside, below, and above the range.
 * - Null Handling Tests: Checking behavior when input values are null.
 * - Exception Tests: Verifying expected exceptions.
 */
public class RangeTest {
    private Range range;

    /**
     * Setup method to initialize a Range instance before each test.
     */
    @Before
    public void setUp() {
        range = new Range(5, 15);
    }

    /**
     * Teardown method to clean up after each test.
     */
    @After
    public void tearDown() {
        range = null;
    }

    // --------- Testing contains() Method --------- //
    
    /**
     * Tests if the contains() method correctly identifies a value within the range.
     */
    @Test
    public void testContainsWithinRange() {
        assertTrue("Value inside the range should return true", range.contains(10));
    }

    /**
     * Tests if the contains() method correctly identifies the lower bound as within range.
     */
    @Test
    public void testContainsAtLowerBound() {
        assertTrue("Value at lower bound should return true", range.contains(5));
    }

    /**
     * Tests if the contains() method correctly identifies the upper bound as within range.
     */
    @Test
    public void testContainsAtUpperBound() {
        assertTrue("Value at upper bound should return true", range.contains(15));
    }

    /**
     * Tests if the contains() method correctly identifies a value below the range as out of range.
     */
    @Test
    public void testContainsBelowRange() {
        assertFalse("Value below the range should return false", range.contains(3));
    }

    /**
     * Tests if the contains() method correctly identifies a value above the range as out of range.
     */
    @Test
    public void testContainsAboveRange() {
        assertFalse("Value above the range should return false", range.contains(17));
    }

    // --------- Testing combine() Method --------- //
    
    /**
     * Tests combining two non-overlapping ranges.
     * Expected output: A new range spanning from the lower bound of the first range to the upper bound of the second range.
     */
    @Test
    public void testCombineTwoValidRanges() {
        Range range1 = new Range(2, 8);
        Range range2 = new Range(10, 20);
        Range combined = Range.combine(range1, range2);
        assertEquals("Combined range should have correct lower bound", 2, combined.getLowerBound(), 0.00001);
        assertEquals("Combined range should have correct upper bound", 20, combined.getUpperBound(), 0.00001);
    }

    /**
     * Tests combining two overlapping ranges.
     * Expected output: A new range that merges the two ranges correctly.
     */
    @Test
    public void testCombineOverlappingRanges() {
        Range range1 = new Range(5, 12);
        Range range2 = new Range(10, 18);
        Range combined = Range.combine(range1, range2);
        assertEquals("Overlapping ranges should merge correctly", 5, combined.getLowerBound(), 0.00001);
        assertEquals("Overlapping ranges should merge correctly", 18, combined.getUpperBound(), 0.00001);
    }

    /**
     * Tests combining a valid range with a null range.
     * Expected output: The non-null range is returned.
     */
    @Test
    public void testCombineWithNullRange() {
        assertEquals("Combining with null should return the non-null range", range, Range.combine(range, null));
    }

    /**
     * Tests combining two null ranges.
     * Expected output: Null should be returned.
     */
    @Test
    public void testCombineBothNull() {
        assertNull("Combining two null ranges should return null", Range.combine(null, null));
    }

    // --------- Testing expand() Method --------- //
    
    /**
     * Tests expanding a range by 50% in both directions.
     * Expected output: New range with correctly expanded bounds.
     */
    @Test
    public void testExpandRange() {
        Range expanded = Range.expand(range, 0.5, 0.5);
        assertEquals("Expanded lower bound incorrect", 0, expanded.getLowerBound(), 0.00001);
        assertEquals("Expanded upper bound incorrect", 20, expanded.getUpperBound(), 0.00001);
    }

    /**
     * Tests expanding a range with zero margins (should return the same range).
     */
    @Test
    public void testExpandWithZeroMargins() {
        Range expanded = Range.expand(range, 0, 0);
        assertEquals("Expanding with zero margins should return the same range", 5, expanded.getLowerBound(), 0.00001);
        assertEquals("Expanding with zero margins should return the same range", 15, expanded.getUpperBound(), 0.00001);
    }

    /**
     * Tests expanding a null range, expecting an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testExpandNullRange() {
        Range.expand(null, 0.1, 0.1);
    }

    // --------- Testing constrain() Method --------- //
    
    /**
     * Tests constraining a value within the range.
     */
    @Test
    public void testConstrainWithinRange() {
        assertEquals("Value inside range should return itself", 10, range.constrain(10), 0.00001);
    }

    /**
     * Tests constraining a value at the lower bound.
     */
    @Test
    public void testConstrainAtLowerBound() {
        assertEquals("Value at lower bound should return lower bound", 5, range.constrain(5), 0.00001);
    }

    /**
     * Tests constraining a value at the upper bound.
     */
    @Test
    public void testConstrainAtUpperBound() {
        assertEquals("Value at upper bound should return upper bound", 15, range.constrain(15), 0.00001);
    }

    /**
     * Tests constraining a value below the range (should return the lower bound).
     */
    @Test
    public void testConstrainBelowRange() {
        assertEquals("Value below range should return lower bound", 5, range.constrain(2), 0.00001);
    }

    /**
     * Tests constraining a value above the range (should return the upper bound).
     */
    @Test
    public void testConstrainAboveRange() {
        assertEquals("Value above range should return upper bound", 15, range.constrain(20), 0.00001);
    }



    // --------- Testing getLowerBound() Method --------- //
    
    /**
     * Tests getting the lower bound of a positive range.
     * Expected output: 5
     */
    @Test
    public void testGetLowerBound() {
        assertEquals("Lower bound should be correct", 5, range.getLowerBound(), 0.00001);
    }

    /**
     * Tests getting the lower bound of a negative range.
     * Expected output: -10
     */
    @Test
    public void testGetLowerBoundWithNegativeRange() {
        Range negativeRange = new Range(-10, -5);
        assertEquals("Lower bound of negative range should be correct", -10, negativeRange.getLowerBound(), 0.00001);
    }
}
