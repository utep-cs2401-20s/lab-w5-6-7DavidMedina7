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
            {true, false, false, false, false},
            {true, false, false, false, false},
            {true, false, false, false, false},
            {true, false, false, false, false},
            {true, false, false, false, false},
    };

    @Test
    public void test1() {
        int[] result = {4, 1, 8};
        SnakeGame test = new SnakeGame(board1, 3, 3);
        assertArrayEquals(result, test.findTailExhaustive());
    }

    @Test
    public void test2() {
        int[] result = {1, 4, 7};
        SnakeGame test = new SnakeGame(board2, 1, 0);
        assertArrayEquals(result, test.findTailExhaustive());
    }

    @Test
    public void test3() {
        int[] result = {4, 0, 5};
        SnakeGame test = new SnakeGame(board3, 0, 0);
        assertArrayEquals(result, test.findTailExhaustive());
    }
}