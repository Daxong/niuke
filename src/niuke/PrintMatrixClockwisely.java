package niuke;

/**
 * 顺时针打印矩阵
 */
public class PrintMatrixClockwisely {
    public static void main(String[] args) {
        int[][] numbers = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        new PrintMatrixClockwisely().printMatrixClockwisely(numbers);
    }
    //挨圈打印
    public void printMatrixClockwisely(int[][] numbers){
        int columns = numbers.length;
        int rows    = numbers[0].length;
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printMatrixCircle(numbers, columns, rows, start);
            start++;
        }
    }
    //打印一圈
    public void printMatrixCircle(int[][] numbers, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印第一行
        for (int i = start; i <= endX; i++) {
            int number = numbers[start][i];
            System.out.println(number);
        }
        //从上到下
        if (start < endY) {
            for (int i = start+1; i <= endY; i++) {
                //变行（row）不变列（columns）
                int number = numbers[i][endX];
                System.out.println(number);
            }
        }
        //从右到左
        if (start < endX && start < endY) {
            for (int i = endX-1; i >= start; i--) {
                int number = numbers[endY][i];
                System.out.println(number);
            }
        }
        //从下到上
        if (start < endX-1 && start < endY -1) {
            for (int i = endY-1; i >= start+1; i--) {
                int number = numbers[i][start];
                System.out.println(number);
            }
        }

    }
}
