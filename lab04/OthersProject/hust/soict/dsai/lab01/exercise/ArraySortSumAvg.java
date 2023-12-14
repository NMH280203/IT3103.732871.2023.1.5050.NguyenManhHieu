import java.util.Arrays;
//Nguyen Manh Hieu 20215050
public class ArraySortSumAvg {
    public static void main(String[] args) {
        // Define an array of numeric values
        double[] numbers = { 5.2, 1.7, 9.8, 2.4, 7.1 };

        // Sort the array in ascending order
        Arrays.sort(numbers);

        // Calculate the sum of array elements
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }

        // Calculate the average value
        double average = sum / numbers.length;

        // Display the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        // Display the sum and average
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
