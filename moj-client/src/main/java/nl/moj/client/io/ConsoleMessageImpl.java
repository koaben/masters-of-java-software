package nl.moj.client.io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 *
 */
public class ConsoleMessageImpl extends AbstractMessage implements Message.Console {

	private String myConsole,myContent;
	
	public ConsoleMessageImpl(String console,String content) {
		super(Message.MSG_CONSOLE);
		myConsole=console;
		myContent=content;
	}
	
	public ConsoleMessageImpl(int type,DataInput in) throws IOException {
		super(type,in);
		if (type!=Message.MSG_CONSOLE) throw new IOException("Incorrect Type"); 
		myConsole=in.readUTF();
		myContent=in.readUTF();
	}
	
	public void write(DataOutput out) throws IOException {
		super.write(out);
		out.writeUTF(myConsole);
		out.writeUTF(myContent);
	}
	
	public String getConsole() { return myConsole;  }
	public String getContent() { return myContent;	}

}
