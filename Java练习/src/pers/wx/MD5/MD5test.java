package pers.wx.MD5;
import java.security.MessageDigest;
public class MD5test {
	//定义MD5类，
	//此类提供一个 hexMD5() 方法用于计算输入字符串的MD5值

	  private String[] hexDigits = { 
	      "0", "1", "2", "3", "4", "5", "6", "7", 
	      "8", "9", "a", "b", "c", "d", "e", "f"}; 

	  /** 
	   * 转换字节数组为16进制字串 
	   * @param b 字节数组 
	   * @return 16进制字串 
	   */ 

	  public String byteArrayToHexString(byte[] b) { 
	    StringBuffer resultSb = new StringBuffer(); 
	    for (int i = 0; i < b.length; i++) { 
	      resultSb.append(byteToHexString(b[i])); 
	    } 
	    return resultSb.toString(); 
	  } 

	  private String byteToHexString(byte b) { 
	    int n = b; 
	    if (n < 0) 
	      n = 256 + n; 
	    int d1 = n / 16; 
	    int d2 = n % 16; 
	    return hexDigits[d1] + hexDigits[d2]; 
	  } 

	  public String hexMD5(String origin) { 
	    String resultString = null; 

	    try { 
	      resultString=new String(origin); 
	      MessageDigest md = MessageDigest.getInstance("MD5"); 
	      resultString=byteArrayToHexString(md.digest(resultString.getBytes())); 
	    } 
	    catch (Exception ex) { 

	    } 
	    return resultString; 
	  } 


	/*
	 * public static void main(String[] args) { // TODO 自动生成的方法存根 MD5test MD5=new
	 * MD5test(); String a="!"; String result=MD5.hexMD5(a);
	 * System.out.println("\rMD5:"+result); }
	 */

}
