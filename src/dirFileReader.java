
import java.io.*;
import java.nio.file.Files;
import java.util.stream.Stream;

public class dirFileReader {

    public static void main(String args[]){

        try {
         String filePath ="src/files/Dictionary.txt";
         readFileAndDisplayWordMeanings(filePath);

        }
        catch(IOException ex){
            System.out.println("Exception-"+ex.getLocalizedMessage());
        }
    }

    private static void readFileAndDisplayWordMeanings(String filePath) throws IOException{

        File fileObj = new File(filePath);
        if(doesFileExist(  fileObj)) {

            try (Stream<String> linesStream = Files.lines(fileObj.toPath())) {
                linesStream.forEach(line -> {
                      System.out.println( (line.toString().trim().split("–"))[0]);
                      String values=(line.toString().split("–"))[1];
                      String [] meanings=values.split(",");
                      for(String meaning:meanings){
                          System.out.println(meaning.trim());
                      }

                });
            }

        }else{
            System.out.println("fileDoesNotExist");
        }
    }

    static boolean doesFileExist( File f){

        if(!f.exists() || f.isDirectory()) {
            return false;
        }
        return true;
    }
}