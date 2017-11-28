package util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * 此类中封装一些常用的字符串操作。 所有方法都是静态方法，不需要生成此类的实例， 为避免生成此类的实例，构造方法被申明为private类型的。
 * 
 * @since 0.1
 */
public class StringUtil {
	private static String strChineseFirstPY = "";// 内容太长请到http://jshuwei.org.cn上下载

	/**
	 * 将一字符串转换成拼音首字母
	 * 
	 * @since 1.1
	 * @param strText
	 *            字符串
	 * @return 字符串对应的拼音首字母
	 */
	public static String getFirstPY(String strText) {
		if (strText == null || strText.trim().length() == 0)
			return "";
		String ret = "";
		for (int i = 0; i < strText.length(); i++) {
			char ch = strText.charAt(i);
			if ('\u4E00' <= ch && '\u9FA5' >= ch)
				ret = ret + strChineseFirstPY.charAt(ch - 19968);
			else
				ret = ret + ch;
		}

		return ret;
	}

	/**
	 * 替换字符串
	 * 
	 * @since 1.1
	 * @param strSc
	 *            需要进行替换的字符串
	 * @param oldStr
	 *            源字符串
	 * @param newStr
	 *            替换后的字符串
	 * @return 替换后对应的字符串
	 */
	public static String replace(String strSc, String oldStr, String newStr) {
		String ret = strSc;
		if (ret != null && oldStr != null && newStr != null) {
			ret = strSc.replaceAll(oldStr, newStr);
		}
		return ret;
	}

	/**
	 * 替换字符串，修复java.lang.String类的replaceAll方法时第一参数是字符串常量正则时(如："address".
	 * replaceAll("dd","$");)的抛出异常：java.lang.StringIndexOutOfBoundsException:
	 * String index out of range: 1的问题。
	 * 
	 * @since 1.2
	 * @param strSc
	 *            需要进行替换的字符串
	 * @param oldStr
	 *            源字符串
	 * @param newStr
	 *            替换后的字符串
	 * @return 替换后对应的字符串
	 */
	public static String replaceAll(String strSc, String oldStr, String newStr) {
		int i = -1;
		while ((i = strSc.indexOf(oldStr)) != -1) {
			strSc = new StringBuffer(strSc.substring(0, i)).append(newStr)
					.append(strSc.substring(i + oldStr.length())).toString();
		}
		return strSc;
	}

	/**
	 * 将字符串转换成HTML格式的字符串
	 * 
	 * @since 1.1
	 * @param str
	 *            需要进行转换的字符串
	 * @return 转换后的字符串
	 */
	public static String toHtml(String str) {
		String html = str;
		if (str == null || str.length() == 0) {
			return "";
		} else {
			html = replace(html, "&", "&amp;");
			html = replace(html, "<", "&lt;");
			html = replace(html, ">", "&gt;");
			html = replace(html, "\r\n", "\n");
			html = replace(html, "\n", "<br>\n");
			html = replace(html, "\"", "&quot;");
			html = replace(html, " ", "&nbsp;");
			return html;
		}
	}

	/**
	 * 将HTML格式的字符串转换成常规显示的字符串
	 * 
	 * @since 1.1
	 * @param str
	 *            需要进行转换的字符串
	 * @return 转换后的字符串
	 */
	public static String toText(String str) {
		String text = str;
		if (str == null || str.length() == 0) {
			return "";
		} else {
			text = replace(text, "&amp;", "&");
			text = replace(text, "&lt;", "<");
			text = replace(text, "&gt;", ">");
			text = replace(text, "<br>\n", "\n");
			text = replace(text, "<br>", "\n");
			text = replace(text, "&quot;", "\"");
			text = replace(text, "&nbsp;", " ");
			return text;
		}
	}

	/**
	 * 将一字符串数组以某特定的字符串作为分隔来变成字符串
	 * 
	 * @since 1.0
	 * @param strs
	 *            字符串数组
	 * @param token
	 *            分隔字符串
	 * @return 以token为分隔的字符串
	 */
	public static String join(String[] strs, String token) {
		if (strs == null)
			return null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i != 0)
				sb.append(token);
			sb.append(strs[i]);
		}
		return sb.toString();
	}

	/**
	 * 将一字符串以某特定的字符串作为分隔来变成字符串数组
	 * 
	 * @since 1.0
	 * @param str
	 *            需要拆分的字符串("@12@34@56")
	 * @param token
	 *            分隔字符串("@")
	 * @return 以token为分隔的拆分开的字符串数组
	 */
	public static String[] split(String str, String token) {
		// String temp = str.substring(1, str.length());
		String temp = str;
		return temp.split(token);
	}

	/**
	 * 验证字符串合法性
	 * 
	 * @since 1.0
	 * @param str
	 *            需要验证的字符串
	 * @param test
	 *            非法字符串（如："~!#$%^&*()',;:?"）
	 * @return true:非法;false:合法
	 */
	public static boolean check(String str, String test) {
		if (str == null || str.equals(""))
			return true;
		boolean flag = false;
		for (int i = 0; i < test.length(); i++) {
			if (str.indexOf(test.charAt(i)) != -1) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * 将数值型字符串转换成Integer型
	 * 
	 * @since 1.0
	 * @param str
	 *            需要转换的字符型字符串
	 * @param ret
	 *            转换失败时返回的值
	 * @return 成功则返回转换后的Integer型值；失败则返回ret
	 */
	public static Integer String2Integer(String str, Integer ret) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return ret;
		}
	}

	// 判断字符串是否是数字
