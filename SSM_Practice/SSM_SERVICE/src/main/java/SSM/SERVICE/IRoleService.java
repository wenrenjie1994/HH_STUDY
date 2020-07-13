package SSM.SERVICE;




import SSM.DOMAIN.Permission;
import SSM.DOMAIN.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissonToRole(String roleId, String[] permissionIds) throws Exception;
}
