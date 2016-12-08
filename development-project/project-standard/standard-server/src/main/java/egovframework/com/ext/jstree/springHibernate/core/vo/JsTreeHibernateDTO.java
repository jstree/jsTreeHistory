package egovframework.com.ext.jstree.springHibernate.core.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "T_COMPREHENSIVETREE_HIBER", schema = "STANDARD_DB")
@org.hibernate.annotations.Entity(selectBeforeUpdate = true, dynamicUpdate = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class JsTreeHibernateDTO extends JsTreeHibernateBaseDTO implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = -6859122566734590165L;

	public JsTreeHibernateDTO() {
		super();
	}

	public JsTreeHibernateDTO(Boolean copyBooleanValue) {
		super();
		this.copyBooleanValue = copyBooleanValue;
	}

	/*
	 * Extend Bean Field
	 */
	private Boolean copyBooleanValue;

	@Transient
	public Boolean getCopyBooleanValue() {
		copyBooleanValue = false;
		if (this.getCopy() == 0) {
			copyBooleanValue = false;
		} else {
			copyBooleanValue = true;
		}
		return copyBooleanValue;
	}

	public void setCopyBooleanValue(Boolean copyBooleanValue) {
		this.copyBooleanValue = copyBooleanValue;
	}

	@Transient
	public String getState() {
		String returnCode = new String();

		if (getChildcount() == null || getChildcount().equals(" ")) {
			returnCode = "update status";
		} else if (getChildcount().equals("InChild")) {
			returnCode = "closed";
		} else {
			returnCode = "leafNode";
		}
		return returnCode;
	}

}
