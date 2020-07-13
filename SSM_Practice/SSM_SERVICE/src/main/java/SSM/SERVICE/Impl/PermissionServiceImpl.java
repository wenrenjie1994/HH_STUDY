package SSM.SERVICE.Impl;

import SSM.DAO.IPermissionDao;
import SSM.DOMAIN.Permission;
import SSM.SERVICE.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission p) throws Exception {
        permissionDao.save(p);
    }

}
