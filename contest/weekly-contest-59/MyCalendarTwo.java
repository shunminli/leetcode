import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Lillard
 */
class MyCalendarTwo {

    private List<Pair<Integer, Integer>> bookedList;

    public MyCalendarTwo() {
        bookedList = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        List<Pair<Integer, Integer>> intersections = new ArrayList<>();
        for (Pair<Integer, Integer> pair : bookedList) {
            if (pair.getKey() < start && start < pair.getValue()) {
                intersections.add(pair);
            } else if (start <= pair.getKey() && pair.getKey() < end) {
                intersections.add(pair);
            }
        }

        if (!check(intersections)) {
            return false;
        }

        bookedList.add(new Pair<>(start, end));
        return true;
    }

    private boolean check(List<Pair<Integer, Integer>> intersections) {
        TreeMap<Integer, Integer> bookedMap = new TreeMap<>();
        for (Pair<Integer, Integer> pair : intersections) {
            int start = pair.getKey();
            int end = pair.getValue();
            Map.Entry<Integer, Integer> leftRange = bookedMap.lowerEntry(start);
            if (leftRange != null && leftRange.getValue() > start) {
                return false;
            }

            Integer rightIndex = bookedMap.higherKey(start - 1);
            if (rightIndex != null && rightIndex < end) {
                return false;
            }

            bookedMap.put(start, end);
        }

        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(50, 60)); // returns true
        System.out.println(myCalendar.book(10, 40)); // returns true
        System.out.println(myCalendar.book(5, 15)); // returns false
        System.out.println(myCalendar.book(5, 10)); // returns true
        System.out.println(myCalendar.book(25, 55)); // returns true
    }
}
