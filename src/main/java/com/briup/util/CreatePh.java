package com.briup.util;

import java.io.File;
import java.util.List;
//生成视频文件的首帧为图片
//windows下的版本
public class CreatePh {
	//public static final String FFMPEG_PATH = "E:/ffmpeg/ffmpeg.exe";
	public static boolean processImg(String veido_path,String filename,String ffmpeg_path) {
		File file = new File(veido_path+"\\"+filename);
		System.out.println(veido_path+"\\"+filename);
		if (!file.exists()) {
			System.err.println("路径[" + veido_path + "]对应的视频文件不存在!");
			return false;
		}
        String img = filename.substring(0, filename.lastIndexOf("."));
		List<String> commands = new java.util.ArrayList<String>();
		commands.add(ffmpeg_path+"\\"+"ffmpeg.exe");
		commands.add("-i");
		commands.add(veido_path+"\\"+filename);
		commands.add("-y");
		commands.add("-f");
		commands.add("image2");
		commands.add("-ss");
		commands.add("8");//这个参数是设置截取视频多少秒时的画面
		//commands.add("-t");
		//commands.add("0.001");
		commands.add("-s");
		commands.add("100*75");
		commands.add(ffmpeg_path+"\\"+ img + ".jpg");
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commands);
			builder.start();
			System.out.println("截取成功");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}