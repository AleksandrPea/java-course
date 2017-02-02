package com.apea.training.ecourse.Homework1.Task5;

import java.math.BigInteger;
import java.security.SecureRandom;

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

    public String encrypt(String message) {
        return encrypt(new BigInteger(message.getBytes())).toString();
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public String decrypt(String message) {
        return decrypt(new BigInteger(message.getBytes())).toString();
    }

    public BigInteger decrypt(BigInteger message) {
        return message.modPow(d, n);
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

    /** Trivial test program. */
    public static void main(String[] args) {
        RSA rsa = new RSA(1024);

        String text1 = "Yellow and Black Border Collies";
        System.out.println("Plaintext: " + text1);
        BigInteger plaintext = new BigInteger(text1.getBytes());

        BigInteger ciphertext = rsa.encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);
        plaintext = rsa.decrypt(ciphertext);

        String text2 = new String(plaintext.toByteArray());
        System.out.println("Plaintext: " + text2);
    }
}
