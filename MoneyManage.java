// ???:108213010 ?m?W:?x???
import java.util.Scanner;
class Wallet {
    String owner;
    int remain;
    public void spend(int money) {
        if (this.remain < money) {
            System.out.println("You don't have enough money to spend!");
        } else {
            this.remain -= money;
        }
    }
    public void earn(int money) {
        this.remain += money;
    }
    public int howMuch() {
        return this.remain;
    }
    public Wallet(String owner, int remain) {
        this.owner = owner;
        this.remain = remain;
    }
}
public class MoneyManage {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        String owner = input.next();
        int remain = input.nextInt();
        Wallet hanwei_s_wallet = new Wallet(owner, remain);
        System.out.println("=====?H?U????@???G=====");
        System.out.println("Owner" + hanwei_s_wallet.owner);
        System.out.println("Remain: "+ hanwei_s_wallet.remain);
        hanwei_s_wallet.earn(500);
        System.out.println("Remain: "+ hanwei_s_wallet.remain);
        hanwei_s_wallet.spend(5000);
        hanwei_s_wallet.spend(50);
        System.out.println("Remain: "+ hanwei_s_wallet.remain);
    }
}    