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
        rsa = new RSA(1024);
        msg = "I'm original msg";
        encMsg = rsa.encryptBase64(msg);
        BigInteger msgBytes = new BigInteger(msg.getBytes());
        encMsgBytes = rsa.encrypt(msgBytes);
    }

    @Test
    public void encryptTest() {
        Assert.assertNotSame(encMsg, Base64.getEncoder().encodeToString(msg.getBytes()));
        Assert.assertEquals(encMsg, Base64.getEncoder().encodeToString(encMsgBytes.toByteArray()));
    }

    @Test
    public void decryptTest() {
        String decMsg = rsa.decryptBase64(encMsg);
        BigInteger decMsgBytes = rsa.decrypt(encMsgBytes);
        Assert.assertEquals(decMsg, msg);
        Assert.assertEquals(new String(decMsgBytes.toByteArray()), msg);
    }

    @Test
    public void interactionTest() {
        RSA clientRsa = new RSA(rsa.getN(), rsa.getE());
        String clientEncMsg = clientRsa.encryptBase64(msg);
        String servDecMsg = rsa.decryptBase64(clientEncMsg);
        Assert.assertEquals(msg, servDecMsg);

        String servEncMsg = rsa.encryptBase64(msg);
        String clientDecMsg = clientRsa.decryptBase64(servEncMsg);
        Assert.assertNotSame(msg, clientDecMsg);
    }
}
