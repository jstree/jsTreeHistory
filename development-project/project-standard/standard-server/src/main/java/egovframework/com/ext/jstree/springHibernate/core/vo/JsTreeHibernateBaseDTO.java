package egovframework.com.ext.jstree.springHibernate.core.vo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Range;

import egovframework.com.ext.jstree.springmyBatis.core.validation.custom.constraints.Contained;
import egovframework.com.ext.jstree.springmyBatis.core.validation.group.AddNode;
import egovframework.com.ext.jstree.springmyBatis.core.validation.group.AlterNode;
import egovframework.com.ext.jstree.springmyBatis.core.validation.group.AlterNodeType;
import egovframework.com.ext.jstree.springmyBatis.core.validation.group.MoveNode;
import egovframework.com.ext.jstree.springmyBatis.core.validation.group.RemoveNode;
import egovframework.com.ext.jstree.springmyBatis.core.vo.ComprehensiveTree;

@MappedSuperclass
public abstract class JsTreeHibernateBaseDTO {

	/** 노드의 고유 id, 1부터 시작(Root Node) */
	@Min(value = 2, groups = { RemoveNode.class, AlterNode.class, AlterNodeType.class, MoveNode.class })
	private BigDecimal c_id;

	/** 노드의 부모 id, 0부터 시작(Root Node) */
	private BigDecimal c_parentid;

	/** Parent의 몇 번째 자식인지를 나타냄. 0부터 시작 */
	@Min(value = 0, groups = { AddNode.class, MoveNode.class })
	private BigDecimal c_position;

	/** 노드의 left 위치, 1부터 시작(Root Node) */
	private BigDecimal c_left;

	/** 노드의 right 위치, 자식이 없다면 left + 1의 값을 가진다. */
	private BigDecimal c_right;

	/** 노드의 depth, 0부터 시작 */
	private BigDecimal c_level;

	/** Node 의 title */
	private String c_title;

	/**
	 * <pre>
	 * 노드의 type
	 * root : root 노드
	 * drive : first child 노드
	 * folder : branch 노드
	 * default : leaf 노드
	 * </pre>
	 */
	@Contained(values = { "folder", "default" }, message = "c_type must be folder or default", groups = {
			AddNode.class, AlterNode.class, AlterNodeType.class })
	private String c_type;

	/*
	 * Common Use Field
	 */
	/** 참조하고 있는 노드의 id */
	@Min(value = 1, groups = { AddNode.class, MoveNode.class })
	private int ref;

	/** copy 시 1의 값을 가짐. */
	@Range(min = 0, max = 1, groups = { MoveNode.class })
	private int copy;

	@Min(value = 0, groups = { MoveNode.class })
	private int multiCounter;

	private int status;
	/** ajax 처리 결과 메시지 */
	private String ajaxMessage;

	private String childcount;

	/** 검색시 Keyword */
	private String searchStr;

	private int idif;
	private int ldif;

	/** 노드가 차지하는 공간 (right - left + 1) */
	private int spaceOfTargetNode;

	/** 임의 노드의 자식 노드들의 id만을 저장하는 컬렉션 */
	private Collection<Integer> c_idsByChildNodeFromNodeById;

	private int fixCopyId;
	private int fixCopyPosition;

	/** 참조 노드의 right */
	private int rightPositionFromNodeByRef;

	private ComprehensiveTree nodeById;

	private int idifLeft;
	private int idifRight;

	private int id; // moveNode
	private final HashMap<String, String> attr;
	private volatile int hashCode;

	public JsTreeHibernateBaseDTO() {
		super();
		attr = new HashMap<String, String>();
	}

