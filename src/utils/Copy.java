package utils;

public class Copy {
    private static final int Nb = 4;

    public static void copy(byte[][] state, byte[] in) {
        int inLoc = 0;
        for (int c = 0; c < Nb; c++)
            for (int r = 0; r < 4; r++)
                state[r][c] = in[inLoc++];
    }

    public static void copy(byte[] out, byte[][] state) {
        int outLoc = 0;
        for (int c = 0; c < Nb; c++)
            for (int r = 0; r < 4; r++)
                out[outLoc++] = state[r][c];
    }
}