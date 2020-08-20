public class Tasks {

    public static void main(String[] a) {
        // Task 1: Calculate the sum of diagonal numbers for the given matrix
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("The sum of diagonal numbers for the matrix " + getMatrixAsString(matrix) + " is " + getDiagonalsSum(matrix));
        // Task 2: Sort the binary array
        int[] arr = {1, 1, 0, 0, 1, 0};
        System.out.println("The array before sorting is " + getArrayAsString(arr));
        sortArray(arr);
        System.out.println("The array after sorting is " + getArrayAsString(arr));
        // Task 3: Find the index of the row for the given matrix, which has maximum number of 1s
        int[][] binaryMatrix = {{0, 1, 0}, {1, 1, 1}, {0, 0, 1}};
        System.out.println("The row with max 1s has index " + getRowWithMax1s(binaryMatrix));
    }

    public static int getDiagonalsSum(final int[][] arr) {
        int sum = 0;
        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            sum += arr[i][j] + arr[arr.length - 1 - i][j];
        }
        return sum;
    }

    public static void sortArray(int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        while (first < last) {
            if (arr[first] == 0) {
                first++;
            } else if (arr[last] == 1) {
                last--;
            } else {
                arr[last] = 1;
                arr[first] = 0;
                first++;
                last--;
            }
        }
    }

    public static int getRowWithMax1s(final int[][] arr) {
        int max1sCount = 0;
        int rowIndexWithMax1s = 0;
        for (int i = 0; i < arr.length; i++) {
            int row1sCount = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0 && arr[i].length - 1 - j < max1sCount) {
                    break;
                }
                if (arr[i][j] == 1) {
                    row1sCount++;
                }
            }
            if (row1sCount > max1sCount) {
                max1sCount = row1sCount;
                rowIndexWithMax1s = i;
            }
        }
        return rowIndexWithMax1s;
    }

    public static String getArrayAsString(final int[] arr) {
        String arrayAsString = "{";
        for (int i = 0; i < arr.length; i++) {
            arrayAsString += arr[i];
            if (i != arr.length - 1) {
                arrayAsString += ",";
            }
        }
        arrayAsString += "}";
        return arrayAsString;
    }

    public static String getMatrixAsString(final int[][] matrix) {
        String matrixAsString = "{";
        for (int i = 0; i < matrix.length; i++) {
            matrixAsString += getArrayAsString(matrix[i]);
            if (i != matrix[i].length - 1) {
                matrixAsString += ",";
            }
        }
        matrixAsString += "}";
        return matrixAsString;
    }

}
