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
    private static int exhaustedChecks;

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
    public int[] findTailExhaustive() {

        // Initializing the result array
        int[] result = new int[3];

        // Initializing length
        int length = 0;

        // Reset counters
        resetCounters();

        // Boolean Check to stop incrementing number of checks
        boolean booleanCheck = true;

        // Start at the first coordinate of the board
        for(int i = 0; i < game.length; i++) {
            for(int j = 0; j < game[i].length; j++) {

                if(booleanCheck) {
                   exhaustedChecks++;
                }

                System.out.println("i: " + i);
                System.out.println("j: " + j);
                System.out.println("Exhausted Checks: " + exhaustedChecks);
                System.out.println();

                // Checks if it is part of the snake
                if (game[i][j]) {

                    // Increment length
                    length++;

                    // Call neighbors
                    int numOfNeighbors = neighbors(i, j);

                    // If the cell has 2 or more neighbors...
                    if (numOfNeighbors >= 2) {
                        continue;
                    }

                    // If the cell only has one neighbor...
                    if (numOfNeighbors == 1) {

                        // If the position is head...
                        if (i  == headPosition[0] && j == headPosition[1]) {
                            System.out.println("Head position found at: i: " + i + " j: " + j);
                        }

                        // Else the position is the tail
                        else {

                            // Storing x and y positions to result
                            result[0] = i;
                            result[1]  = j;

                            booleanCheck = false;

                        }
                    }
                }
            }
        }

        // Storing length to result
        result[2] = length;

        System.out.println("Tail found at: i: " + result[0] + " j: " + result[1]);
        System.out.println("Exhaustive Checks: " + exhaustedChecks);
        System.out.print("The length of the snake is: " + length);

        return result;
    }

    // will find the tail of the snake by conducting a search starting at the head location and
    // recursively following the snake's body, and return 3 items: the x and y position of the tail in
    // the grid, and the length of the snake on the board. Increments the recursiveChecks counter with
    // each (x',y') cell that is examined.
    public int[] findTailRecursive() {

        // Initializing the result array
        int[] result = new int[3];


        return result;
    }

    // overloads the previous method, and is similar in definition, but starts at a position other
    // than the head position (used for the recursive calls), also takes in the position of the
    // previous body position (to exclude it from deciding the next position). Increments the
    // recursiveChecks counter with each (x',y') cell that is examined.
    // Hint: the call for starting from the head position made from the public method should be
    // findTailRecursive(headPosition, headPosition).
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {

        // Initializing the result array
        int[] result = new int[3];

        // Looking at head position and setting it to currentPosition
        currentPosition = headPosition;

        // Calling neighbors
        neighbors(currentPosition[0], currentPosition[1]);



        return result;
    }

    // resets both the exhaustiveChecks and recursiveChecks counters to 0.
    private void resetCounters() {
        exhaustedChecks = 0;
        recursiveChecks = 0;
    }

    // **GETTERS**

    // gets the current state of the recursiveChecks counter.
    private static int getRecursiveChecks() {
        return recursiveChecks;
    }

    //  gets the current state of the exhaustiveChecks counter.
    private static int getExhastedChecks() {
        return exhaustedChecks;
    }

    // Counts number of neighbors
    public int neighbors(int row, int col) {

        int numOfNeighbors = 0;

        // Checking if it is out of bounds
        if((row - 1) >= 0) {
            // Checking the top coordinate
            if(game[row - 1][col]) {
                numOfNeighbors++;
            }
        }

        // Checking if it is out of bounds
        if((col + 1) < game[row].length) {
            // Checking the right coordinate
            if(game[row][col + 1]) {
                numOfNeighbors++;
            }
        }


        // Checking if it is out of bounds
        if((row + 1) < game.length) {
            // Checking the bottom coordinate
            if(game[row + 1][col]) {
                numOfNeighbors++;
            }
        }


        // Checking if it is out of bounds
        if((col - 1) >= 0){
            // Checking the left coordinate
            if(game[row][col - 1]) {
                numOfNeighbors++;
            }
        }


        return numOfNeighbors;
    }


}
