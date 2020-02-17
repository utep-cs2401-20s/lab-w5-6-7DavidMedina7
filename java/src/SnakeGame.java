public class SnakeGame {

    // **Attributes**

    // Stores the final game state
    // Description: cells that are true contain part of the snake, and false are the background.
    // Note that in this version of the game the snake will always have a barrier of one cell
    // (i.e. every neighborhood of 9 cells around a portion of the snake will only ever have at most true cells)
    private boolean[][] game;

    // Stores the location of the snake's head
    private int[] headPosition;

    // Counts the number of positions checked when performing the tail search using exhaustive enumeration, across all instances of the SnakeGame
    private static int exhastedChecks;

    // Counts the number of positions checked when performing the tail search using recursive search, across all instances of the SnakeGame
    private static int recursiveChecks;

    // **Constructors**

    // default constructor, which initializes an empty 1 x 1 gameboard
    SnakeGame() {
        int[][] board = new int[1][1];
    }

    // constructor that takes a 2-dimensional boolean array, and the x and y position of the snakes "head"
    SnakeGame(boolean[][] board, int x, int y) {}


    // **Methods**

    // Will find the tail of the snake by searching across the whole grid to find the grid position
    // where a true element is surrounded by only one other true cell (see figure below), but is not
    // the head, and return 3 items: the x and y position of the tail in the grid, and the length of
    // the snake on the board. Increments the exhaustiveChecks counter with each (x',y') cell that is
    // examined.
    public int[] findTailExhastive() {}

    // will find the tail of the snake by conducting a search starting at the head location and
    // recursively following the snake's body, and return 3 items: the x and y position of the tail in
    // the grid, and the length of the snake on the board. Increments the recursiveChecks counter with
    // each (x',y') cell that is examined.
    public int[] findTailRecursive() {}

    // overloads the previous method, and is similar in definition, but starts at a position other
    // than the head position (used for the recursive calls), also takes in the position of the
    // previous body position (to exclude it from deciding the next position). Increments the
    // recursiveChecks counter with each (x',y') cell that is examined.
    // Hint: the call for starting from the head position made from the public method should be
    // findTailRecursive(headPosition, headPosition).
    private int[] findTailRecursive(int[] currentposition, int[] previousPosition) {}

    // resets both the exhaustiveChecks and recursiveChecks counters to 0.
    private void resetCounters() {}

    // gets the current state of the recursiveChecks counter.
    private static int getRecursiveChecks() {}

    //  gets the current state of the exhaustiveChecks counter.
    private static int getExhastedChecks() {}
}