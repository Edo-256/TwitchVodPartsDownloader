package src_prop;

import java.io.*;

import src.Cmd_exec;

public class Twitch_downloader
{
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

	public static void launch_download(String url, String format, int hs, int ms, int he, int me) throws IOException, InterruptedException
	{
		int start_s = converter_to_second(hs, ms);
		int finish_s = converter_to_second(he, me);
		int[] values_comm = parametri_corretti(start_s, finish_s);
		String comando_completo = get_command(url, format, values_comm[0], values_comm[1]);
		
		String[] aaa = new String[14];
		aaa[0] = comando_completo;

		Cmd_exec.executeCmd(aaa);
	}
}
