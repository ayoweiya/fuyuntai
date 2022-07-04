package com.naturaltel.util;

import java.security.MessageDigest;

public class Secuity {
	public static String encrypt(String uid) throws Exception {
        String result = "fail";
        String msisdnReverse = "";
        String reverseHex = "";
        
        try {
	        if(uid.isEmpty() || uid == "") {
	        	return result;	        	
	        }
	        
	        if (uid.length() < 11) {
	        	for(int i=uid.length();i<11;i++) {
	        		uid = "9" + uid;	        		
	        	}
	        }
	        
	        //偶數數字 9補數
	        msisdnReverse = transOddNum(uid);
	        //轉成16進位
	        reverseHex = Long.toHexString(Long.valueOf(msisdnReverse));
	        
	        if(reverseHex.length() != 10) {
	        	result = "reverseHexLength : " + reverseHex.length();
	        	return result;	        	
	        }
	        
	        reverseHex = stringShift(reverseHex);
	        result = reverseHex;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
	/**
	 * 輸入門號每隔兩位就用9-原本數字， EX: 987654321 => 91 73 55 37 1
	 * @param msisdn
	 * @return String
	 */
	private static String transOddNum(String msisdn) {
		//用9扣掉偶數數字，987654321 => 917355371
		String result = "";
		int numOfOdd = 0;
		try {
			for(int idx = 0; idx < msisdn.length(); idx++) {
				if(idx % 2 == 1) {
					numOfOdd = Integer.valueOf(msisdn.substring(idx, idx+1));
					result = result + String.valueOf(9 - numOfOdd);
				} else {
					result = result + msisdn.substring(idx, idx+1);
				}
			}
		} catch (Exception ex) {
            ex.printStackTrace();
        }
		return result;
	}
	
	private static String stringShift(String str) {
		//將str 3.4.5位字元移到最後面，6.7.8移到最前面 str(1234567890) => str(678 12 90 345)  
		String result = "";
		try {
			result = str.substring(5, 8) + str.substring(0, 2) + str.substring(8) + str.substring(2, 5);
		} catch (Exception ex) {
            ex.printStackTrace();
        }
		return result;
	}
	
	private static String stringShiftDecrypt(String str) {
		//將str 4.5移到最前面,倒數三位接續,1.2.3再接續  str(678 12 90 345)  => str(12 345 678 90) 
		String result = "";
		try {
			result = str.substring(3, 5) + str.substring(7) + str.substring(0, 3) + str.substring(5, 7);
		} catch (Exception ex) {
            ex.printStackTrace();
        }
		return result;
	}
	
	/**
	 * 加密輸入字串
	 * @param encrypted (length = 10)
	 * @return String
	 */
	public static String decrypt(String encrypted) {
        String result = "fail";
        String reverseHex = "";
        String uid = "";
        
        try {
        	if(encrypted.length() != 10 || encrypted.isEmpty() || encrypted == "") {
        		return result;        		
        	}
        	
        	reverseHex = encrypted;        	
        	reverseHex = stringShiftDecrypt(reverseHex);
        	
        	//再做一次transOddNum 可以回到原本的字串
        	uid = transOddNum(String.valueOf(Long.valueOf(reverseHex, 16)));        	
        	//去除前面的數字到長度為10
        	if (uid.length() > 10) {
	        	for(int i=uid.length();i>10;i--) {
	        		uid = uid.substring(1);
	        	}
	        }
        	
        	result = uid;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
	
	/**
	 *  計算numStr的總和，以十進位為例，如果numStr大於10就將個位數字加上十位數字加上百位...
	 * @param numStr
	 * @param type ("int" or "hex")
	 * @return String (return "0" <= 異常)
	 */
	private static String Sum(String numStr, String type) {
		//將numStr相加，如果大於進位數字就繼續相加 => 988756895 => 56 5+6=11 1+1=2 
		//type "uid" 10進位 ,"hex" 16進位
		String returnSum = "";
		int sum = 0;
		int tenDigits = 0;
		int hexDigitis = 0;
		int digits = 0;
		try {
			if(type.isEmpty() || type == "") {
				return "0";
			}
			switch(type) {
				case "uid":
					if(numStr.length() != 10)
						return "0";
					
					for(int idx = 0; idx < numStr.length(); idx++) {
						sum = sum + Integer.valueOf(numStr.substring(idx, idx+1));
					}
					for(;sum > 10;) {
						tenDigits = sum / 10;
						digits = sum % 10;
						sum = tenDigits + digits;
					}
					returnSum = String.valueOf(sum);
					break;
				case "hex":
					if(numStr.length() != 8)
						return "0";
					
					for(int idx = 0; idx < numStr.length(); idx++) {
						sum = sum + Integer.parseInt(numStr.substring(idx, idx+1), 16);
						if(idx == numStr.length())
							sum = sum + Integer.parseInt(numStr.substring(idx, idx+1), 16);
					}
					for(;sum > 15;) {
						hexDigitis = sum / 16;
						digits = sum % 16;
						sum = hexDigitis + digits;
					}
					returnSum = Integer.toHexString(sum).toUpperCase();
					break;
			}
		} catch (Exception ex) {
            ex.printStackTrace();
        }
		return returnSum;
	}
	
	/**
	 * 將str進行MD5加密，並將英文字母轉為大寫
	 * @param str
	 * @return String
	 */
	public static String md5(String str) {
		String md5 = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] barr = md.digest(str.getBytes()); // 將 byte 陣列加密
			StringBuffer sb = new StringBuffer(); // 將 byte 陣列轉成 16 進制
			for (int i = 0; i < barr.length; i++) {
				sb.append(byte2Hex(barr[i]));				
			}			
			String hex = sb.toString();			
			md5 = hex.toUpperCase(); // 一律轉成大寫
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5;
	}
	
	private static String byte2Hex(byte b) {
		String[] h = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
		
		int i = b;
		if (i < 0) {
			i += 256;			
		}
		
		return h[i / 16] + h[i % 16];
	}
}