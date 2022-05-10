package bit.easy.reverse_bits;

/**
 * LeetCode 190. Reverse Bits
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 190. Reverse Bits
 * @since 2022/5/10
 */
public class Solutions {
    public int reverseBits1(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }

    public int reverseBits2(int n) {
        // 01010101010101010101010101010101
        int M1 = 0x55555555;
        // 00110011001100110011001100110011
        int M2 = 0x33333333;
        // 00001111000011110000111100001111
        int M4 = 0x0f0f0f0f;
        // 00000000111111110000000011111111
        int M8 = 0x00ff00ff;
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }
}
