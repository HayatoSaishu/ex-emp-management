package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者情報の処理制御を行うコントローラー.
 * 
 * @author hayato.saishu
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;
	
	@Autowired
	private HttpSession session;
	
	/**
	 * フォームをリクエストスコープに格納.
	 * 
	 * @return フォームオブジェクト
	 */	
	@ModelAttribute
	public InsertAdministratorForm setUpForm() {
		return new InsertAdministratorForm();
	}
	
	/**
	 * フォームをリクエストスコープに格納
	 * 
	 * @return フォームオブジェクト
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	
	/**
	 * 管理者情報を登録する画面に遷移.
	 *
	 * @return 管理者情報を登録する画面へフォワードする。
	 * 初期画面へ遷移.
	 * 
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	/**
	 * 管理者情報を登録する.
	 * 
	 * @return ログイン画面にリダイレクトする
	 */
	@RequestMapping("/insert")
	public String toInsert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		
		administratorService.insert(administrator);
		
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
	
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
		if(administrator == null) {
			model.addAttribute("errorMessage", "メールアドレスまたはパスワードが不正です");
			return "administrator/login";
		} else {
			session.setAttribute("administratorName", administrator.getName());
			return "forward:/employee/showList";
		}
	}

}
