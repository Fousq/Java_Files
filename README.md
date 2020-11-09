# Java_Files

## Source Links

Documentation:

* <a href="https://docs.oracle.com/javase/tutorial/essential/io/file.html">IO Tutorial</a>
* <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/io/index.html">IO, NIO & NIO 2</a>
* <a href="http://www.jdom.org/">JDOM</a>
* <a href="">SAX</a>
* <a href="https://docs.oracle.com/javase/tutorial/essential/io/walk.html">Walking the file tree</a>

References:

* <a href="https://vertex-academy.com/tutorials/ru/filewriter-i-filereader/">Шутливая статья про FileWriter/File Reader</a>
* <a href="https://o7planning.org/ru/10141/java-commons-io-tutorial">Apache Commons IO</a>
* <a href="https://www.tutorialspoint.com/commons_io/commons_io_ioutils.htm">Apache Commons IO Tutorial</a>
* <a href="https://javapapers.com/java/java-nio-tutorial/">Java NIO Tutorial</a>

Additional links to conference presentation or popular education videos:

* <a href="https://www.youtube.com/watch?v=7GlMS630dt8">Дмитрий Говорухин — Эффективная работа с файлами для Java-разработчиков</a>

## Task 7

Implement the next use cases of File Share application:

1. Save file to the database.
2. Retrieve file from the database.
3. Optional: file expiration.

Large files should be supported (size up to 200 MB).

Acceptance criteria:

1. File Share database schema is developed:
    * DB schema diagram is provided (5 points);
    * stored procedures for saving and retrieving files from DB are created (5 points).
2. DAO on JDBC is implemented:
    * DAO methods that are not used in proposed use cases can throw UnsupportedOperationException (2 points);
    * CallableStatement is used to call DB stored procedures (3 points);
    * large binary files are retrievable from DB (5 points).
    
Think about pros and cons of stored procedures usage comparing to SQL statement stored in Java code. Describe what difficulties you’ve faced when working with large binary files. Make demo via console interface or via special main method.