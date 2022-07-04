package com.naturaltel.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class BouncyCastleAES {
	private final static String ALGORITHM = "AES";
	private final static String TRANSFORMATION = "AES/CBC/PKCS5Padding";
	private final static Charset UTF8 = StandardCharsets.UTF_8;

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	public static String encrypt(String yek, String initVector, String value)
			throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
		Key k = toYek(yek);
		Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, k, iv);

        byte[] encrypted = cipher.doFinal(value.getBytes());
        
        return Base64.getEncoder().encodeToString(encrypted);
	}
	
	byte[] parseHex(String str) {
	    byte[] a = new BigInteger(str, 16).toByteArray();
	    if (a.length != str.length() / 2) {
	        a = Arrays.copyOfRange(a, 1, a.length);
	    }
	    return a;
	}

    public static String decrypt(String yek, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
    		Key k = toYek(yek);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, k, iv);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private static Key toYek(String yek) {
		SecretKey secretKey = new SecretKeySpec(yek.getBytes(UTF8), ALGORITHM);
		return secretKey;
	}
}