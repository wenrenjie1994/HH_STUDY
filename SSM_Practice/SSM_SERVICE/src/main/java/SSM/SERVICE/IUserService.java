package SSM.SERVICE;







import SSM.DOMAIN.Role;
import SSM.DOMAIN.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userid)throws Exception;

    void addRoleToUser(String userId, String[] roleIds)throws Exception;
}
