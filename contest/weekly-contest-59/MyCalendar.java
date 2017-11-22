import java.util.Map;
import java.util.TreeMap;

/**
 * @author Lillard
 */

class MyCalendar {

    private TreeMap<Integer, Integer> bookMap;

    public MyCalendar() {
        bookMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry leftRange = bookMap.lowerEntry(start);
        if (leftRange != null && (int)leftRange.getValue() > start) {
            return false;
        }

        Integer rightIndex = bookMap.higherKey(start - 1);
        if (rightIndex != null && rightIndex < end) {
            return false;
        }

        bookMap.put(start, end);

        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}