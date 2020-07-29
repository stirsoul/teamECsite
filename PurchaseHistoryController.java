package jp.co.internous.ocean.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jp.co.internous.ocean.model.domain.dto.PurchaseHistoryDto;
import jp.co.internous.ocean.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.ocean.model.session.LoginSession;

@Controller
@RequestMapping("/ocean/history")
public class PurchaseHistoryController {
	
// userIdをもらう
	@Autowired 
	LoginSession loginSession;
		
//	購入履歴の引き出し
	@Autowired
	TblPurchaseHistoryMapper mapper;
	
//	SQL内の購入履歴の表示
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("loginSession", loginSession);
		int userId = loginSession.getUserId();
		List<PurchaseHistoryDto> history = mapper.findHistoryByUserId(userId);
		model.addAttribute("history", history);
		return "purchase_history";
	}
	
//	購入履歴の削除
	@ResponseBody
	@PostMapping("/delete")
	public String deleteApi() {
		int userId = loginSession.getUserId();
		try {
 			mapper.deleteById(userId);
		}catch (IllegalArgumentException e) {
		return "-1";
		}
		return "1";
	}
}
