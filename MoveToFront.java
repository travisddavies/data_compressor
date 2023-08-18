/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;

public class MoveToFront {

    private static final int R = 256;


    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        ArrayList<Character> charOrder = new ArrayList<Character>();
        char[] index = new char[R];
        int[] st = new int[R];

        for (int i = 0; i < R; i++) {
            st[i] = i;
            index[i] = (char) i;
            charOrder.add((char) i);
        }
        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            BinaryStdOut.write((char) st[c]);
            int charIndex = st[c];

            for (int j = charIndex; j > 0; j--) {
                index[j] = index[j - 1];
                st[index[j]]++;
            }
            st[c] = 0;
            index[0] = c;
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        int[] st = new int[R];
        char[] index = new char[R];
        for (int i = 0; i < R; i++) {
            st[i] = i;
            index[i] = (char) i;
        }
        Queue<Character> q = new Queue<Character>();
        while (!BinaryStdIn.isEmpty()) {
            int charIndex = BinaryStdIn.readChar();
            char c = index[charIndex];
            q.enqueue(c);

            for (int j = charIndex; j > 0; j--) {
                index[j] = index[j - 1];
                st[index[j]]++;

            }
            st[charIndex] = 0;
            index[0] = c;
        }
        while (!q.isEmpty()) BinaryStdOut.write(q.dequeue());
        BinaryStdIn.close();
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) encode();
        if (args[0].equals("+")) decode();
    }
}
