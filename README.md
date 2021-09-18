# Histogram

## Story

A histogram is an approximate, graphical representation of the distribution of numerical
or categorical data. Simply put, it represents data using bars of different heights.
In a histogram, each bar group numbers into ranges. Taller bars show that more data falls
in that range. A histogram displays the shape and spread of continuous sample data.
To construct a histogram, the first step is to get the range of values and count the occurrences
in your data.

For example, let's make a histogram for the following text.

Harry Potter and the Sorcerer's Stone
Mr. and Mrs. Dursley, of number four, Privet Drive,
were proud to say that they were perfectly normal, thank you very much.

```
1  - 3 | *********
4  - 6 | ****************
7  - 9 | ***
```

In the text, there are 9 words in the range 1-3 letters,
16 words in the range 4-6, and 3 in the range 7-9. Punctuation signs are not included.

We need to ensure that the already implemented program collects all data into the histogram
correctly. Nobody likes charts with incorrect data. So let’s implement unit tests.
Make your tests shine, and ensure that they pay off more than they cost.
In this project, your job is to cover your code with tests, and make an assertion for all
the statements in the bullet points.

## What are you going to learn?

- Write unit tests.
- Develop boundary conditions.
- Handle exceptions and cover them with tests.
- Improve code efficiency based on test results.

## Tasks

1. Create separate files for testing purposes isolated from production code.
    - There are test files containing edge cases in the `test > resources` directory.
    - The `BeforeEach`, `BeforeAll`, `AfterEach`, and `AfterAll` annotations are used properly. For example, if a class needs to be instantiated before every test method, it is placed inside a `BeforeEach` annotated method.

2. In the `TextReader` class, we have a read method which returns `String` from the read file. Cover this method with tests, by implementing the `TextReaderTest` class.
    - When providing a wrong file name, a `FileNotFoundException` exception is thrown.
    - The following test cases are provided for the `read()` method. - existing but empty files - one line text in text file - multiple line in text file

3. Cover the `Range` class with tests, by implementing the `RangeTest` class.
    - The following test cases are provided for the for constructor.
- `from < 0`
- `to < from`
    - The following test cases are provided for the `isInRange()` method. - word length in range - word length equals to range `from` - word length equals to range `to` - word length is out of range
    - A test case is provided for the `toString()` method.

4. Cover the `Histogram` class with tests by implementing the `HistogramTest` class.
    - The following test cases are provided for the `generateRanges()` method. - positive integers added as parameters - negative integer as `step` parameter - negative integer as `amount` parameter
    - The `generate()` method returns counts of words with length in given ranges as a `HashMap`. The following test cases are provided for the `generate()` method. - all words in `text` is in one of the given `ranges` - `text` with words out of given ranges - empty `text` - null as `text` - null as `ranges` - generating histogram multiple times
    - The following test cases are provided for the `getHistogram()` method. - Calling before generating histogram. - Calling after generating histogram. - Calling after multiple calls of `generateHistogram()`.
    - The string representation of histogram presents specific ranges
and their values displayed with proper asterisk repetition.
The following test cases are provided.
- Histogram before generating.
- Histogram after generating.

5. The problem with the current implementation is that while it works nicely for shorter texts, if we
decided to put, say, the text of an entire book into it, the histogram becomes unreadably large.
To make the visualization of our histogram independent of the input size, we must to normalize our results.
We need to use Min-Max normalization, which transforms all the input data into a fixed range of values,
where the smallest value of the original data becomes the minimum of the range,
while the biggest becomes the maximum, and every other value becomes relative to where they fit in the original dataset.
For this task, we transform our data into a range of values between 0 to 100.
Implement this method in the Histogram class.
    - There is a method to get the maximum value from the histogram.
    - There is a method to get the minimum value from the histogram.
    - The new value is calculated by the `V' = (V - min) * 100 / (max - min)` formula,
where `V` is the current histogram value, `min` is smallest
histogram value in the dataset, `max` is biggest histogram value, and `V'` is the normalized value.
For example, if the maximum value of the range is 115, and the minimum value is 7,
when there are 25 words in the range of 4-6 characters, normalizing the range returns 16 as the value.
(The fraction part in value result is not considered, only an integer value is taken.)

6. Update the `HistogramTest` class to cover the methods written in the previous step.
    - The `getMin()` and `getMax()` methods return values accordingly.
    - The string representation of the histogram presents specific ranges
and their values from 0 to 100, represented by asterisk repetition.

7. Try to optimize code and find a way to improve test efficiency.
    - There is no unnecessary code repetition in test methods.
    - The execution time of tests is as short as possible.
    - Test coverage of `Histogram`, `TextReader` and `Range` classes are 100%.

## General requirements

- The name of every test method follows the same naming convention.
If a test fails, the name makes it easy to find which method in which scenario
is broken and what is the expected behavior.
- The different assertion methods are used as intended. For example, `assertTrue(value)` is used for examining a boolean value, instead of `assertEquals(true, value)`.

## Hints

- Override both `equals` and `hashCode` when testing whether a given structure, list, map, etc. contains the right object.
- Run a test and check the coverage by clicking `Run > Run with Coverage` in IntelliJ.
  You can see percentile test coverage of classes, methods, and lines.
- Choose a naming standard which is more descriptive and specific enough to easily detect
  where a certain issue can be found. For example, `MethodName_StateUnderTest_ExpectedBehavior`.
  For more information on unit test naming standards, see the Background materials section.


## Background materials

- <i class="far fa-exclamation"></i> [Software testing](project/curriculum/materials/pages/general/software-testing.md)
- <i class="far fa-exclamation"></i> [Positive test or negative test](https://stackoverflow.com/questions/8162423)
- <i class="far fa-exclamation"></i> [IDEA - JUnit step-by-step Guide](project/curriculum/materials/pages/tools/idea-junit-step-by-step-guide.md)
- <i class="far fa-exclamation"></i> [JUnit Introduction](project/curriculum/materials/pages/java/junit-introduction.md)
- <i class="far fa-exclamation"></i> [Unit test naming conventions](https://dzone.com/articles/7-popular-unit-test-naming)
- <i class="far fa-book-open"></i> [BeforeEach and BeforeAll](https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall#beforeeach-and-beforeall)
- <i class="far fa-candy-cane"></i> [Order of tests in JUnit](https://www.baeldung.com/junit-5-test-order)

