class Solution {
    public double separateSquares(int[][] squares) {
        double EPS = 1e-5;
        double bottom = squares[0][1];
        double top = 0;

        for(int[] square : squares) {
            top = Math.max(top, square[1] + square[2]);
            bottom = Math.min(bottom, square[1]);
        }

        while(bottom + EPS <= top) {
            double mid = (bottom + top) / 2.0;
            if(check(squares, mid) > 0) bottom = mid;
            else top = mid;
        }

        return bottom;
    }

    public double check(int[][] squares, double line) {
        double above = 0;
        double below = 0;

        for(int[] square : squares) {
            int y = square[1];
            double l = (double) square[2];

            if (line <= y) {
                above += l * l;
            } else if (line >= y + l) {
                below += l * l;
            } else {
                above += l * (y + l - line);
                below += l * (line - y);
            }
        }

        return above - below;
    }
}
