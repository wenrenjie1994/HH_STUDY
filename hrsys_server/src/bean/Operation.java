package bean;

public class Operation<T> {
    private String operation;
    private T object;

    public String getOperation() {
        return operation;
    }

    public T getObject() {
        return object;
    }

    public Operation(String operation) {
        this.operation = operation;
    }

    public Operation(String operation, T object) {
        this.operation = operation;
        this.object = object;
    }

}
