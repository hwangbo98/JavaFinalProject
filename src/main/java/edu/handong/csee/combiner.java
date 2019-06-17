package edu.handong.csee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache commons.cli.ParseException;

public class combiner {
	String resultPath="";
	boolean help;
	
	public void run(String args[]) {
		Options options =createOptions();
		
	}
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		
		try {
			CommandLine cmd = parser.parse(options, args);
			
			File file = new File(cmd.getOptionValue("i"));
			resultPath = cmd.getOptionValue("o");
			help = cmd.hasOption("h");
		}catch (Exception e) {
			printHelp(options);
			return false;
		}
		return true;
	}
	
	private Options createOptions() {
		Options options = new Options();
		
		options.addOption(Option.builder("i").longOpt("input")
						.desc("Set an input file path. zip file")
						.hasArg()
						.argName("Input path")
						.required()
						.build());
		
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set an output file path.")
				.hasArg()
				.argName("Output path")
				.required()
				.build());
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());
		
		return options;
	}
	
	private void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "통일한국개론 수집 데이터 합치기 ";
		String footer ="";
		formatter.printHelp("HGUCourseCounter", header, options, footer, true);
	}
}
