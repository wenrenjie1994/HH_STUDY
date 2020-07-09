package main.mapper;

import main.dto.Result;
import main.entity.AbstractResume;
import main.mapper.interfaces.ResumeMapper;

/**
 * @author: hqweay
 * @description: 对数据操作进行抽象，可以从内存、可以从文本
 * Created on 7/2/20 12:01 PM
 */
public class AbstractResumeMapper implements ResumeMapper {
  @Override
  public Result saveResume(AbstractResume resume) {
    return Result.errorResult();
  }

  @Override
  public Result removeResume(AbstractResume resume) {
    return Result.errorResult();
  }

  @Override
  public Result updateResume(AbstractResume oldResume, AbstractResume newResume) {
    return Result.errorResult();
  }

  @Override
  public Result getResumeByID(AbstractResume oldResume) {
    return Result.errorResult();
  }

  @Override
  public Result listResume() {
    return Result.errorResult();
  }

}
