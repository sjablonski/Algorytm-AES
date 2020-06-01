package crypto.CipherAlgorithm.DES;

public class DES {
//    private byte[] subkeys;
//    private DESTables tab;
//
//    public DES(byte[] key) {
//        this.tab = new DESTables();
//        this.subkeys = keyExpansion(key);
//    }
//
////    String hextoBin(String input)
////    {
////        int n = input.length() * 4;
////        input = Long.toBinaryString(
////                Long.parseUnsignedLong(input, 16));
////        while (input.length() < n)
////            input = "0" + input;
////        return input;
////    }
////
////    // binary to hexadecimal conversion
////    String binToHex(String input)
////    {
////        int n = (int)input.length() / 4;
////        input = Long.toHexString(
////                Long.parseUnsignedLong(input, 2));
////        while (input.length() < n)
////            input = "0" + input;
////        return input;
////    }
//
//    byte[] permutation(int[] sequence, byte[] input) {
//        byte[] output = new byte[sequence.length];
//        // błąd bo chodzi o to że input ma 8 bajtów a musi być 56 bitów
//        for (int i = 0; i < sequence.length; i++)
//            output[i] = input[sequence[i] - 1];
//        return output;
//    }
//
//    String xor(String a, String b) {
//        long t_a = Long.parseUnsignedLong(a, 16);
//        long t_b = Long.parseUnsignedLong(b, 16);
//        t_a = t_a ^ t_b;
//        a = Long.toHexString(t_a);
//        while (a.length() < b.length())
//            a = "0" + a;
//        return a;
//    }
//
//    byte[] leftCircularShift(byte[] input, int numBits) {
//        int n = input.length * 4;
//        int[] perm = new int[n];
//        for (int i = 0; i < n - 1; i++)
//            perm[i] = (i + 2);
//        perm[n - 1] = 1;
//        while (numBits-- > 0)
//            input = permutation(perm, input);
//        return input;
//    }
//
//    public byte[] getSliceOfArray(byte[] arr, int start, int end)
//    {
//        // Get the slice of the Array
//        byte[] slice = new byte[end - start];
//
//        // Copy elements of arr to slice
//        for (int i = 0; i < slice.length; i++) {
//            slice[i] = arr[start + i];
//        }
//        // return the slice
//        return slice;
//    }
//
//    byte[][] keyExpansion(byte[] key) {
//        byte[][] keys = new byte[16][12];
//        key = permutation(tab.PC1, key);
//        for (int i = 0; i < 16; i++) {
//            byte[] first = getSliceOfArray(key, 0, 7);
//            byte[] second = getSliceOfArray(key, 7, 14);
//            first = leftCircularShift(first, tab.shiftBits[i]);
//            second = leftCircularShift(second, tab.shiftBits[i]);
//            System.arraycopy(first, 0, key, 0, 7);
//            System.arraycopy(second, 0, key, 7, 14);
//            keys[i] = permutation(tab.PC2, key);
//        }
//        return keys;
//    }
//
//    String sBox(String input) {
//        String output = "";
//        input = hextoBin(input);
//        for (int i = 0; i < 48; i += 6) {
//            String temp = input.substring(i, i + 6);
//            int num = i / 6;
//            int row = Integer.parseInt(
//                    temp.charAt(0) + "" + temp.charAt(5), 2);
//            int col = Integer.parseInt(
//                    temp.substring(1, 5), 2);
//            output += Integer.toHexString(
//                    sbox[num][row][col]);
//        }
//        return output;
//    }
//
//    String round(String input, String key, int num) {
//        // fk
//        String left = input.substring(0, 8);
//        String temp = input.substring(8, 16);
//        String right = temp;
//        // Expansion permutation
//        temp = permutation(EP, temp);
//        // xor temp and round key
//        temp = xor(temp, key);
//        // lookup in s-box table
//        temp = sBox(temp);
//        // Straight D-box
//        temp = permutation(P, temp);
//        // xor
//        left = xor(left, temp);
//        System.out.println("Round "
//                + (num + 1) + " "
//                + right.toUpperCase()
//                + " " + left.toUpperCase() + " "
//                + key.toUpperCase());
//
//        // swapper
//        return right + left;
//    }
//
//    String encrypt(String plaintext, String key) {
//        int i;
//
//        // initial permutation
//        plainText = permutation(IP, plainText);
//
//        // 16 rounds
//        for (i = 0; i < 16; i++) {
//            plainText = round(plainText, keys[i], i);
//        }
//
//        // 32-bit swap
//        plainText = plainText.substring(8, 16) + plainText.substring(0, 8);
//
//        // final permutation
//        plainText = permutation(tab.IP1, plainText);
//        return plainText;
//    }
//
//    String decrypt(String ciphertext, String key) {
//        int i;
//
//        // initial permutation
//        plainText = permutation(tab.IP, plainText);
//
//        // 16-rounds
//        for (i = 15; i > -1; i--) {
//            plainText = round(plainText, keys[i], 15 - i);
//        }
//
//        // 32-bit swap
//        plainText = plainText.substring(8, 16) + plainText.substring(0, 8);
//        plainText = permutation(tab.IP1, plainText);
//        return plainText;
//    }
}