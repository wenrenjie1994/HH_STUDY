package SSM.SERVICE;

import SSM.DOMAIN.*;

import java.util.List;

public interface IOrdersService {

    public List<Orders> findAll() throws Exception;
    public List<Orders> findAllByPage(int page, int pageSize) throws Exception;
    public Orders findById(String id) throws Exception;
}
