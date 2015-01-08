package egovframework.com.ext.jstree.support.manager.viewResolver.specialPurposeView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownloadView extends AbstractView {
    
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (null == model) {
            throw new IOException();
        }
        
        response.setContentType("application/octet-stream; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        
        File file = (File) model.get("file");
        String fileName = file.getName();
        
        Object fileNameTemp = model.get("fileName");
        if (null != fileNameTemp) {
            fileName = (String) fileNameTemp;
        }
        
        if (file.exists()) {
            
            FileInputStream fileInputStream = new FileInputStream(file);
            
            //response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); 
            response.setHeader("Content-Transfer-Encoding", "binary;");
            response.setHeader("Pragma", "no-cache;");
            response.setHeader("Expires", "-1;");
            
            String mime = request.getSession().getServletContext().getMimeType(file.getName());
            if (mime == null || mime.length() == 0) {
             //Header Mime 추가
             mime = "application/octet-stream;charset=euc-kr";
            }
            
            response.setContentType(mime);
            
            String userAgent = request.getHeader("User-Agent");
            if (userAgent.indexOf("MSIE 5.5") > -1) { // MS IE 5.5 이하
                response.setHeader("Content-Disposition", "filename=" + URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "\\ ") + ";");
                
            } else if (userAgent.indexOf("MSIE") > -1) { // MS IE (보통은 6.x 이상 가정)
                response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8").replaceAll( "\\+", "\\ ") + ";");
                
            } else { // 모질라나 오페라
                response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("UTF-8"), "latin1") .replaceAll("\\+", "\\ ") + ";");
                
            }
            
            if (file.length() > 0) {
                response.setHeader("Content-Length", "" + file.length());
            }
           
            if (file.length() > 0) {
                response.setHeader("Content-Length", "" + file.length());
            }
            
            
            
            
            IOUtils.copy(fileInputStream, response.getOutputStream());
            response.flushBuffer();
            
            fileInputStream.close();
        }
        
    }
}
