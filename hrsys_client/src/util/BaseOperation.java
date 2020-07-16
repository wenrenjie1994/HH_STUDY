package util;

/**
 * 泛型接口，声明了常用的请求类型
 * @param <T>
 */
public interface BaseOperation<T> {
    String add(T t);

    String delete(T t);

    String update(T t);

    String queryAll();

    String query(T t);

    String quit();
}
