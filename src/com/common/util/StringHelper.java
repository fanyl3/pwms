package com.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.regex.Pattern;

public class StringHelper {
	public static boolean isNumber(String paramString) {
		if (isEmpty(paramString))
			return false;
		return Pattern.matches("^[-+0-9.]*$", paramString.trim());
	}

	public static void main(String[] paramArrayOfString) throws Exception {
//		String str = "select * from awhere,awhereb    ";
//		int i = getSqlWhereIndex(str);
//		System.out.println(i);
//		if (i == -1)
//			return;
//		System.out.println(str.substring(i));
		System.out.println(StringHelper.uuid());
	}

	public static String uuid() {
		UUID localUUID = UUID.randomUUID();
		String str = localUUID.toString();
		return replace(str, "-", "");
	}

	public static String encodeUtf8String(String paramString) {
		if (isEmpty(paramString))
			return "";
		try {
			String str = URLEncoder.encode(paramString, "utf-8");
			return str;
		} catch (UnsupportedEncodingException localUnsupportedEncodingException) {
			localUnsupportedEncodingException.printStackTrace();
		}
		return "";
	}

	public static String decodeUtf8String(String paramString) {
		if (isEmpty(paramString))
			return "";
		try {
			String str = new String(paramString.getBytes("iso8859_1"), "utf-8");
			str = URLDecoder.decode(str, "utf-8");
			return str;
		} catch (UnsupportedEncodingException localUnsupportedEncodingException) {
			localUnsupportedEncodingException.printStackTrace();
		}
		return "";
	}

