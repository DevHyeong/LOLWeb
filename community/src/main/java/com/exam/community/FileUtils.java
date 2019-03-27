package com.exam.community;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUtils {
	
	public String fileUpload(HttpServletRequest request, HttpServletResponse response) {
		
		String fileName="";
		
		try {

	         //��������
	         String sFileInfo = "";
	         //���ϸ��� �޴´� - �Ϲ� �������ϸ�
	         String filename = request.getHeader("file-name");
	         
	         //��0�� Ȯ����
	         String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
	         
	         //Ȯ���ڸ��ҹ��ڷ� ����
	         filename_ext = filename_ext.toLowerCase();
	         //���� �⺻���
	         String dftFilePath = request.getSession().getServletContext().getRealPath("/");
	         
	         //���� �⺻��� _ �󼼰��
	         String filePath = dftFilePath + "resources" + File.separator + "photo_upload" + File.separator;
	         
	         File file = new File(filePath);
	         if(!file.exists()) {
	            file.mkdirs();
	         }
	         String realFileNm = "";
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	         String today= formatter.format(new java.util.Date());
	         realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
	         String rlFileNm = filePath + realFileNm;
	         ///////////////// ������ ���Ͼ��� /////////////////
	         InputStream is = request.getInputStream(); // �б�
	         OutputStream os=new FileOutputStream(rlFileNm); // ����
	         
	         
	         
	         int numRead;
	         byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
	         while((numRead = is.read(b,0,b.length)) != -1){
	            os.write(b,0,numRead);
	         }
	         if(is != null) {
	            is.close();
	         }
	         os.flush();
	         os.close();
	         ///////////////// ������ ���Ͼ��� /////////////////
	         // ���� ���
	         sFileInfo += "&bNewLine=true";
	         // img �±��� title �Ӽ��� �������ϸ����� ��������ֱ� ����
	         sFileInfo += "&sFileName="+ filename;;
	         sFileInfo += "&sFileURL="+"/resources/photo_upload/"+realFileNm;
	         PrintWriter print = response.getWriter();
	         print.print(sFileInfo);
	         print.flush();
	         print.close();
	         
	        
	         //���� DB�� ������ ���ߴٸ� ����� ������ ����.
	         
	        /* File f = new File(rlFileNm);
	         if(f.exists()) {
	        	 f.delete();
	         }*/
	         //DB�� ������ �ߴ��� ���ߴ��� Ȯ���Ҽ��ִ� ���.
	         
	         
	         
	         return rlFileNm;
	         
	         
	         
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return "";
	}
	
	
	
	
}
