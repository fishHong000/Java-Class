public class zimishu {
    public static void main(String args[]) {
        //﹚竡ぶ计
        int l = 7;
        //癹伴﹚竡计眖3l
        for (int k = 3; k <= l; k++) {//沮kㄓ﹚竡絛瞅,k=3,100-1000ぇず,ㄌΩ患糤
            for (int i = (int) Math.pow(10, k - 1); i < Math.pow(10, k); i++) {
                long sum = 0;//ゲ斗睲箂,–Ω计常琌ぃ妓
                long num = 0;//ゲ斗睲箂,–Ω计常琌ぃ妓
                //﹚竡计竚计,沮k计﹚竡皚,祇ネ犯钵盽
                int array[] = new int[k];
            }
        }
        for (int j = 0; j < k; j++) {
            //硄筁癹伴皚―κ单竚计结
            array[j] = i / (int) Math.pow(10, j) % 10;
            sum += Math.pow(array[j], k);//–竚经羆㎝
            num += array[j] * Math.pow(10, j);//–竚计舱Θ计
        }
        if (sum == num) {
            System.out.print(num + " ");
        }
    }
}