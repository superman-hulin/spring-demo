package dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pojo.Account;
@Mapper
public interface AccountDao extends BaseMapper<Account> {

}
