package by.ecp.services;

import by.ecp.entity.Privilege;

/**
 * Created by User on 20.06.2017.
 */
public interface PrivilegeService {

    void save(Privilege privilege);

    Privilege findOne(Long id);
}
