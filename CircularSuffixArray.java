/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class CircularSuffixArray {
    private final int n;
    private final String s;
    private final SuffixArray[] circularSuffixArray;

    private class SuffixArray {
        private final int start;

        public SuffixArray(int start) {
            this.start = start;
        }

        public char charAt(int i) {
            if (i >= s.length()) return s.charAt((start + i) % s.length());
            else return s.charAt((start + i) % s.length());
        }

        public int index() {
            return start;
        }
    }

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) throw new IllegalArgumentException("argument must not be null");
        this.s = s;
        n = s.length();

        circularSuffixArray = new SuffixArray[n];
        for (int i = 0; i < n; i++) {
            circularSuffixArray[i] = new SuffixArray(i);
        }

        sort(circularSuffixArray, n);
    }

    // length of s
    public int length() {
        return n;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= n)
            throw new IllegalArgumentException("argument must be between 0 and n - 1");
        return circularSuffixArray[i].index();
    }

    private void sort(SuffixArray[] a, int w) {
        int R = 256;
        SuffixArray[] aux = new SuffixArray[w];

        for (int d = w - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            for (int i = 0; i < n; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];
            for (int i = 0; i < n; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        String s = args[0];
        CircularSuffixArray circularSuffixArray = new CircularSuffixArray(s);
    }
}
