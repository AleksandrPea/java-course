package com.apea.training.ecourse.homework1.task5;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Base64;

public class RSA {
    private BigInteger n;
    private BigInteger d;
    private BigInteger e;

    private int bitlen = 1024;

    /** @see RSAFactory#createRSA(BigInteger, BigInteger) */
    private RSA(BigInteger newn, BigInteger newe) {
        n = newn;
        e = newe;
    }

    /** @see RSAFactory#createRSA(int) */
    private RSA(int bits) {
        bitlen = bits;
        generateKeys();
    }

    /**
     * @param originalMsg plain text in ASCII
     * @return encrypted text in Base64
     */
    public String encryptBase64(String originalMsg) {
        return Base64.getEncoder().encodeToString(
                encrypt(new BigInteger(originalMsg.getBytes())).toByteArray());
    }

    /**
     * @return encrypted bytes
     */
    public BigInteger encrypt(BigInteger originalBytes) {
        return originalBytes.modPow(e, n);
    }


    /**
     * @param encrMsg encrypted text in Base64
     * @return decrypted text in ASCII.
     */
    public String decryptBase64(String encrMsg) {
        return new String(
                decrypt(new BigInteger(Base64.getDecoder().decode(encrMsg))).toByteArray());
    }

    /**
     * @return decrypted bytes.
     */
    public BigInteger decrypt(BigInteger encrBytes) {
        if (d == null) {
           throw new IllegalStateException("This rsa client can't decrypt");
        }
        return encrBytes.modPow(d, n);
    }

    public void generateKeys() {
        BigInteger[] arr = generateModulusAndFunc(bitlen);
        n = arr[0];
        arr = generateOpenAndSecretExp(arr[1]);
        e = arr[0];
        d = arr[1];
    }

    /**
     * @param eulerFunc value of euler function from modulus
     * @return [0] - open exponent, [1] = secret exponent
     */
    public static BigInteger[] generateOpenAndSecretExp(BigInteger eulerFunc) {
        BigInteger openE = new BigInteger("3");
        while (eulerFunc.gcd(openE).intValue() > 1) {
            openE = openE.add(new BigInteger("2"));
        }
        BigInteger secretE = openE.modInverse(eulerFunc);
        return new BigInteger[]{openE, secretE};
    }

    /**
     * @param bits modulus length
     * @return [0] - modulus, [1] = Euler's function from modulus
     */
    public static BigInteger[] generateModulusAndFunc(int bits) {
        BigInteger[] result = new BigInteger[2];
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bits / 2, 100, r);
        BigInteger q = new BigInteger(bits / 2, 100, r);
        result[0] = p.multiply(q);
        result[1] = (p.subtract(BigInteger.ONE)).multiply(q
                .subtract(BigInteger.ONE));
        return result;
    }

    /** @return modulus */
    public  BigInteger getN() {
        return n;
    }

    /** @return open exponent. */
    public BigInteger getE() {
        return e;
    }

    public static class RSAFactory {

        private RSAFactory() {}

        /** Create an instance that can encrypt using someone elses public key. */
        public static RSA createRSA(BigInteger newn, BigInteger newe) {
            if (newn == null || newe == null) {
                throw new NullPointerException("Some of the parameters is null");
            }
            return new RSA(newn, newe);
        }

        /** Create an instance that can both encrypt and decrypt. */
        public static RSA createRSA(int bits) {
            if (bits <= 0) {
                throw new IllegalArgumentException("Bits can't be <= 0");
            }
            return new RSA(bits);
        }
    }
}
