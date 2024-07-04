import java.util.*;

public class test {
    public static void main(String[] args) {
        List<List<Integer>> ll=new ArrayList<>();
        ll.add(new ArrayList<>());
        ll.get(0).add(1);
        System.out.println(ll);
        // List<Integer> ll = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    }
}
