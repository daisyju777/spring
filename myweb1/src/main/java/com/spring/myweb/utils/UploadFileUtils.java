package com.spring.myweb.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
  public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
    //  원래 이름앞에 랜덤으로 이름을 붙히기 위해 사용 (이름이 중복되는것 방지)
    UUID uid = UUID.randomUUID();
    //  저장할 파일의 이름 가운데에 "_"를 넣는다.
    String savedName = uid.toString() + "_" + originalName;
    //  파일 저장 경로
    String savedPath = calcPath(uploadPath);
    File target = new File(uploadPath + savedPath, savedName);
    FileCopyUtils.copy(fileData, target);
    String uploadFileName = makeIcon(uploadPath, savedPath, savedName);
    return uploadFileName;
  }

  private static String calcPath(String uploadPath) {
    Calendar cal = Calendar.getInstance();
    
    String yearPath = File.separator + cal.get(Calendar.YEAR);
    String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
    String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

    makeDir(uploadPath, yearPath, monthPath, datePath);

    return datePath;
  }

  private static void makeDir(String uploadPath, String... paths) {
    if (new File(paths[paths.length - 1]).exists())
      return;
    for (String path : paths) {
      File dirPath = new File(uploadPath + path);
      if (!dirPath.exists())       //디렉토리가 없으면 만들어라
        dirPath.mkdir();
    }
  }

  private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {
    String iconName = uploadPath + path + File.separator + fileName;
    return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
  }
}
