package crypto.CipherAlgorithm.AES;

import crypto.CipherAlgorithm.CipherAlgorithmIF;

public class AES implements CipherAlgorithmIF {
    private final AESEncryption encryption;
    private final AESDecryption decryption;

    public AES(byte[] key, int keyLength) {
        encryption = new AESEncryption(key, keyLength);
        decryption = new AESDecryption(key, keyLength);
    }

    @Override
    public byte[] encrypt(byte[] plaintext) {
        return encryption.encrypt(plaintext);
    }

    @Override
    public byte[] decrypt(byte[] ciphertext) {
        return decryption.decrypt(ciphertext);
    }
}
