//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PQ pq = new PQ();

        pq.insert(5);
        pq.insert(15);
        pq.insert(3);
        pq.insert(20);

        System.out.println(pq.peekMax());
        System.out.println(pq.extractMax());
        System.out.println(pq.extractMax());
        System.out.println(pq.peekMax());

        System.out.println(pq.indexOf(5));
        pq.changeKey(0,6);
        System.out.println(pq.indexOf(6));
        System.out.println(pq.peekMax());
    }
}