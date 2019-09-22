package cn.IBeauty.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * Created by haoz1w0w@126.com on 2017-06-02 23:36:18.
 *spring 测试基类
 */
import cn.IBeauty.dao.ProductDAO;
import cn.IBeauty.po.Product;
import cn.IBeauty.service.ProductService;
import cn.IBeauty.service.impl.ProductServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*.xml" })
public class SpringTestCase extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	public ProductDAO productDao;
	@Autowired
	public ProductService productService;
	@Autowired
	RedisTemplate redisTemplate;
	

	@Test
	@Ignore
	public void testDao() {	
		List<Product> list = productDao.findAll();	
		for (Product product : list) {
			System.out.println(product.getProduct_name());
		}
	}

	@Test
	public void testService() {
		List<Product> list = productService.findAllProduct();
		for (Product product : list) {
			System.out.println(product.getProduct_name());
		}
	}

	@Test
	@Ignore
	public void testRedis() {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("192.168.80.129");
		System.out.println("连接成功");

		// 设置 redis 字符串数据
		jedis.set("runoobkey", "www.runoob.com");

		// 获取存储的数据并输出
		System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
		jedis.close();
	}
	
	/**
	 * redis连接池
	 */
	@Test
	@Ignore
	public void testRedis2(){
		JedisPoolConfig config = new JedisPoolConfig();
		//设置最大连接数
		config.setMaxTotal(30);
		//设置最大空闲连接数
		config.setMaxIdle(10);
		
		//获得连接池
		JedisPool jedisPool = new JedisPool(config,"192.168.80.129",6379);
		Jedis jedis = null;
		try{
			//通过连接池获取连接
			jedis = jedisPool.getResource();
			//设置数据
			jedis.set("runoobkey", "www.runoob.com");
			System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			if(jedis!=null)
				jedis.close();
			if(jedisPool!=null)
				jedisPool.close();
		}	
	}
	@Test
	@Ignore
	public void Test01() {
		List<Product> list = productDao.findAll();	

		//存储到到内存中的不是map而是string，进行了序列化
		redisTemplate.opsForValue().set("productlist", list);
		List<Product> list1 = (List<Product>) redisTemplate.opsForValue().get("productlist");
		//上面两步不能保证每次使用RedisTemplate是操作同一个对Redis的连接
		
		System.out.println("redis开始");
		for (Product product : list1) {
			System.out.println(product.getProduct_name());
		}
	}
}