//	public static boolean isNumeric(String str) {
//		if (str.matches("\\d *")) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	/**
	 * 将数值型转换成字符串
	 * 
	 * @since 1.0
	 * @param it
	 *            需要转换的Integer型值
	 * @param ret
	 *            转换失败的返回值
	 * @return 成功则返回转换后的字符串；失败则返回ret
	 */
	public static String Integer2String(Integer it, String ret) {
		try {
			return Integer.toString(it);
		} catch (NumberFormatException e) {
			return ret;
		}
	}

	/**
	 * 比较两字符串大小(ASCII码顺序)
	 * 
	 * @since 1.1
	 * @param str1
	 *            参与比较的字符串1
	 * @param str2
	 *            参与比较的字符串2
	 * @return str1>str2:1;str1<str2:-1;str1=str2:0
	 */
	public static int compare(String str1, String str2) {//
		if (str1.equals(str2)) {
			return 0;
		}
		int str1Length = str1.length();
		int str2Length = str2.length();
		int length = 0;
		if (str1Length > str2Length) {
			length = str2Length;
		} else {
			length = str1Length;
		}
		for (int i = 0; i < length; i++) {
			if (str1.charAt(i) > str2.charAt(i)) {
				return 1;
			}
		}
		return -1;
	}

	/**
	 * 将阿拉伯数字的钱数转换成中文方式
	 * 
	 * @since 1.1
	 * @param num
	 *            需要转换的钱的阿拉伯数字形式
	 * @return 转换后的中文形式
	 */
	public static String num2Chinese(double num) {
		String result = "";
		String str = Double.toString(num);
		if (str.contains(".")) {
			String begin = str.substring(0, str.indexOf("."));
			String end = str.substring(str.indexOf(".") + 1, str.length());
			byte[] b = begin.getBytes();
			int j = b.length;
			for (int i = 0, k = j; i < j; i++, k--) {
				result += getConvert(begin.charAt(i));
				if (!"零".equals(result.charAt(result.length() - 1) + "")) {
					result += getWei(k);
				}
				System.out.println(result);

			}
			for (int i = 0; i < result.length(); i++) {
				result = result.replaceAll("零零", "零");
			}
			if ("零".equals(result.charAt(result.length() - 1) + "")) {
				result = result.substring(0, result.length() - 1);
			}
			result += "元";
			byte[] bb = end.getBytes();
			int jj = bb.length;
			for (int i = 0, k = jj; i < jj; i++, k--) {
				result += getConvert(end.charAt(i));
				if (bb.length == 1) {
					result += "角";
				} else if (bb.length == 2) {
					result += getFloat(k);
				}
			}
		} else {
			byte[] b = str.getBytes();
			int j = b.length;
			for (int i = 0, k = j; i < j; i++, k--) {
				result += getConvert(str.charAt(i));
				result += getWei(k);
			}
		}
		return result;
	}

	private static String getConvert(char num) {
		if (num == '0') {
			return "零";
		} else if (num == '1') {
			return "一";
		} else if (num == '2') {
			return "二";
		} else if (num == '3') {
			return "三";
		} else if (num == '4') {
			return "四";
		} else if (num == '5') {
			return "五";
		} else if (num == '6') {
			return "六";
		} else if (num == '7') {
			return "七";
		} else if (num == '8') {
			return "八";
		} else if (num == '9') {
			return "九";
		} else {
			return "";
		}
	}

	private static String getFloat(int num) {
		if (num == 2) {
			return "角";
		} else if (num == 1) {
			return "分";
		} else {
			return "";
		}
	}

	private static String getWei(int num) {
		if (num == 1) {
			return "";
		} else if (num == 2) {
			return "十";
		} else if (num == 3) {
			return "百";
		} else if (num == 4) {
			return "千";
		} else if (num == 5) {
			return "万";
		} else if (num == 6) {
			return "十";
		} else if (num == 7) {
			return "百";
		} else if (num == 8) {
			return "千";
		} else if (num == 9) {
			return "亿";
		} else if (num == 10) {
			return "十";
		} else if (num == 11) {
			return "百";
		} else if (num == 12) {
			return "千";
		} else if (num == 13) {
			return "兆";
		} else {
			return "";
		}
	}

	/**
	 * 将字符串的首字母改为大写
	 * 
	 * @since 1.2
	 * @param str
	 *            需要改写的字符串
	 * @return 改写后的字符串
	 */
	public static String firstToUpper(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * 非空检验 is==true:表示不为空
	 */
	public static boolean isNull(String str) {
		if (str == null || str.equals("") || str.equals("null")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * list非空检验 is==true:表示不为空
	 */
	public static boolean isNullList(List list) {
		if (list == null || list.isEmpty() || list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNullOrEmpty(Object obj) {
		return obj == null || "".equals(obj.toString());
	}

	public static String toString(Object obj) {
		if (obj == null)
			return "null";
		return obj.toString();
	}

	public static String join(Collection s, String delimiter) {
		StringBuffer buffer = new StringBuffer();
		Iterator iter = s.iterator();
		while (iter.hasNext()) {
			buffer.append(iter.next());
			if (iter.hasNext()) {
				buffer.append(delimiter);
			}
		}
		return buffer.toString();
	}
	
	//获取uuid
	public static String getUuid(){
		String str="";
		UUID uuid = UUID.randomUUID();
		str = uuid.toString().replaceAll("-", ""); 
		
		return str;
	}
	
}
