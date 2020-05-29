package cglib;


/**
 * @program: cglib
 * @description: 生产者
 * @author: Su
 * @create: 2020-05-28 15:48
 **/
public class Producer{
    /**
    * @Autor:Su
    * @Description 销售
    * @Param
    */
    public void  sale(float money){
        System.out.println("销售产品，并拿到钱: "+money);
    }
    /**
    * @Autor:Su
    * @Description 售后
    * @Param
    */
    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
