import java.util.*;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        Deque<Integer> stack = new ArrayDeque<>(); 

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevDay = stack.pop();
                answer[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return answer;
    }
}
