package com.startup.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CLIArgumentParser {
	private final Options options;
	private final CommandLineParser parser;

	private CLIArgumentParser(Options options) {
		this.options = options;
		this.parser = new DefaultParser();
	}

	public void printHelpUsage() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("utility-name", this.options);
	}

	public CLIArgumentParser.Result parse(String[] args) {
		try {
			CommandLine cmd = this.parser.parse(this.options, args);
			return new CLIArgumentParser.Result(cmd, this.options);
		} catch (ParseException var3) {
			throw new IllegalArgumentException(var3.getMessage());
		}
	}

	public static class Builder {
		private final Options options = new Options();

		public Builder() {
		}

		public CLIArgumentParser.Builder addOpt(String opt, String longOpt,
				boolean hasArgs, String description, boolean required) {
			Option option = new Option(opt, longOpt, hasArgs, description);
			option.setRequired(required);
			this.options.addOption(option);
			return this;
		}

		public CLIArgumentParser build() {
			return new CLIArgumentParser(this.options);
		}
	}

	public static class Result {
		private final CommandLine cmd;
		private final Options options;

		private Result(CommandLine cmd, Options options) {
			this.cmd = cmd;
			this.options = options;
		}

		public Map<String, String> getOptions() {
			Map<String, String> map = new TreeMap<String, String>();
			Iterator var2 = this.options.getOptions().iterator();

			while (var2.hasNext()) {
				Option opt = (Option) var2.next();
				map.put(opt.getLongOpt(), this.getOptionValue(opt.getLongOpt()));
			}

			return map;
		}

		public String getOptionValue(String opt) {
			return this.cmd.getOptionValue(opt);
		}

		public String getOptionValue(String opt, String defVal) {
			return this.cmd.getOptionValue(opt, defVal);
		}

		public String[] getAppArgs() {
			return this.cmd.getArgs();
		}
	}
}
