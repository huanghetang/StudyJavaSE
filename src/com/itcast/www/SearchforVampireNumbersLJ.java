package com.itcast.www;
//��������˳��˼ά����������λ�����ٲ�֣��ĸ����������ˣ����˻���ԭ����ȣ��������������Ϊһ����Ѫ�����֡�TMJG��Ӵ��в�ע��  
//��ʵsum�Ľ��Ϊ107976�Σ��ǳ����㷨Ч�ʺܵͣ����ҳ������ظ���6880 = 86 * 80��6880 = 80 * 86����TMJG��Ӵ��в�ע�� 
    public class SearchforVampireNumbersLJ {  
        public static int count = 0;// ��¼һ���ж��ٸ���Ѫ������  
        public static int k=0;//��¼�����ж϶��ٴ�  
        public static void main(String[] args) {  
            for (int i = 1001; i < 10000; i++) {  
                // �����������1100����ĩβ������2��0�ģ�������  
                if (i % 100 == 0) {  
                    continue;  
                }  
                // ��������ĸ���ֵλ�ϵ�����,�������Ǽٶ���λ����ʾΪabcd  
                int a = i / 1000;  
                int b = (i - a * 1000) / 100;  
                int c = (i - a * 1000 - b * 100) / 10;  
                int d = i - a * 1000 - b * 100 - c * 10;  
                // �ж��ĸ�λ�����Ƿ�������0���ڵ��������1010����������Щ��������ǧλ������Ϊ0�����ֻ��Ҫ�ж�������λ�Ƿ���2��0�����  
                // ��3��������2��0ʱ����Ȼ���ڡ�3����֮�͵�������ĳһ���������Դ���Ϊ�ж����ݣ�������λΪ0��Ҳ�Ѿ��ų�����ʵֻ��Ҫ�ж���1001����1010�����������  
                if (b + c + d == c || b + c + d == d) {  
                    continue;  
                }  
                // �ų�����������󣬿��Կ�ʼ��������Ѫ������ɸѡ��  
                // ��ôһ����12�������abcd,abdc,acbd,acdb,adbc,adcb,bacd,badc,bcda,bdca,cadb,cbda  
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
            System.out.println("��λ������Ѫ������һ����" + count + "����");  
            System.out.println("һ�������жϴ���Ϊ" + k);  
        }  
      
        //�ж��Ƿ���������  
        static  boolean search(int i, int a, int b, int c, int d) {  
            k++;  
            if ((a * 10 + b) * (c * 10 + d) == i) {  
                searchfor(i,a,b,c,d);//����������������ӡ���  
                return true;  
            }else{  
                return false;  
            }  
        }  
      
        //������������ӡ������ͳ�Ƹ���  
        static void searchfor(int i, int a, int b, int c, int d) {  
            count++;  
            System.out.println(i + "=" + (a * 10 + b) + "*" + (c * 10 + d));  
        }  
    }  