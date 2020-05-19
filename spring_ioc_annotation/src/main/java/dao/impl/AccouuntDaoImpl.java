package dao.impl;

import dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @program: factory_model
 * @description: dao实现类
 * @author: Mr.Wang
 * @create: 2020-05-18 19:03
 **/
@Repository
public class AccouuntDaoImpl implements AccountDao {
    public void save() {
        System.out.println("保存了");
    }
}
