package test.mapper;

import main.dto.Result;
import main.dto.ResumeList;
import main.mapper.DBResumeMapper;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/9/20 2:58 PM
 */
public class DBResumeMapperTest {

  public static void main(String[] args) {
    listResumeTest();
  }

  public static void listResumeTest() {
    Result result = new DBResumeMapper().listResume();
    ResumeList resumes = (ResumeList) result.getData();
    resumes.forEach(System.out::println);
  }
}
