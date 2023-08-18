# Wheels Burrow Data Compressor
This algorith is an implementation of the Wheels Burrow Data Compressor,
popularly used in compression technologies such as **gzip**. This implementation
is built on top of the shoulders of the Giants Robert Sedgewick and Kevin Wayne,
namely their Huffman Encoding algorithm.

To use this compressor, you can type in the following commands:
`
java-algs4 BurrowsWheeler - < abra.txt | java-algs4 edu.princeton.cs.algs4.HexDump 16
``

This should give an output such as:
``
00 00 00 03 41 52 44 21 52 43 41 41 41 41 42 42
128 bits
``
