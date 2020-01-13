# FRAMEWORK FOR JAVA

One of the traits of a good and experienced Java developer is the extensive knowledge of API, including JDK and third-party libraries. I spent a good deal of time learning API, especially after reading Effective Java 3rd Edition, where Joshua Bloch advised how to use existing APIs for development rather than writing new pieces of code for common stuff.

That advise made sense to me because of the testing exposure 2nd-party libraries get. In this article, I am going to share some of the most useful and essential libraries and APIs that a Java developer should be familiar with. However, I am not including frameworks, e.g. Spring and Hibernate, because they are pretty well known and have specific features.

In general, I am including useful libraries for day-to-day projects, including logging libraries like Log4j, JSON parsing libraries like Jackson, and unit testing APIs like JUnit and Mockito. If you need to use them in your project, then, you can either include JARs of these libraries in your project's classpath to start using them or you can use Maven for dependency management.

When you use Maven for dependency management, it will automatically download these libraries, including the libraries they depend on, known as the transitive dependency.

For example, if you download the Spring Framework, it will also download all other JARs on which Spring is dependent, for example, Log4j.

You might not realize, but having the right version of dependent JARs is a big headache. If you have the wrong versions of the JAR, then, you will get the ClassNotFoundException, NoClassDefFoundError, or the UnsupportedClassVersionError.

## Logging Libraries

Logging libraries are very common, because you need them in every project. They are the most important thing for server-side applications, because logs are only placed where you can see what's going on your application. Even though JDK ships with its own logging library, there are better alternatives available, e.g. Log4j, SLF4j, and LogBack.

A Java developer should be familiar with the pros and cons of the logging library and know why using SLF4j is better than plain Log4j. If you don't know why, I suggest you read my earlier article on the same subject.

## JSON Parsing libraries

In today's world of web services and the IoT, JSON has become the go-to protocol to carry information from the client to the server. They have replaced the XML as the most preferred way to transfer information in a platform-independent way.

Unfortunately, JDK doesn't have a JSON library. But, there are many good third-party libraries that allow you to both parse and create JSON messages, like Jackson and Gson.

A Java web developer should be familiar with at least one of these libraries. If you want to know more about Jackson and JSON, I suggest going through JSON with the Java API course from Udemy.

## Unit Testing Libraries

Unit testing is the single most important thing that separates an average developer from a good developer. Programmers often are given excuses for not writing unit tests, but the most common excuse for avoiding unit testing is lack of experience and knowledge of popular unit testing libraries, including JUnit, Mockito, and PowerMock.

I have a goal in 2018 to improve my knowledge of unit testing and integration testing libraries, like JUnit 5, Cucumber, Robot framework, and a few others.

I have also signed up for a JUnit and Mockito Crash Course in Udemy. Even if you know JUnit and the basics of unit testing, you may want to refresh and upgrade your own knowledge.

## General Purpose Libraries

There are a couple of good, general purpose, third-party libraries available to Java developers, like Apache Commons and Google Guava. I always include these libraries in my projects, because they simplify a lot of tasks.

As Joshua Bloch rightly said in Effective Java, there is no point in re-inventing the wheels. We should prefer using tried and tested libraries instead of writing our own routines every now and then.

It's good for a Java developer to get themselves familiar with Google Guav$$anonymous$$nd the Apache Commons library.

## HTTP Libraries

One thing I don't like about JDK is their lack of support for HTTP. Though you can make an HTTP connection using classes in the java.netpackage, it's not as easy or seamless to use open source, third-party libraries like Apache HttpClient and HttpCore.

Though JDK 9 is bringing the support of HTTP 2.0 and better support for HTTP, I strongly suggest all Java developers get familiar with popular HTTP client libraries, including HttpClient and HttpCore.

You can also check out this post What's New in Java 9 - Modules and More to learn more about JDK 9's HTTP 2 support.

## XML Parsing Libraries

There are many XML parsing libraries, including Xerces, JAXB, JAXP, Dom4j, and Xstream. Xerces2 is the next generation of high performance, fully compliant XML parsers in the Apache Xerces family. This new version of Xerces introduces the Xerces Native Interface (XNI), a complete framework for building parser components and configurations that is extremely modular and easy to program.

The Apache Xerces2 parser is the reference implementation of XNI, but other parser components, configurations, and parsers can be written using the Xerces Native Interface. Dom4j is another flexible XML framework for Jav$$anonymous$$pplications. If you want to learn more about XML parsing in Java, I suggest you take a look at the Java Web Services and XML online course on Udemy. 

## Excel Reading Libraries

Believe it or not — all real-world applications have to interact with Microsoft Office in some form or another. Many application needs to provide functionality to export data in Excel, and if you have to do same from your Jav$$anonymous$$pplication, you need the Apache POI API.

This is a very rich library that allows you to both read and write XLS files from a Java program. You can see that link for a working example of reading an Excel file in a core Jav$$anonymous$$pplication.

## Bytecode Libraries

If you are writing a framework or libraries that generate code or interact with bytecodes, then, you need a bytecode library.

They allow you to read and modify bytecode generated by an application. Some of the popular bytecode libraries in the Java world are javassist and Cglib Nodep.

