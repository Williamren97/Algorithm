class Solution {
    public int mySqrt(int x) {
        // 找最大的ans，满足ans^2<=x
        return (int)(myRealSqrt(x));
    }

    // 实数二分模板
    // ans = realSqrt(x)
    // 如果要求4位小数，就多算2~4位，到1e-6或1e-8，保证精确
    double myRealSqrt(double x) {
        double left = 0, right = x;
        while (right - left > 1e-7) {
            double mid = (left + right) / 2;
            if (mid * mid <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
