package newbie.c24;


/**
 * 双端链表 , O(1)
 * 单链表不能实现，因为跳不回去，不能O(1)
 * 参考C24_2
 */
public class C24_Stub {
    private static class MyDeque<V> {



        void addToHead(V v) {

        }

        void addToTail(V v) {

        }

        V popFromHead() {
            return null;
        }

        V popFromTail() {

            return null;
        }
    }

    public static void main(String[] args) {
        MyDeque<Integer> dell = new MyDeque();
        dell.addToHead(1);
        dell.addToHead(2);
        dell.addToTail(3);
        dell.addToTail(4);
        System.out.println(dell.popFromHead());
        System.out.println(dell.popFromTail());
        System.out.println(dell.popFromHead());
        System.out.println(dell.popFromTail());

    }
}
