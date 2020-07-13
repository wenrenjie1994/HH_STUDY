package SSM.SERVICE.Impl;


import SSM.DAO.IRoleDao;
import SSM.DOMAIN.Permission;
import SSM.DOMAIN.Role;
import SSM.SERVICE.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll()throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissonToRole(String roleId, String[] permissionIds) throws Exception{
        for(String permissionId : permissionIds){
            roleDao.addPermissonToRole(roleId,permissionId);
        }
    }
}
