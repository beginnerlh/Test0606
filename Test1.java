/*
题目描述
洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，
从上到下依次是第1张，第2张，第3张一直到第2n张。首先，我们把这2n张牌分成两堆，
左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。接着就开始洗牌的过程，
先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，
再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。接着把牌合并起来就可以了。
 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。
 在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，
 我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。
  现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。

输入描述:
第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，
接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
输出描述:
对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
示例1
输入
3 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1
输出

1 4 2 5 3 6
1 5 4 3 2 6
1 1 1 1
        */
package bishi0605;

//洗牌
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//T组
        while(T>0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] num1 = new int[n];
            int[] num2 = new int[n];
            for(int i = 0;i<n;i++){
                num1[i] = sc.nextInt();
            }
            for(int i = 0;i<n;i++){
                num2[i] = sc.nextInt();
            }
            int[] nums = new int[2*n];
            for(int i = 0;i<k;i++){
                fanZhuan(num1,num2,n,nums);
            }
            for(int i = 0;i<2*n;i++){
                if(i == 2*n-1){
                    System.out.print(nums[i]);
                }else{
                    System.out.print(nums[i]);
                    System.out.print(" ");
                }
            }
            T--;
            if(T > 0){
                System.out.println();
            }
        }

    }
    public static void fanZhuan(int[] num1,int[] num2,int n,int[] nums){
        for(int i = 0;i<n;i++){
            nums[2*i] = num1[i];
        }
        for(int i = 0;i<n;i++){
            nums[2*i +1] = num2[i];
        }
        for(int i = 0;i<2*n;i++){
            if(i<n){
                num1[i] = nums[i];
            }else{
                num2[i-n] = nums[i];
            }
        }
    }
}