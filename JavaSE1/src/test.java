import java.io.*;
import javax.swing.filechooser.*;

public class test {
    public static void main(String[] args) {
        FileSystemView view = FileSystemView.getFileSystemView();
        File path = view.getHomeDirectory();
        System.out.println(path);
    }
}
