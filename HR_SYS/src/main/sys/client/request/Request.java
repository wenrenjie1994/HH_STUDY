package main.sys.client.request;

import main.dto.RequestDTO;
import main.dto.Result;
import main.entity.Resume;
import main.enums.RequestEnum;
import main.mapper.AbstractResumeMapper;
import main.mapper.DBResumeMapper;
import main.sys.client.request.utils.ParamGetter;
import main.view.TerminalView;
import main.view.interfaces.View;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author: hqweay
 * @description: 客户端与 Server 交互（算是代理类）
 * Created on 7/15/20 2:42 PM
 */
public class Request extends AbstractRequest {

  // 通过 ResumeServiceHelper 实现数据的展示
  private View TerminalView;
  private ParamGetter paramGetter;
  private Scanner scanner;

  // resumeService
  public Request(AbstractResumeMapper resumeMapper, Scanner scanner) {
    TerminalView = new TerminalView(new DBResumeMapper());
    paramGetter = new ParamGetter(scanner);
  }

  public Request() {
  }

  @Override
  public void saveResume() {
    Resume resume = paramGetter.saveResume();

    Result result = null;
    RequestDTO requestDTO = new RequestDTO(RequestEnum.SAVE_RESUME, new Resume[]{resume});
    try {
      out.writeObject(requestDTO);
      result = (Result) in.readObject();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    TerminalView.saveResume(result);
  }


  @Override
  public void removeResume() {
    Resume resume = paramGetter.removeResume();

    Result result = null;
    RequestDTO requestDTO = new RequestDTO(RequestEnum.REMOVE_RESUME, new Resume[]{resume});
    try {
      out.writeObject(requestDTO);
      result = (Result) in.readObject();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    TerminalView.removeResume(result);

  }

  @Override
  public void updateResume() {
    Resume resume = paramGetter.getResumeByID();
    Result result = null;
    RequestDTO requestDTO = new RequestDTO(RequestEnum.GET_RESUME_BY_ID, new Resume[]{resume});
    try {
      out.writeObject(requestDTO);
      result = (Result) in.readObject();
      Resume oldResume = (Resume) result.getData();

      Resume newResume = paramGetter.updateResume(oldResume);

      requestDTO = new RequestDTO(RequestEnum.UPDATE_RESUME, new Resume[]{oldResume, newResume});
      out.writeObject(requestDTO);
      result = (Result) in.readObject();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    TerminalView.updateResume(result);
  }

  @Override
  public void getResumeByID() {
    Resume resume = paramGetter.getResumeByID();
    Result result = null;
    RequestDTO requestDTO = new RequestDTO(RequestEnum.GET_RESUME_BY_ID, new Resume[]{resume});
    try {
      out.writeObject(requestDTO);
      result = (Result) in.readObject();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    TerminalView.getResumeByID(result);
  }

  @Override
  public void listResume() {
    Result result = null;
    RequestDTO requestDTO = new RequestDTO(RequestEnum.LIST_RESUME);
    try {
      out.writeObject(requestDTO);

      result = (Result) in.readObject();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    TerminalView.listResume(result);
  }
}
