package com.hj.client.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2015/3/14  21:34
 */
public class FileUtil {

    static final Logger log = LoggerFactory.getLogger(FileUtil.class);
    public static final String localPath = "/home/admin/file/";


    public static String upload(byte[] file,String fileName, String packName) {
        String filePath = localPath + packName + "/" + fileName;
        File uploadFile = new File(filePath);
        try {
            //�ϴ�
            FileCopyUtils.copy(file, uploadFile);
        }
        catch (IOException e) {
            log.error("upload file fail", e);
        }
        return filePath;
    }

    public static HttpServletResponse download(String path, HttpServletResponse response, String pack) {
        try {
            // path��ָ�����ص��ļ���·����
            File file = new File(path );
            // ȡ���ļ�����
            String filename = file.getName();
            // ȡ���ļ��ĺ�׺����
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // ��������ʽ�����ļ���
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // ���response
            response.reset();
            // ����response��Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        }
        catch (IOException ex) {
            log.error("download file", ex);
        }
        return response;
    }

    public static void downloadLocal(HttpServletResponse response, String path) throws FileNotFoundException {
        // ���ر����ļ�
        // ��������
        InputStream inStream = new FileInputStream(path);// �ļ��Ĵ��·��
        // ��������ĸ�ʽ
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + System.currentTimeMillis() + "\"");
        // ѭ��ȡ�����е�����
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        }
        catch (IOException e) {
            log.error("download file", e);
        }
    }

    public static void downloadNet(HttpServletResponse response, String path) throws MalformedURLException {
        // ���������ļ�
        int bytesum = 0;
        int byteread = 0;

        URL url = new URL(path);

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream("c:/abc.gif");

            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
