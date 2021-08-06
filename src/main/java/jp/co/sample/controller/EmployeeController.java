package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 従業員情報を操作するコントローラ.
 * 
 * @author hayato.saishu
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@ModelAttribute
	public UpdateEmployeeForm setUpForm() {
		return new UpdateEmployeeForm();
	}
	
	/**
	 * 従業員一覧を表示する.
	 * 
	 * @param model　リクエストスコープへ格納する
	 * @return 従業員一覧ページへフォワード
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		model.addAttribute("employeeList", employeeService.showList());
		
		return "employee/list";
	}
	
	/**
	 * 従業員の詳細情報を表示する.
	 * 
	 * @param id 従業員ID
	 * @param model リクエストスコープへ格納する
	 * @return　従業員詳細ページへフォワード
	 */
	@RequestMapping("/showDetail")
	public String showDatail(String id, Model model) {
		Integer showId = Integer.parseInt(id);
		model.addAttribute("employee", employeeService.showDetail(showId));
		return "employee/detail";
	}
}
