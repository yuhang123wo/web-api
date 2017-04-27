package com.yuhang.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yuhang.dto.LoginInfoDto;
import com.yuhang.framework.MyException;
import com.yuhang.framework.SpringContextHolder;
import com.yuhang.service.CacheService;

public class Tools {
	public static void staticize(String html, String filePath) throws MyException, IOException {
		if (html == null) {
			throw new MyException("000045");
		}
		OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
		try {
			fw.write(html);
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("000001", e.getMessage());
		} finally {
			fw.close();
		}
	}

	public static void createZip(String sourcePath, String zipPath) throws Exception {
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(zipPath);
			zos = new ZipOutputStream(fos);
			writeZip(new File(sourcePath), "", zos);
		} catch (FileNotFoundException e) {
			throw e;
		} finally {
			if (zos != null) {
				zos.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}

	private static void writeZip(File file, String parentPath, ZipOutputStream zos)
			throws Exception {
		if (file.exists()) {
			if (file.isDirectory()) {// 处理文件夹
				parentPath += file.getName() + File.separator;
				File[] files = file.listFiles();
				if (files.length != 0) {
					for (File f : files) {
						writeZip(f, parentPath, zos);
					}
				} else {
					zos.putNextEntry(new ZipEntry(parentPath));
				}
			} else {
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(file);
					ZipEntry ze = new ZipEntry(parentPath + file.getName());
					zos.putNextEntry(ze);
					byte[] content = new byte[1024];
					int len;
					while ((len = fis.read(content)) != -1) {
						zos.write(content, 0, len);
						zos.flush();
					}
				} catch (Exception e) {
					throw e;
				} finally {
					if (fis != null) {
						fis.close();
					}
				}
			}
		}
	}

