package pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: proxy
 * @description: 账户实体类
 * @author: Su
 * @create: 2020-05-25 19:48
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("account_test")
public class Account {
    private int id;
    private String accountName;
    private Float money;
}
