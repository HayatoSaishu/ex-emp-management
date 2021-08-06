package jp.co.sample.form;

/**
 * 従業員情報を変更する際に必要な値を受け取るフォーム.
 * 
 * @author hayato.saishu
 *
 */
public class UpdateEmployeeForm {

	/**
	 * ID
	 */
	private String id;
	/**
	 * 扶養人数
	 */
	private String dependentsCount;
	
	public Integer getIntegerId() {
		return Integer.parseInt(id);
	}
	
	public Integer getIntegerDependentsCount() {
		return Integer.parseInt(dependentsCount);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}
}
