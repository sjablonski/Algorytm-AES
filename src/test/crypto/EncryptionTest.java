package test.crypto;

import crypto.Cipher.Cipher;
import crypto.Cipher.CipherFactory;
import crypto.Cipher.CipherFactoryIF;
import crypto.CipherAlgorithm.CipherAlgorithmFactory;
import crypto.CipherAlgorithm.CipherAlgorithmFactoryIF;
import crypto.CipherAlgorithm.CipherAlgorithmIF;
import crypto.Enums.Algorithm;
import crypto.Enums.CipherMode;
import utils.Print;

import java.util.Arrays;

public class EncryptionTest {
    public static void main(String[] args) {
        byte[] key = "Thats my Kung Fu".getBytes();
        byte[] plaintext = "Two One Nine Two".getBytes();
        int keyLength = 4;

        CipherAlgorithmFactoryIF algorithmFactory = new CipherAlgorithmFactory();
        CipherFactoryIF cipherFactory = new CipherFactory();
        CipherAlgorithmIF algorithm = algorithmFactory.createCipherAlgorithm(Algorithm.AES, key, keyLength);
        Cipher cipher = cipherFactory.createCipher(CipherMode.ECB, algorithm);

        Print.printArray("Encrypt", cipher.encrypt(plaintext));
    }
}