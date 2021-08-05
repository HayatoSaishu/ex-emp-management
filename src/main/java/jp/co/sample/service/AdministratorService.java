package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.repository.AdministratorRepository;

/**
 * 管理者情報の業務処理を行うサービス.
 * 
 * @author hayato.saishu
 *
 */
@Service
@Transactional
public class AdministratorService {

	@SuppressWarnings("unused")
	@Autowired
	private AdministratorRepository administratorRepository; 
}
