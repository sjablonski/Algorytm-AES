package crypto.CipherAlgorithm.AES;

import utils.Copy;

public class AESDecryption {
    private final int blockSize;
    private final int keyLength;
    private final int rounds;
    private int wCount;
    private byte[] w;
    private AESTables tab;

    public AESDecryption(byte[] key, int keyLength) {
        this.blockSize = 4;
        this.keyLength = keyLength;
        this.rounds = keyLength + 6;
        this.w = new byte[4 * blockSize * (rounds + 1)];
        this.tab = new AESTables();

        keyExpansion(key, w);
    }

    public byte[] decrypt(byte[] ciphertext) {
        wCount = 4 * blockSize * (rounds + 1);
        byte[] out = new byte[ciphertext.length];
        byte[][] state = new byte[4][blockSize];
        Copy.copy(state, ciphertext);
        InvAddRoundKey(state);
        for (int round = rounds - 1; round >= 1; round--) {
            InvShiftRows(state);
            InvSubBytes(state);
            InvAddRoundKey(state);
            InvMixColumns(state);
        }
        InvShiftRows(state);
        InvSubBytes(state);
        InvAddRoundKey(state);
        Copy.copy(out, state);
        return out;
    }

    private void keyExpansion(byte[] key, byte[] w) {
        byte[] temp = new byte[4];
        int j = 0;
        while (j < 4 * keyLength) {
            w[j] = key[j++];
        }
        int i;
        while (j < 4 * blockSize * (rounds + 1)) {
            i = j / 4;
            for (int iTemp = 0; iTemp < 4; iTemp++)
                temp[iTemp] = w[j - 4 + iTemp];
            if (i % keyLength == 0) {
                byte ttemp, tRcon;
                byte oldtemp0 = temp[0];
                for (int iTemp = 0; iTemp < 4; iTemp++) {
                    if (iTemp == 3) ttemp = oldtemp0;
                    else ttemp = temp[iTemp + 1];
                    if (iTemp == 0) tRcon = tab.Rcon(i / keyLength);
                    else tRcon = 0;
                    temp[iTemp] = (byte) (tab.SBox(ttemp) ^ tRcon);
                }
            } else if (keyLength > 6 && (i % keyLength) == 4) {
                for (int iTemp = 0; iTemp < 4; iTemp++)
                    temp[iTemp] = tab.SBox(temp[iTemp]);
            }
            for (int iTemp = 0; iTemp < 4; iTemp++)
                w[j + iTemp] = (byte) (w[j - 4 * keyLength + iTemp] ^ temp[iTemp]);
            j = j + 4;
        }
    }

    private void InvSubBytes(byte[][] state) {
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < blockSize; col++)
                state[row][col] = tab.invSBox(state[row][col]);
    }

    private void InvShiftRows(byte[][] state) {
        byte[] t = new byte[4];
        for (int r = 1; r < 4; r++) {
            for (int c = 0; c < blockSize; c++)
                t[(c + r) % blockSize] = state[r][c];
            for (int c = 0; c < blockSize; c++)
                state[r][c] = t[c];
        }
    }

    private void InvMixColumns(byte[][] s) {
        int[] sp = new int[4];
        byte b0b = (byte) 0x0b;
        byte b0d = (byte) 0x0d;
        byte b09 = (byte) 0x09;
        byte b0e = (byte) 0x0e;
        for (int c = 0; c < 4; c++) {
            sp[0] = tab.FFMul(b0e, s[0][c]) ^ tab.FFMul(b0b, s[1][c]) ^ tab.FFMul(b0d, s[2][c]) ^ tab.FFMul(b09, s[3][c]);
            sp[1] = tab.FFMul(b09, s[0][c]) ^ tab.FFMul(b0e, s[1][c]) ^ tab.FFMul(b0b, s[2][c]) ^ tab.FFMul(b0d, s[3][c]);
            sp[2] = tab.FFMul(b0d, s[0][c]) ^ tab.FFMul(b09, s[1][c]) ^ tab.FFMul(b0e, s[2][c]) ^ tab.FFMul(b0b, s[3][c]);
            sp[3] = tab.FFMul(b0b, s[0][c]) ^ tab.FFMul(b0d, s[1][c]) ^ tab.FFMul(b09, s[2][c]) ^ tab.FFMul(b0e, s[3][c]);
            for (int i = 0; i < 4; i++) s[i][c] = (byte) (sp[i]);
        }
    }

    private void InvAddRoundKey(byte[][] state) {
        for (int c = blockSize - 1; c >= 0; c--)
            for (int r = 3; r >= 0; r--)
                state[r][c] = (byte) (state[r][c] ^ w[--wCount]);
    }

}