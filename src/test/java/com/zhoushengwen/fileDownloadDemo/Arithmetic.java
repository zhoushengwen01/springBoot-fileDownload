package com.zhoushengwen.fileDownloadDemo;

import java.util.Scanner;

/*
5、 算法设计题目

        题目描述：
        大家知道，给出正整数n，则1到n这n个数可以构成n！种排列，把这些排列按照从小到大的顺序（字典顺序）列出，如n=3时，列出1 2 3，1 3 2，2 1 3，2 3 1，3 1 2，3 2 1六个排列。

        任务描述：
        给出某个排列，求出这个排列的下k个排列，如果遇到最后一个排列，则下1排列为第1个排列，即排列1 2 3…n。
        比如：n = 3，k=2 给出排列2 3 1，则它的下1个排列为3 1 2，下2个排列为3 2 1，因此答案为3 2 1。
        输入
        第一行是一个正整数m，表示测试数据的个数，下面是m组测试数据，每组测试数据第一行是2个正整数n( 1 <= n < 1024 )和k(1<=k<=64)，第二行有n个正整数，是1，2 … n的一个排列。
        输出
        对于每组输入数据，输出一行，n个数，中间用空格隔开，表示输入排列的下k个排列。
        样例输入
        3
        3 1
        2 3 1
        3 1
        3 2 1
        10 2
        1 2 3 4 5 6 7 8 9 10
        样例输出
        3 1 2
        1 2 3
        1 2 3 4 5 6 7 9 8 10
*/
public class Arithmetic {
    public static void main(String[] args) {
        int N;//输入测试的数据组数
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int i;
        int x, y;
        while (N > 0) {
            Scanner sc1 = new Scanner(System.in);
            x = sc.nextInt();
            Scanner sc2 = new Scanner(System.in);
            y = sc.nextInt();
            int a[] = new int[x];
            int b[] = new int[x];
            for (i = 0; i < x; i++) {
                Scanner sc3 = new Scanner(System.in);
                a[i] = sc.nextInt();
            }
            get(x, a, b);
            while (y - 1 > 0) {
                for (i = 0; i < x; i++) {
                    a[i] = b[i];
                }
                get(x, a, b);
                y--;
            }
            for (i = 0; i < x; i++) {
                System.out.printf(b[i] + "");
            }
            System.out.println();
            N--;
        }



    }

    public static void get(int z, int[] a, int[] y) {
        int i = 0, l = 0;
        int s = -1, p = 0;
        for (i = z - 1; i > 0; i--) {
            if (a[i - 1] < a[i]) {
                s = i - 1;
                l = i;
                break;
            }
        }
        if (s == -1) {
            for (i = 0; i < z; i++) {
                y[i] = i + 1;
            }

        } else {
            for (i = s + 1; i < z; i++) {
                if (a[i] > a[s]) {
                    if ((a[l] - a[s]) > (a[i] - a[s])) {
                        l = i;
                    }
                }
            }


            p = a[l];
            a[l] = a[s];
            a[s] = p;
            for (i = s + 1; i < (s + z) / 2 + 1; i++) {
                p = a[i];
                a[i] = a[z - i + s];
                a[z - i + s] = p;
            }
            for (i = 0; i < z; i++) {
                y[i] = a[i];
            }
        }
    }
}
