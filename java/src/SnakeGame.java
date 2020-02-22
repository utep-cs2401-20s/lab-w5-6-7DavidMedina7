public class SnakeGame {

    // **ATTRIBUTES**

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
    SnakeGame(boolean[][] board, int x, int y) {

        // Initializing the array headPosition
        headPosition = new int[2];

        // Setting x and y values values in headPosition
        headPosition[0] = x;
        headPosition[1] = y;

        // Passing the address board to game
        game = board;
    }


    // **METHODS**

    // Will find the tail of the snake by searching across the whole grid to find the grid position
    // where a true element is surrounded by only one other true cell (see figure below), but is not
    // the head, and return 3 items: the x and y position of the tail in the grid, and the length of
    // the snake on the board. Increments the exhaustiveChecks counter with each (x',y') cell that is
    // examined.
    public int[] findTailExhastive() {

        // Initilizing the result array
        int[] result = new int[3];

        // Initializing length
        int length = 0;

        // Reset counters
        resetCounters();

        // Start at the first coordinate of the board
        for(int i = 0; i < game.length; i++) {
            for(int j = 0; i < game[i].length; j++) {

                // Initialize neighbors
                int neighbors = 0;

                // Checks if it is part of the snake
                if (game[i][j]) {
                    length++;

                    // If the position is head...
                    if(i == headPosition[0] && j == headPosition[1]) {
                        continue;
                    }

                    // Iterating around each cell to find neighbors
                    for (int r = i - 1; r <= i + 1; r++) {
                        for (int c = j - 1; c <= j + 1; c++) {

                            // Checking if coordinate is out of bounds
                            if (r < 0 || r >= game.length || c < 0 || c >= game[r].length) {
                            // It is out of bounds
                                continue;
                            }

                            // If neighbor equals true
                            if(game[r][c]) {
                                neighbors++;
                            }
                        }
                    }
                    if(neighbors == 1) {

                        // Storing x and y positions to result
                        result[0] = i;
                        result[1]  = j;

                        exhastedChecks++;
                    }
                }
            }

        }
        // Storing length to result
        result[2] = length;

        return result;
    }

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
    private void resetCounters() {
        exhastedChecks = 0;
        recursiveChecks = 0;
    }

    // **GETTERS**

    // gets the current state of the recursiveChecks counter.
    private static int getRecursiveChecks() {
        return recursiveChecks;
    }

    //  gets the current state of the exhaustiveChecks counter.
    private static int getExhastedChecks() {
        return exhastedChecks;
    }
}
