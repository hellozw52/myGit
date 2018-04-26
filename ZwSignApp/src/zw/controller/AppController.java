package zw.controller;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * APK自动签名工具
 * @author zhaowei
 */
@Controller
@RequestMapping("/app")
public class AppController {

    // app名称
    String filename;
    // 签名后的app名称
    String app_signed_filename;
    // app上传路径
    String app_original_url = "/app/APK_sign/app_original";
    // app下载路径
    String app_signed_url = "/app/APK_sign/app_sign";
    // 待执行bat文件url路径
    String bat_url = "/app/APK_sign/APK_sign_onekey.bat";
    // 164服务器上bat文件的绝对路径
    static String server_bat_file_url = "D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/APK_sign_onekey.bat";
    // 是否执行bat
    boolean isrunbat = false;
    // 是否清空
    boolean isallcleanup = false;
    
    

    /**
     * 上传待签名APK文件
     * @param request
     * @param description
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
	    @RequestParam("file") MultipartFile file) throws Exception {
	
	// 如果APK文件不为空，放入上传路径
	if (!file.isEmpty()) {

	    // APK文件名
	    filename = file.getOriginalFilename();
	    System.out.println("上传APK名称： " + filename);

	    // 上传APK路径
	    String uploadpath = getFileUrl(request, app_original_url);
	    // 下载APK路径
	    String downloadpath = getFileUrl(request, app_signed_url);

	    System.out.println("上传路径: " + uploadpath);
	    System.out.println("下载路径: " + downloadpath);
	    
	    //清空上传和下载路径下所有文件
	    if(isFilesAllCleanUp(uploadpath)&&isFilesAllCleanUp(downloadpath)){
		isallcleanup = true;
		System.out.println("操作前是否清空所有目录: "+ isallcleanup );
	    }
	    
	    // 获取上传文件夹
	    File filepath = new File(uploadpath, filename);
	    // 判断上传文件夹路径是否存在，如果不存在就创建一个
	    if (!filepath.getParentFile().exists()) {
		filepath.getParentFile().mkdirs();
	    }
	    // 将APK保存到上传文件夹中
	    file.transferTo(new File(uploadpath + File.separator + filename));

	    // 获取bat执行状态 
	    isrunbat = runBat();
	    System.out.println("bat文件是否执行成功： " + isrunbat);

	    // bat运行成功
	    if (isrunbat) {

		Thread.currentThread();
		Thread.sleep(3000); // 延时3秒,跳转成功页面
		return "success";

	    } else {
		// bat运行失败
		return "error";
	    }
	} else {
	    return "error";
	}

    }

    /**
     * 下载签名后的APK文件
     * @param request
     * @param filename
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
	    Model model) throws Exception {
	// 签过名后的APK名称： 先去文件格式后缀名，插入后缀 _signed.apk
	app_signed_filename = filename.substring(0, filename.length() - 4)
		+ "_signed.apk";

	System.out.println("签名后APK名称： " + app_signed_filename);

	// 下载文件路径
	String downloadpath = getFileUrl(request, app_signed_url);
	// 下载文件夹
	File file = new File(
		downloadpath + File.separator + app_signed_filename);
	
	HttpHeaders headers = new HttpHeaders();
	// 下载显示的文件名，解决中文名称乱码问题
	String downloadFielName = new String(
		app_signed_filename.getBytes("UTF-8"), "iso-8859-1");
	// 通知浏览器以attachment（下载方式）打开图片
	headers.setContentDispositionFormData("attachment", downloadFielName);
	// application/octet-stream ： 二进制流数据（最常见的文件下载）。
	headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
		headers, HttpStatus.CREATED);
    }

    /**
     * 执行bat程序，进行一键签名
     * @return true 执行成功
     * @throws InterruptedException
     */
    public static boolean runBat() throws InterruptedException {

	String cmd = "cmd /c start " + server_bat_file_url;

	try {
	    // 执行bat文件，进行一键签名
	    Process ps = Runtime.getRuntime().exec(cmd);
	    ps.waitFor();
	    return true;
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	    return false;
	}
    }

    /**
     * 删除文件目录下的所有子内容
     * @param fileurl  文件路径
     * @return
     * @throws InterruptedException
     */
    public static boolean isFilesAllCleanUp(String fileurl) throws InterruptedException {
	
	//获取待删除文件目录
	File file = new File(fileurl);
	
	//递归删除目录中的子目录下
	if (file.isDirectory()) {
	    
	      String[] children = file.list();
	      
	      for (int i=0; i<children.length; i++) {
		  boolean success = new File(file, children[i]).delete();
        	     if (!success) {
        	        return false;
        	     }
	      }
	 }
	 // 删除完毕
	 return true;
    }

    /**
     * 获取服务器的上传和下载路径
     * @param request
     * @param url
     *            相对路径
     * @return file_url 绝对路径
     * @throws InterruptedException
     */
    public static String getFileUrl(HttpServletRequest request, String url)
	    throws InterruptedException {

	String file_url = "";
	// 获取路径
	if (!url.isEmpty()) {
	    file_url = request.getServletContext().getRealPath(url);
	    ;
	}
	return file_url;
    }
}
