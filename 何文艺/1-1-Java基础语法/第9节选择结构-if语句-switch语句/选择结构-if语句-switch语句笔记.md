**选择结构-if语句-switch语句笔记**  


----------


**一、流程概述与顺序结构**  
    三种流程：顺序、选择、循环  
      
**二、选择结构_单if语句** 

    if(关系表达式){  
      语句体  
    }  
      
**三、选择结构_标准if-else语句**  

    if(关系表达式){  
      语句体1  
    } else {  
      语句体2  
    }  
      
**四、选择结构_扩展if-else语句**  

    if(关系表达式1) {  
      语句体1  
    } else if(关系表达式2) {  
      语句体2  
    } else if(关系表达式3) {  
    ...  
    } else if(关系表达式n) {  
      语句体n  
    } else {  
      语句体n+1  
    }  
      
**五、练习_用if语句实现考试成绩等级的判断（Grade.java）**  
  
**六、练习_用if语句替换三元运算符实现取两个数中的较大值（IfTest.java）**  
  
**七、选择结构_标准的switch**  

    switch(表达式) {  
      case 常量值1:  
        语句体1  
        break;  
      case 常量值2:  
        语句体2  
        break;  
      ...  
      case 常量值n:  
        语句体n  
        break;  
      default:  
        语句体n+1  
        break;    
    }  
      
**八、选择结构_穿透的switch**  
switch语句使用的注意事项：  
1.多个case后面的数值不可以重复  
2.switch后面小括号当中只能是下列数据类型：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基本数据类型：byte/short/char/int  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;引用数据类型：String字符串/enum枚举  
3.switch语句格式可以很灵活：前后顺序可以颠倒，而且break语句还可以省略  
                      
【匹配哪一个case就从哪一个位置向下执行，直到遇到了break或者整体结束为止】