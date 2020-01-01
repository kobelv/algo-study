package com.kobe.backtracking;

public class Calc8Queens {
    private final int ROW_SIZE = 8;
    private final int COLUMN_SIZE = 8;
    private int[] result = new int[ROW_SIZE];

    private void calc8Queens(int row){
        //递归终止条件
        if (row == ROW_SIZE){
            printResult();
            return;
        }

        for (int column = 0; column< COLUMN_SIZE; column++){
            if (isQualified(row, column)){
                //当前行已经标记完成，记录下来结果，递归开始下一行
                result[row] = column;
                calc8Queens(row+1);
            }
        }

    }

    private boolean isQualified(int row, int column) {
        //查找当前坐标行=row，列=column的位置是否符合要求
        //判断标准：以该点为出发点，判断三个方向上是否已经有满足要求的点了：
        int leftup = column-1;
        int rightup = column+1;
        for (int i=row-1; i>=0; i--){
            //垂直向上方向直到出界
            if (result[i] == column){
                return false;
            }

            //左上角方向直到出界
            if (leftup >=0 && result[i] == leftup){
                return false;
            }

            //右上角方向直到出界
            if (rightup<8 && result[i] == rightup){
                return false;
            }

            //左上&右上方向继续延伸
            leftup--;
            rightup++;
        }

        //没有找到不满足要求的情况，说明当前位置符合要求
        return true;
    }

    private void printResult() {
        System.out.println("========start======");
        for (int row=0; row<ROW_SIZE; row++){
            for (int column=0; column<COLUMN_SIZE; column++){
                if (result[row] == column){
                    System.out.print("Q ");
                } else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("========end========");
    }

    public static void main(String[] args) {
        Calc8Queens calc = new Calc8Queens();
        calc.calc8Queens(0);
    }
}
