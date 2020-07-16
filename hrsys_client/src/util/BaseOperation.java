package util;


public interface BaseOperation<T> {
    String add(T t);

    String delete(T t);

    String update(T t);

    String queryAll();

    String query(T t);
}
