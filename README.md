
# Searching and Sorting Algorithm Testbed

## Overview
This program provides an interactive testbed for experimenting with and comparing various searching and sorting algorithms. It allows users to test linear and binary search operations, as well as multiple sorting algorithms with different time complexities.

## Features

### Search Algorithms
- Linear Search (O(n))
- Binary Search (O(log n))
  - Note: Array is automatically sorted before binary search

### Sort Algorithms
- Bubble Sort (O(n²))
- Quick Sort (O(n log n))
- Merge Sort (O(n log n))
- Selection Sort (O(n²))

### Performance Analysis
- Built-in performance measurement for all sorting algorithms
- Comparison counter to track the number of comparisons made
- Ability to generate CSV reports with performance metrics
- Visual comparison of algorithm performance with different input sizes

## Usage

### Main Menu Options
1. Linear searching
2. Binary searching
3. O(n²) type of sorting
4. O(n log n) type of sorting
5. Sorting performance analysis
6. Generate CSV performance report
- q/Q to quit

### Search Operations
- For search operations (options 1 & 2), the program will:
  - Display available values (0 to length-1)
  - Prompt for a value to search
  - Return whether the value was found

### Sort Operations
- For sorting operations (options 3 & 4), the program will:
  - Generate a random array of integers (-100 to 100)
  - Display the unsorted array
  - Sort the array using the selected algorithm
  - Display the sorted array

### Performance Analysis
- Option 5 provides a detailed performance comparison of all sorting algorithms:
  - Tests arrays of increasing sizes
  - Measures execution time in milliseconds
  - Counts number of comparisons
  - Displays results in a tabulated format

### CSV Report Generation
- Option 6 generates a CSV file named "SortingData.csv" containing:
  - Execution times for all sorting algorithms
  - Number of comparisons for each algorithm
  - Data for different input sizes (1000 to 10000 elements)

## Demo

<p align="center">
  <img src="https://github.com/user-attachments/assets/74d5083e-396d-4782-9f45-b06fd898784b" alt="Sorting Algo Demo">
</p>

## Implementation Details

### Data Structures
- Generic implementation supporting Comparable types
- Array-based storage for data elements
- Support for both primitive integers and objects

### Performance Tracking
- Nanosecond-precision timing measurements
- Dedicated ComparisonCounter class for operation counting
- Support for both time-based and operation-based complexity analysis

## Classes
- `Program`: Main application entry point
- `UserInterface`: Core algorithm implementation and user interaction
- `UserOptions`: Input handling and menu display
- `ComparisonCounter`: Performance measurement utility

## Dependencies
- Java Standard Library
- No external dependencies required
