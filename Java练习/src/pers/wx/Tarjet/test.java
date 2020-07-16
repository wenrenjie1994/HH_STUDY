package pers.wx.Tarjet;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.TargetDataLine;

public class test {
	
		static volatile boolean stop = false;
		 
		public static void main(String[] args) {
			Play();
		}
	 
		// 播放音频文件
		public static void Play() {
	 
			try {
				AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F, 16, 2, 4, 44100F, true);
	 
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
	            //FloatControl fc=(FloatControl)sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN); 
	            //double value=2; //原来音量的2倍
	            //double value=0.5; //原来音量的一半
	            //0.0001倍即为 -80dB
	            //float dB = (float)
	                  //(Math.log(value==0.0?0.0001:value)/Math.log(10.0)*20.0);
	            //fc.setValue(dB); //以dB为单位进行设定，最大为2倍（6.0206dB），最小为0（静音，等效为不播放）
	            
				int nByte = 0;
				final int bufSize=4*2048; //2048个采样点
	            System.out.println("采样率=44100Hz，双声道，16bit线性PCM，每声道每帧"+bufSize/4+"个采样点（"+(bufSize/4.0/44100)+"s），音量增强="+"dB");
				byte[] buffer = new byte[bufSize];
				long ncount=0; //计数
				while (nByte != -1) {
					ncount++;
	                nByte = targetDataLine.read(buffer, 0, bufSize);
	                System.out.print("\r第"+ncount+"次从音频流一次读入 Byte="+nByte+" 字节");
	                for(int n=0;n<=8191;n++)
	                {	           
	                	if(Math.abs(buffer[n])>125)
	                	{System.out.print("PCM="+buffer[n]);}
	                	else;
	                }
					sourceDataLine.write(buffer, 0, nByte);//原始采样到的左右声道都送播放 }
				}
				sourceDataLine.stop();
	 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 

}
