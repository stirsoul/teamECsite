package jp.co.internous.ocean.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.ocean.model.domain.dto.PurchaseHistoryDto;

@Mapper
 public interface TblPurchaseHistoryMapper {
	
// useIdによる購入情報表示（降順 status = 1 のデータのみ）
	@Select("SELECT p.purchased_at, m.product_name, p.price, p.product_count, d.family_name, d.first_name, d.address  FROM tbl_purchase_history p "+
				 "INNER JOIN mst_destination d " +
				 "ON d.id = p.destination_id " +
				 "INNER JOIN mst_product m " +
				 "ON m.id = p.product_id " +
				 "WHERE #{userId} = p.user_id " +
				 "AND p.status = 1 " +
				 "ORDER  BY purchased_at desc")
	List<PurchaseHistoryDto> findHistory(int userId);
	
//	購入情報の書き込み（決済から）
	@Insert("INSERT INTO tbl_purchase_history (user_id, product_id, product_count, price, destination_id) " +
				 "VALUE (#{userId}, #{productId}, #{productCount}, #{price}, #{destinationId}) ")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(PurchaseHistoryDto PurchaseHistoryDto);

//	商品購入履歴の削除(論理削除status = 0）
	@Update("UPDATE tbl_purchase_history set status = 0, updated_at = now() WHERE #{userId} = user_id AND status = 1 ")
	boolean deleteById(int userId);
}
