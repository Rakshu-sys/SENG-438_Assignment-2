**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |Rakshita Suri      |
|                |Mohit Kaila     |
|                |Okibe Abang     |
|                |Shalin Wickremeratna|

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

  
## expand() Method
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


# DataUtilitiesTest Class - Test Case Documentation

#### **calculateColumnTotal() Method**  
**testEmptyTableColumnSum**  
- **Description:** Tests summing a column in an empty table to ensure the result is zero.  
- **Expected Outcome:** 0.0.  
- **Testing Type:** Boundary Testing.  

**testSingleRowColumnSum**  
- **Description:** Tests summing a single-column table with one row to ensure correctness.  
- **Expected Outcome:** The single value in the column is returned.  
- **Testing Type:** Equivalence Testing.  

#### **calculateRowTotal() Method**  
**testEmptyTableRowSum**  
- **Description:** Tests summing a row in an empty table to ensure the result is zero.  
- **Expected Outcome:** 0.0.  
- **Testing Type:** Boundary Testing.  

**testMixedValuesRowSum**  
- **Description:** Tests summing a row containing both positive and negative values.  
- **Expected Outcome:** The correct sum of all values in the row.  
- **Testing Type:** Equivalence Testing.  

#### **createNumberArray() Method**  
**testConvertPositiveArrayToNumbers**  
- **Description:** Tests converting an array of positive values into a Number array.  
- **Expected Outcome:** The values are correctly converted into a Number array.  
- **Testing Type:** Equivalence Testing.  

**testConvertNegativeArrayToNumbers**  
- **Description:** Tests converting an array of negative values into a Number array.  
- **Expected Outcome:** The values are correctly converted into a Number array.  
- **Testing Type:** Equivalence Testing.  

**testConvertNullArrayToNumbers**  
- **Description:** Tests handling of null input when converting a double array to a Number array.  
- **Expected Outcome:** IllegalArgumentException is thrown.  
- **Testing Type:** Exception Testing.  

#### **createNumberArray2D() Method**  
**testConvert2DArrayToNumbers**  
- **Description:** Tests converting a 2D array of doubles into a 2D Number array.  
- **Expected Outcome:** The values are correctly converted into a 2D Number array.  
- **Testing Type:** Equivalence Testing.  

**testConvertNull2DArrayToNumbers**  
- **Description:** Tests handling of null input when converting a 2D double array.  
- **Expected Outcome:** IllegalArgumentException is thrown.  
- **Testing Type:** Exception Testing.  

#### **getCumulativePercentages() Method**  
**testCumulativePercentageCalculation**  
- **Description:** Tests calculation of cumulative percentages for a KeyedValues object.  
- **Expected Outcome:** A valid KeyedValues object with cumulative percentages is returned.  
- **Testing Type:** Equivalence Testing.  

# 4 How the team work/effort was divided and managed

The assignment was carried out in a way that all of us Mohit, Rakshita, Shalin, and Okibe took our tasks and smoothly finished the assignment through effective collaboration. Mohit and Rakshita focused on writing and testing the DataUtilities class, ensuring that all methods met the expected functionality and adhered to the framework specifications. Meanwhile, Shalin and Okibe were responsible for implementing and verifying the Range class, carefully testing its behavior under different scenarios.

At the initial stage, we thoroughly read through the JFreeChart framework documentation and studied the Javadoc specifications to gain a clear understanding of what needed to be analyzed and implemented. Before jumping into development, we devised a structured approach to testing by planning test cases using techniques like equivalence partitioning and boundary value analysis to ensure that all critical scenarios were covered. This helped us identify edge cases and avoid potential errors in implementation.

Once we developed the test cases, we engaged in peer review, checking each other's work, running the tests, and debugging issues to improve the overall quality of our code. Regular team meetings were held to discuss progress, address challenges, and support one another, making sure we stayed aligned with the project goals. To further streamline our workflow and maintain consistency, we used version control, which helped us track changes, manage code conflicts, and ensure a smooth integration of our contributions.

Overall, our structured approach, combined with teamwork and effective planning, allowed us to complete the assignment successfully while gaining valuable insights into software testing and collaborative development.


# 5 Difficulties encountered, challenges overcome, and lessons learned

One of the greatest difficulties we encountered was the correct interpretation of the Javadoc specifications. Some of our initial test cases failed when we first implemented them, as we misunderstood certain method behaviors and expected outputs. However, after reimplementing the tests and engaging in group discussions, we were able to refine our approach and get them working correctly. This iterative process reinforced the importance of carefully analyzing documentation and collaborating to resolve misunderstandings.

Another significant challenge was the employment of mock objects in DataUtilities. Since mocking was a new concept for some of us, integrating it correctly proved to be tricky. However, Mohit and Rakshita took the initiative to research mock object usage and successfully implemented them, ensuring the tests properly isolated dependencies. This process highlighted the value of self-learning and peer guidance in overcoming technical difficulties.

Additionally, ensuring our test cases adequately covered edge cases was another key difficulty. Initially, we realized that some of our test scenarios only handled common cases, potentially overlooking boundary conditions that could reveal hidden bugs. To address this, we carefully reviewed our test plans and expanded coverage through techniques like equivalence partitioning and boundary value analysis.

Through collaboration and persistence, we tackled these challenges, ultimately enhancing our understanding of JUnit testing and improving our ability to design well-structured test cases. The assignment reinforced the importance of clear communication within a project and the necessity of a structured, methodical approach to testing. Overall, this experience helped us develop stronger problem-solving skills and a deeper appreciation for effective teamwork in software development.

# 6 Comments/feedback on the lab itself

This lab was a great opportunity to deepen our understanding of unit testing and improve our ability to write and execute test cases effectively. The lab instructions were clear and well-structured, making it easy to follow along and understand what needed to be done. Having example tests as a reference was especially helpful, as they provided a solid starting point and gave us insight into how to structure our own test cases.

At the beginning, setting up the environment in Eclipse took some time, especially for those who were less familiar with the IDE. Getting used to JUnit and understanding how to properly run and analyze tests required some trial and error. However, as we worked through the tasks and helped each other with any setup issues, we gradually became more comfortable with the process.

Once the initial hurdles were out of the way, running and refining our unit tests became much more manageable. The lab not only strengthened our understanding of test-driven development but also reinforced the importance of writing comprehensive test cases that cover different scenarios. Overall, it was a valuable learning experience that improved both our technical skills and our ability to collaborate effectively as a team.
