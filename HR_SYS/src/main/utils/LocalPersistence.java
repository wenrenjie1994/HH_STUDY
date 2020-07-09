package main.utils;

import main.dto.ResumeList;
import main.entity.Resume;
import main.enums.ProcessEnum;

import java.io.*;

/**
 * @author: hqweay
 * @description: 将内存里的书据（ResumeList）保存至本地
 * Created on 7/4/20 10:43 AM
 */
public class LocalPersistence {
  private String path = "./db.txt";

  public LocalPersistence(String path) {
    this.path = path;
  }

  public LocalPersistence() {
  }

  public boolean saveToLocal(ResumeList list) {
    File file = new File(this.path);
    try {
      if (!file.exists()) {
        file.createNewFile();
      }
      // FileWriter fileWritter = new FileWriter(file.getName());
      // BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

      Writer bufferWritter = new BufferedWriter(
              new OutputStreamWriter(
                      new FileOutputStream(file), "UTF-8"));
      list.forEach(resume -> {
        try {
          bufferWritter.write(resume.toSaveString());
          bufferWritter.write("\n");
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
      bufferWritter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  public ResumeList getFromLocal() {
    ResumeList list = new ResumeList();
    File file = new File(this.path);
    try {
      if (!file.exists()) {
        file.createNewFile();
      }


      BufferedReader bufferedReader = new BufferedReader(
              new InputStreamReader(
                      new FileInputStream(file), "UTF-8"));

      String resumeStr = null;
      while ((resumeStr = bufferedReader.readLine()) != null) {
        // resumeStr to resume object
        String[] resumeFields = resumeStr.split(",");
        ProcessEnum processEnum = ProcessEnum.PASS_APPLICATION;
        processEnum.setCode(Integer.parseInt(resumeFields[3]));
        Resume resume = new Resume(resumeFields[0], resumeFields[1], resumeFields[2], processEnum, false);
        list.add(resume);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }
}
