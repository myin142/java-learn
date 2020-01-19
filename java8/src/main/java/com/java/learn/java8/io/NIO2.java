package com.java.learn.java8.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO2{

    public static void init(){

        // Path interface to replace File, supports symbolic links
        //
        // Factory Class: Paths (static methods)
        //      Path get(String, String...)
        //      Path get(URI)
        //
        //      String starts with forward slash -> absolute path
        //      String starts with drive letter -> absolute path
        //      else -> relative path
        //
        //      URI - uniform resource identifier, string of characters
        //      new URI(String) throws URISyntaxException
        //      must reference absolute paths at runtime
        //      begins with file://, http://, https://, ftp://, ...
        //
        //      Paths.get() == FileSystems.getDefault().getPath()
        //      file.toPath() <-> path.toFile()
        Path path = Paths.get("./out");
        Path uriPath = Paths.get(path.toUri());

        // Optional Arguments: ( LinkOption, CopyOption, StandardCopyOption )
        //      NOFOLLOW_LINKS      symbolic links not traversed
        //      FOLLOW_LINKS        symbolic links will be traversed
        //      COPY_ATTRIBUTES     all metadata copied
        //      REPLACE_EXISTING    file exists -> replaced | if not set and exists -> exception
        //      ATOMIC_MOVE         operation as atomic, throw exception if not supported
        //
        // Path Methods:
        //      toString() | getNameCount(), getName(int) | getFileName(), getParent() | getRoot()
        //      isAbsolute() | toAbsolutePath() | subpath(int start, int endExcluded)
        //      equals(Path) - compares path string
        //
        //      relativize(Path) - relative path between 2 paths, either both relative or absolute -> else IllegalArgumentException
        //      resolve(Path) - joining paths, if using absolute path -> second will be used
        //      normalize() - cleaning up path
        //      toRealPath() throws IOException - converts relative to absolute + checks file existence 
        System.out.println(uriPath.getRoot());

        // Helper Class: Files (static methods) all methods throw IOException except exists()
        //      exists(Path) | isSameFile(Path, Path) | createDirectory(Path), createDirectories(Path)
        //      copy(Path, Path)            / 
        //      copy(InputStream, Path)     / does not copy files inside directory
        //      copy(Path, OutputStream)    /
        //      move(Path, Path) - cannot move non-empty directory across drives -> DirectoryNotEmptyException
        //      delete(Path), deleteIfExists(Path)
        //      newBufferedReader(Path, Charset) | newBufferedWriter(Path, Charset)
        //      readAllLines(Path) - return list of Strings
        //
        // File Attributes: Files (All have Path as argument) 
        //      isDirectory() | isRegularFile() | isSymbolicLink() | isReadable() | isExecutable()
        //
        //      Throws IOException:
        //      isHidden() | size() - in bytes
        //      FileTime getLastModifiedTime() | Path setLastModifiedTime()
        //      UserPrincipal getOwner() | Path setOwner()
        //
        // Views: group of related attributes for file system
        //      Files.readAttributes(Path, Class<A>) throws IOException - return read-only view of attributes
        //      Files.getFileAttributeView(Path, Class<V>) - view that can be modified
        //
        //      BasicFileAttributes
        //          isDirectory() | isRegularFile() | isSymbolicLink() | size() | lastModifiedTime()
        //          isOther() | creationTime() | lastAccessTime() | fileKey() - unique id if supported
        //
        //      BasicFileAttributeView
        //          readAttributes() throws IOException
		//			setTimes(FileTime lastMod, FileTime lastAccess, FileTime create) - no changes -> pass null
        Files.exists(path);

        // Stream Methods:
        //      Directory Walking: start at parent -> over all descendants
        //          depth-first | breadth-first | search depth
        //      
        //      Avoid Circular Paths: by default traverse symbolic links
        //          FileSystemLoopException -> ~when depth specified and loop detected
        //
        //      All throws IOException:
        //          Stream<Path> Files.walk(Path)
        //          Stream<Path> Files.walk(Path, int)                   specifiy search depth
        //          Stream<Path> Files.find(Path, int, BiPredicate<Path, BasicFileAttributes>)
        //          Stream<Path> Files.list(Path)                        only one depth list
        //          Stream<String> Files.lines(Path)
        try{
            Files.walk(path).filter(p -> p.getNameCount() > 4).forEach(System.out::println);
        } catch (IOException e){}

        // Comparing with Legacy:
        //      file.exists()               Files.exists(Path)
        //      file.getName()              path.getFileName()
        //      file.getAbsolutePath()      path.toAbsolutePath()
        //      file.isDirectory()          Files.isDirectory(Path)
        //      file.isFile()               Files.isRegularFile(Path)
        //      file.isHidden()             Files.isHidden(Path)
        //      file.length()               Files.size(Path)
        //      file.lastModified()         Files.getLastModifiedTime(Path)
        //      file.setLastModified()      Files.setLastModifiedTime(Path, FileTime)
        //      file.delete()               Files.delete(Path)
        //      file.renameTo(file2)        Files.move(Path, Path)
        //      file.mkdir()                Files.createDirectory(Path)
        //      file.mkdirs()               Files.createDirectories(Path)
        //      file.listFiles()            Files.list(Path)

    }

}
