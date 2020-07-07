package Other;

import java.io.*;
import java.util.LinkedList;

public class DataOperate {
    public static void loadData(LinkedList<Candidate> bookList) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Users/wenrenjie/Desktop/booklist.txt"));
            String data = br.readLine();
            while (data != null) {
                String[] str = data.split(",");
                String a = str[0];
                String b = str[1];
                String c = str[2];
                Candidate book = new Candidate(a, b, c);
                bookList.add(book);
                data = br.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveCandidate(LinkedList<Candidate> bookList) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/Users/wenrenjie/Desktop/booklist.txt", false)));//¸²¸ÇÐ´Èë
            int bookCount = bookList.size();
            for (int i = 0; i < bookCount; i++) {
                printWriter.println(bookList.get(i).Name + "," + bookList.get(i).age + "," + bookList.get(i).Education);
            }
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}
