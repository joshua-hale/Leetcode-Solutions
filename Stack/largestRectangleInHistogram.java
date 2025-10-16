import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = 0;
            if (i != heights.length) {
                h = heights[i];
            }

            while (!st.isEmpty() && h < heights[st.peek()]) {
                int height = heights[st.pop()];

                int leftBoundary;
                if (st.isEmpty()) {
                    leftBoundary = -1;
                } else {
                    leftBoundary = st.peek();
                }

                int width = i - leftBoundary - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}
