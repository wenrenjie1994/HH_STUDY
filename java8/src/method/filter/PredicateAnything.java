package method.filter;

/**
 * @Author: A wei
 * @Date: 2020/6/24 17:39
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
public interface PredicateAnything<T> {

    boolean predict(T t);
}
