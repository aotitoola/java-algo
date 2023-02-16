package b.searchingAndSorting;

public class testt {


    public static void closestNumbers(List<Integer> numbers) {

        if (numbers.size() <= 1) {
            return;
        }

        Collections.sort(numbers);

        int minAbsDiff = Math.abs(numbers.get(1) - numbers.get(0));

        for (int i = 2; i < numbers.size(); i++) {
            int absDiff = Math.abs((numbers.get(i) - numbers.get(i - 1)));
            minAbsDiff = Math.min(absDiff, minAbsDiff);
        }

        for (int i = 1; i < numbers.size(); i++) {
            int absDiff = Math.abs((numbers.get(i) - numbers.get(i - 1)));
            if (absDiff == minAbsDiff) {
                if (numbers.get(i) < numbers.get(i-1)) {
                    System.out.println(numbers.get(i) + " " + numbers.get(i - 1));
                } else {
                    System.out.println(numbers.get(i - 1) + " " + numbers.get(i));
                }
            }
        }
    }

}


}
