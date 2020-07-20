package util;
import medol.ActionResult;
/**
 * @program: HH_STUDY
 * @description:
 * @author: qiu haoran
 * @create: 2020-07-20 17:25
 */
public class ServerProtocol {
    public ServerProtocol() {
    }

    public String AddResumeMessage(ActionResult ar) {
        String isSuccess = ar.isSuccess;
        String str;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }

        return str;
    }

    public String deleteResumeByIdMessage(ActionResult ar) {
        String isSuccess = ar.isSuccess;
        String str;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }

        return str;
    }

    public String deleteResumeByAuthorMessage(ActionResult ar) {
        String isSuccess = ar.isSuccess;
        String str;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }

        return str;
    }

    public String changeResumeMessage(ActionResult ar) {
        String isSuccess = ar.isSuccess;
        String str;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }

        return str;
    }

//    public String searchBookByNameMessage(ActionResult ar) {
//        String isSuccess = ar.isSuccess;
//        String str;
//        if (isSuccess.equals("Success")) {
//            BookList bookList = (BookList)ar.resultData;
//            str = isSuccess + "/n";
//            int booksize = bookList.size();
//
//            for(int i = 0; i < booksize; ++i) {
//                String bookstring = ((Book)bookList.get(i)).bookName + "," + ((Book)bookList.get(i)).bookAuthor + "," + ((Book)bookList.get(i)).bookPrice + ";";
//                str = str + bookstring;
//            }
//        } else {
//            str = isSuccess + "/n" + ar.failReason;
//        }
//
//        return str;
//    }
//
//    public String searchBookByAuthorMessage(ActionResult ar) {
//        String isSuccess = ar.isSuccess;
//        String str;
//        if (isSuccess.equals("Success")) {
//            BookList bookList = (BookList)ar.resultData;
//            str = isSuccess + "/n";
//            int booksize = bookList.size();
//
//            for(int i = 0; i < booksize; ++i) {
//                String bookstring = ((Book)bookList.get(i)).bookName + "," + ((Book)bookList.get(i)).bookAuthor + "," + ((Book)bookList.get(i)).bookPrice + ";";
//                str = str + bookstring;
//            }
//        } else {
//            str = isSuccess + "/n" + ar.failReason;
//        }
//
//        return str;
//    }
//
//    public String searchBookByPriceMessage(ActionResult ar) {
//        String isSuccess = ar.isSuccess;
//        String str;
//        if (isSuccess.equals("Success")) {
//            BookList bookList = (BookList)ar.resultData;
//            str = isSuccess + "/n";
//            int booksize = bookList.size();
//
//            for(int i = 0; i < booksize; ++i) {
//                String bookstring = ((Book)bookList.get(i)).bookName + "," + ((Book)bookList.get(i)).bookAuthor + "," + ((Book)bookList.get(i)).bookPrice + ";";
//                str = str + bookstring;
//            }
//        } else {
//            str = isSuccess + "/n" + ar.failReason;
//        }
//
//        return str;
//    }
//
//    public String searchBookByKeyWordMessage(ActionResult ar) {
//        String isSuccess = ar.isSuccess;
//        String str;
//        if (isSuccess.equals("Success")) {
//            BookList bookList = (BookList)ar.resultData;
//            str = isSuccess + "/n";
//            int booksize = bookList.size();
//
//            for(int i = 0; i < booksize; ++i) {
//                String bookstring = ((Book)bookList.get(i)).bookName + "," + ((Book)bookList.get(i)).bookAuthor + "," + ((Book)bookList.get(i)).bookPrice + ";";
//                str = str + bookstring;
//            }
//        } else {
//            str = isSuccess + "/n" + ar.failReason;
//        }
//
//        return str;
//    }
}
