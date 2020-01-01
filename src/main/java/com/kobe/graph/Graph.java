package com.kobe.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private int nodeNum;
    //这是一个邻接表
    private LinkedList<Integer> items[];
    private boolean found = false;

    public Graph(int count){
        this.nodeNum = count;
        items = new LinkedList[nodeNum];
        for (int i=0; i<nodeNum; i++){
            items[i] = new LinkedList<>();
        }
    }
    private void addRelation(int from, int to){
        items[from].add(to);
        items[to].add(from);
    }

    public void bfsGraph(int from, int to){
        if (from == to){
            return;
        }

        //记录节点是否已经被访问过，避免重复访问
        boolean[] visited = new boolean[nodeNum];
        visited[from] = true;

        //prevNode[i]=j,记录当前节点i是从节点j过来的
        int[] prevNode = new int[nodeNum];
        for (int i=0; i<nodeNum; i++){
            prevNode[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        while (!queue.isEmpty()){
            int currentNode = queue.poll();
            for (int j=0; j<items[currentNode].size(); j++){
                int tmpNode = items[currentNode].get(j);
                if (visited[tmpNode]){
                    continue;
                }

                visited[tmpNode] = true;
                queue.add(tmpNode);
                prevNode[tmpNode] = currentNode;
                if (tmpNode == to){
                    //找到了，逆向打印搜索路径
                    printTrace(prevNode, from, to);
                }
            }
        }
    }

    public void dfsGraph(int from, int to){
        if (from == to){
            return;
        }

        //记录节点是否已经被访问过，避免重复访问
        boolean[] visited = new boolean[nodeNum];
        visited[from] = true;

        //prevNode[i]=j,记录当前节点i是从节点j过来的
        int[] prevNode = new int[nodeNum];
        for (int i=0; i<nodeNum; i++){
            prevNode[i] = -1;
        }

        recusiveDfs(from, to, prevNode, visited);
        printTrace(prevNode, from, to);
    }

    private void recusiveDfs(int from, int to, int[] prevNode, boolean[] visited) {
        if (found){
            return;
        }
        visited[from] = true;
        if (from == to){
            found = true;
            return;
        }
        for (int i=0; i<items[from].size(); i++){
            int tmp = items[from].get(i);
            if (!visited[tmp]){
                prevNode[tmp] = from;
                recusiveDfs(tmp, to, prevNode, visited);
            }
        }
    }

    private void printTrace(int[] prevNode, int from, int to) {
        if (prevNode[to] != -1 && to!= from){
            printTrace(prevNode, from, prevNode[to]);
        }

        System.out.println(to + "--");
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);

        g.addRelation(0,3);
        g.addRelation(0,1);
        g.addRelation(1,2);
        g.addRelation(1,4);
        g.addRelation(2,5);
        g.addRelation(3,4);
        g.addRelation(4,5);
        //g.addRelation(4,6);
        g.addRelation(5,7);
        g.addRelation(6,7);

        g.bfsGraph(0,7);
        g.dfsGraph(0,7);
    }
}
