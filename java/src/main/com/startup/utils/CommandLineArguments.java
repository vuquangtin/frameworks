package com.startup.utils;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class CommandLineArguments extends OptionsBase {

	@Option(name = "NUMCORES", abbrev = 'p', help = "Number of cores to use to produce the schedule", category = "Startup", defaultValue = "1")
	public int numCores;

	@Option(name = "OUTPUT", abbrev = 'o', help = "output file is named OUTPUT (default is INPUT-output.dot)", category = "Startup", defaultValue = "")
	public String outputFile;

	@Option(name = "VISUALISE", abbrev = 'v', help = "Visualise the search", category = "Startup", defaultValue = "false")
	public boolean visualise;
}