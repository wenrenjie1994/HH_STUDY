package pers.wx.Tarjet;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.TargetDataLine;
public class RecordAndPlay
{
    static volatile boolean stop=false;
    public static int dqz_ctr=0; //0为左右声道播放，1为只播放左声道，2为只播放右声道
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
        Play();
    }
    
    //播放实时音频
    public static void Play()
    {

        try
        {
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
            
            //回放音频时的音量增强控制
            FloatControl fc=(FloatControl)sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN); 
            double value=2; //原来音量的2倍
            //double value=0.5; //原来音量的一半
            //0.0001倍即为 -80dB
            float dB = (float)
                  (Math.log(value==0.0?0.0001:value)/Math.log(10.0)*20.0);
            fc.setValue(dB); //以dB为单位进行设定，最大为2倍（6.0206dB），最小为0（静音，等效为不播放）
            
            int nByte = 0;
            //final int bufSize=4*100;//分帧，帧长为400字节，在双声道16bit量化的采样下即为400*8/16/2=每声道100个采样点数，也即100/44100Hz=0.00226757369614512471655328798186秒的数据
            //final int bufSize=4*441; //0.01秒，441个采样点
            final int bufSize=4*2048; //2048个采样点
            System.out.println("采样率=44100Hz，双声道，16bit线性PCM，每声道每帧"+bufSize/4+"个采样点（"+(bufSize/4.0/44100)+"s），音量增强="+dB+"dB");
            
            byte[] buffer = new byte[bufSize];
            long ncount=0; //计数
			while (nByte != -1) 
			{ 
				ncount++;
                nByte = targetDataLine.read(buffer, 0, bufSize);
				/*
				 * int n; for(n=0;n<=bufSize&&n<nByte;n+=1) { short data = buffer[n]; }
				 */
                System.out.print("\r第"+ncount+"次从音频流一次读入 Byte="+nByte+" 字节");
                int n; 
                short l1=0;
                short r1=0;
                int l2=0;
                int r2=0;
                int d1=0;
                float d2=0;
                float d3=0;
                for(n=0;n<=bufSize&&n<nByte;n+=4)
                {
                l1 = (short)(((buffer[n] & 0x00FF) << 8) | (0x00FF & buffer[n+1]));
                r1 = (short)(((buffer[n+2] & 0x00FF) << 8) | (0x00FF & buffer[n+3]));
                l2 = (int)((short)(Math.abs(l1)));
                r2 = (int)((short)(Math.abs(r1)));
                d1 += l2+r2;
                }
                d2 = d1/2048;
                System.out.println("\r平均能量："+d2);
                d3 = (float)(Math.log(d2));
                System.out.println("\r一帧："+d3);
				sourceDataLine.write(buffer, 0, nByte);//原始采样到的左右声道都送播放 }
			}
			  sourceDataLine.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
