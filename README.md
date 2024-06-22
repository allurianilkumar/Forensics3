# The Naive, The Savvy, and The Bad

In this assignment you will be working to create a simple carving tool. As you know, carving and data
recovery are vital aspects for forensics work. If you seized a storage drive from a crime scene full with
data but you cannot read it to benefit from its content, then what is the point of seizing it.
In this project you will be working to create a simple carving tool that handles basic operations related
to recovering image/picture files. The project should be developed in phases. Phase 1 is a basic phase
where images are stored normally in the data dump. Phase 2 is about handling the problem of slightly
modified headers, and the change is fixed. Phase 3 is the final stage where header and footer are
modified with a fixed pattern.

Objectives
1- Learn how to deal with data on the binary level
2- Learn how to carve/recover data from unknown data dumps
3- Learn to identify the signature of a file and appreciate its importance
4- Learn to develop complex tools by working on a phase-by-phase plan

Phase 1: The Naïve

In this case, the naïve suspect has not done any modifications to the images. The data image/data dump
contains some image/picture files. For this part of the project, you can assume that image files are not
modified in any way. Meaning:
1- The headers, and footer if found, are following the standards for the image type
2- You can assume that the data of image files are not fragmented or damaged.
3- Your task here is to extract the image files.
4- The image files are stored sequentially in the dump (they are not mixed or interleaved)
a. i.e. file1, file2, file3 ... etc.

The result of this first part of the project is to produce each found image in a separate file with the
correct type. E.g., file1.jpg, file2.png, file3.gif ..... etc.
Phase 2: The Savvy

In this part of the project, the savvy was aware that he/she might be discovered, so he/she tried to hide
the data. The image files stored in the data dump file are modified to hide content. The change the
savvy did is in the header part of the file. As you know headers and footers play a very important role in
identifying the type of the file, so the right software application can handle it. In this part, you will be
working again to recover image files assuming the following:
1- The first 4 bytes of the header are the only part that would be changed.
2- The change is a fixed pattern, the savvy inserted to modify the header.
3- The pattern is zzzz
4- You task here is correct the headers so the image files can be handled correctly.
5- The image files are stored sequentially in the dump (they are not mixed or interleaved)


a. i.e. file1, file2, file3 ... etc.

The result of this second part of the project is to produce each found image in a separate file with the
correct type. E.g., file1.jpg, file2.png, file3.gif ... etc.
Phase 3: The Bad

This guy is really bad and knows that forensics experts can easily figure out what he/she is trying hide if
the technique is basic, so he/she decides to go for the next level to protect his/her data. In this case the
image files are modified as well. The change the bad guy implemented is more problematic because it
affects both the header and footer.
1- The first 4 bytes of the header are the only part that would be changed.
2- The change is a fixed pattern, the bad inserted to modify the header.
a. The pattern is zzzz
3- The last two bytes of the footer are changed with a fixed pattern
a. The pattern is ww
4- Your task here is correct the headers and footers so the image files can be handled correctly.
5- The image files are stored sequentially in the dump (they are not mixed or interleaved)
a. i.e. file1, file2, file3 ... etc.

The result of this second part of the project is to produce each found image in a separate file with the
correct type. E.g., file1.jpg, file2.png, file3.gif ... etc.
Notes:

1- The phases mentioned above are not separate; rather, they show the progress and quality of
your tool. Meaning, you should start with the basic case, then you improve your tool to deal
with mid-level problems, and then improve it more to handle more problematics scenarios.
2- You can assume only jpg, png, and gif formats are used:
jpg:
header: FF D8 FF E0 xx xx 4A 46 49 46 00, footer: FF D9
png:
header: 89 50 4E 47 0D 0A 1A 0A, footer: 49 45 4E 44 AE 42 60 82
gif:
header: 47 49 46 38 39 61, footer: 00 3B
3- The data dump will only contain the picture files data.
4- Useful link about file signatures : http://www.garykessler.net/library/file_sigs.html
5- You will need to access the data dump on the binary level
6- You can assume that the order of image types in the given data files is png, jpg, gif
7- To make your life easier, I am giving you 3 data files; one file for each phase. However, you need
to create only one code that can handle any of the 3 phases mentioned above. The data files are
ph1, ph2, and ph3


## Guidelines


1- The project is to be done in groups of 3 or less. Groups have to be from same section. Forming
groups, if you want to have a group, is the responsibility of students.
a. Not finding a group is not an excuse not to do the project; you still can do it on your
own.

2- You should be developing this project under a Linux operating system without the need to
install any special packages or libraries except the default compilers and libraries.
a. There are many free distros of Linux (Mate (light for lower end laptops), Ubuntu, Mint,
CentOS, ...)
b. You should install a Linux OS inside virtual environment software (VMware, virtual
box...)

3- Do not use any kind of sophisticated IDEs (Eclipse, NetBeans, visual studio ...etc.).
a. We will not use any of these to run and grade your code.
4- One code file should be able to handle all three scenarios.
5- Languages to be used are python2.7, java.
6- Name the solution file simpleCarve.py, simpleCarve.java
7- Only one zipped code file has to be submitted per group. Your code should start with a block of
comment.
a. This comment block has:
i. Students names, ids, and sections
8- To test (compile and run) your code, you can use:
a. python2.7 simpleCarve.py dataimagefile
b. javac simpleCarve.java
i. java simpleCarve dataimagefile
9- Do not submit screen shots or any similar unrelated files.
a. No score will be awarded for these.
b. They will not be used to convince us that your code runs fine.
10- You have to make sure that your code runs error-free, especially compilation errors.
a. We will not debug or fix any errors.
b. Very low score is expected in case there are errors
11- Be careful about the Path names. Always assume current folder/directory.
