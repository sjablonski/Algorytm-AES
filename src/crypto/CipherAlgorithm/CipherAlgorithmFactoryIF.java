package crypto.CipherAlgorithm;

import crypto.Enums.Algorithm;

public interface CipherAlgorithmFactoryIF {
    CipherAlgorithmIF createCipherAlgorithm(Algorithm algorithm, byte[] key, int keyLength);
}
