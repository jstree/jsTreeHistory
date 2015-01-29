/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package egovframework.com.ext.jstree.support.util.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.ext.jstree.support.manager.mvc.controller.GenericAbstractController;
import egovframework.com.ext.jstree.support.manager.mvc.exception.GenericServiceRuntimeException;

@Controller
public class EncryptionController extends GenericAbstractController
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Map<String, Map<String, Object>> bindTypes()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * Modification Information
     * 
     * @author 오권우
     * @since 2014. 12. 18.
     * @version 1.0
     * @throws NoSuchAlgorithmException
     * @see <pre>
     *  Class Name  : EncryptionController.java
     *  Description : 암호화 컨트롤러 클래스
     *  Infomation  : 암호화 컨트롤러 클래스
     *  
     *  << 개정이력(Modification Information) >>
     *  
     *  수정일               수정자                 수정내용
     *  -------       ------------   -----------------------
     *  2014. 12. 18.        오권우                 최초 생성
     * 
     *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
     * </pre>
     */
    @RequestMapping(value = "/common/ClientEncryption.do")
    public String EncryptionModule()
    {
        return "/jsp/encryption/ClientEncryptionModule";
    }
    
    @SuppressWarnings("unused")
    @RequestMapping(value = "/common/EncryptionModule.do")
    public void EncryptionModule(String url, String password) throws GenericServiceRuntimeException,
            NoSuchAlgorithmException
    {
        // MD5 암호화
        String EncryptionUrl = encryptText(url);
        // SHA256 암호화
        String EncryptionPasswd = sha256(password);
        // return "/jsp/encryption/EncryptionModuleSample";
    }
    
    private static byte[] sharedvector = { 0x01, 0x02, 0x03, 0x05, 0x07, 0x0B, 0x0D, 0x11 };
    
    public String sha256(String password) throws NoSuchAlgorithmException
    {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        sha256.update(password.getBytes());
        byte byteData[] = sha256.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++)
        {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        logger.info("원문: " + password + "   Password SHA-256: " + sb.toString() + "   SourceLine:");
        return sb.toString();
    }
    
    // 암호화
    public String encryptText(String url)
    {
        String encUrl = "";
        byte[] keyArray = new byte[24];
        byte[] temporaryKey;
        String key = "developersnotedotcom";
        byte[] toEncryptArray = null;
        try
        {
            toEncryptArray = url.getBytes("UTF-8");
            MessageDigest m = MessageDigest.getInstance("MD5");
            temporaryKey = m.digest(key.getBytes("UTF-8"));
            
            if (temporaryKey.length < 24)
            { // DESede require 24 byte length key
                int index = 0;
                for (int i = temporaryKey.length; i < 24; i++)
                {
                    keyArray[i] = temporaryKey[index];
                }
            }
            
            Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(sharedvector));
            byte[] encrypted = c.doFinal(toEncryptArray);
            encUrl = Base64.encodeBase64String(encrypted);
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException NoEx)
        {
            logger.error(NoEx.getMessage());
        }
        logger.info("endUrl : " + encUrl + "   SourceLine:");
        return encUrl;
    }
    
    // 복호화
    @SuppressWarnings("unused")
    public String decryptText(String encUrl)
    {
        String decUrl = "";
        byte[] keyArray = new byte[24];
        byte[] temporaryKey;
        String key = "develoㄴㄴㄴㄴㄴ";
        byte[] toEncryptArray = null;
        
        try
        {
            MessageDigest m = MessageDigest.getInstance("MD5");
            temporaryKey = m.digest(key.getBytes("UTF-8"));
            
            if (temporaryKey.length < 24)
            { // DESede require 24 byte length key
                int index = 0;
                for (int i = temporaryKey.length; i < 24; i++)
                {
                    keyArray[i] = temporaryKey[index];
                }
            }
            
            Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(sharedvector));
            byte[] decrypted = c.doFinal(Base64.decodeBase64(encUrl));
            
            decUrl = new String(decrypted, "UTF-8");
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException NoEx)
        {
            logger.error(NoEx.getMessage());
        }
        logger.info("decUrl : " + decUrl + "   SourceLine:");
        return decUrl;
    }
}
