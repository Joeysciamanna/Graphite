package ch.g_7.graphite.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Objects;

public class Test {

	public static void main(String[] args) throws IOException {

		InputStream inputStream = Test.class.getResourceAsStream("/textures/square1.png");

		ByteBuffer byteBuffer = ByteBuffer.wrap(inputStream.readAllBytes());

		try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Joey Sciamanna\\Desktop\\square1.png")) {
//			fos.write(b);
//			inputStream.transferTo(fos);
			
			WritableByteChannel channel = Channels.newChannel(fos);
			channel.write(byteBuffer);
			channel.close();

		}


	}

}
