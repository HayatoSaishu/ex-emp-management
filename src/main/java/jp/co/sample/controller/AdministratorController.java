package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministratorForm;
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

	@SuppressWarnings("unused")
	@Autowired
	private AdministratorService administratorService;
	
	@ModelAttribute
	public InsertAdministratorForm setUpForm() {
		return new InsertAdministratorForm();
	}
	
	/**
	 * 初期画面へ遷移.
	 * 
	 * @return 初期画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
}
