package zw.suanfa;

public class SuanFaStudy {

    /**
     * 用于测试各个经典算法
     * 
     * @param args
     */
    public static void main(String[] args) {

	// 测试交换算法
	int n1 = 100;
	int n2 = 60;
	System.out.println("交换前： " + "n1=" + n1 + ";" + "n2=" + n2);// n1=100
								    // n2=60

	// 此种方法可以将中间量看成空杯，即把temp看成是空杯,把n1看成是装有白酒的杯子，把n2看成是装有红酒的杯子。
	// int temp = n1 把白酒倒到空杯中，此时temp装有白酒，n1变成空杯; 
	// n1 = n2 把n2中的红酒倒到n1空杯中，此时n1装有红酒，n2变成空杯; 
	// n2 = temp 把白酒倒到n2空杯中，此时n1装有红酒，n2装有白酒，实现n1和n2的互换.
	int temp = n1;
	n1 = n2;
	n2 = temp;

	System.out.println("交换后： " + "n1=" + n1 + ";" + "n2=" + n2);// n1=60
	System.out.println();
	
	// 测试冒泡排序
	int[] bb = { 1, 7, 3, 4, 6, 2, 5, 8, 11, 9, 10 };
	int[] result = bubbleSort(bb);
	for (int num : result)
	    System.out.print(num + " ");
	
	System.out.println();
	System.out.println();
	
	//打印九九乘法表
	nineNine();
    }

    /**
     * 冒泡排序 N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句。
     * 外层控制循环多少趟(N-1)，内层控制每一趟的循环次数(N-i)
     * 
     * @param cc
     */
    public static int[] bubbleSort(int[] cc) {

	for (int i = 0; i < cc.length - 1; i++) {// 外层循环控制排序趟数(N-1)
	    for (int j = 0; j < cc.length - 1 - i; j++) {// 内层循环控制每一趟排序多少次(N-i),-1为了防止溢出
		if (cc[j] > cc[j + 1]) {
		    // 交换
		    int temp = cc[j];
		    cc[j] = cc[j + 1];
		    cc[j + 1] = temp;
		}
	    }
	}
	return cc;
    }

    /**
     * 99乘法表
     * 双重for循环 
     * 结果：
     * 1*1=1
     * 2*1=2 2*2=4
     * 3*1=3 3*2=6 3*3=9
     * ...
     * 9*1=9 9*2=18 9*3=27 9*4=36 9*5=45 9*6=54	9*7=63 9*8=72 9*9=81 
     */
    public static void nineNine() {
	
	//外层一共循环9次
	for (int i = 1; i <= 9; i++) {
	    //外层每循环1次，内层循环i次
	    for (int j = 1; j <= i; j++) {
		System.out.print(i + "*" + j + "=" + i * j + '\t');
	    }
	    System.out.println();
	}
    }

}
