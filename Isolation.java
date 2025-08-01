// �Ǹ��G108213010 �m�W�G�xޱ��
import java.util.Scanner;
public class Isolation {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        List allStu = new List(input.nextInt(), input);
        allStu.print(); // ��i�hprint�̭�
        allStu.filter().print(); // ����i�hfilter�̭�, �A��iprint�̭�
        allStu.find(input.next()).print();
    }
}
class Student {
    String name, id; // �W�r, �Ǹ�
    float tem; // �ū�(�p���I)
    int history; // �X��v
    public Student(String name, String id, float tem, int history) { // �غc�l
        this.name = name;
        this.id = id;
        this.tem = tem;
        this.history = history;
    }
    // ���L�X�Ҧ��ǥ͸��
    public void print() {
        System.out.println("- - - - �����ǥ� - - - -");
        System.out.println("�m�W	���	�X��v");
        System.out.println();
        System.out.println(name+"\t"+tem+"\t"+history);
    }
}
class List {
    // �Ф@�ӥsdata���ǥͦW��
    Student[] data;
    // �X�Ӿǥ�
    int len;
    // ���@��constructor
    // �ΨӱN��J�ǤJclass������l��class�ϥ�
    public List(int max) {
        data = new Student[max];
        len = 0;
    }
    public List(int max, Scanner input) { // �غc�l
        this(max); // call�ۤv��constructor, ���P��List(max),���o��u���this
        for (int i = 0; i < max; i++) {
            addStu(new Student(input.next(),input.next(),input.nextFloat(),input.nextInt()));
        }
    }
    // allStu(Student s) -> �ǤJ���A�� Student ������,�R�W�� s
    public void addStu(Student s) {
        data[len++] = s;
    }
    public void print() {
        // �L�X
        System.out.println("- - - - �j���W�� - - - -");
        System.out.println("�m�W	���	�X��v");
        System.out.println();
        
        for (int i = 0; i < len; i++) {
            data[i].print();
        }
    }
    public List filter() {
        List result = new List(len);
        for (int i = 0; i < len; i++) {
            // �p�G��ŶW�L37.4 �� ���X��v
            if (data[i].tem > 37.4 || data[i].history >= 1){
                result.addStu(data[i]);
            }
        }
        return result;
    }
    public Student find(String id) {
        for (int i = 0; i < len; i++) {
            if (data[i].id.equals(id)) {
                return data[i];
            }
        }
        // �p�G�b�T�w��J�������|���ŭȪ��ɭԥi�H����
        // �����J���ŭȨS��return null���ܴN���|���^�ǭ�
        return null;
    }
}