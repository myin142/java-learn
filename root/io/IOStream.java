package root.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// file             record within file system, stores user and system data
// directory        record within file system, contains files and directories
// root directory   topmost directory in file system
// file system      in charge of reading and writing data
// path             String representation of file or directory
public class IOStream{

    public static void init(){

        // File represents pathname and cannot read/write data -> to streams
        //      File(String) | File(File, String)
        //      Pass relative or absolute path
        //      Backslash needs to be escaped with another backslash
        //      Or using slashes -> converted to right one
        File file = new File("/");

        // Methods:
        // exists() | isDirectory() | isFile() | delete() | mkdir() | mkdirs()
        // renameTo(File) | getName() | getAbsolutePath() | getParent() - null if none
        // lastModified() - number of milliseconds since epoch
        // listFiles() - returns File[]
        // length() - number of bytes
        file.exists(); file.isDirectory();

        // Byte Streams and Character Streams:
        //      Stream Classes used for all types of binary and byte data
        //      InputStream <-> OutputStream, except PrinterStream
        //
        //      Reader/Writer classes used for character and String
        //      Reader <-> Writer, except PrinterWriter
        //
        //      Low-Level Stream: Direct connection to source
        //      High-Level Stream: Built on top of another stream
        //
        // Streams: InputStream | OutputStream | Reader | Writer
        //      FileInputStream     Low     Read as bytes
        //      FileOutputStream    Low     Write as bytes
        //      FileReader          Low     Read as characters
        //      FileWriter          Low     Write as characters
        //      BufferedReader      High    Read characters from existing Reader
        //      BufferedWriter      High    Write characters from existing Writer
        //      ObjectInputStream   High    Deserialize object from existing InputStream
        //      ObjectOutputStream  High    Serialize object from existing OutputStream
        //      InputStreamReader   High    Read characters from existing InputStream
        //      OutputStreamWriter  High    Write characters from existing OutputStream
        //      PrintStream         High    Write formatted representation of object to binary stream
        //      PrintWriter         High    Write formatted representation of object to text-based output stream
        //
        // NOT OCP: InputStreamReader, OutputStreamWriter, FilterInputStream, FilterOutputStream
        //
        // Common Stream Operations:
        //      close() throws IOException
        //      flush() throws IOException - request immediate write to disk
        //      mark(int readAheadLimit) throws IOException - mark current position, not all streams support mark
        //      markSupported() - check if marking is supported for stream
        //      reset() throws IOException - reset stream, if marked -> attempt to reposition to mark
        //      skip(long) throws IOException - skips characters, returns actually skipped characters in long

        // FileInputStream and FileOutputStream:
        //      Constructor takes File or String (throws FileNotFoundException)
        //
        //      int read() throws IOException               returns character as int value, -1 if end of file
        //      int read(byte[]) throws IOException                         / return number of bytes read into buffer
        //      int read(byte[], int off, int len) throws IOException       /
        //
        //      void write(int) throws IOException      pass character as int value
        //      void write(byte[]) throws IOException                       / return number of bytes read into buffer
        //      void write(byte[], int off, int len) throws IOException     /
        //
        // BufferedInputStream and BufferedOutputStream: Wrapping Stream, improved performance
        //      Constructor takes InputStream/OutputStream

        // FileReader and FileWriter:
        //      Constructor takes File or String (throws FileNotFoundException / IOException )
        //
        //      int read() throws IOException
        //      void write(String) throws IOException
        //
        // BufferedReader and BufferedWriter: Wrapping Stream, improved performance
        //      Constructor takes Reader/Writer
        //
        //      String readline() throws IOException
        //      void newLine() throws IOException

        // ObjectInputStream and ObjectOutputStream: (supports null objects)
        //      Constructor takes Input-/OutputStream (throws IOException)
        //
        //      serialization - convert object to stored data format
        //      Recommended static serialVersionUID variable when implementing Serializable
        //      Serializable Interface to enable serialization
        //      Variables also has to implement it or be transient -> else NotSerializableException
        //      transient and static objects will skip serialization process
        //      object type inside memory will be saved
        //      On deserialization - skip constructor/initializer of serialized class
        //          first no-arg constructor from non-serializable parent class called
        //          default initializations ignored
        //
        //      Object readObject() throws IOException, ClassNotFoundException
        //      void writeObject() throws IOException

        // PrinterStream and PrinterWriter: (throw no exceptions)
        //      Constructor takes File/String/OutputStream ( + Writer for PrinterWriter)
        //
        //      void print()
        //      void println()
        //      boolean checkError()
        //      PrintStream/PrintWriter format(String, Object...)
        //      PrintStream/PrintWriter printf(String, Object...) - passthrough to format()

        try(ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("./save")))){
            stream.writeObject(new Save());
        }

        // Catching:
        //      new FileInputStream(File) throws FileNotFoundException
        //      close() throws IOException
        //      readObject() throws IOException, ClassNotFoundException
        catch(Exception e){ System.out.println(e.getMessage());}

        try(ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./save")))){
            Save s = (Save) stream.readObject();
            s.print();
        }catch(Exception e){ System.out.println(e.getMessage());}
        

        // Interfacting with User: Console Class (Singleton) from System.console() -> might be null
        //      Reader reader()
        //      PrintWriter writer()
        //      Console format(String, Object...) / printf()
        //      void flush() - force any buffered output to write, called before reads to ensure no data is pending
        //      String readline()
        //      char[] readPassword(String, Object...) - disables echoing
        System.console().readLine();
    }

}

class Save implements Serializable{
    private static String name = "Test";
    private Object s = null;

    public void print(){
        System.out.println("Name: " + name);
    }
}