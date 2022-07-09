package lecture04;

import java.util.Arrays;
import java.util.Scanner;

public class E11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputArray = scanner.nextLine();
        int[] array = convertStringToIntArray(inputArray);

        String currentCommand = scanner.nextLine();
        while (!currentCommand.equals("end")) {
            commandDispatcher(currentCommand, array);

            currentCommand = scanner.nextLine();
        }
        printArray(array);
    }

    private static void commandDispatcher(String s, int[] arr) {

        if (s.contains("exchange")) {
            int index = getIndex(s);
            exchange(arr, index);
        } else if (s.contains("max") && s.contains("even")) {
            maxEven(arr);
        } else if (s.contains("min") && s.contains("even")) {
            minEven(arr);
        } else if (s.contains("max") && s.contains("odd")) {
            maxOdd(arr);
        } else if (s.contains("min") && s.contains("odd")) {
            minOdd(arr);
        } else if (s.contains("first") && s.contains("even")) {
            int index = getIndex(s);
            firstNEven(arr, index);
        } else if (s.contains("last") && s.contains("even")) {
            int index = getIndex(s);
            lastNEven(arr, index);
        } else if (s.contains("first") && s.contains("odd")) {
            int index = getIndex(s);
            firstNOdd(arr, index);
        } else if (s.contains("last") && s.contains("odd")) {
            int index = getIndex(s);
            lastNOdd(arr, index);
        }
    }

    public static int[] convertStringToIntArray(String s) {
        if (s.equals("")) {
            return new int[0];
        }
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void exchange(int[] arr, int index) {
        if (index < 0 || index > arr.length - 1) {
            System.out.println("Invalid index");
            return;
        }
        int[] arr1 = Arrays.copyOf(arr, index + 1);
        int[] arr2 = Arrays.copyOfRange(arr, index + 1, arr.length);
        System.arraycopy(arr2, 0, arr, 0, arr2.length);
        System.arraycopy(arr1, 0, arr, arr.length - index - 1, arr1.length);
    }

    public static void maxEven(int[] arr) {
        int value = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value && arr[i] % 2 == 0) {
                value = arr[i];
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("No matches");
            return;
        }
        System.out.println(index);
    }

    public static void minEven(int[] arr) {
        int value = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= value && arr[i] % 2 == 0) {
                value = arr[i];
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("No matches");
            return;
        }
        System.out.println(index);
    }

    public static void maxOdd(int[] arr) {
        int value = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value && arr[i] % 2 != 0) {
                value = arr[i];
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("No matches");
            return;
        }
        System.out.println(index);

    }

    public static void minOdd(int[] arr) {
        int value = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= value && arr[i] % 2 != 0) {
                value = arr[i];
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("No matches");
            return;
        }
        System.out.println(index);
    }

    public static void firstNOdd(int[] arr, int count) {
        if (count > arr.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] odds = new int[0];
        for (int j : arr) {
            if (j % 2 != 0) {
                int[] newArr = Arrays.copyOf(odds, odds.length + 1);
                newArr[newArr.length - 1] = j;
                odds = newArr;
                if (odds.length == count) {
                    break;
                }
            }
        }
        printArray(odds);
    }

    public static void firstNEven(int[] arr, int count) {
        if (count > arr.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] evens = new int[0];
        for (int j : arr) {
            if (j % 2 == 0) {
                int[] newArr = Arrays.copyOf(evens, evens.length + 1);
                newArr[newArr.length - 1] = j;
                evens = newArr;
                if (evens.length == count) {
                    break;
                }
            }
        }
        printArray(evens);
    }

    public static void lastNOdd(int[] arr, int count) {
        if (count > arr.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] odds = new int[0];
        arr = reverseArray(arr);
        for (int j : arr) {
            if (j % 2 != 0) {
                int[] newArr = Arrays.copyOf(odds, odds.length + 1);
                newArr[newArr.length - 1] = j;
                odds = newArr;
                if (odds.length == count) {
                    break;
                }
            }
        }
        odds = reverseArray(odds);
        printArray(odds);
    }

    public static void lastNEven(int[] arr, int count) {
        if (count > arr.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] evens = new int[0];
        arr = reverseArray(arr);
        for (int j : arr) {
            if (j % 2 == 0) {
                int[] newArr = Arrays.copyOf(evens, evens.length + 1);
                newArr[newArr.length - 1] = j;
                evens = newArr;
                if (evens.length == count) {
                    break;
                }
            }
        }
        evens = reverseArray(evens);
        printArray(evens);
    }

    public static int[] reverseArray(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - i - 1];
        }
        return newArr;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int getIndex(String s) {
        String[] arr = s.split(" ");
        return Integer.parseInt(String.valueOf(arr[1]));
    }
}
