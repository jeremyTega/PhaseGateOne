import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireDrillThreeTest {
    @Test
    public void takeArrayReturnArrayOfEvenArray() {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] expected = {1, 3, 5};

        int[] actual = FireDrillThree.taskFour(arr1);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void takeArrayReturnArrayOfOddArray() {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] expected = {2, 4, 6};

        int[] actual = FireDrillThree.taskFive(arr1);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void sumOfEvenNumberInArray() {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int expected =  9;

        int actual = FireDrillThree.taskSix(arr1);

        assertEquals(expected, actual);
    }

    @Test
    public void sumOfOddNumberArray() {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int expected =  12;

        int actual = FireDrillThree.taskSeven(arr1);

        assertEquals(expected, actual);
    }



}