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
			
			ByteBuffer buffer = ByteBuffer.allocate(100);
//			byte[] outputBytes = "Hello world!".getBytes();
//			byte[] outputBytes2 = "Nice to meet you".getBytes();
//			buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(100);
//			buffer.flip();
			
			
			byte[] outputBytes = "Hello world!".getBytes();
			buffer.put(outputBytes);
			long intPos = outputBytes.length;
			buffer.putInt(245);
			long intPos2 = intPos + Integer.BYTES;
			buffer.putInt(-98765);
			byte[] outputBytes2 = "Nice to meet you".getBytes();
			buffer.put(outputBytes2);
			long intPos3 = intPos2 + Integer.BYTES + outputBytes.length;
			buffer.putInt(1000);
			buffer.flip();
			
			binChannel.write(buffer);
			
			RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
			FileChannel channel = ra.getChannel();
			
			ByteBuffer readBuffer = ByteBuffer.allocate(100);
			channel.read(readBuffer);
			readBuffer.flip();
			byte[] inputString = new byte[outputBytes.length];
			readBuffer.get(inputString);
			System.out.println("inputString " + new String(inputString));
			System.out.println("int1 = " + readBuffer.getInt());
			System.out.println("int2 = " + readBuffer.getInt());
			byte[] inputString2 = new byte[outputBytes2.length];
			readBuffer.get(inputString2);
			System.out.println("inputString " + new String(inputString2));
			System.out.println("int1 = " + readBuffer.getInt());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
