package crypto.Cipher;

import crypto.CipherAlgorithm.CipherAlgorithmIF;
import crypto.Enums.CipherMode;

public interface CipherFactoryIF {
    Cipher createCipher(CipherMode mode, CipherAlgorithmIF crypt);
}
