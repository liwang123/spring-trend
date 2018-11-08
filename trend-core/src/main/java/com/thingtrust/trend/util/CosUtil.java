package com.thingtrust.trend.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.Random;

/**
 * @author liwang
 */
@Service
public class CosUtil {


    private final String appId = "1253605028";

    private final String secretId = "AKIDsfPyMbJU8byMhrvZAaAex54wb4W8bpxw";

    private final String secretKey = "JXmvvkOuHTn7KLBA3pQvFNI2b2KVaU8f";

    private final String region = "ap-beijing";

    private final String bucketName = "token-image";

    private final String tencentUrl = "http://token-image-1253605028.cos.ap-beijing.myqcloud.com;";

    private final String retrunUrl = "http://token-image-1253605028.file.myqcloud.com/";

    private COSClient getCOSClient() {
        final COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        final ClientConfig clientConfig = new ClientConfig(new Region(region));
        return new COSClient(cred, clientConfig);
    }

    private static void close(final COSClient cosClient) {
        if (cosClient != null) {
            cosClient.shutdown();
        }
    }


    /**
     * 上传图片
     *
     * @param url
     */
    public void uploadImg2Cos(final String url) throws Exception {
        final File fileOnServer = new File(url);
        final FileInputStream fin;
        try {
            fin = new FileInputStream(fileOnServer);
            final String[] split = url.split("/");
            uploadFile2Cos(fin, split[split.length - 1]);
        } catch (final FileNotFoundException e) {
            throw new Exception("图片上传失败");
        }
    }

    public String uploadFile2Cos(final MultipartFile file) throws Exception {
        if (file.getSize() > 10 * 1024 * 1024) {
            throw new Exception("上传图片大小不能超过10M！");
        }

        final BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        if (bufferedImage != null) {

//            if (imageHeight != null && imageWidth != null) {
//                if (bufferedImage.getWidth() > imageWidth || bufferedImage.getHeight() > imageHeight) {
//                    result.setCode(ResultEnum.PRECONDITION_FAILED.getCode());
//                    result.setMsg(ResultEnum.PRECONDITION_FAILED.getMsg() + ": 像素大小不能超出" + imageHeight + "*" + imageWidth);
//                    return result;
//                }
//            }

        }
        final String originalFilename = file.getOriginalFilename();
        final String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        final Random random = new Random();
        final String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            final InputStream inputStream = file.getInputStream();
            uploadFile2Cos(inputStream, name);
            return retrunUrl + name;
        } catch (final Exception e) {
            throw new Exception("图片上传失败");
        }
    }

    /**
     * 获得图片路径
     *
     * @param fileUrl
     * @return
     */
    public String getImgUrl(final String fileUrl) {
        return getUrl(fileUrl);
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(final String key) {
        final COSClient cosClient = getCOSClient();
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        final Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        final URL url = cosClient.generatePresignedUrl(new StringBuilder(bucketName).append("-").append(appId).toString(), key, expiration);
        if (url != null) {
            close(cosClient);
            return url.toString();
        }
        return null;
    }

    /**
     * 上传到COS服务器 如果同名文件会覆盖服务器上的
     *
     * @param instream 文件流
     * @param fileName 文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public String uploadFile2Cos(final InputStream instream, final String fileName) {
        final COSClient cosClient = getCOSClient();
        String ret = "";
        try {
            // 创建上传Object的Metadata
            final ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(CosUtil.getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            final PutObjectResult putResult = cosClient.putObject(new StringBuilder(bucketName).append("-").append(appId).toString(), fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
                close(cosClient);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * Description: 判断Cos服务文件上传时文件的contentType
     *
     * @param filenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(final String filenameExtension) {
        if (filenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
                || filenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (filenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

}