	public JsTreeHibernateBaseDTO(BigDecimal c_id, BigDecimal c_parentid, BigDecimal c_position, BigDecimal c_left,
			BigDecimal c_right, BigDecimal c_level, String c_title, String c_type, int ref, int copy, int multiCounter,
			int status, String ajaxMessage, String childcount, String searchStr, int idif, int ldif,
			int spaceOfTargetNode, Collection<Integer> c_idsByChildNodeFromNodeById, int fixCopyId,
			int fixCopyPosition, int rightPositionFromNodeByRef, ComprehensiveTree nodeById, int idifLeft,
			int idifRight, int id) {
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
		this.ajaxMessage = ajaxMessage;
		this.childcount = childcount;
		this.searchStr = searchStr;
		this.idif = idif;
		this.ldif = ldif;
		this.spaceOfTargetNode = spaceOfTargetNode;
		this.c_idsByChildNodeFromNodeById = c_idsByChildNodeFromNodeById;
		this.fixCopyId = fixCopyId;
		this.fixCopyPosition = fixCopyPosition;
		this.rightPositionFromNodeByRef = rightPositionFromNodeByRef;
		this.nodeById = nodeById;
		this.idifLeft = idifLeft;
		this.idifRight = idifRight;
		this.id = id;
		attr = new HashMap<String, String>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_id")
	public BigDecimal getC_id() {
		return c_id;
	}

	public void setC_id(BigDecimal c_id) {
		this.c_id = c_id;
	}

	@Column(name = "c_parentid")
	public BigDecimal getC_parentid() {
		return c_parentid;
	}

	public void setC_parentid(BigDecimal c_parentid) {
		this.c_parentid = c_parentid;
	}

	@Column(name = "c_position")
	public BigDecimal getC_position() {
		return c_position;
	}

	public void setC_position(BigDecimal c_position) {
		this.c_position = c_position;
	}

	@Column(name = "c_left")
	public BigDecimal getC_left() {
		return c_left;
	}

	public void setC_left(BigDecimal c_left) {
		this.c_left = c_left;
	}

	@Column(name = "c_right")
	public BigDecimal getC_right() {
		return c_right;
	}

	public void setC_right(BigDecimal c_right) {
		this.c_right = c_right;
	}

	@Column(name = "c_level")
	public BigDecimal getC_level() {
		return c_level;
	}

	public void setC_level(BigDecimal c_level) {
		this.c_level = c_level;
	}

	@Column(name = "c_title")
	public String getC_title() {
		return c_title;
	}

	public void setC_title(String c_title) {
		this.c_title = c_title;
	}

	@Column(name = "c_type")
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

	@Transient
	public String getAjaxMessage() {
		return ajaxMessage;
	}

	public void setAjaxMessage(String ajaxMessage) {
		this.ajaxMessage = ajaxMessage;
	}

	@Transient
	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	@Transient
	public int getIdif() {
		return idif;
	}

	public void setIdif(int idif) {
		this.idif = idif;
	}

	@Transient
	public int getLdif() {
		return ldif;
	}

	public void setLdif(int ldif) {
		this.ldif = ldif;
	}

	@Transient
	public int getSpaceOfTargetNode() {
		return spaceOfTargetNode;
	}

	public void setSpaceOfTargetNode(int spaceOfTargetNode) {
		this.spaceOfTargetNode = spaceOfTargetNode;
	}

	@Transient
	public Collection<Integer> getC_idsByChildNodeFromNodeById() {
		return c_idsByChildNodeFromNodeById;
	}

	public void setC_idsByChildNodeFromNodeById(Collection<Integer> c_idsByChildNodeFromNodeById) {
		this.c_idsByChildNodeFromNodeById = c_idsByChildNodeFromNodeById;
	}

	@Transient
	public int getFixCopyPosition() {
		return fixCopyPosition;
	}

	public void setFixCopyPosition(int fixCopyPosition) {
		this.fixCopyPosition = fixCopyPosition;
	}

	@Transient
	public int getRightPositionFromNodeByRef() {
		return rightPositionFromNodeByRef;
	}

	public void setRightPositionFromNodeByRef(int rightPositionFromNodeByRef) {
		this.rightPositionFromNodeByRef = rightPositionFromNodeByRef;
	}

	@Transient
	public ComprehensiveTree getNodeById() {
		return nodeById;
	}

	public void setNodeById(ComprehensiveTree nodeById) {
		this.nodeById = nodeById;
	}

	@Transient
	public int getIdifLeft() {
		return idifLeft;
	}

	public void setIdifLeft(int idifLeft) {
		this.idifLeft = idifLeft;
	}

	@Transient
	public int getIdifRight() {
		return idifRight;
	}

	public void setIdifRight(int idifRight) {
		this.idifRight = idifRight;
	}

	@Transient
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Transient
	public HashMap<String, String> getAttr() {
		attr.put("id", "node_" + c_id);
		attr.put("rel", c_type);
		return attr;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		JsTreeHibernateBaseDTO that = (JsTreeHibernateBaseDTO) o;

		if (c_id != that.c_id)
			return false;
		if (c_left != that.c_left)
			return false;
		if (c_level != that.c_level)
			return false;
		if (c_parentid != that.c_parentid)
			return false;
		if (c_position != that.c_position)
			return false;
		if (c_right != that.c_right)
			return false;
		if (copy != that.copy)
			return false;
		if (fixCopyId != that.fixCopyId)
			return false;
		if (fixCopyPosition != that.fixCopyPosition)
			return false;
		if (hashCode != that.hashCode)
			return false;
		if (id != that.id)
			return false;
		if (idif != that.idif)
			return false;
		if (idifLeft != that.idifLeft)
			return false;
		if (idifRight != that.idifRight)
			return false;
		if (ldif != that.ldif)
			return false;
		if (multiCounter != that.multiCounter)
			return false;
		if (ref != that.ref)
			return false;
		if (rightPositionFromNodeByRef != that.rightPositionFromNodeByRef)
			return false;
		if (spaceOfTargetNode != that.spaceOfTargetNode)
			return false;
		if (status != that.status)
			return false;
		if (!attr.equals(that.attr))
			return false;
		if (c_idsByChildNodeFromNodeById != null ? !c_idsByChildNodeFromNodeById
				.equals(that.c_idsByChildNodeFromNodeById) : that.c_idsByChildNodeFromNodeById != null)
			return false;
		if (c_title != null ? !c_title.equals(that.c_title) : that.c_title != null)
			return false;
		if (c_type != null ? !c_type.equals(that.c_type) : that.c_type != null)
			return false;
		if (childcount != null ? !childcount.equals(that.childcount) : that.childcount != null)
			return false;
		if (nodeById != null ? !nodeById.equals(that.nodeById) : that.nodeById != null)
			return false;
		if (searchStr != null ? !searchStr.equals(that.searchStr) : that.searchStr != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = hashCode;

		if (result == 0) {
			int primeNumber = 313;
			result = primeNumber * result + ref;
			result = primeNumber * result + copy;
			result = primeNumber * result + multiCounter;
			result = primeNumber * result + status;
			result = primeNumber * result + (c_title != null ? c_title.hashCode() : 0);
			result = primeNumber * result + (c_type != null ? c_type.hashCode() : 0);
			result = primeNumber * result + (childcount != null ? childcount.hashCode() : 0);
			result = primeNumber * result + (searchStr != null ? searchStr.hashCode() : 0);
			result = primeNumber * result + idif;
			result = primeNumber * result + ldif;
			result = primeNumber * result + spaceOfTargetNode;
			result = primeNumber * result
					+ (c_idsByChildNodeFromNodeById != null ? c_idsByChildNodeFromNodeById.hashCode() : 0);
			result = primeNumber * result + fixCopyId;
			result = primeNumber * result + fixCopyPosition;
			result = primeNumber * result + rightPositionFromNodeByRef;
			result = primeNumber * result + (nodeById != null ? nodeById.hashCode() : 0);
			result = primeNumber * result + idifLeft;
			result = primeNumber * result + idifRight;
			result = primeNumber * result + id;
			result = primeNumber * result + attr.hashCode();

			hashCode = result;
		}
		return result;
	}
}
