package main.enums;

/**
 * @author: hqweay
 * @description: 应聘流程
 * Created on 7/2/20 11:01 AM
 */
public enum ProcessEnum {

  PASS_APPLICATION(0),
  PASS_RESUME(1),
  PASS_WRITTEN_TEST(2),
  PASS_PHYSICAL_TEST(3),
  PASS_BACKGROUND_CHECK(4),
  SIGNED(5),
  EMPLOYED(6);

  /**
   * 可以用 int，仅仅表示状态时，编译器会优化 short 与 int
   * 0：已申请
   * 1：简历通过
   * 2：笔试通过
   * 3：体检通过
   * 4：背调通过
   * 5：已签约
   * 6：已入职
   */
  @SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
  private int code;

  ProcessEnum(int process) {
    this.code = process;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }


  @Override
  public String toString() {
    String str;
    switch (code) {
      case 0:
        str = "已申请";
        break;
      case 1:
        str = "简历通过";
        break;
      case 2:
        str = "笔试通过";
        break;
      case 3:
        str = "体检通过";
        break;
      case 4:
        str = "背调通过";
        break;
      case 5:
        str = "已签约";
        break;
      case 6:
        str = "已入职";
        break;
      default:
        str = "null";
        break;
    }
    return str;
  }
}
