package com.startup.utils;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.devtools.common.options.OptionsParser;
import com.startup.exceptions.InvalidInputException;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class CommandLineParser {
	private Logger logger = LoggerFactory.getLogger(CommandLineParser.class);
	private static CommandLineParser cmdLineParser = null;
	private String inputFileName;
	private String outputFileName;
	private int numProcessors;
	private int numCores;
	private boolean visualise;
	private OptionsParser optParser;

	/**
	 * Private constructor only called by this class
	 */
	private CommandLineParser() {
		numProcessors = 1;
		outputFileName = null;
		optParser = OptionsParser.newOptionsParser(CommandLineArguments.class);
	}

	/**
	 * Static method to return single instance of singleton class
	 * 
	 * @return The single CommandLineParser object
	 */
	public static CommandLineParser getInstance() {
		return (cmdLineParser == null) ? (cmdLineParser = new CommandLineParser()) : cmdLineParser;
	}

	/**
	 * Parse all command line arguments
	 * 
	 * @param input
	 *            The string arguments
	 */
	public void parseCommandLineArguments(String[] input) throws InvalidInputException {
		optParser.parseAndExitUponError(input);
		checkInvalidArgs(input);

		logger.info("Input file entered: " + this.inputFileName);
		logger.info("Output will be saved to: " + this.outputFileName);
		logger.info("Number of processors to use: " + this.numProcessors);
	}

	/**
	 * Checks the input for illegal arguments
	 * 
	 * @param input
	 *            Arguments as strings to check for legality
	 * @throws InvalidInputException
	 */
	private void checkInvalidArgs(String[] input) throws InvalidInputException {
		// Check that all compulsory inputs have been entered (2 inputs)
		if (input.length < 2) {
			throw new InvalidInputException("Please enter the .dot input file AND number of processors to be used");
		}

		// Parse the number of processors to be used
		try {
			this.numProcessors = Integer.parseInt(input[1]);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Please enter an integer for the number of processors to be used");
		}

		// Check that at least one process has been entered
		if (this.numProcessors < 1) {
			throw new InvalidInputException("Please enter a valid number of processors (at least 1)");
		}

		CommandLineArguments options = optParser.getOptions(CommandLineArguments.class);

		// Check that more than 0 cores (processors) are entered
		if (options.numCores < 1) {
			throw new InvalidInputException(
					"Please enter a valid number of cores (processors) for paralellising the search");
		}

		this.inputFileName = input[0];

		// Check that the file is a .dot file
		if (!this.inputFileName.toLowerCase().endsWith(".dot")) {
			throw new InvalidInputException("Please enter a file with the .dot extension");
		}

		// If the user does not specify an output, then set default to be
		// INPUT-output.dot
		// else set the output file to be what the user specifies
		if (options.outputFile.equals("")) {
			String inputFileName = this.inputFileName;
			this.outputFileName = inputFileName.replace(".dot", "") + "-output.dot";
		} else {
			this.outputFileName = options.outputFile;
		}

		this.visualise = options.visualise;
		this.numCores = options.numCores;
	}

	/**
	 * Get the input number of processors
	 * 
	 * @return The number of processors
	 */
	public int getNumberOfProcessors() {
		return numProcessors;
	}

	/**
	 * Get the number of cores specified by the user
	 * 
	 * @return
	 */
	public int getNumberOfCores() {
		return numCores;
	}

	/**
	 * Get the input .dot file name
	 * 
	 * @return The input .dot file name
	 */
	public String getInputFileName() {
		return inputFileName;
	}

	/**
	 * Get the output .dot file name
	 * 
	 * @return The output .dot file name
	 */
	public String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * Finds whether the user specified to visualise the algorithm or not.
	 * 
	 * @return true if visualisation was specified by the user, false otherwise.
	 */
	public boolean wantVisual() {
		return visualise;
	}

	/**
	 * Prints out how the user should run the program with appropriate arguments
	 */
	public void printUsage() {
		System.out.println("\nUsage: java -jar scheduler.jar <INPUT-FILE> <NUMBER-OF-PROCESSORS> [OPTIONS]\n");
		System.out.println("\t- <INPUT-FILE> should be a .dot file");
		System.out.println("\t- <NUMBER-OF-PROCESSORS> should be an integer greater than 0\n");
		System.out.println(
				optParser.describeOptions(Collections.<String, String> emptyMap(), OptionsParser.HelpVerbosity.LONG));
	}

}
