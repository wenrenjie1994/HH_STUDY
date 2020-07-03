package bean;

public enum ChoiceEnum {
    ADD(1, "add"),
    REMOVE(2, "remove"),
    UPDATE(3, "update"),
    QUERY(4, "query"),
    EXIT(5, "exit");

    private int ordinal;
    private String operation;

    ChoiceEnum(int ordinal, String operation){
        this.ordinal = ordinal;
        this.operation = operation;
    }

    public static ChoiceEnum getEnumByValue(int value){
        for (ChoiceEnum choice : values()){
            if(choice.ordinal == value)
                return choice;
        }
        return null;
    }
}
