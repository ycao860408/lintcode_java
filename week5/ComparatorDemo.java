import java.util.*;

public class ComparatorDemo{
    static class NewComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b.intValue() - a.intValue();
        }
    }
    
    public static void main(String args[]) {
        Integer [] arr = {6,4,5,7,2,4,3,4,7,8};
        Integer [] arr2 = {6,4,5,7,2,4,3,4,7,8};
        Arrays.sort(arr, Collections.reverseOrder());
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        List<Integer> al = new ArrayList<>();
        al.add(6);
        al.add(4);
        al.add(5);
        al.add(7);
        al.add(2);
        al.add(4);
        al.add(3);
        al.add(4);
        al.add(7);
        al.add(8);
        
        //Collections.sort(al, new NewComparator());
        Collections.sort(al, Collections.reverseOrder());
        for (int num : al) {
            System.out.print(num + " ");
        }
    }
}