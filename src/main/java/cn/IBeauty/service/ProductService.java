package cn.IBeauty.service;

import java.util.List;
import cn.IBeauty.po.Product;

public interface ProductService {

	public List<Product> findAllProduct();

	// 查询一级分类
	public List<Product> findFirstProduct(int id);

	// 查询二级分类
	public List<Product> findsecondProduct(int id);

	// 查询细节分类
	public List<Product> findProductBytexture(String texture);

	// 品牌分类
	public List<Product> GroupByBrand(int id);

	public List<Product> GroupByBrand_Search(String keyword);

	// 肤质分类
	public List<Product> GroupByCondition(int id);

	public List<Product> GroupByConditionn_Search(String keyword);

	// 根据id查询
	public Product findProduct(int productId);

	// 模糊搜索
	public List<Product> Search(String keyword);

	// 查询相似品牌的商品
	public Product SameBrandProduct(String ProductBrand);

	// 查询同类商品
	public Product SameProduct(String texture);

	// 王春培
	public List<Product> listProduct(String brand);

	// 根据肤质查询结果
	public List<Product> listcondition(String condition);

	// 根据肤质和品牌查询
	public List<Product> listcal(String brand, String condition);

	public List<Product> listDetail(int productId);

	public List<Product> changeprice(int xiaprice, int shangprice);

	public List<Product> groundtime(String categoryy);

	public List<Product> dgroundtime(String categoryy);
}
