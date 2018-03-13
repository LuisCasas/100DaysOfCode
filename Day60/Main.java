package com.luiscasas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		try(FileOutputStream binFile = new FileOutputStream("data.dat");
			FileChannel binChannel = binFile.getChannel()){
			
			byte[] outputBytes = "Hello world!".getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
			int numBytes = binChannel.write(buffer);
			System.out.println("Number of bytes " + numBytes);
			
			ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
			intBuffer.putInt(245);
			intBuffer.flip();
			numBytes = binChannel.write(intBuffer);
			System.out.println("Number of bytes " + numBytes);
			
			intBuffer.flip();
			intBuffer.putInt(-85032);
			intBuffer.flip();
			numBytes = binChannel.write(intBuffer);
			System.out.println("Number of bytes " + numBytes);		
			
			RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
			FileChannel channel = ra.getChannel();
			long numBytesRead = channel.read(buffer);
			outputBytes[0] = 'a';
			outputBytes[1] = 'b';
			buffer.flip();
			if(buffer.hasArray()) {
				System.out.println("Buffer bytes: " + new String(buffer.array()));
			}
			
			// absolute read:
			intBuffer.flip();
			numBytesRead = channel.read(intBuffer);	
			System.out.println(intBuffer.getInt(0));
			intBuffer.flip();
			numBytesRead = channel.read(intBuffer);	
			System.out.println(intBuffer.getInt(0));			
			
			// relative read:
//			intBuffer.flip();
//			numBytesRead = channel.read(intBuffer);
//			intBuffer.flip();
//			System.out.println(intBuffer.getInt());
//			intBuffer.flip();
//			numBytesRead = channel.read(intBuffer);
//			intBuffer.flip();
//			System.out.println(intBuffer.getInt());
			
			
			channel.close();
			ra.close();
			
			// System.out.println("Output bytes: " + new String(outputBytes));
//			RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//			byte[] b = new byte[outputBytes.length];
//			ra.read(b);
//			
//			System.out.println(new String(b));
//			
//			long int1 = ra.readInt();
//			long int2 = ra.readInt();
//			
//			System.out.println(int1);
//			System.out.println(int2);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
