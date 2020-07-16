package pers.wx.Tarjet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
 
/**
 * 将.pcm文件转为WAV文件
 * @author Administrator
 *
 */
public class pcm_wav {
	
	
	
	public static void main(String[] args) throws Exception {
		if(args.length<2) {
			args = new String[2];
			args[0] = "G:\\Tarjettest\\123.pcm";//输入路径
			args[1] = "G:\\Tarjettest\\123.wav";//输出路径
		}
		convertAudioFiles(args);
	}
	
	
	
	
	public static void convertAudioFiles(String[] src) throws Exception {
		   FileInputStream fis = new FileInputStream(src[0]);
 
		   //计算长度
		   byte[] buf = new byte[4*2048];
		   int size = fis.read(buf);
		   int PCMSize = 0;
		   while (size != -1) {
		      PCMSize += size;
		      size = fis.read(buf);
		    }
		   fis.close();
 
 
		   //填入参数，比特率等等。这里用的是16位单声道 8000 hz
		   WaveHeader header = new WaveHeader(PCMSize);
		   //长度字段 = 内容的大小（PCMSize) + 头部字段的大小(不包括前面4字节的标识符RIFF以及fileLength本身的4字节)
		   header.fileLength = PCMSize + (44 - 8);
		   header.FmtHdrLeth = 16;
		   header.BitsPerSample = 16;
		   header.Channels = 2;
		   header.FormatTag = 0x0001;
		   header.SamplesPerSec = 44100;
		   header.BlockAlign = (short)(header.Channels * header.BitsPerSample / 8);
		   header.AvgBytesPerSec = header.BlockAlign * header.SamplesPerSec;
		   header.DataHdrLeth = PCMSize;
 
		   byte[] h = header.getHeader();
 
		   assert h.length == 44; //WAV标准，头部应该是44字节
		   
//		   auline.write(h, 0, h.length);
		   
		   byte[] b = new byte[10];
		   
		   FileOutputStream fs = new FileOutputStream(src[1]);
		   fs.write(h);
		   FileInputStream fiss = new FileInputStream(src[0]);
		   byte[] bb = new byte[10];
		   int len = -1;
		   while((len = fiss.read(bb))>0) {
			   fs.write(bb, 0, len);
		   }
		   
		}
}
 
 
 
/**
 * WavHeader辅助类。用于生成头部信息。
 * @author Administrator
 *
 */
class WaveHeader { 
	public final char fileID[] = {'R', 'I', 'F', 'F'};
	public int fileLength;
	public short FormatTag;
	public short Channels;
	public int SamplesPerSec;
	public int AvgBytesPerSec;
	public short BlockAlign;
	public short BitsPerSample;
	public char DataHdrID[] = {'d','a','t','a'};
	public int DataHdrLeth;
	public char wavTag[] = {'W', 'A', 'V', 'E'};;
	public char FmtHdrID[] = {'f', 'm', 't', ' '};
	public int FmtHdrLeth;
	
	public WaveHeader() {}//无参构造方法
	/**
	 * 
	 * @param a
	 */
	public WaveHeader(int a) {
		
	}
	
	public byte[] getHeader() throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		WriteChar(bos, fileID);
		WriteInt(bos, fileLength);
		WriteChar(bos, wavTag);
		WriteChar(bos, FmtHdrID);
		WriteInt(bos,FmtHdrLeth);
		WriteShort(bos,FormatTag);
		WriteShort(bos,Channels);
		WriteInt(bos,SamplesPerSec);
		WriteInt(bos,AvgBytesPerSec);
		WriteShort(bos,BlockAlign);
		WriteShort(bos,BitsPerSample);
		WriteChar(bos,DataHdrID);
		WriteInt(bos,DataHdrLeth);
		bos.flush();
		byte[] r = bos.toByteArray();
		bos.close();
		return r;
	}
	
	private void WriteShort(ByteArrayOutputStream bos, int s) throws IOException {
		byte[] mybyte = new byte[2];
		mybyte[1] =(byte)( (s << 16) >> 24 );
		mybyte[0] =(byte)( (s << 24) >> 24 );
		bos.write(mybyte);
	}
	
	
	private void WriteInt(ByteArrayOutputStream bos, int n) throws IOException {
		byte[] buf = new byte[4];
		buf[3] =(byte)( n >> 24 );
		buf[2] =(byte)( (n << 8) >> 24 );
		buf[1] =(byte)( (n << 16) >> 24 );
		buf[0] =(byte)( (n << 24) >> 24 );
		bos.write(buf);
	}
	
	private void WriteChar(ByteArrayOutputStream bos, char[] id) {
		for (int i=0; i<id.length; i++) {
			char c = id[i];
			bos.write(c);
		}
	}
}
 