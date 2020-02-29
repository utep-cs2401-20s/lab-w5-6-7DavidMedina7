import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTest {

    // TEST BOARD #1
    public boolean[][] board1 = {
            {false, false, false, false, false},
            {false, true, true, true, false},
            {false, true, false, true, false},
            {false, true, false, true, false},
            {false, true, false, false, false},
    };

    // TEST BOARD #2
    public boolean[][] board2 = {
            {true, true, true, true, true},
            {true, false, false, false, true},
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
    };

    // TEST BOARD #3
    public boolean[][] board3 = {
            {false, false, false, false, true},
            {false, false, false, true, true},
            {false, false, true, true, false},
            {false, true, true, false, false},
            {true, true, false, false, false},
    };

    // TEST BOARD #4
    public boolean[][] board4 = {
            {true, true, true, true, true, true, true, true, true, true},
            {true, false, false, false, false, false, false, false, false, true},
            {true, false, false, false, false, false, false, false, false, true},
            {true, false, false, false, false, false, false, false, false, true},
            {true, false, true, true, true, true, true, false, false, true},
            {true, false, true, false, false, false, false, false, false, true},
            {true, false, true, false, false, false, false, false, false, true},
            {true, false, true, false, false, false, false, false, false, true},
            {true, false, true, false, false, true, false, false, false, true},
            {true, false, true, false, false, true, false, false, false, true},
            {true, false, true, false, false, true, false, false, false, true},
            {true, false, true, false, false, true, false, false, false, true},
            {true, false, true, false, false, true, false, false, false, true},
            {true, false, true, true, false, true, false, false, false, true},
            {true, false, false, true, false, true, false, false, false, true},
            {true, false, false, true, false, true, false, false, false, true},
            {true, false, false, true, false, true, false, false, false, true},
            {true, false, false, true, false, true, false, false, false, true},
            {true, false, true, true, false, true, false, false, false, true},
            {true, true, true, false, false, true, true, true, true, true},
    };

    // TEST BOARD #5
    public boolean[][] board5 = {
            {false, true, true, true, false, true, true, true, false, true, true, true, false, true, true, true, false, true, true, true},
            {true, true, false, true, true, true, false, true, true, true, false, true, true, true, false, true, true, true, false, false},
    };

    // TEST BOARD #6 (EDGE CASE)
    public boolean[][] board6 = {
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, true, true, true, true, true},
            {false, false, false, false, false, false, false, false, false, true, false, false},
            {false, false, false, false, false, false, false, false, true, true},
            {false, false, false, false, false, false, true, true, true},
            {false, false, false, false, false, false, true},
            {false, false, false, false, false, false, true, false},
            {false, false, false, false, false, false, true, true, true, true},
            {false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false},
    };

    // *** TESTING EXHAUSTIVE METHOD ***

    @Test
    // TESTING BOARD #1:
    // * Setting head: (3, 3)
    // * Expecting tail: (4, 1)
    // * Expecting length of snake: 8
    // TEST: PASSED
    // (Board reference at the top)
    // TEST DESCRIPTION: Essentially to test the basic functionality of the findTailExhausted() method
    public void test1() {
        int[] result = {4, 1, 8};
        SnakeGame test = new SnakeGame(board1, 3, 3);
        assertArrayEquals(result, test.findTailExhaustive());
    }

    @Test
    // TESTING BOARD #1:
    // * Setting head: (3, 3)
    // Expecting Exhausted Checks: 22
    // TEST: PASSED
    // (Board reference at the top)
    // TEST DESCRIPTION: To test if the findTailExhaustive() method returns the correct number of exhaustive checks
    public void test2() {
        int expectedChecks = 22;
        SnakeGame test = new SnakeGame(board1, 3, 3);
        test.findTailExhaustive();
        assertEquals(expectedChecks, test.getExhastedChecks());
    }

    @Test
    // TESTING BOARD #2:
    // * Setting head: (1, 4)
    // * Expecting tail: (1, 0)
    // * Expecting length of snake: 7
    // TEST: PASSED
    // (Board reference at the top)
    // TEST DESCRIPTION: To test the basic functionality of the findTailExhausted() method via corners of a board
    public void test3() {
        int[] result = {1, 0, 7};
        SnakeGame test = new SnakeGame(board2, 1, 4);
        assertArrayEquals(result, test.findTailExhaustive());
    }

    @Test
    // TESTING BOARD #4:
    // * Setting head: (8, 5)
    // * Expecting tail: (4, 6)
    // * Expecting length of snake: 86
    // TEST: PASSED
    // (Board reference at the top)
    // TEST DESCRIPTION: To test the basic functionality of the findTailExhausted() method with a tricky and long pattern of the snake
    public void test4() {
        int[] result = {8, 5, 86};
        SnakeGame test = new SnakeGame(board4, 4, 6);
        assertArrayEquals(result, test.findTailExhaustive());
    }

    @Test
    // TESTING BOARD #6 (EDGE CASE):
    // * Setting head: (11, 13)
    // * Expecting tail: (17, 9)
    // * Expecting length of snake: 17
    // TEST: FAILED
    // (Board reference at the top)
    // TEST DESCRIPTION: To test the basic functionality of the findTailExhausted() method across a jagged board/field
    public void test5() {
        int[] result = {17, 9, 17};
        SnakeGame test = new SnakeGame(board6, 11, 13);
        assertArrayEquals(result, test.findTailExhaustive());
    }

    // *** TESTING RECURSIVE METHOD ***

    @Test
    // TESTING BOARD #1:
    // * Setting head: (3, 3)
    // * Expecting tail: (4, 1)
    // * Expecting length of snake: 8
    // TEST: PASSED
    // (Board reference at the top)
    // TEST DESCRIPTION: Essentially to test the basic functionality of the findTailRecursive() method
    public void test6() {
        int[] result = {4, 1, 8};
        SnakeGame test = new SnakeGame(board1, 3, 3);
        assertArrayEquals(result, test.findTailRecursive());
    }

    @Test
    // TESTING BOARD #1:
    // * Setting head: (3, 3)
    // Expecting Exhausted Checks: 7
    // TEST: PASSED
    // (Board reference at the top)
    // TEST DESCRIPTION: To test if the findTailRecursive() method returns the correct number of recursive checks
    public void test7() {
        int expectedChecks = 8;
        SnakeGame test = new SnakeGame(board1, 3, 3);
        test.findTailRecursive();
        assertEquals(expectedChecks, test.getRecursiveChecks());
    }

    @Test
    // TESTING BOARD #3:
    // * Setting head: (0, 4)
    // * Expecting tail: (4, 0)
    // * Expecting length of snake: 9
    // TEST: PASSED
    // (Board reference at the top)
    // TEST DESCRIPTION: Essentially to test the basic functionality of the findTailRecursive() method via escalator type snake
    public void test8() {
        int[] result = {4, 0, 9};
        SnakeGame test = new SnakeGame(board3, 0, 4);
        assertArrayEquals(result, test.findTailRecursive());
    }

    @Test
    // TESTING BOARD #5:
    // * Setting head: (0, 1)
    // * Expecting tail: (0, 19)
    // * Expecting length of snake: 29
    // TEST: PASSED
    // (Board reference at the top)
    // TEST DESCRIPTION: Essentially to test the basic functionality of the findTailRecursive() method given a oscillating long snake
    public void test9() {
        int[] result = {0, 19, 29};
        SnakeGame test = new SnakeGame(board5, 1, 0);
        assertArrayEquals(result, test.findTailRecursive());
    }

    @Test
    // TESTING BOARD #6 (EDGE CASE):
    // * Setting head: (11, 13)
    // * Expecting tail: (17, 9)
    // * Expecting length of snake: 17
    // TEST: FAILED
    // (Board reference at the top)
    // TEST DESCRIPTION: To test the basic functionality of the findTailRecursive() method across a jagged board/field
    public void test10() {
        int[] result = {17, 9, 17};
        SnakeGame test = new SnakeGame(board6, 11, 13);
        assertArrayEquals(result, test.findTailRecursive());
    }
}

