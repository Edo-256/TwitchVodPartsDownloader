import java.io.*;
import java.util.*;

import src_prop.Twitch_downloader;

public class Launcher{
    public static void main(String args[]) throws IOException, InterruptedException
    {
      //java Launcher url format hs:ms he:me
      if(args.length != 0){

        //detect staring time of clip
        int pos1time = args[2].indexOf(':');
        int hs = Integer.parseInt(args[2].substring(0, pos1time));
        int ms = Integer.parseInt(args[2].substring(pos1time+1));

        //detect end time of clip
        int pos2time = args[3].indexOf(':');
        int he = Integer.parseInt(args[3].substring(0, pos2time));
        int me = Integer.parseInt(args[3].substring(pos2time+1));

        Twitch_downloader.launch_download(args[0], args[1], hs, ms, he, me);
        
      }else{
        Scanner keyboardd = new Scanner(System.in);

        System.out.println("Insert Link");
        String link = keyboardd.nextLine();


        System.out.println("Insert Fromat (ex. 360p, 1080p, ...)");
        String formato = keyboardd.nextLine();


        System.out.println("Insert Hours_Start");
        int ora1 = keyboardd.nextInt();
        keyboardd.nextLine();


        System.out.println("Insert Minute_Start");
        int minuti1 = keyboardd.nextInt();
        keyboardd.nextLine();


        System.out.println("Insert Hours_End");
        int ora2 = keyboardd.nextInt();
        keyboardd.nextLine();


        System.out.println("Insert Minute_End");
        int minuti2 = keyboardd.nextInt();
        keyboardd.nextLine();

        keyboardd.close();

        Twitch_downloader.launch_download(link, formato, ora1, minuti1, ora2, minuti2);
        return;
      }
	    return;
    }
}
