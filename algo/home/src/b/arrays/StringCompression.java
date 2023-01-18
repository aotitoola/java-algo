package b.arrays;

public class StringCompression {

    // Used Kevin Naughton's video for intuition
    public int compress(char[] chars) {

        // create an index for updating chars array in place
        int index = 0;

        // use a 2 pointer approach to enumerate/ walk through the array
        int i = 0;
        int n = chars.length;

        // we do a while loop to go through till the end of the array
        while (i < n) {

            int j = i;
            while (j < n && chars[j] == chars[i]) {
                j++;
            }

            // here we check if the number of new characters in greater than 1
            if (j - i > 1) {
                chars[index] = chars[i];
                index++;

                String count = j - i + "";
                for (char x : count.toCharArray()) {
                    chars[index] = x;
                    index++;
                }
            } else {
                chars[index] = chars[i];
                index++;
            }
            i = j;
        }
        return index;
    }
}