	public static String readFile(String filePath) throws Exception {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line + (line.equals("\r\n") ? "" : "\r\n"));
			}
			return sb.toString();
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (br != null) {
				br.close();
			}
		}
	}

	public static void copyFile(String source, String dest) throws IOException {
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(source);
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null)
				input.close();
			if (output != null)
				output.close();
		}
	}

	public static void getHrefFromText(String html, List<String> filePaths) {
		Pattern pattern = Pattern.compile("href=\"(.*)\"", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			String foundURL = matcher.group(1);
			if (foundURL.startsWith("http")) {
				if (!filePaths.contains(foundURL)) {
					filePaths.add(foundURL);
				}
			}
		}
		pattern = Pattern.compile("src=\"(.*)\"", Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(html);
		while (matcher.find()) {
			String foundURL = matcher.group(1);
			if (foundURL.startsWith("http")) {
				if (!filePaths.contains(foundURL)) {
					filePaths.add(foundURL);
				}
			}
		}
	}

	/**
	 * 通过递归调用删除一个文件夹及下面的所有文件
	 * 
	 * @param file
	 */
	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			return;
		}
		if (file.isFile()) {// 表示该文件不是文件夹
			file.delete();
		} else {
			// 首先得到当前的路径
			String[] childFilePaths = file.list();
			for (String childFilePath : childFilePaths) {
				deleteFile(file.getAbsolutePath() + "/" + childFilePath);
			}
			file.delete();
		}
	}

	// 创建文件夹
	public static void createFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * 构造查询的id
	 * 
	 * @param roleName
	 * @return
	 */
	public static List<String> getIdsFromField(String ids) {
		return Arrays.asList(ids.split(","));
	}

	public static boolean hasAuth(String authPassport) throws MyException {
		LoginInfoDto user = Tools.getUser();
		if (user == null) {
			throw new MyException("000003");
		}

		String authority = user.getAuthStr();
		if (user != null && ("," + user.getRoleId()).indexOf("," + Const.SUPER + ",") >= 0) {
			return true;// 超级管理员
		}

		// 管理员修改自己的资料
		if (authPassport.equals("USER")) {
			// 如果session中的管理员id和参数中的id一致
			if (user.getId() == user.getId()) {
				return true;
			}
		}

		if (authority.indexOf("," + authPassport + ",") >= 0) {
			return true;
		}
		throw new MyException("000003");
	}

	/**
	 * 构造查询Map集合
	 * 
	 * @param params
	 *            不定数量参数 格式(key1,value1,key2,value2....)
	 * @return
	 */
	public static Map<String, Object> getMap(Object... params) {
		if (params.length == 0 || params.length % 2 != 0) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < params.length; i = i + 2) {
			if (!StringUtils.isEmpty(params[i + 1]))
				map.put(params[i].toString(), params[i + 1]);
		}
		return map;

	}

	public static Map<String, String> getStrMap(String... params) {
		if (params.length == 0 || params.length % 2 != 0) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < params.length; i = i + 2) {
			if (!StringUtils.isEmpty(params[i + 1]))
				map.put(params[i].toString(), params[i + 1]);
		}
		return map;

	}

	/**
	 * 构造导航条
	 */
	// public static List<CrumbDto> getCrumbs(String... params) {
	// List<CrumbDto> crumbDtos = new ArrayList<CrumbDto>();
	// if (params.length == 0 || params.length % 2 != 0) {
	// return crumbDtos;
	// }
	// for (int i = 0; i < params.length; i = i + 2) {
	// if (!StringUtils.isEmpty(params[i + 1])) {
	// CrumbDto crumb = new CrumbDto(params[i], params[i + 1]);
	// crumbDtos.add(crumb);
	// }
	// }
	// return crumbDtos;
	//
	// }

	public static String getChar(int num) {
		String md = "123456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ789abcd";
		Random random = new Random();
		String temp = "";
		for (int i = 0; i < num; i++) {
			temp = temp + md.charAt(random.nextInt(50));
		}
		return temp;
	}

	public static boolean isEmail(String email) {
		if (null == email || "".equals(email))
			return false;
		// Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isSuperAdmin(String role) {
		if (StringUtils.isEmpty(role)) {
			return false;
		}

		if (("," + role + ",").indexOf("," + Const.SUPER + ",") >= 0) {
			return true;
		}
		return false;
	}

	public static HttpServletResponse getResponse() {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getResponse();
		;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		return response;
	}

	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
	}

	public static ServletContext getServletContext() {
		WebApplicationContext webApplicationContext = ContextLoader
				.getCurrentWebApplicationContext();
		return webApplicationContext.getServletContext();
	}

	public static String readStream(InputStream inStream, String encoding) throws Exception {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		return new String(outSteam.toByteArray(), encoding);
	}

	public static String removeHtml(String inputStr) {
		if (inputStr == null) {
			return "";
		}
		inputStr = inputStr.replaceAll("<[a-zA-Z|//]+[1-9]?[^><]*>", "");
		inputStr = inputStr.replaceAll("&nbsp;", "");
		StringBuffer temp = new StringBuffer();
		String str = "[a-z]*[A-Z]*[0-9]*[\u4E00-\u9FA5]*[Ⅰ|,|。|，|.|：|(|)|（|）|:|/]*";
		Pattern pattern = Pattern.compile(str, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		while (matcher.find()) {
			temp.append(matcher.group());
		}
		return temp.toString();
	}

	public static String subString(String str, int length, String suffix) {
		if (StringUtils.isEmpty(str)) {
			return "";
		}

		if (StringUtils.isEmpty(suffix)) {
			suffix = "...";
		}

		if (str.length() > length) {
			return str.substring(0, length) + suffix;
		}

		return str;
	}

	/**
	 * 获取用户登录信息
	 * 
	 * @return
	 */
	public static LoginInfoDto getUser() {
		CacheService cacheService = SpringContextHolder.getBean("cacheService", CacheService.class);
		String uId = MyCookie.getCookie(Const.COOKIE_USERID, false, Tools.getRequest());
		return (LoginInfoDto) cacheService.getObj(Const.CACHE_USER + uId);
	}

	public static boolean checkUserName(String userName) {
		String regex = "^[0-9A-Za-z-_\\.]{5,20}$";
		return userName.matches(regex);
	}

	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
