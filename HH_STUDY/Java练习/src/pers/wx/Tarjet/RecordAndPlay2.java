package pers.wx.Tarjet;
//TargetDataLine是声音的输入(麦克风),而SourceDataLine是输出(音响,耳机).
//整个过程,请参见下面的程序.(运行后,实时地从麦克风录音,实时输出).
//javax.sound包被默认包含在JDK中
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.TargetDataLine;

//演示AWT绘图
import java.awt.*;  //导入java.util包

class dqz_draw extends Frame  //定义从Frame类继承的dqz_draw类
{
	
	
	public void paint(Graphics g)
	{ 
		//定义一个新的字体myfont，字体为宋体、加斜体、高度为40点
		Font myfont=new Font("宋体",Font.ITALIC,40);
		g.setFont(myfont);  //设置myfont字体为当前字体
		
		
		g.drawOval(60,50,80,80);	//在指定(X,Y)坐标处绘制长宽均为80的椭圆（即圆）。	
    g.setColor(Color.red);  //设置当前颜色为红色
		g.fillOval(150,50,80,80);	//在指定(X,Y)坐标处绘制长宽均为80的实心椭圆（即圆）。	
    g.setColor(Color.red);  //设置当前颜色为红色
		g.drawOval(240,50,80,80);	//在指定(X,Y)坐标处绘制长宽均为80的椭圆（即圆）。	
	
		g.setColor(Color.green);  //设置当前颜色为绿色
		g.drawString("这是测试",80,260);  //在指定(X,Y)坐标处绘制字符串

    int i,x,y,R,G,B;
    for(i=0;i<20;i++)  //绘制20个随机实心圆
    {
    	 x=(int)(Math.random()*300)+30; //随机生成坐标x
    	 y=(int)(Math.random()*300)+30; //随机生成坐标y
    	 R=(int)(Math.random()*255);  //随机生成红基色
    	 G=(int)(Math.random()*255);  //随机生成绿基色
    	 B=(int)(Math.random()*255);  //随机生成蓝基色
    	 g.setColor(new Color(R,G,B));   //设置当前颜色为随机RGB颜色
    	 
    	 g.fillOval(x,y,10,10); //以随机颜色在随机坐标处绘制直径为10个像素的实心圆
    }

    g.setColor(Color.orange);  //设置当前颜色为橙色
    y=100;
    for(i=0;i<40;i++)  //绘制40个矩形
    {
    	y+=5;
    	g.drawRect(30,30,320,y); //依次绘制40个间隔为5的矩形
    }
    
   

 }
} 

public class RecordAndPlay2      //定义公共类
{
    static volatile boolean stop=false;
    public static int dqz_ctr=0; //0为左右声道播放，1为只播放左声道，2为只播放右声道
    static dqz_draw a; //绘图窗体
    
    public static void main(String[] args)
    {
    	 System.out.println("命令行参数个数args.length="+args.length);
    	 System.out.println("命令行传给程序的参数为 L 时只播放左声道，为 R 时只播放右声道，否则播放立体声");
    	 dqz_ctr=0;
    	 if(1==args.length)
    	 {
    	  	if(args[0].equalsIgnoreCase("L"))dqz_ctr=1;
    	  	else if(args[0].equalsIgnoreCase("R"))dqz_ctr=2;
    	 }
    	  
    	 a=new dqz_draw(); //实例化一个直接继承自Frame类的dqz_draw类对象
  	   a.setTitle("java从声卡录音并播音");
  	   a.setSize(600,480); //设置组件为320×240象素
	     //a.setLocation(120,250); //设置组件位置X,Y坐标
	   
	     /*设置布局为流布局
	     如果不设置布局类型，整个框架中各组件对象将被重叠在一起。
	     结果是只能看到最后一个组件对象。 */
  	   a.setLayout(new FlowLayout()); 
  
     
       //最后才能是显示框架
       //否则在此之行代码之后加入的可视化组件都不能被显示
       a.setVisible(true);
       
       Play();
    }
    
    //播放音频文件
    public static void Play() 
    {

        try {
            AudioFormat audioFormat =
//                    new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F,
//                    8, 1, 1, 44100F, false);
             new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100F, 16, 2, 4,
             44100F, true);//有符号线性PCM编码，每个采样值16bit编码，44.1KHz采样频率，双声道，每帧4字节（即左右声道，每声道2字节），每秒帧数44100（由采样率而得），指示是否以 big-endian (大数在前)字节顺序存储单个样本中的数据（false 意味着 little-endian（小数在前））。

            DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
            TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
            targetDataLine.open(audioFormat);
            final SourceDataLine sourceDataLine;
            info = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(audioFormat);
            targetDataLine.start();
            sourceDataLine.start();
            FloatControl fc=(FloatControl)sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
            double value=2;
            float dB = (float)
                  (Math.log(value==0.0?0.0001:value)/Math.log(10.0)*20.0);
            fc.setValue(dB);
            int nByte = 0;
            final int bufSize=4*100;
            byte[] buffer = new byte[bufSize];
            
            //dqz测试对有符号的线性PCM编码的左右声道数据分离
            byte[] bleft=new byte[bufSize];
            int kk=0,hh=0;
            
            while (nByte != -1) {
                //System.in.read();
                nByte = targetDataLine.read(buffer, 0, bufSize);
                //System.out.println("\nByte="+nByte);
                
                if(1==dqz_ctr)
                {
                  //提取左声道（每个声道连续2字节）
                  for(kk=0;kk<bufSize&&kk<nByte;kk+=4)
                  {
                	  bleft[kk]=buffer[kk]; //保留左声道数据
                	  bleft[kk+1]=buffer[kk+1];
                	  bleft[kk+2]=0; //右声道数据删除
                	  bleft[kk+3]=0;
                  }
                  sourceDataLine.write(bleft, 0, nByte); //处理过的左或右声道送播放
                }
                else if(2==dqz_ctr)
                {
                  //提取右声道（每个声道连续2字节）
                  for(kk=0;kk<bufSize&&kk<nByte;kk+=4)
                  {
                	  bleft[kk]=0; //左声道数据删除
                	  bleft[kk+1]=0;
                	  bleft[kk+2]=buffer[kk+2]; //保留右声道数据
                	  bleft[kk+3]=buffer[kk+3];
                	}
                	sourceDataLine.write(bleft, 0, nByte); //处理过的左或右声道送播放
                }
                else
                {
                	//播放没有处理过的原始采样的立体声
                	sourceDataLine.write(buffer, 0, nByte); //原始采样到的左右声道都送播放
                }
                
                
            }
            sourceDataLine.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
