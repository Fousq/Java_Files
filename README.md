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

## Task 3

Write several versions of the FastFileMover utility, which moves a file from one directory to another directory. It takes both file paths as a command line parameters. All exceptions must be handled correctly.

Required functionality:

1. (5 points) It uses FileStreams
2. (5 points) It uses FileStreams with buffer 100 kb
3. (5 points) It uses FileChannel
4. (5 points) It uses NIO 2 File API

After that prepare a performance report based on next requirements.

Measure the time for copying, run on several reference files of different sizes (1 Kb, 100 Kb, 10 Mb, 1 GB). On each file, run 1000 times, get the average time.