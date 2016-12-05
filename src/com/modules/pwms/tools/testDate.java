package com.modules.pwms.tools;

import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * officialsa2ee 11223344556
 */
public class testDate {
		public static void main(String[] args) throws InterruptedException { 
			int y,m,d,h,mi,s;    
			char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
					'K', 'L', 'M', 'N',  'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
					'X', 'Y', 'Z',  '1', '2', '3', '4', '5', '6', '7', '8', '9' };
			Calendar cal=Calendar.getInstance();    
			y=cal.get(Calendar.YEAR);    
			m=cal.get(Calendar.MONTH);    
			d=cal.get(Calendar.DATE);    
			h=cal.get(Calendar.HOUR_OF_DAY);    
			mi=cal.get(Calendar.MINUTE);    
			s=cal.get(Calendar.SECOND);    
			System.out.println("现在时刻是"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒");   
			long  t1 = System.currentTimeMillis()/1000;
			System.out.println(t1);
			long  t2 = System.currentTimeMillis()/1000;
			System.out.println(t2);
			Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
			Matcher matcher = pattern.matcher("aa@12334.com");
			System.out.println(matcher.matches());
			Random random = new Random();
			StringBuffer randomCode = new StringBuffer();
			for(int i =0;i<5;i++){
				String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
				randomCode.append(strRand);
			}
			String yzm = randomCode.toString();
			System.out.print(yzm);
		}
}
