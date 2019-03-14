package circular;

import java.util.Date;

public class circular_rotation_2 {
	public static void main(String[] args) {
		Date date = new Date();
		String a = "123456789";
		String b = "789123456";
		long start = date.getTime();//测试时间
		System.out.println(circular2(a, b));
		long end = date.getTime();
		System.out.println(start-end);
		int s = 10;
		
	}

	private static boolean circular2(String a, String b) {
		if (a.length()!=b.length()) {//如果长度不相等,直接pass
			return false;
		}
		int c= b.indexOf(a.charAt(0));//测试位置,规定前进量
		if (c<0) {//如果不存在,直接pass
			return false;
		}
		String aString = b.substring(0, c);
		String bString = b.substring(c, b.length());
		String uerequal = bString + aString;
		if (a.equals(uerequal)) {
			return true;
		}
		return false;
		
	}
}
