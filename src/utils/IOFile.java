package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static <T> List<T> readFromFile ( String path)  {
        List<T> list = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            // Thử đọc object từ file
            list = (List<T>) ois.readObject();
            ois.close();
        } catch (EOFException e) {
            System.out.println("Tệp trống hoặc không còn đối tượng để đọc: " + path);
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tập tin: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi đọc tập tin: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
        return list;
    }

    public static <T> void writeToFile(List<T> list, String path)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(list);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
