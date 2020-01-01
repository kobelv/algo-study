package com.kobe.backtracking;

public class Bag0Or1 {
    int ITEMS_COUNT;
    int TOTAL_WEIGHT;
    int[] items_weight;
    int maxWeight;

    public Bag0Or1(int item_count, int total_wight, int[] items_weight){
        this.ITEMS_COUNT = item_count;
        this.TOTAL_WEIGHT = total_wight;
        this.items_weight = new int[item_count];
        this.items_weight = items_weight;
    }
    public void packBagByBackTracking(int i, int cumulatedWeight){
        //终止条件1：包里装满了
        //终止条件2：已经考察过所有物品了
        if (cumulatedWeight == TOTAL_WEIGHT || i == ITEMS_COUNT){
            maxWeight = cumulatedWeight;
            return;
        }

        //对一个物品而言有两种选择，要么不装，要么装。先试试不装的情况，如果不符合要求再回溯
        packBagByBackTracking(i+1, cumulatedWeight);
        if (cumulatedWeight + items_weight[i] <= TOTAL_WEIGHT){
            //要么把当前物品装进去
            packBagByBackTracking(i+1, cumulatedWeight+items_weight[i]);
        }
    }

    /**
     * 动态规划思想：
     * 牺牲空间把所有可能的情况都穷举出来并保存下来，最后遍历出最优的那个解
     *
     * @return
     */
    public int packBagByDP(){
        boolean[][] results = new boolean[ITEMS_COUNT][TOTAL_WEIGHT+1];

        //初始化第一个物品的情况
        //放入第一个物品
        results[0][0] = true;
        //不放入第一个物品
        if (items_weight[0] <= maxWeight){
            results[0][items_weight[0]] = true;
        }

        //逐个考虑放入或者不放入第i个物品的情况
        for (int i=1; i<ITEMS_COUNT; i++){
            //不放入：即保持已经放入i-1个物品的情况
            for (int j=0; j<TOTAL_WEIGHT; j++){
                //遍历前一行有效的状态，复制到当前物品所在的行
                if (results[i-1][j]){
                    results[i][j] = results[i-1][j];
                }
            }

            //放入：即在原来已经放入i-1个物品的情况下，加上当前物品的重量
            for (int j=0; j<=TOTAL_WEIGHT-items_weight[i]; j++){
                //遍历前一行有效的状态，复制到当前物品所在的行
                if (results[i-1][j]){
                    results[i][j+items_weight[i]] = true;
                }
            }
        }

        //输出结果，最后一行上的最后一个有效转态就是最优解
        for (int i=TOTAL_WEIGHT; i>0; i--){
            if (results[ITEMS_COUNT-1][i]) return i;
        }

        return 0;
    }

    /**
     * 动态规划思想：
     * 空间优化：从二维数组改为一维数组
     * @return
     */
    public int packBagByDPOptimzed(){
        boolean[] results = new boolean[TOTAL_WEIGHT+1];

        //初始化第一个物品的情况
        //放入第一个物品
        results[0] = true;
        //不放入第一个物品
        if (items_weight[0] <= maxWeight){
            results[items_weight[0]] = true;
        }

        //逐个考虑放入或者不放入第i个物品的情况
        for (int i=1; i<ITEMS_COUNT; i++){
            //放入：即在原来已经放入i-1个物品的情况下，加上当前物品的重量
            for (int j=TOTAL_WEIGHT-items_weight[i]; j>=0; j--){
                //遍历前一行有效的状态，复制到当前物品所在的行
                if (results[j]){
                    results[j+items_weight[i]] = true;
                }
            }
        }

        //输出结果，最后一行上的最后一个有效转态就是最优解
        for (int i=TOTAL_WEIGHT; i>=0; i--){
            if (results[i]) return i;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] weights = {50,60,12,55,54,30,45};
        Bag0Or1 bag = new Bag0Or1(7, 100, weights);
        bag.packBagByBackTracking(0,0);
        System.out.println(bag.maxWeight);

        System.out.println(bag.packBagByDP());
        System.out.println(bag.packBagByDPOptimzed());
    }
}
