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

## Measurement

Without creating file:
* 1 Kb:
    1. 3 ms
    2. 3 ms
    3. 16 ms
    4. 8 ms
* 102 Kb:
    1. 224 ms
    2. 10 ms
    3. 8 ms
    4. 5 ms
* 31 MB:
    1. 66363 ms = 1 m 3 s
    2. 771 ms
    3. 251 ms
    4. 5 ms
* 1 GB:
    1. 2303941 ms or more, so no measurement can be provided
    2. 26032 ms
    3. 6498 ms
    4. 5 ms

With creating file:
* 1Kb:
    1. 5 ms
    2. 6 ms
    3. 6 ms
    4. 6 ms
* 102 Kb:
    1. 252 ms
    2. 12 ms
    3. 14 ms
    4. 7 ms
* 31 MB:
    1. 68839 ms = 1 m 8 s
    2. 771 ms
    3. 251 ms
    4. 6 ms
* 1 GB:
    1. 2303941 ms
    2. 26046 ms
    3. 6446 ms
    4. 10 ms