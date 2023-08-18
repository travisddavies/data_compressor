/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdIn;

public class BurrowsWheeler {

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
        String s = StdIn.readAll();
        int n = s.length();
        int first = -1;
        CircularSuffixArray circularSuffixArray = new CircularSuffixArray(s);
        for (int i = 0; i < n; i++) {
            if (circularSuffixArray.index(i) == 0) {
                first = i;
                BinaryStdOut.write(first);
            }
        }
        for (int i = 0; i < n; i++) {
            BinaryStdOut.write(s.charAt((circularSuffixArray.index(i) + n - 1) % n));
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String s = BinaryStdIn.readString();

        int n = s.length();
        char[] a = new char[n];
        int[] next = new int[n];
        int R = 256;
        char[] aux = new char[n];
        int[] count = new int[R + 1];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i);
            next[i] = i;
        }
        for (int i = 0; i < n; i++)
            count[a[i] + 1]++;
        for (int r = 0; r < R; r++)
            count[r + 1] += count[r];
        for (int i = 0; i < n; i++) {
            aux[count[a[i]]] = a[i];
            next[count[a[i]]++] = i;
        }
        for (int i = 0; i < n; i++)
            a[i] = aux[i];

        int row = first;
        for (int i = 0; i < n; i++) {
            BinaryStdOut.write(a[row]);
            row = next[row];
        }
        BinaryStdIn.close();
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-")) transform();
        else if (args[0].equals("+")) inverseTransform();
    }
}
