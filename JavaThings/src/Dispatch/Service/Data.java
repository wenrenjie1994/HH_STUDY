package Dispatch.Service;

public class Data {
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    //Employee:     10, id, name, age, salary
    //Programmer:   11, id, name, age, salary
    //Designer:     12, id, name, age, salary, bonus
    //Architect:    13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
            {"10", "1", "Jack Ma", "22", "3000"},
            {"13", "2", "Pony Ma", "32", "18000", "15000", "2000"},
            {"11", "3", "YH Li", "23", "7000"},
            {"11", "4", "QD Liu", "24", "7300"},
            {"12", "5", "Jun Lei", "28", "10000", "5000"},
            {"11", "6", "ZQ Ren", "22", "6800"},
            {"12", "7", "CZ Liu", "29", "10800", "5200"},
            {"13", "8", "YQ Yang", "30", "19800", "15000", "2500"},
            {"12", "9", "YZ Shi", "26", "9800", "5500"},
            {"11", "10", "L Ding", "21", "6600"},
            {"11", "11", "CY Zh", "25", "7100"},
            {"12", "12", "ZY Yang", "27", "9600", "4800"}
    };

    //EQUIPMENTS与EMPLOYEES数组元素一一对应
    //PC:       21, model, display
    //NoteBook: 22, model, price
    //Printer:  23, model, type
    public static final String[][] EQUIPMENTS = {
            {},
            {"22", "Lenovo T4", "6000"},
            {"21", "Dell", "NEC 17inch"},
            {"21", "Dell", "Sung 17inch"},
            {"23", "Canon 2900", "Iaser"},
            {"21", "ASUS", "Sung 17inch"},
            {"21", "ASUS", "Sung 17inch"},
            {"23", "Epson20K", "Needle"},
            {"22", "HP m6", "5800"},
            {"21", "Dell", "NEC 17inch"},
            {"21", "ASUS", "Sung 17inch"},
            {"22", "HP m6", "5800"}
    };
}
