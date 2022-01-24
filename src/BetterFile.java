package src;

import java.io.*;
import java.util.Scanner;

//Ricordiamo che prende in input solo directory assolute
//Come deciso dal nostro standard

public class BetterFile{

    public String complete_dir;

    public BetterDirectory partial_dir;
    public String filename;
    public String filename_no_ext;
    public String ext_no_point;
    public File std_file;

    public BetterFile(String dir_input)
    {
      this.complete_dir = dir_input;

      int last_slash = dir_input.lastIndexOf("\\");
      this.filename = dir_input.substring(last_slash+1);
      String partial_dir_string = dir_input.substring(0, last_slash);
      this.partial_dir = new BetterDirectory(partial_dir_string);

      int last_dot = this.filename.lastIndexOf(".");
      this.filename_no_ext = this.filename.substring(0, last_dot);
      this.ext_no_point = this.filename.substring(last_dot+1);

      this.std_file = new File(dir_input);
      std_file.setWritable(true);
    }

    public BetterFile renameFile(String new_name)
    {
      //corerct use of this function,
          //BetterFile filen = new BetterFile(...);
          //filen = filen.renameFile(...);

      String new_file_dir = this.partial_dir.complete_dir + "\\" +new_name;
      BetterFile newone = new BetterFile(new_file_dir);
  		boolean result = this.std_file.renameTo(newone.std_file);
      if(result==true)
      {

        return newone;
      }
      else
      {
        System.out.println("ERRORE RENAME");
        return this;
      }
    }

    public BetterFile moveFile(String new_dir)
    {
      //corerct use of this function,
          //BetterFile filen = new BetterFile(...);
          //filen = filen.renameFile(...);

      String new_complete_dir = new_dir + "\\" + this.filename;
      BetterFile new_file = new BetterFile(new_complete_dir);

      boolean success = this.std_file.renameTo(new_file.std_file);
  		if(success == true)
  		{
  			this.std_file.delete();
        return new_file;
  		}
  		else
  		{
  			System.out.println("ERRORE NELLO SPOSTAMENTO DEL FILE, NON SONO STATE APPORTATE MODIFICHE");
        return this;
  		}
    }

//---------------------------------------------------------------

    public static boolean char_valid(char s)
    {
      return Character.isUnicodeIdentifierPart(s);
    }

    public static String convert_to_correct_name(String old_filename)
    {
      String new_filename = "";

      for(int i=0; i<old_filename.length(); i++)
      {
        if(char_valid(old_filename.charAt(i)))
        {
          new_filename += old_filename.charAt(i);
        }
        else
        {
          new_filename += '_';
        }
      }

      return new_filename;
    }

    public BetterFile renameFile_validName()
    {
      String correct_name = convert_to_correct_name(this.filename_no_ext);
      boolean isCorret = this.filename_no_ext.equals(correct_name);
      if(isCorret)
      {
        return this;
      }
      else
      {
        return renameFile(correct_name + "." + this.ext_no_point);
      }
    }

//---------------------------------------------------------------

    public static String random_file_name_number()
    {
      String new_name = "";
      for(int j=0;j<20;j++)//add to new_name the number digits
      {
        int number_gen = (int) ((Math.random()*10)); //between 0 and 9
        new_name = new_name+number_gen;
      }
      return new_name;
    }

    public boolean check_name_only_number()
  	{
  		boolean only_number = true;
  		int str_len = this.filename_no_ext.length();
  		for(int i=0;i<str_len;i++)
  		{
  			boolean coditionif = this.filename_no_ext.charAt(i) >= '0' && this.filename_no_ext.charAt(i) <= '9';
  			if(!coditionif)
  			{
  				only_number = false;
  			}
  		}
  		return only_number;
  	}

    public BetterFile rename_to_random()
    {
      boolean b = this.check_name_only_number();
      if(b)
      {
        return this;
      }
      else
      {
        String new_name = random_file_name_number();
        BetterFile new_file = this.renameFile(new_name+"."+this.ext_no_point);
        return new_file;
      }
    }

//---------------------------------------------------------------

    public static void main(String args[]) throws IOException
    {
    }
}
