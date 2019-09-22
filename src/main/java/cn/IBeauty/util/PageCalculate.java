package cn.IBeauty.util;

public class PageCalculate {
	public static Integer getRowIndex(Integer Index,Integer pageSize){
		return (Index > 0)?(Index-1)*pageSize:pageSize;	
	}
}
