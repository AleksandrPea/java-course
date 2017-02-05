package com.apea.training.ecourse.homework1.task5;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Base64;

public class RSATest {

    private RSA rsa;
    private String msg;
    private String encMsg;
    private BigInteger encMsgBytes;

    public RSATest() {
        rsa = RSA.RSAFactory.createRSA(1024);
        msg = "I'm original msg";
        encMsg = rsa.encryptBase64(msg);
        BigInteger msgBytes = new BigInteger(msg.getBytes());
        encMsgBytes = rsa.encrypt(msgBytes);
    }

    /** Trying to create client-rsa with null parameters */
    @Test(expected = NullPointerException.class)
    public void createClientRSATest() {
        RSA.RSAFactory.createRSA(null, null);
    }

    /** Trying to create rsa with bits <= 0 */
    @Test(expected = IllegalArgumentException.class)
    public void createRSATest() {
        RSA.RSAFactory.createRSA(-1024);
    }

    /**
     * Checking:
     * 1) That generated open exponent is in (1, eulerF(modulus)
     * 2) That open exp is coprime with eulerF
     * 3) That openExp*secretExp mod eulerF = 1
     */
    @Test
    public void generateTest() {
        BigInteger[] arr = RSA.generateModulusAndFunc(2048);
        BigInteger m = arr[1];
        arr = RSA.generateOpenAndSecretExp(m);
        BigInteger e = arr[0];
        BigInteger d = arr[1];
        Assert.assertTrue(BigInteger.ONE.compareTo(e) == -1  && e.compareTo(m) == -1);
        Assert.assertEquals(e.gcd(m).intValue(), 1);
        Assert.assertEquals(d.multiply(e).mod(m).intValue(), 1);
    }

    /**
     * Checking:
     * 1) encoded message is not same as original in base64
     * 2) encoded message is equals to encoded bytes converted in base64
     */
    @Test
    public void encryptTest() {
        Assert.assertNotSame(encMsg, Base64.getEncoder().encodeToString(msg.getBytes()));
        Assert.assertEquals(encMsg, Base64.getEncoder().encodeToString(encMsgBytes.toByteArray()));
    }

    /**
     * Checking:
     * 1) decoded message is equals to original message
     * 2) decoded bytes converted to String is equals to original message
     */
    @Test
    public void decryptTest() {
        String decMsg = rsa.decryptBase64(encMsg);
        BigInteger decMsgBytes = rsa.decrypt(encMsgBytes);
        Assert.assertEquals(decMsg, msg);
        Assert.assertEquals(new String(decMsgBytes.toByteArray()), msg);
    }

    /**
     * Creating rsa-client, that can only encrypt.<br>
     * Checking scenario: client encodes message, server decodes it; decoded
     * message is equals to original.
     */
    @Test
    public void interactionTest() {
        RSA rsaServer = rsa;
        RSA rsaClient = RSA.RSAFactory.createRSA(rsaServer.getN(), rsaServer.getE());
        String clientEncMsg = rsaClient.encryptBase64(msg);
        String servDecMsg = rsaServer.decryptBase64(clientEncMsg);
        Assert.assertEquals(msg, servDecMsg);
    }

    /** Checking that rsa-client can only encrypt */
    @Test(expected = IllegalStateException.class)
    public void interactionFailTest() {
        RSA rsaClient = RSA.RSAFactory.createRSA(rsa.getN(), rsa.getE());
        rsaClient.decrypt(new BigInteger("2555"));
    }
}
