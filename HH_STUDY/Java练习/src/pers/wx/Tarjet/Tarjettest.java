package pers.wx.Tarjet;

import java.io.File;
import java.io.FileOutputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
 
public class Tarjettest{
	private static FileOutputStream os;
	/*
	 * //采样率 private static float RATE = 44100f; //编码格式PCM private static
	 * AudioFormat.Encoding ENCODING = AudioFormat.Encoding.PCM_SIGNED; //帧大小 16
	 * private static int SAMPLE_SIZE = 16; //是否大端 private static boolean BIG_ENDIAN
	 * = true; //通道数 private static int CHANNELS = 2;
	 */
 
	public static void main(String[] args) throws Exception{
		if(args.length<1) {
			save("G:/Tarjettest/123.pcm");
		}else {
			save(args[0]);
		}
	}
 
	public static void save(String path) throws Exception {
		File file = new File(path);
		
		if(file.isDirectory()) {
			if(!file.exists()) {
				file.mkdirs();
			}
			file.createNewFile();
		}
		
		AudioFormat audioFormat =
//              new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F,
//              8, 1, 1, 44100F, false);
       new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,48000F, 16, 2, 4,
       44100F, true);//有符号线性PCM编码，每个采样值16bit编码，44.1KHz采样频率，双声道，每帧4字节（即左右声道，每声道2字节），每秒帧数44100（由采样率而得），指示是否以 big-endian (大数在前)字节顺序存储单个样本中的数据（false 意味着 little-endian（小数在前））。
		TargetDataLine targetDataLine = AudioSystem.getTargetDataLine(audioFormat);
		targetDataLine.open(audioFormat);       
		targetDataLine.start();
		
		final int bufSize=4*2048; //2048个采样点
		System.out.println("采样率=44100Hz，双声道，16bit线性PCM，每声道每帧"+bufSize/4+"个采样点（"+(bufSize/4.0/44100)+"s）");
		byte[] buffer = new byte[bufSize];
		int flag = 0;
		os = new FileOutputStream(file);
		while((flag = targetDataLine.read(buffer, 0, buffer.length))>0) {//从声卡中采集数据
			os.write(buffer);
			System.out.println(flag);
		}
	}
}