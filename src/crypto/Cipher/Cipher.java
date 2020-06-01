package crypto.Cipher;

import crypto.CipherAlgorithm.CipherAlgorithmIF;

public abstract class Cipher {
    protected CipherAlgorithmIF crypt;

    protected Cipher(CipherAlgorithmIF crypt) {
        this.crypt = crypt;
    }

    abstract public byte[] encrypt(byte[] input);
}
