# CSES Problem Set Solutions

This repository contains Java solutions to problems from the [CSES Problem Set](https://cses.fi/problemset/), a collection of competitive programming practice problems.

## About CSES

CSES (Code Submission Evaluation System) is a comprehensive collection of algorithmic programming problems that cover various topics in competitive programming and algorithms. The problem set is widely used for learning and practicing competitive programming concepts.

## Repository Structure

The solutions are organized by problem categories:

```
src/
├── intro/          # Introductory Problems
├── sort/           # Sorting and Searching
├── dp/             # Dynamic Programming
├── graph/          # Graph Algorithms
├── math/           # Mathematics
├── rangesum/       # Range Queries
├── somepackage/    # Solution template (example file)
└── util/           # Utility classes (e.g., FastReader)
```

### Problem Categories

- **Introductory Problems** (`intro/`): Basic problems to get started with competitive programming
  - `weird.java` - Weird Algorithm (Collatz Conjecture)
  - `repetition.java` - Repetitions
  - `missing.java` - Missing Number

- **Sorting and Searching** (`sort/`): Problems involving sorting and searching techniques
  - `distinct.java` - Distinct Numbers
  - `apartment.java` - Apartments
  - `gondolas.java` - Ferris Wheel / Gondola Lift

- **Dynamic Programming** (`dp/`): Classic dynamic programming problems
  - `dice.java` - Dice Combinations

- **Graph Algorithms** (`graph/`): Graph traversal and pathfinding problems
  - `labyrinth.java` - Labyrinth
  - `rooms.java` - Counting Rooms

- **Mathematics** (`math/`): Mathematical and number theory problems
  - `josephus.java` - Josephus Problem
  - `point.java` - Point Location Test

- **Range Queries** (`rangesum/`): Problems involving range-based operations
  - `staticrange.java` - Static Range Sum Queries
  - `rangemin.java` - Static Range Minimum Queries
  - `rangexor.java` - Range XOR Queries

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.) or command-line tools

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/b423016/CSES_SOLN.git
   cd CSES_SOLN
   ```

2. **Open in your IDE**:
   - For IntelliJ IDEA: Open the project folder directly (the `.iml` file is already configured)
   - For other IDEs: Import as a Java project with `src/` as the source folder

3. **Compile and run** (command line):
   ```bash
   # Compile a specific solution from the project root
   javac -d out -cp src src/intro/weird.java
   
   # Run the compiled class
   java -cp out intro.weird
   ```

## Usage

Each Java file contains a solution to a specific CSES problem. To use a solution:

1. Navigate to the problem on [CSES Problem Set](https://cses.fi/problemset/)
2. Find the corresponding solution file in this repository
3. Review the code to understand the approach
4. Test the solution with sample inputs
5. Submit to CSES for verification

### Running Solutions

**Option 1: Using an IDE**
- Open the desired `.java` file
- Run the main method
- Provide input through the console

**Option 2: Command Line**
```bash
# From the project root directory
# Compile
javac -d out -cp src src/intro/weird.java

# Run
java -cp out intro.weird
```

### Example Input/Output

For the Weird Algorithm problem (`intro/weird.java`):
```
Input: 3
Output: 3 10 5 16 8 4 2 1
```

## Utilities

The repository includes helpful utilities:

- **`util/FastReader.java`**: Fast input reader for competitive programming (optimized for large inputs)
- **`somepackage/Solution.java`**: Template file demonstrating the usage of FastReader - use this as a starting point for new solutions

## Contributing

Contributions are welcome! If you'd like to add more solutions or improve existing ones:

1. Fork the repository
2. Create a new branch for your solution (`git checkout -b add-problem-name`)
3. Add your solution in the appropriate category folder
4. Follow the existing code structure and naming conventions
5. Test your solution on CSES
6. Commit your changes (`git commit -m 'Add solution for Problem Name'`)
7. Push to your branch (`git push origin add-problem-name`)
8. Open a Pull Request

### Code Style Guidelines

- Use meaningful variable names
- Add comments for complex logic
- Follow Java naming conventions (camelCase for variables/methods, PascalCase for classes)
- Keep solutions efficient and optimized for competitive programming constraints
- Include the problem name or number as a comment at the top of the file

## Resources

- [CSES Problem Set](https://cses.fi/problemset/) - Official problem set
- [CSES Problem Set Solutions](https://cses.fi/problemset/stats/) - Statistics and discussion
- [Competitive Programmer's Handbook](https://cses.fi/book/book.pdf) - Free book by the CSES creator

## License

This project is open source and available for educational purposes. Solutions are provided as-is for learning and reference.

## Acknowledgments

- Problems are from the [CSES Problem Set](https://cses.fi/problemset/)
- Created and maintained by competitive programming enthusiasts

## Disclaimer

These solutions are meant for learning purposes. It's recommended to attempt solving the problems yourself before referring to the solutions. Understanding the approach is more valuable than just copying the code.

---

**Happy Coding!** 🚀
