public class zimishu {
    public static void main(String args[]) {
        //�w�q�h�֦��
        int l = 7;
        //�j��w�q��Ʊq3��l��
        for (int k = 3; k <= l; k++) {//�ھ�k�����Ȩөw�q�d��,k=3,100-1000����,�̦����W
            for (int i = (int) Math.pow(10, k - 1); i < Math.pow(10, k); i++) {
                long sum = 0;//�����M�s,�C���Ʀr���O���@�˪�
                long num = 0;//�����M�s,�C���Ʀr���O���@�˪�
                //�w�q�ƪ��U�Ӧ�m���Ʀr,�ھ�k����Ʃw�q�}�C����,�H�K�o�ͷ��첧�`
                int array[] = new int[k];
            }
        }
        for (int j = 0; j < k; j++) {
            //�q�L�j��}�C�D�X�ӤQ�ʤd����m�W�Ʀr�ý��
            array[j] = i / (int) Math.pow(10, j) % 10;
            sum += Math.pow(array[j], k);//�C�Ӧ�m�W�����`�M
            num += array[j] * Math.pow(10, j);//�C�Ӧ�m�Ʀr�զ�����
        }
        if (sum == num) {
            System.out.print(num + " ");
        }
    }
}