	public static String toUtf8String(String paramString) {
		StringBuffer localStringBuffer = new StringBuffer();
		for (int i = 0; i < paramString.length(); ++i) {
			char c = paramString.charAt(i);
			if ((c >= 0) && (c <= '?')) {
				localStringBuffer.append(c);
			} else {
				byte[] arrayOfByte;
				try {
					arrayOfByte = Character.toString(c).getBytes("utf-8");
				} catch (Exception localException) {
					System.out.println(localException);
					arrayOfByte = new byte[0];
				}
				for (int j = 0; j < arrayOfByte.length; ++j) {
					int k = arrayOfByte[j];
					if (k < 0)
						k += 256;
					localStringBuffer.append("%"
							+ Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return localStringBuffer.toString();
	}

	public static String toUTF(String paramString) {
		String str = new String("");
		if (paramString == null)
			paramString = "";
		for (int j = 0; j < paramString.length(); ++j) {
			char c = paramString.charAt(j);
			if ((c == '=') || (c == '/') || (c == '<') || (c == '>')
					|| (c == '"') || (c == ' ')
					|| (c + "".toString().getBytes().length == 1)) {
				str = str + c;
			} else {
				int i = c + '\000';
				str = str + "&#x" + Integer.toHexString(i) + ";";
			}
		}
		return str;
	}

	public static int getSqlWhereIndex(String paramString) {
		if ((paramString == null) || ("".equals(paramString)))
			return -1;
		String str = paramString.toLowerCase();
		int i = str.indexOf("where");
		if (i == -1)
			return -1;
		for (int j = i;; j = j + i + 5) {
			str = str.substring(i + 5);
			i = str.indexOf("where");
			if (i == -1)
				break;
		}
		str = paramString.toLowerCase();
		int k = i + 5;
		if ((str.charAt(k) != '\r') && (str.charAt(k) != '\t')
				&& (str.charAt(k) != '\n') && (str.charAt(k) != ' '))
			return -1;
		str = paramString.toLowerCase().substring(i + 5);
		if (str.indexOf(')') != -1)
			return -1;
		return i;
	}

	public static int getSqlOrderByIndex(String paramString) {
		if ((paramString == null) || ("".equals(paramString)))
			return -1;
		String str = paramString.toLowerCase();
		int i = str.indexOf("order");
		if (i == -1)
			return -1;
		for (int j = i;; j = j + i + 5) {
			str = str.substring(i + 5);
			i = str.indexOf("order");
			if (i == -1)
				break;
		}
		str = paramString.toLowerCase();
		int k = i + 5;
		if ((str.charAt(k) != '\r') && (str.charAt(k) != '\t')
				&& (str.charAt(k) != '\n') && (str.charAt(k) != ' '))
			return -1;
		str = paramString.toLowerCase().substring(i + 5);
		if (str.indexOf("by") == -1)
			return -1;
		if (str.indexOf(')') != -1)
			return -1;
		return i;
	}

	public static String convertNull(String paramString) {
		if (paramString != null)
			return paramString.trim();
		return "";
	}

	public static String parseURLToFile(URL paramURL) {
		String str = paramURL.toString();
		if (str.startsWith("file:"))
			str = str.substring("file:".length(), str.length());
		else if (str.startsWith("file:/"))
			str = str.substring("file:/".length(), str.length());
		else if (str.startsWith("file:\\\\"))
			str = str.substring("file:\\\\".length(), str.length());
		else if (str.startsWith("file:\\"))
			str = str.substring("file:\\".length(), str.length());
		return str;
	}

	public static boolean isEmpty(String paramString) {
		return (paramString == null) || (paramString.trim().length() == 0)
				|| ("null".equals(paramString));
	}

	public static boolean isNotEmpty(String paramString) {
		return (paramString != null) && (paramString.trim().length() != 0)
				&& (!"null".equals(paramString));
	}

	public static String firstCharToLowercase(String paramString) {
		if (Character.isUpperCase(paramString.charAt(0))) {
			char c = Character.toLowerCase(paramString.charAt(0));
			paramString = c + paramString.substring(1, paramString.length());
		}
		return paramString;
	}

	public static String firstCharToUppercase(String paramString) {
		if (Character.isLowerCase(paramString.charAt(0))) {
			char c = Character.toUpperCase(paramString.charAt(0));
			paramString = c + paramString.substring(1, paramString.length());
		}
		return paramString;
	}

	public static String propertyNameToGetterName(String paramString) {
		paramString = firstCharToUppercase(paramString);
		return "get" + paramString + "()";
	}

	public static String getNestedPropertyGetterName(String paramString) {
		StringTokenizer localStringTokenizer = new StringTokenizer(paramString,
				".", false);
		StringBuffer localStringBuffer = new StringBuffer();
		while (localStringTokenizer.hasMoreElements()) {
			String str = (String) localStringTokenizer.nextElement();
			propertyNameToGetterName(str);
			localStringBuffer.append(propertyNameToGetterName(str) + ".");
		}
		paramString = localStringBuffer.toString();
		if (paramString.endsWith("."))
			return paramString.substring(0, paramString.length() - 1);
		return paramString;
	}

	public static String replace(String paramString1, String paramString2,
			String paramString3) {
		int i = 0;
		int j = 0;
		StringBuffer localStringBuffer = new StringBuffer();
		while ((j = paramString1.indexOf(paramString2, i)) >= 0) {
			localStringBuffer.append(paramString1.substring(i, j));
			localStringBuffer.append(paramString3);
			i = j + paramString2.length();
		}
		localStringBuffer.append(paramString1.substring(i));
		return localStringBuffer.toString();
	}

	public static String leftPad(String paramString, int paramInt,
			char paramChar) {
		int i = paramInt - paramString.length();
		if (i > 0) {
			for (int j = 0; j < i; ++j)
				paramString = paramChar + paramString;
			return paramString;
		}
		return paramString;
	}
/*	public static String password2Md5(String plainText) {
		try { 
			plainText = plainText.trim();
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(plainText.getBytes()); 
			byte b[] = md.digest(); 
			int i; 
			StringBuffer buf = new StringBuffer(""); 
			for (int offset = 0; offset < b.length; offset++) { 
				i = b[offset]; 
				if(i<0) 
					i+= 256; 
				if(i<16) buf.append("0"); 
				buf.append(Integer.toHexString(i));
			} 
			return buf.toString().substring(8,24).toLowerCase(); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace(); 
			return "MD5FAIL";
		} 
	} */
	/*** 
     * MD5加码 生成32位md5码 
     */  
    public static String string2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
  
    }  
  
    /** 
     * 加密解密算法 执行一次加密，两次解密 
     */   
    public static String convertMD5_1(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
    public static String convertMD5(String inStr){  
    	return convertMD5_1(convertMD5_1(inStr));
    }
  
}
