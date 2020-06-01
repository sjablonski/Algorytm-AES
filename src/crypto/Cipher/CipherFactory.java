package crypto.Cipher;

import crypto.Cipher.Mode.CBC;
import crypto.Cipher.Mode.ECB;
import crypto.CipherAlgorithm.CipherAlgorithmIF;
import crypto.Enums.CipherMode;

public class CipherFactory implements CipherFactoryIF {
    public Cipher createCipher(CipherMode mode, CipherAlgorithmIF crypt) {
        switch (mode) {
            case ECB:
                return new ECB(crypt);
            case CBC:
                return new CBC(crypt);
            default:
                return null;
        }
    }
}
