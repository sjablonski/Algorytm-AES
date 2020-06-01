package crypto.Cipher.Mode;

import crypto.Cipher.Cipher;
import crypto.CipherAlgorithm.CipherAlgorithmIF;

public class CBC extends Cipher {
    public CBC(CipherAlgorithmIF crypt) {
        super(crypt);
    }

    @Override
    public byte[] encrypt(byte[] input) {
        return crypt.encrypt(input);
    }
}