Best Bytecode manipulation libraries for Java developers

The Javassist (JAVA programming ASSISTant) makes Java bytecode manipulation very simple. It is a class library for editing bytecodes in Java. ASM is another useful bytecode editing library. If you are not familiar with bytecode, I suggest you check the Introduction to Java Programmers to learn more about it. 

## Database Connection Pool Libraries

If you are interacting with the database from a Jav$$anonymous$$pplication but not using database connection pool libraries, then, you are missing something.

Since creating database connections at runtime takes time and makes request processing slower, it's always advised to use DB connection libraries. Some of the popular ones are Commons Pool and DBCP.

In a web application, it's web server generally provides these functionalities, but in core Jav$$anonymous$$pplications, you need to include these connection pool libraries into your classpath to use the database connection pool.

If you want to learn more about JDBC and the connection pool in a web application, I suggest you take a look at the JSP, Servlet, and JDBC for Beginners course in Udemy.

## Messaging Libraries 

Similar to logging and database connection, messaging is also a common feature of many real-world Jav$$anonymous$$pplications.

Java provides JMS, or the Java Messaging Service, that's not part of JDK. For this component, you need to include a separate  jms.jar.

Similarly, if you are using third-party messaging protocols, like Tibco RV, then, you need to use a third-party JAR —  tibrv.jar — in your application classpath.

## PDF Libraries

Similar to Microsoft Excel, PDF libraries are another ubiquitous format. If you need to support PDF functionality in your application, like exporting data in PDF files, you can use the iText and Apache FOP libraries.

Both provide useful PDF related functionality, but iText is richer and better. See here to learn more about iText.

Best PDF libraries for Java developers

## Date and Time Libraries

Before Java 8, JDK's dat$$anonymous$$nd time libraries have so many flaws, because they were not thread-safe, immutable, and error-prone. Many Java developers relied on JodaTime for implementing their date and time requirement.

From JDK 8, there is no reason to use Joda, because you get all that functionality in the JDK 8's new date and time API, but if you are working in an older Java version, then JodaTime is a worth learning library.

If you want to learn more about the new date and time API, I suggest you check the What's new in Java 8 course on Udemy. It provides a nice overview of all important features of Java 8, including the date and time API.

## Collection Libraries

Even though JDK has a rich collection library, there are are some 3rd-party libraries that provide more options, like the Apache Commons collections, Goldman Sachs collections, Google collections, and Trove.

The Trove library is particularly useful because it provides high speed regular and primitive collections for Java.

FastUtil is another similar API. It extends the Java Collections Framework by providing type-specific maps, sets, lists, and priority queues with a small memory footprint, fast access, and insertion; it also provides big (64-bit) arrays, sets, and lists, with fast, practical I/O classes for binary and text files.

## Email APIs

The javax.mail and Apache Commons Email both provide an API for sending an email from Java. It is built on top of the JavaMail API, which it aims to simplify.

## HTML Parsing Libraries

Similar to JSON and XML, HMTL is another common format many of us have to deal with. Thankfully, we have JSoup, which greatly simplifies working with HTML in a Jav$$anonymous$$pplication.

You can use JSoup to not only parse HTML but also to create HTML documents

It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods. JSoup implements the WHATWG HTML5 specification and parses HTML to the same DOM, as modern browsers do.

## Cryptographic Library

The Apache Commons Codec package contains simple encoder and decoders for various formats, such as Base64 and Hexadecimal.

In addition to these widely used encoders and decoders, the codec package also maintains a collection of phonetic encoding utilities.


## Embedded SQL Database Library

I really love in-memory databases like H2, which you can embed in your Jav$$anonymous$$pplication. They are great for testing your SQL scripts and running unit tests that need a database. However, H2 is not the only DB, you also have Apache Derby and HSQL to choose from.

## JDBC Troubleshooting Libraries

There are some good JDBC extension libraries that exist and can make debugging easier, like the P6spy.

This is a library that enables database data to be seamlessly intercepted and logged with no code changes to the application. You can use these to log SQL queries and their timings.

For example, if you are using PreparedStatment and CallableStatement in your code, these libraries can log an exact call with parameters and how much time it took to execute.
If you want to learn more about JDBC, you can check out the JDBC for Beginners. 

## Serialization Libraries

The Google Protocol Buffers are a way of encoding structured data in an efficient— yet, extensible — format. It's a richer and better alternative to Java serialization. I strongly recommend experienced Java developers to learn Google Protobuf. You can see this article to learn more about the Google Protocol Buffer.

## Networking Libraries

Some of the useful networking libraries are Netty and Apache MINA. If you are writing an application where you need to do low-level networking task, consider using these libraries. If you want to learn more about networking programming in Java, check out the Java Network Programming - TCP/IP Socket Programming.

That's all for now about some of the useful libraries every Java developer should be using. The Java sphere is vast, and you will find tons of libraries for doing different things.

If you want to do anything in Java, more than likely, you will find a library on how to do just that. As always, Google is your best friend to find useful Java libraries, but you can also take a look at the Maven central repository to find some of the useful libraries for your task at hand.