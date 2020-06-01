package crypto.CipherAlgorithm;

import crypto.CipherAlgorithm.AES.AES;
import crypto.Enums.Algorithm;

public class CipherAlgorithmFactory implements CipherAlgorithmFactoryIF {
    public CipherAlgorithmIF createCipherAlgorithm(Algorithm algorithm, byte[] key, int keyLength) {
        switch (algorithm) {
            case AES:
                return new AES(key, keyLength);
            default:
                return null;
        }
    }
}
