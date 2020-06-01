package crypto.CipherAlgorithm;

public interface CipherAlgorithmIF {
    byte[] encrypt(byte[] plaintext);

    byte[] decrypt(byte[] ciphertext);
}