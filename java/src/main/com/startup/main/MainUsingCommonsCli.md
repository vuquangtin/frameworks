@see https://commons.apache.org/proper/commons-cli/usage.html

# Usage Scenarios

The following sections describe some example scenarios on how to use CLI in applications.

## Using a boolean option

A boolean option is represented on a command line by the presence of the option, i.e. if the option is found then the option value is true, otherwise the value is false.

The DateApp utility prints the current date to standard output. If the -t option is present the current time is also printed.

## Create the Options

An Options object must be created and the Option must be added to it.

```java
// create Options object
Options options = new Options();

// add t option
options.addOption("t", false, "display current time");
```
The addOption method has three parameters. The first parameter is a java.lang.String that represents the option. The second parameter is a boolean that specifies whether the option requires an argument or not. In the case of a boolean option (sometimes referred to as a flag) an argument value is not present so false is passed. The third parameter is the description of the option. This description will be used in the usage text of the application.

## Parsing the command line arguments

The parse methods of CommandLineParser are used to parse the command line arguments. There may be several implementations of the CommandLineParser interface, the recommended one is the DefaultParser.

```java
CommandLineParser parser = new DefaultParser();
CommandLine cmd = parser.parse( options, args);
```
Now we need to check if the t option is present. To do this we will interrogate the CommandLine object. The hasOption method takes a java.lang.String parameter and returns true if the option represented by the java.lang.String is present, otherwise it returns false.

```java
if(cmd.hasOption("t")) {
    // print the date and time
}
else {
    // print the date
}
```

## Note.
As of version 1.5-SNAPSHOT (as of 7/31/2017), the DefaultParser's constructor now has an override with the signature DefaultParser(final boolean allowPartialMatching). Given the following code:

```java
final Options options = new Options();
options.addOption(new Option("d", "debug", false, "Turn on debug."));
options.addOption(new Option("e", "extract", false, "Turn on extract."));
options.addOption(new Option("o", "option", true, "Turn on option with argument."));
```

we define "partial matching" as -de only matching the "debug" option. We can consequently, now, turn this off and have -de match both the debug option as well as the extract option.

## International Time

The InternationalDateApp utility extends the DateApp utility by providing the ability to print the date and time in any country in the world. To facilitate this a new command line option, c, has been introduced.

```java
// add c option
options.addOption("c", true, "country code");
```

The second parameter is true this time. This specifies that the c option requires an argument value. If the required option argument value is specified on the command line it is returned, otherwise null is returned.
Retrieving the argument value

The getOptionValue methods of CommandLine are used to retrieve the argument values of options.

```java
// get c option value
String countryCode = cmd.getOptionValue("c");

if(countryCode == null) {
    // print default date
}
else {
    // print date for country specified by countryCode
}
```

## Ant Example

One of the most ubiquitous Java applications Ant will be used here to illustrate how to create the Options required. The following is the help output for Ant.

```
ant [options] \[target] \[target2] \[target3] ...]]
  Options: 
  -help                  print this message
  -projecthelp           print project help information
  -version               print the version information and exit
  -quiet                 be extra quiet
  -verbose               be extra verbose
  -debug                 print debugging information
  -emacs                 produce logging information without adornments
  -logfile <file>        use given file for log
  -logger <classname>    the class which is to perform logging
  -listener <classname>  add an instance of class as a project listener
  -buildfile <file>      use given buildfile
  -D<property>=<value>   use value for given property
  -find <file>           search for buildfile towards the root of the
                         filesystem and use it
```

## Boolean Options

Lets create the boolean options for the application as they are the easiest to create. For clarity the constructors for Option are used here.

```java
Option help = new Option( "help", "print this message" );
Option projecthelp = new Option( "projecthelp", "print project help information" );
Option version = new Option( "version", "print the version information and exit" );
Option quiet = new Option( "quiet", "be extra quiet" );
Option verbose = new Option( "verbose", "be extra verbose" );
Option debug = new Option( "debug", "print debugging information" );
Option emacs = new Option( "emacs",
                           "produce logging information without adornments" );
```

## Argument Options

The argument options are created using the OptionBuilder.

```java
Option logfile   = OptionBuilder.withArgName( "file" )
                                .hasArg()
                                .withDescription(  "use given file for log" )
                                .create( "logfile" );

Option logger    = OptionBuilder.withArgName( "classname" )
                                .hasArg()
                                .withDescription( "the class which it to perform "
                                                  + "logging" )
                                .create( "logger" );

Option listener  = OptionBuilder.withArgName( "classname" )
                                .hasArg()
                                .withDescription( "add an instance of class as "
                                                  + "a project listener" )
                                .create( "listener"); 

Option buildfile = OptionBuilder.withArgName( "file" )
                                .hasArg()
                                .withDescription(  "use given buildfile" )
                                .create( "buildfile");

Option find      = OptionBuilder.withArgName( "file" )
                                .hasArg()
                                .withDescription( "search for buildfile towards the "
                                                  + "root of the filesystem and use it" )
                                .create( "find" );
```

