package src;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;


public class Cmd_exec
{
	public static void executeCmd(String arr_command[])
	{
	    try
		{
			String complete_string = "";
			for(int i=0; i<arr_command.length;i++ ){
				complete_string += arr_command[i];
				if(i<arr_command.length-1){
					complete_string += " && ";
				}
			}
			complete_string += " && exit";
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K \""+complete_string+"\"");
	    }
		catch (IOException e)
		{
	        e.printStackTrace();
	    }
	}

	public static void main(String[] args) throws IOException, InterruptedException
	{
	}
}
