package egovframework.com.ext.jstree.springHibernate.core.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class T_JsTree {

	private long c_id;
	private long c_parentid;
	private long c_position;
	private long c_left;
	private long c_right;
	private long c_level;
	private String c_title;
	private String c_type;
	
	/*
	 * Common Use Field
	 */
	private int ref;
	private int copy;
	private int multiCounter;

	private int status;
	private String childcount;

	private int fixCopyId;
	
	public T_JsTree() {
	}

	

	public T_JsTree(long c_id, long c_parentid, long c_position, long c_left,
			long c_right, long c_level, String c_title, String c_type, int ref,
			int copy, int multiCounter, int status, String childcount,
			int fixCopyId) {
		super();
		this.c_id = c_id;
		this.c_parentid = c_parentid;
		this.c_position = c_position;
		this.c_left = c_left;
		this.c_right = c_right;
		this.c_level = c_level;
		this.c_title = c_title;
		this.c_type = c_type;
		this.ref = ref;
		this.copy = copy;
		this.multiCounter = multiCounter;
		this.status = status;
		this.childcount = childcount;
		this.fixCopyId = fixCopyId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	@Column
	public long getC_parentid() {
		return c_parentid;
	}

	public void setC_parentid(long c_parentid) {
		this.c_parentid = c_parentid;
	}

	@Column
	public long getC_position() {
		return c_position;
	}

	public void setC_position(long c_position) {
		this.c_position = c_position;
	}

	@Column
	public long getC_left() {
		return c_left;
	}

	public void setC_left(long c_left) {
		this.c_left = c_left;
	}

	@Column
	public long getC_right() {
		return c_right;
	}

	public void setC_right(long c_right) {
		this.c_right = c_right;
	}

	@Column
	public long getC_level() {
		return c_level;
	}

	public void setC_level(long c_level) {
		this.c_level = c_level;
	}

	@Column
	public String getC_title() {
		return c_title;
	}

	public void setC_title(String c_title) {
		this.c_title = c_title;
	}

	@Column
	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	
	@Transient
	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}
	
	@Transient
	public int getCopy() {
		return copy;
	}

	public void setCopy(int copy) {
		this.copy = copy;
	}
	
	@Transient
	public int getMultiCounter() {
		return multiCounter;
	}

	public void setMultiCounter(int multiCounter) {
		this.multiCounter = multiCounter;
	}
	
	@Transient
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	@Transient
	public String getChildcount() {
		return childcount;
	}

	public void setChildcount(String childcount) {
		this.childcount = childcount;
	}
	
	@Transient
	public int getFixCopyId() {
		return fixCopyId;
	}

	public void setFixCopyId(int fixCopyId) {
		this.fixCopyId = fixCopyId;
	}
}
