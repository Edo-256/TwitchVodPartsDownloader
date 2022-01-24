package src;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

public class BetterDirectory{
    public String complete_dir;
    public String[] arr_dir;

    public BetterDirectory(String input_dir)
    {
      this.complete_dir = input_dir;
    }

    public void generate_arr_dir()
    {
      this.arr_dir = this.complete_dir.split(Pattern.quote(File.separator));
    }

    public String[] dir_of_all_files_in_dir() throws IOException
  	{
  		List<File> filesInFolder = Files.walk(Paths.get(this.complete_dir)).filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
  		int contatore = 0;
  		for (File oggetto : filesInFolder)
  		{
  			contatore++;
          }
  		String array_con_directory[] = new String[contatore];
  		contatore = 0;
  		for (File oggetto : filesInFolder)
  		{
  			array_con_directory[contatore] = oggetto.getAbsolutePath();
  			contatore++;
          }
  		return array_con_directory;
  	}

    public void rename_random_all_file_dir() throws IOException
    {
      //rename all files in the directory with name composed by 20numbers
      String[] dir_of_all_files = this.dir_of_all_files_in_dir();
      BetterFile file_select;

      for(int i=0; i<dir_of_all_files.length; i++)
      {
        file_select = new BetterFile(dir_of_all_files[i]);
        file_select.rename_to_random();
      }
    }

    public void rename_valid_all_file_dir() throws IOException
    {
      //rename all files in the directory by replacin all invalid char with _
      String[] dir_of_all_files = this.dir_of_all_files_in_dir();
      BetterFile file_select;

      for(int i=0; i<dir_of_all_files.length; i++)
      {
        file_select = new BetterFile(dir_of_all_files[i]);
        file_select.renameFile_validName();
      }
    }

    public static void main(String args[]) throws IOException
    {
    }
}
