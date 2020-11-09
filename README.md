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

## Task 8

Write your own annotation-based or XML-based JabaORM that parses specific class and generates SQL-queries for CRUD (or SCRUD) operations.

Your mini-ORM should have one entry point, which supports CRUD operations for parsed class passed as a parameter in

* .save
* .load
* .update
* .delete

methods.

Implement all actions via RowSet if it is possible.

Bonus: inheritance support will be a plus (+5 points).