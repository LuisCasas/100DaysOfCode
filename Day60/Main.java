package com.luiscasas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
			
			byte[] outputByte = "Hello world!".getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(outputByte);
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
			
			
			
//			FileInputStream file = new FileInputStream("data.txt");
//			FileChannel channel = file.getChannel();
			
//			Path dataPath = FileSystems.getDefault().getPath("data.txt");
//			Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
//			List<String> lines = Files.readAllLines(dataPath);
//			for(String line : lines) {
//				System.out.println(line);
//			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
