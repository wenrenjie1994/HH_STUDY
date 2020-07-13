package SSM.SERVICE;



import SSM.DOMAIN.Permission;

import java.util.List;


public interface IPermissionService {
    List<Permission> findAll()throws Exception;

    void save(Permission p)throws Exception;
}
