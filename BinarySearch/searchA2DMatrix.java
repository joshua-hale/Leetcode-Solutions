class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nRows = matrix.length;
        if (nRows == 0) {
            return false;
        }
        int nCols = matrix[0].length;
        if (nCols == 0) {
            return false;
        }

        int left = 0;
        int right = nRows * nCols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / nCols;
            int col = mid % nCols;
            int val = matrix[row][col];

            if (target == val) {
                return true;
            } else if (target > val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
