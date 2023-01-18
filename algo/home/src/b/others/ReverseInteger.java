package b.others;

public class ReverseInteger {

    // Time Complexity: O(log(x)).. There are roughly log(x) digits in x.
    // Space Complexity: O(1)

    // We can build up the reversed integer one digit at a time
    // This method is called pop & push method

    // The idea is to pop the last digit off of the input
    // and push it to the back of the results

    // so we don't need to use an auxiliary stack/array, we can use math

    // pop operation
    // tail = input % 10;
    // input = input / 10;


    // push operation
    // result = result * 10 + tail

    public int reverse(int input) {

        // initialise the results to 0
        int result = 0;

        // we use a while loop to pop off all the numbers from the input
        while (input != 0) {

            // this will give us the last digit in the input (units). gives us only the remainder part.
            int tail = input % 10;

            // then we divide the input by 10 (floor division) to get rid of the last digit. returns the quotient
            input = input / 10;

            // because we need to assume that the environment does not allow us to store 64-bit integers (signed or unsigned).
            // If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

            // we need to check if this operation would cause an overflow
            // if the statement below cause an overflow, then it is because our result >= Integer.MAX_VALUE / 10
            // if the result is > Integer.MAX_VALUE / 10, then the operation will overflow

            // Long isn't 32-bit signed

            // however if result == Integer.MAX_VALUE / 10, then the operation below will overflow if tail > 7
            // the max value ends with a 7. i.e. 2,147,483,647
            // min value -2,147,483,648

            // Therefore,
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tail > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && tail > -8)) {
                return 0;
            }

            result = result * 10 + tail;
        }

        return result;
    }




    // we also check whether appending a digit would cause overflow
}
