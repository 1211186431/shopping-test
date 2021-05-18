package com.example.demo.dao.goodsMapper;

import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class GoodsSelect {
	 public String getGoodsShow(Map<String,Object> map){
		 String str="SELECT"
		 		+ "	g.id,"
		 		+ "	g.price,"
		 		+ "	g.NAME,"
		 		+ "	g.picture,"
		 		+ "	g.user_id,"
		 		+ " g.salesNum,"
		 		+ " g.grade "
		 		+ "FROM"
		 		+ "	type t"
		 		+ "	JOIN goodstype gt ON t.id = gt.type_id"
		 		+ "	JOIN goods g ON gt.goods_id = g.id ";
		 String a=" ";
		 String g="g";
		 if(!map.get("type").equals(0)) {
			 str=str+ "WHERE"
				+ "	gt.type_id = "+map.get("type");
			 a=" and ";
			 g="g";
		 }else {
			 str="SELECT"
			 		+ "	id,"
			 		+ "	price,"
			 		+ "	goods.`name`,"
			 		+ "	picture,"
			 		+ "	user_id,"
			 		+ "	salesNum,"
			 		+ "	grade "
			 		+ "FROM "
			 		+ "	goods ";
			 g="goods";
		 }
		 if(map.get("name")!="") {
			 str=str+a+ "where "+g+".state=1 && g.name like CONCAT('%','"+map.get("name")+"','%')";
		 }
		 if(!(map.get("priceSort")=="" && map.get("salesSort")=="" && map.get("gradeSort")=="")) {
			 String f= " ORDER BY ";
			 String t="";
			 if(map.get("priceSort")!="") {
				 f=f+g+".price "+map.get("priceSort");
				 t=",";
			 }
			 if(map.get("salesSort")!="") {
				 f=f+t+g+".salesNum "+map.get("salesSort");
				 t=",";
			 }
			 if(map.get("gradeSort")!="") {
				 f=f+t+g+".grade"+map.get("gradeSort");
			 }
			 str=str+f;
		 }
		 		
		 return str;
	 }
}
