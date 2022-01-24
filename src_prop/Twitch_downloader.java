package src_prop;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

import src.Cmd_exec;

public class Twitch_downloader
{
	public static void clear_console(){return;}




	public static String get_command(String link, String formato, int sec_start, int sec_to_register) throws IOException, InterruptedException
	{
		String command = "for /f \"delims=\" %a in ('youtube-dl -f "+formato+" -g "+link+"') do (ffmpeg -ss "+sec_start+" -t "+sec_to_register+" -i %a -c copy 1.ts)";
		return command;
	}

	public static int converter_to_second(int ore, int minuti) throws IOException, InterruptedException
	{
		int tmp1 = ore*60;
		int tmp2 = tmp1+minuti;
		return tmp2*60;
	}

	public static int[] parametri_corretti(int start_in_s, int finish_in_s) throws IOException, InterruptedException
	{
		int[] aa = new int[2];
		aa[0] = start_in_s;
		aa[1] = finish_in_s - start_in_s;
		return aa;
	}

	public static void prog_princip() throws IOException, InterruptedException
	{
		Scanner keyboardd = new Scanner(System.in);
		String debug;

		clear_console();
		System.out.println("Insert Link");
		String link = keyboardd.nextLine();

		clear_console();
		System.out.println("Insert Fromat (ex. 360p, 1080p, ...)");
		String formato = keyboardd.nextLine();

		clear_console();
		System.out.println("Insert Hours_Start (ex)");
		int ora1 = keyboardd.nextInt();
		debug = keyboardd.nextLine();

		clear_console();
		System.out.println("Inserisci Minuti_Inizio");
		int minuti1 = keyboardd.nextInt();
		debug = keyboardd.nextLine();

		clear_console();
		System.out.println("Inserisci Ora_Fine");
		int ora2 = keyboardd.nextInt();
		debug = keyboardd.nextLine();

		clear_console();
		System.out.println("Inserisci Minuti_Fine");
		int minuti2 = keyboardd.nextInt();
		debug = keyboardd.nextLine();

		//inizio conversione
		int start_s = converter_to_second(ora1, minuti1);
		int finish_s = converter_to_second(ora2, minuti2);
		int[] values_comm = parametri_corretti(start_s, finish_s);

		//chiamata al comando e stampa
		String comando_completo = get_command(link, formato, values_comm[0], values_comm[1]);

		//risultato
		String[] aaa = new String[14];
		aaa[0] = "X:";
		aaa[1] = "cd ..";
		aaa[2] = "cd ..";
		aaa[3] = "cd ..";
		aaa[4] = "cd ..";
		aaa[5] = "cd ..";
		aaa[6] = "cd ..";
		aaa[7] = "cd ..";
		aaa[8] = "cd ..";
		aaa[9] = "cd ..";
		aaa[10] = "cd ..";
		aaa[11] = "cd ..";
		aaa[12] = "cd ..";
		aaa[13] = comando_completo;
		Cmd_exec.executeCmd(aaa);

		return;
	}

	public static void main(String[] args){
	}
}
