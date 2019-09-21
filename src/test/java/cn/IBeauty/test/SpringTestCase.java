package cn.IBeauty.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;



/**
* Created by haoz1w0w@126.com on 2017-06-02 23:36:18.
*spring 测试基类
*/
import cn.IBeauty.dao.ProductDAO;
import cn.IBeauty.po.Product;
import cn.IBeauty.service.ProductService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class SpringTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	public ProductDAO productDao;
	@Autowired
	public ProductService productService;
	
	
	@Test
	@Ignore
	public void testDao(){
		List<Product> list = productDao.findAll();
		for(Product product:list){
			System.out.println(product.getProduct_name());
		}
	}
	
	@Test 
	public void testService(){
		List<Product> list = productService.findAllProduct();
		for(Product product:list){
			System.out.println(product.getProduct_name());
		}
	}
}