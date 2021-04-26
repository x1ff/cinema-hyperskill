import java.util.*;

public class Main {

    private static int[] getFirstAndLast(int...inputArr) {
        int[] outArr = new int[2];
        outArr[0] = inputArr[0];
        outArr[1] = inputArr[inputArr.length - 1];
        return outArr;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = getFirstAndLast(array);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}