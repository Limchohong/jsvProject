package com.jsv.giftShop.controller;

import java.util.ArrayList;
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

import com.jsv.giftShop.dto.GoodsOrderDTO;
import com.jsv.giftShop.dto.GoodsOrderDetailDTO;
import com.jsv.giftShop.service.OrderService;
import com.jsv.giftShop.util.OrderBaseController;
import com.jsv.member.dto.MemberDTO;

@Controller("PaymentController")
public class OrderControllerImpl extends OrderBaseController implements OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//결제 폼 보여주기 - 장바구니 구매시
	@Override
	@RequestMapping(value="/gift-shop/goodsOrdersForm.mo", method=RequestMethod.POST)
	public ModelAndView goodsOrdersForm(ModelAndView mv,
			@RequestParam("checkArr") List<Integer> checkArr) throws Exception {
		
		//파라미터로 받은 체크된 상품 목록으로 DB에서 조회후 상품 목록 정보,회원 정보를 받기
		List<Map<String, Object>> listMap = orderService.getCartList(checkArr);
		
		//회원 정보 가져오기
		Map<String, Object> cartMap = listMap.get(0);
		
		//회원 정보가 담긴 변수명 안에 회원번호로 회원 정보 조회 
		Map<String, Object> memberInfoMap = orderService.getMemberInfo((Integer)cartMap.get("u_no"));
		
		//구매하는 상품 정보를 view에 전달
		mv.addObject("listMap", listMap);
		
		//구매자 정보를 view에 전달
		mv.addObject("memberInfoMap", memberInfoMap);
		
		//view지정
		mv.setViewName("/order/goodsOrderForm");
		
		return mv;
	}
	
	//결제 폼 보여주기 - 개별상품 구매시
	@Override
	@RequestMapping("/gift-shop/goodsOrderForm.mo")
	public ModelAndView goodsOrderForm(HttpServletRequest request,HttpServletRequest response,
										ModelAndView mv,
										@RequestParam("goods_no") int goods_no,
										@RequestParam("qty") int qty) throws Exception {
		
		//세션에 저장된 회원 정보 가져오기
		MemberDTO user = (MemberDTO)request.getSession().getAttribute("authUser");
		
		//세션에 저장된 회원 번호 가져오기
		int u_no = user.getU_no();
		
		//세션에서 가져온 회원번호로 회원 정보 받기
		Map<String, Object> memberInfoMap = orderService.getMemberInfo(u_no);
		
		//파라미터로 받은 상품번호로 해당 상품  정보 받기
		List<Map<String, Object>> listMap = orderService.getOrderGoods(goods_no);
		
		//파라미터로 받은 수량을 view에 전달
		mv.addObject("qty",qty);
		
		//상품 상세내용 view에 전달 
		mv.addObject("listMap", listMap);
		
		//구매자 정보 view에 전달
		mv.addObject("memberInfoMap", memberInfoMap);
		
		//상품 상세페이지와 장바구니에서 구매하는 것을 구별하기 위한 내용 view에 전달
		mv.addObject("result", "one");
		
		//view지정
		mv.setViewName("/order/goodsOrderForm");
		return mv;
	}
	
	//결제 처리
	@Override
	@ResponseBody
	@RequestMapping(value="/gift-shop/goodsOrder.mo",method=RequestMethod.POST)
	public int newGoodsOrder (HttpServletRequest request,
								@RequestParam("goods_qty[]") List<Integer> goods_qty,
								@RequestParam("goods_no[]") List<Integer> goods_no,
								@RequestParam("goods_price[]") List<Integer> goods_price,
								@RequestParam("user_ph") int user_ph,
								@RequestParam("sum") int sum) throws Exception{
		
		//세션에 저장된 회원 정보 받기
		MemberDTO user = (MemberDTO)request.getSession().getAttribute("authUser");
		
		//회원 번호 가져오기 
		int u_no = user.getU_no();
		
		//주문번호 생성 메서드 호출 후 주문번호 받기 
		String orderNo = getOrderNo();
		
		//주문DTO의 생성자를 이용하여 생성한 주문번호, 회원번호, 휴대폰 번호, 결제 금액 세팅
		GoodsOrderDTO goodsOrderDTO = new GoodsOrderDTO(orderNo,u_no,String.valueOf(user_ph),sum);	
		
		//주문 상세 내용을 담기 위한 변수 초기화 
		GoodsOrderDetailDTO orderDetailDTO = null;
		
		//주문 상세내용이 담긴 주문상세DTO 여러개를 담을 List 객체 생성
		List<GoodsOrderDetailDTO> list = new ArrayList<GoodsOrderDetailDTO>();
		
		/*파라미터로 받은 상품번호가 담긴 배열의 사이즈 만큼 반복을 돌며 
		  DB내 주문 상세 테이블에 담길 데이터를 
		    주문 상세 DTO에 주문번호, 회원번호, 상품번호, 
		    해당 상품가격, 구매수량, 결제방법, 기프티콘 번호 세팅 후 List에 추가
		    기프티콘 번호는 랜덤 문자열 + 랜덤 숫자 총 12자리 생성 메서드를 따로 빼서 사용함 getGiftconeNum() */
		for(int i=0;i<goods_no.size();i++) {
			orderDetailDTO = new GoodsOrderDetailDTO(orderNo,u_no,goods_no.get(i),
					goods_price.get(i),goods_qty.get(i),"card",getGiftconeNum());
			list.add(orderDetailDTO);
		}
		
		//주문 상세내용이 담긴 List를 Map에 추가하기 위한 객체 생성 후 추가
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		//주문 내용과, 주문상세 내용을 DB에 저장 후 DB내 주문 상세 목록 정보 받기
		List<Map<String,String>> giftcones = orderService.newGoodsOrder(goodsOrderDTO,map);	
		
		//DB내 주문 상세 목록 정보가 비어있지 않다면
		if(giftcones!=null) {
			
			//문자 발송할 내용을 담을 변수 
			String text = "JSV 기프티콘 \n";
			
			/*Map안에 담긴 주문 상세 목록의 길이만큼 반복문을 돌며 
			    상품명,기프티콘 번호를 문자 발송할 내용이 담긴 변수에 추가*/
			for(Map<String, String> giftcon:giftcones) {
				text += giftcon.get("goods_name")+" : "+giftcon.get("goods_giftcone_code")+"\n";
			}
			
			/*문자발송 메서드를 호출하여 파라미터로 받은 
			    구매자의 휴대폰 번호와 발송할 내용이 담긴 변수를 매개변수로 주어 문자 발송함 */
			sendsms(String.valueOf(user_ph), text);
			return 200;
		}else {
			return 404;
		}
	}

	
	//주문 - 성공,실패 여부 확인 후 페이지 리턴
	@Override
	@RequestMapping("/gift-shop/isOrderComplete.mo")
	public ModelAndView isOrderComplete(ModelAndView mv,
										@RequestParam("code") int code) throws Exception{
		
		/*파라미터로 받은 코드가 200일 경우 성공 페이지로 view지정
		    그렇지 않을 경우 실패 페이지로 view지정*/
		if(code==200) {
			mv.setViewName("redirect:successOrderComplete.mo");
		}else {
			mv.setViewName("redirect:failedOrderComplete.mo?code=404");
		}
		return mv;
	}
	
	//주문 - 성공시 
	@Override
	@RequestMapping("/gift-shop/successOrderComplete.mo")
	public ModelAndView successOrderComplete(ModelAndView mv) throws Exception{
		
		//view에 전달할 내용
		mv.addObject("result", "complete");
		
		//view지정
		mv.setViewName("/order/isCompleteForm");
		return mv;
	}
	
	//주문 - 실패시
	@Override
	@RequestMapping("/gift-shop/failedOrderComplete.mo")
	public ModelAndView failedOrderComplete(ModelAndView mv, @RequestParam("code") int code) throws Exception{
		
		//파라미터로 받은 코드가 404일 경우 view에 전달할 내용과 view지정
		if(code==404) {
			mv.addObject("result", "failed_404");
			mv.setViewName("/order/isCompleteForm");
		}
		return mv;
	}
	
	
	//주문내역 조회
	@Override
	@RequestMapping("/gift-shop/getOrderList.mo")
	public ModelAndView getOrderList(HttpServletRequest request,
									 ModelAndView mv) throws Exception{

		//세션에 저장된 회원 정보 받기
		MemberDTO user = (MemberDTO)request.getSession().getAttribute("authUser");
		
		//세션에 저장된 정보에서 회원 번호 가져오기
		int u_no = user.getU_no();
		
		//회원번호로 주문내역 목록 가져오기
		List<Map<String,Object>> orderListMap = orderService.getOrderList(u_no);
		
		//주문내역 목록 view에 전달
		mv.addObject("orderListMap", orderListMap);
		
		//view지정
		mv.setViewName("/order/goodsOrderList");
		return mv;
	}
	
	//주문 상세내역 조회
	@Override
	@RequestMapping("/gift-shop/getOrderDetail.mo")
	public ModelAndView getOrderDetail(ModelAndView mv,
			@RequestParam("order_no") String goods_order_no) throws Exception{
		
		//파라미터로 받은 주문 번호로 상세 주문내역 정보 가져오기
		List<Map<String,Object>> detailListMap = orderService.getOrderDetail(goods_order_no);
		
		//상세 주문내역 정보 view에 전달
		mv.addObject("detailListMap",detailListMap);
		
		//파라미터로 받은 주문번호 view에 전달 
		mv.addObject("goods_order_no",goods_order_no);
		
		//view지정
		mv.setViewName("/order/goodsOrderDetail");
		return mv;
	}
	
	
	
}
