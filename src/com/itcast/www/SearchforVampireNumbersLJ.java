package com.itcast.www;
//本方法是顺向思维，即先有四位数，再拆分，四个数字组合相乘，若乘积与原数相等，则输出，并计算为一个吸血鬼数字。TMJG添加此行并注释  
//其实sum的结果为107976次，非常大，算法效率很低，并且出现了重复（6880 = 86 * 80，6880 = 80 * 86）。TMJG添加此行并注释 
    public class SearchforVampireNumbersLJ {  
        public static int count = 0;// 记录一共有多少个吸血鬼数字  
        public static int k=0;//记录调用判断多少次  
        public static void main(String[] args) {  
            for (int i = 1001; i < 10000; i++) {  
                // 如果数字是像1100这种末尾至少有2个0的，则跳过  
                if (i % 100 == 0) {  
                    continue;  
                }  
                // 获得数字四个数值位上的数字,这里我们假定四位数表示为abcd  
                int a = i / 1000;  
                int b = (i - a * 1000) / 100;  
                int c = (i - a * 1000 - b * 100) / 10;  
                int d = i - a * 1000 - b * 100 - c * 10;  
                // 判断四个位置上是否有两个0存在的情况，如1010，并跳过这些数，由于千位不可能为0，因此只需要判断另外三位是否有2个0的情况  
                // 当3个数中有2个0时，必然存在“3个数之和等于其中某一个数”，以此作为判断依据，而后两位为0的也已经排除，其实只需要判断如1001，和1010这种情况即可  
                if (b + c + d == c || b + c + d == d) {  
                    continue;  
                }  
                // 排除掉各种情况后，可以开始真正的吸血鬼数字筛选了  
                // 那么一共有12种情况：abcd,abdc,acbd,acdb,adbc,adcb,bacd,badc,bcda,bdca,cadb,cbda  
                if (search(i, a, b, c, d)) {  
                } else if (search(i, a, b, d, c)) {  
                } else if (search(i, a, c, b, d)) {  
                } else if (search(i, a, c, d, b)) {  
                } else if (search(i, a, d, b, c)) {  
                } else if (search(i, a, d, c, b)) {  
                } else if (search(i, b, a, c, d)) {  
                } else if (search(i, b, a, d, c)) {  
                } else if (search(i, b, c, d, a)) {  
                } else if (search(i, b, d, c, a)) {  
                } else if (search(i, c, a, d, b)) {  
                } else if (search(i, c, b, d, a)) {  
                }  
            }  
            System.out.println("四位数的吸血鬼数字一共有" + count + "个。");  
            System.out.println("一共调用判断次数为" + k);  
        }  
      
        //判断是否满足条件  
        static  boolean search(int i, int a, int b, int c, int d) {  
            k++;  
            if ((a * 10 + b) * (c * 10 + d) == i) {  
                searchfor(i,a,b,c,d);//如果满足条件，则打印结果  
                return true;  
            }else{  
                return false;  
            }  
        }  
      
        //满足条件即打印，并且统计个数  
        static void searchfor(int i, int a, int b, int c, int d) {  
            count++;  
            System.out.println(i + "=" + (a * 10 + b) + "*" + (c * 10 + d));  
        }  
    }  