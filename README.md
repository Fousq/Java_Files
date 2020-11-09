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

## Task 2

Write the DiskAnalyzer utility command line, which accepts a path to the input (for example, C: ) and a function number, correctly processes incorrect paths or function numbers. The utility outputs the results of its work to a file. The program should work for the C: drive of your working machine.

Required functionality:

1. Search for the file name with the maximum number of letters ‘s’ in the name, display the path to it.
2. Print Top-5 largest files (by size in bytes).
3. The average file size in the specified directory or any its subdirectory.
4. The number of files and folders, divided by the first letters of the alphabet (for example, 100,000 files and 200 folders begin with the letter A).