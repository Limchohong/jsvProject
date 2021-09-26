package com.jsv.giftShop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsv.giftShop.dto.GoodsCartDTO;
import com.jsv.giftShop.service.CartService;
import com.jsv.member.dto.MemberDTO;


//장바구니 관련 컨트롤러 
@Controller("CartController")
public class CartControllerImpl implements CartController {
	
	@Autowired
	private CartService cartService;
	
	//장바구니 담기
	@Override
	@ResponseBody
	@RequestMapping(value="/gift-shop/addCart.mo", method=RequestMethod.POST)
	public String addCart(HttpServletRequest request,
			@RequestParam("goods_no") int goods_no,
			@RequestParam("cart_qty") int cart_qty) throws Exception {
		
		//세션에 저장된 회원 정보 가져오기
		MemberDTO user = (MemberDTO)request.getSession().getAttribute("authUser");
		
		//세션에 저장된 회원의 정보가 비어있지 않을 경우
		if(user!=null) {
			
			//세션에 저장된 회원 번호 받아오기 
			int userno = user.getU_no();
			
			//데이터 교환을 위한 장바구니 객체 생성자를 통해 값 세팅
			GoodsCartDTO cartDTO = new GoodsCartDTO(userno,goods_no,cart_qty);

			/*데이터 교환을 위한 장바구니 객체를 DB에 전달 후 
			    해당 내용으로 추가 된 행의  해당 상품번호의 행 생성 수를 return받아
			   행이 생성 되었으면 "success"를 view에 전달
			    행이 생성되지 않았을 경우  "failed"를 view에 전달 */
			int result = cartService.addCart(cartDTO);
			
			if(result>0) {
				return "success";
			}else {
				return "failed";
			}
		//세션에 저장된 회원의 정보가 비어있을 경우	
		}else {
			return "noLogin";
		}
	}
	
	//장바구니 목록조회
	@Override
	@RequestMapping("/gift-shop/userCartList.mo")
	public ModelAndView getCartList(HttpServletRequest request) throws Exception{
		
		//세션에 저장된 회원 정보 가져오기
		MemberDTO user = (MemberDTO)request.getSession().getAttribute("authUser");
		
		//Model처리와 view지정을 위한 객체 생성 
		ModelAndView mv = new ModelAndView();
		
		//세션에 저장된 회원의 정보가 비어있지 않을 경우
		if(user!=null) {
			
			//세션에 저장된 회원 번호 받아오기 
			int userno = user.getU_no();
			
			//세션에 저장된 회원 번호로 DB에서 조회된 장바구니 목록 정보를 List타입으로 받음
			List<GoodsCartDTO> cartList = cartService.getCartList(userno);
			
			//해당 회원의 장바구니 목록 정보를 view에 전달
			mv.addObject("cartList", cartList);
			
			//view지정
			mv.setViewName("/cart/cartList");
		}
		return mv;
	}
	
	//장바구니 수량변경
	@Override
	@RequestMapping(value="/gift-shop/setCartQty.mo", method=RequestMethod.POST)
	@ResponseBody
	public String setCartQty(@RequestParam("cart_no") int goods_cart_no,
							 @RequestParam("qty") int goods_cart_qty) throws Exception{
		
		//파라미터로 받은 값을 담을 Map생성
		Map<String,Integer> cartMap = new HashMap<String,Integer>();
		cartMap.put("goods_cart_no", goods_cart_no);	//장바구니 번호
		cartMap.put("goods_cart_qty",goods_cart_qty);	//변경할 수량
		
		//장바구니 번호와 변경할 수량이 담긴 Map을 DB에 전달하여 수정된 행의 수를 return받음
		int result = cartService.setCartQty(cartMap);
		
		/*수정된 행이 있을 경우 "success" 전달
		    수정된 행이 없을 경우 "failed" 전달 */
		if(result>0) {
			return "success";
		}else {
			return "failed";
		}
	}
	
	//장바구니 체크박스 선택 삭제
	@Override
	@RequestMapping(value="/gift-shop/removeCheckedCart.mo", method=RequestMethod.POST)
	@ResponseBody
	public String removeCheckedCart(@RequestParam("checkArr[]") List<Integer> checkArr) throws Exception{
		
		//파라미터로 받은 삭제할 번호들이 담긴 배열을 DB에 전달 후 해당 번호로 삭제된 행의 수 return받음
		int result = cartService.removeCheckedCart(checkArr);
		
		/*return받은 값이 삭제할 번호가 담긴 배열의 크기와 같을 경우 "success" 전달
		    그렇지 않을 경우엔 "failed" 전달 */
		if(checkArr.size() == result) {
			return "success";
		}else {
			return "failed";
		}
	}
	
}