## Java Property Option

The last option to create is the Java property and it is also created using the OptionBuilder.

```java
Option property  = OptionBuilder.withArgName( "property=value" )
                                .hasArgs(2)
                                .withValueSeparator()
                                .withDescription( "use value for given property" )
                                .create( "D" );
```

The map of properties specified by this option can later be retrieved by calling getOptionProperties("D") on the CommandLine.

## Create the Options

Now that we have created each Option we need to create the Options instance. This is achieved using the addOption method of Options.

```java
Options options = new Options();

options.addOption( help );
options.addOption( projecthelp );
options.addOption( version );
options.addOption( quiet );
options.addOption( verbose );
options.addOption( debug );
options.addOption( emacs );
options.addOption( logfile );
options.addOption( logger );
options.addOption( listener );
options.addOption( buildfile );
options.addOption( find );
options.addOption( property );
```


All the preperation is now complete and we are now ready to parse the command line arguments.

## Create the Parser

We now need to create a CommandLineParser. This will parse the command line arguments, using the rules specified by the Options and return an instance of CommandLine.

```java
public static void main( String[] args ) {
    // create the parser
    CommandLineParser parser = new DefaultParser();
    try {
        // parse the command line arguments
        CommandLine line = parser.parse( options, args );
    }
    catch( ParseException exp ) {
        // oops, something went wrong
        System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
    }
}
```

## Querying the commandline

To see if an option has been passed the hasOption method is used. The argument value can be retrieved using the getOptionValue method.

```java
// has the buildfile argument been passed?
if( line.hasOption( "buildfile" ) ) {
    // initialise the member variable
    this.buildfile = line.getOptionValue( "buildfile" );
}
```

## Usage/Help

CLI also provides the means to automatically generate usage and help information. This is achieved with the HelpFormatter class.

// automatically generate the help statement
HelpFormatter formatter = new HelpFormatter();
formatter.printHelp( "ant", options );

When executed the following output is produced:

usage: ant
-D <property=value>     use value for given property
-buildfile <file>       use given buildfile
-debug                  print debugging information
-emacs                  produce logging information without adornments
-file <file>            search for buildfile towards the root of the
                        filesystem and use it
-help                   print this message
-listener <classname>   add an instance of class as a project listener
-logger <classname>     the class which it to perform logging
-projecthelp            print project help information
-quiet                  be extra quiet
-verbose                be extra verbose
-version                print the version information and exit

If you also require to have a usage statement printed then calling formatter.printHelp( "ant", options, true ) will generate a usage statment as well as the help information.

## ls Example

One of the most widely used command line applications in the *nix world is ls. Due to the large number of options required for ls this example will only cover a small proportion of the options. The following is a section of the help output.

Usage: ls [OPTION]... [FILE]...
List information about the FILEs (the current directory by default).
Sort entries alphabetically if none of -cftuSUX nor --sort.

-a, --all                  do not hide entries starting with .
-A, --almost-all           do not list implied . and ..
-b, --escape               print octal escapes for nongraphic characters
    --block-size=SIZE      use SIZE-byte blocks
-B, --ignore-backups       do not list implied entries ending with ~
-c                         with -lt: sort by, and show, ctime (time of last
                           modification of file status information)
                           with -l: show ctime and sort by name
                           otherwise: sort by ctime
-C                         list entries by columns

The following is the code that is used to create the Options for this example.

```java
// create the command line parser
CommandLineParser parser = new DefaultParser();

// create the Options
Options options = new Options();
options.addOption( "a", "all", false, "do not hide entries starting with ." );
options.addOption( "A", "almost-all", false, "do not list implied . and .." );
options.addOption( "b", "escape", false, "print octal escapes for nongraphic "
                                         + "characters" );
options.addOption( OptionBuilder.withLongOpt( "block-size" )
                                .withDescription( "use SIZE-byte blocks" )
                                .hasArg()
                                .withArgName("SIZE")
                                .create() );
options.addOption( "B", "ignore-backups", false, "do not list implied entried "
                                                 + "ending with ~");
options.addOption( "c", false, "with -lt: sort by, and show, ctime (time of last " 
                               + "modification of file status information) with "
                               + "-l:show ctime and sort by name otherwise: sort "
                               + "by ctime" );
options.addOption( "C", false, "list entries by columns" );

String[] args = new String[]{ "--block-size=10" };

try {
    // parse the command line arguments
    CommandLine line = parser.parse( options, args );

    // validate that block-size has been set
    if( line.hasOption( "block-size" ) ) {
        // print the value of block-size
        System.out.println( line.getOptionValue( "block-size" ) );
    }
}
catch( ParseException exp ) {
    System.out.println( "Unexpected exception:" + exp.getMessage() );
}
```
