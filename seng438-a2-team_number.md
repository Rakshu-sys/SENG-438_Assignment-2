**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |Rakshita Suri      |
|                |Mohit Kaila     |
|                |Okibe Abang     |
|                |     |

# 1 Introduction


This lab aims on teaching the basics of unit testing. The framework we use is JUnit. Our system needs to be tested using unit testing as it is important for reliability. We test the system in a package called org.jfree.data using JFreeChart framework. It contains multiple classes, however we focus on testing the two classes: Range and DataUtilities. The class DataUtilities also uses mock  objects through JMock. This lab provides us a an opportunity to apply our theoretical knowledge of the unit testing. In this lab, we use resources like API specifications provided in the lab folder, javadoc documentations, and lecture material in order to get more familiar with the concepts of unit testing. 


# 2 Detailed description of unit test strategy

First, we will discuss the Java documentation in order to have a understanding of how the DataUtilities and Range classes work. After mastering the basics of their use, we will then outline the 10 test cases and start coding. 

For DataUtilities, we will use all of its  methods as benchmark test cases. We can always add more unit tests if we think the methods being tested require it. 
For Range, we will explore 5 out of its 15  methods to test according to the same guideline and if there is a need, to add more cases for testing. 

After deciding which sets of the methods to test, we will then choose the best black-box testing methods such as equivalence classes and boundary testing that we will use in order to have a complete and reliable test cases.


# 3 Test cases developed
# RangeTest Class - Test Case Documentation

## contains() Method
### testContainsWithinRange
- **Description:** Tests if the `contains()` method correctly identifies a value within the range.
- **Expected Outcome:** True.
- **Testing Type:** Equivalence Testing.

### testContainsAtLowerBound
- **Description:** Tests if the `contains()` method correctly identifies the lower bound as within range.
- **Expected Outcome:** True.
- **Testing Type:** Boundary Testing.

### testContainsAtUpperBound
- **Description:** Tests if the contains() method correctly identifies the upper bound as within range.
- **Expected Outcome:** True.
- **Testing Type:** Boundary Testing.

### testContainsBelowRange
- **Description:** Tests if the contains() method correctly identifies a value below the range as out of range.
- **Expected Outcome:** False.
- **Testing Type:** Equivalence Testing.

### testContainsAboveRange
- **Description:** Tests if the contains() method correctly identifies a value above the range as out of range.
- **Expected Outcome:** False.
- **Testing Type:** Equivalence Testing.

## combine() Method
### testCombineTwoValidRanges
- **Description:** Tests combining two non-overlapping valid ranges.
- **Expected Outcome:** A new range spanning from the lower bound of the first range to the upper bound of the second range.
- **Testing Type:** Equivalence Testing.

### testCombineOverlappingRanges
- Description: Tests combining two overlapping ranges.
- Expected Outcome: A new range that merges the two ranges correctly.
- Testing Type: Boundary Testing.

### testCombineWithNullRange
- **Description:** Tests combining a valid range with a null range.
- **Expected Outcome:** The non-null range is returned.
- **Testing Type:** Equivalence Testing.


### testCombineBothNull
- **Description**: Tests combining two null ranges.
- **Expected Outcome:** Null should be returned.
- **Testing Type:** Equivalence Testing.

  
## expand() Mrthod
### testExpandRange
- **Description:** Tests if a range is correctly expanded by a given margin.
- **Expected Outcome:** The range is expanded correctly on both sides.
- **Testing Type:** Boundary Testing.

### testExpandWithZeroMargins
- **Description:** Tests expanding a range with zero margins.
- **Expected Outcome:** The range remains unchanged.
- **Testing Type:** Equivalence Testing.

### testExpandNullRange
- **Description:** Tests expanding a null range.
- **Expected Outcome:** IllegalArgumentException is thrown.
- **Testing Type:** Exception Testing.

## constrain() Method
### testConstrainWithinRange
- **Description:** Tests constraining a value within the range.
- **Expected Outcome:** The same value is returned.
- **Testing Type:** Equivalence Testing.

### testConstrainAtLowerBound
- **Description:** Tests constraining a value at the lower bound.
- **Expected Outcome:** The lower bound is returned.
- **Testing Type:** Boundary Testing.

### testConstrainAtUpperBound
- **Description:** Tests constraining a value at the upper bound.
- **Expected Outcome:** The upper bound is returned.
- **Testing Type:** Boundary Testing.

### testConstrainBelowRange
- **Description:** Tests constraining a value below the range.
- **Expected Outcome:** The lower bound is returned.
- **Testing Type:** Equivalence Testing.

### testConstrainAboveRange
-** Description:** Tests constraining a value above the range.
- **Expected Outcome:** The upper bound is returned.
- **Testing Type:** Equivalence Testing.

## getLowerBound() Method
### testGetLowerBound
- **Description:** Tests if `getLowerBound()` correctly returns the lower bound.
- **Expected Outcome:** The correct lower bound is returned.
- **Testing Type:** Equivalence Testing.

### testGetLowerBoundWithNegativeRange
- **Description:** Tests if `getLowerBound()` correctly returns the lower bound for a negative range.
- **Expected Outcome:** The correct lower bound is returned.
- **Testing Type:** Equivalence Testing.

**Boundary Testing:** Used for tests dealing with edge values (e.g., bounds of a range, expansion, constraints).

**Equivalence Testing:** Used for tests verifying normal operations (e.g., checking values inside, outside, or at the edges of the range).

**Exception Testing:** Used for tests that ensure the correct exceptions are thrown when expected.


// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

This lab serves as a really good opportunity to enhance our knowledge. The lab instructions are self-explanatory and easy to follow through. Overall, the lab went well after the team members got familiar with unit testing. The example tests were quite helpful as well. Initially, the setup in Eclipse and getting familiar with it took some time. However, once everyone got used to it, it became easier to perform unit tests. 
