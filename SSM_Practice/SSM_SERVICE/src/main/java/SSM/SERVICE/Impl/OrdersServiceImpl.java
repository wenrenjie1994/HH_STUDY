package SSM.SERVICE.Impl;

import SSM.DAO.IOrdersDao;
import SSM.DOMAIN.Orders;
import SSM.SERVICE.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;
    @Override
    public List<Orders> findAll() throws Exception {
        PageHelper.startPage(1,5);
        return ordersDao.findAll();
    }
    @Override
    public List<Orders> findAllByPage(int page, int pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return ordersDao.findAll();
    }
    public Orders findById(String id) throws Exception{
        return ordersDao.findById(id);
    }
}
