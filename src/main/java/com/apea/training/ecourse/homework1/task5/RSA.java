package com.apea.training.ecourse.homework1.task5;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class RSA {
    private BigInteger n;
    private BigInteger d;
    private BigInteger e;

    private int bitlen = 1024;

    /** Create an instance that can encrypt using someone elses public key. */
    public RSA(BigInteger newn, BigInteger newe) {
        n = newn;
        e = newe;
    }

    /** Create an instance that can both encrypt and decrypt. */
    public RSA(int bits) {
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
     *
     * @param encrMsg encrypted text in Base64
     * @return decrypted text in ASCII.
     * If this RSA-client can't decrypt it returns random text.
     */
    public String decryptBase64(String encrMsg) {
        return new String(
                decrypt(new BigInteger(Base64.getDecoder().decode(encrMsg))).toByteArray());
    }

    /**
     * @return decrypted bytes.
     * If this RSA-client can't decrypt it returns rubbish bytes.
     */
    public BigInteger decrypt(BigInteger encrBytes) {
        BigInteger result;
        if (d != null) {
           result = encrBytes.modPow(d, n);
        } else {
            result = new BigInteger(encrBytes.bitLength(), new Random());
        }
        return result;
    }

    public void generateKeys() {
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bitlen / 2, 100, r);
        BigInteger q = new BigInteger(bitlen / 2, 100, r);
        n = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
                .subtract(BigInteger.ONE));
        e = new BigInteger("3");
        while (m.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        d = e.modInverse(m);
    }

    /** @return modulus */
    public  BigInteger getN() {
        return n;
    }

    /** @return open exponent. */
    public BigInteger getE() {
        return e;
    }
}
