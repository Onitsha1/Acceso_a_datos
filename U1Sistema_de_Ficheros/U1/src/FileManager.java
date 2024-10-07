import java.io.*;

public class FileManager {

    public void createFile (String fileName){
        File file = new File(fileName); /*Defining a reference to the new file.
        Note: The file is not created at this point*/
        try {
            if (file.createNewFile()) { //It returns true if the file is created and false if it could not be created
                System.out.println("File " + file.getName() + " created.");
            } else {
                System.out.println("Unable to create file " + file.getName() + ".");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile (String fileName){
        File file = new File(fileName);
        if (file.delete()){
            System.out.println("File " + file.getName() + " deleted successfully.");
        } else {
            System.out.println("Unable to delete file " + file.getName());
        }
    }

    public void copyFile (String source, String sink){
        File sourceFile = new File(source);
        File sinkFile = new File (sink);
        /*The following classes are used to read data from a file byte by byte
         * and writing data to a file, respectively*/
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(sinkFile))
        {
            byte [] buffer = new byte[1024]; //Declaring an array of 1KB as a buffer
            int length;
            while ((length = fis.read(buffer)) > 0){ /* It will read 1KB from the source file in every iteration
             unless there is fewer bytes left to read*/
                fos.write(buffer, 0, length); /* Writes the content of the buffer from start to the amount of bytes
                read from the source file in the current iteration */
            }
            System.out.println("File " + source + " copied successfully.");
        } catch (IOException e){
            System.out.println("Unable to copy file " + source);
            e.printStackTrace();
        }
    }

    public void moveFile (String source, String sink) {
        /*This method can be used both to move a file and to rename it. To move a file the path is modified and
        to rename a file the path stays as it is but the name is modified.
         */
        File sourceFile = new File(source);
        File sinkFile = new File (sink);
        if (sourceFile.renameTo(sinkFile)){
            System.out.println("File " + source + "moved to " + sink);
        } else {
            System.out.println("Unable to move file " + source);
        }
    }
}