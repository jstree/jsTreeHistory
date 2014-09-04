package egovframework.com.ext.jstree.springiBatis.core.vo;

import java.util.Collection;
import java.util.HashMap;

/**
 * Modification Information
 * 
 * @author ?
 * @since 2014. 7. 31.
 * @version 1.0
 * @see <pre>
 * 	Class Name 	: ComprehensiveTree.java
 * 	Description : jstree에서 사용되는 VO 
 * 	Infomation	: jstree에서 사용되는 VO
 *  
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014. 7. 31.      ?         최초 생성
 * 	2014. 9.  4. JeonKyunghun   주석 추가
 *  Copyright (C) 2014 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
public class ComprehensiveTree {

	private int c_id;			// Node 의 고유 ID
	private int c_parentid;		// Node 의 부모 ID
	private int c_position;		// Parent 밑으로 몇번째 위치인지를 나타냄
	private int c_left;  		// Node 의 Left 위치
	private int c_right; 		// Node 의 Right 위치
	private int c_level; 		// Node 의 Depth

	private int ref;
	private int copy;
	private int multiCounter;

	private int status;
	
	private String c_title;		// Node 의 Title
	private String c_type;		// Node 의 Type ( Drive, Folder, File )
	private String childcount;
	private String searchStr;	// 검색시 Keyword
	
	private int idif;
	private int ldif;
	private int spaceOfTargetNode;
	Collection<Integer> c_idsByChildNodeFromNodeById;

	private int fixCopyId;
	private int fixCopyPosition;

	private int rightPositionFromNodeByRef;
	private ComprehensiveTree nodeById;

	private int idifLeft;
	private int idifRight;
	private Boolean copyBooleanValue;
	
	private int id; // moveNode
	private final HashMap<String, String> attr;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ComprehensiveTree() {
		attr = new HashMap<String, String>();
	}
	
	public void setCopyBooleanValue(Boolean copyBooleanValue) {
		this.copyBooleanValue = copyBooleanValue;
	}

	public Boolean getCopyBooleanValue() {
		copyBooleanValue = false;
		if (this.getCopy() == 0) {
			copyBooleanValue = false;
		} else {
			copyBooleanValue = true;
		}
		return copyBooleanValue;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getCopy() {
		return copy;
	}

	public void setCopy(int copy) {
		this.copy = copy;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getC_parentid() {
		return c_parentid;
	}

	public void setC_parentid(int c_parentid) {
		this.c_parentid = c_parentid;
	}

	public int getC_position() {
		return c_position;
	}

	public void setC_position(int c_position) {
		this.c_position = c_position;
	}

	public int getC_left() {
		return c_left;
	}

	public void setC_left(int c_left) {
		this.c_left = c_left;
	}

	public int getC_right() {
		return c_right;
	}

	public void setC_right(int c_right) {
		this.c_right = c_right;
	}

	public int getC_level() {
		return c_level;
	}

	public void setC_level(int c_level) {
		this.c_level = c_level;
	}

	public String getC_title() {
		return c_title;
	}

	public void setC_title(String c_title) {
		this.c_title = c_title;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

	public int getMultiCounter() {
		return multiCounter;
	}

	public void setMultiCounter(int multiCounter) {
		this.multiCounter = multiCounter;
	}

	public int getSpaceOfTargetNode() {
		return spaceOfTargetNode;
	}

	public void setSpaceOfTargetNode(int spaceOfTargetNode) {
		this.spaceOfTargetNode = spaceOfTargetNode;
	}

	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	public String getChildcount() {
		return childcount;
	}

	public void setChildcount(String childcount) {
		this.childcount = childcount;
	}

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdif() {
		return idif;
	}

	public void setIdif(int idif) {
		this.idif = idif;
	}

	public int getLdif() {
		return ldif;
	}

	public void setLdif(int ldif) {
		this.ldif = ldif;
	}

	public Collection<Integer> getC_idsByChildNodeFromNodeById() {
		return c_idsByChildNodeFromNodeById;
	}

	public void setC_idsByChildNodeFromNodeById(
			Collection<Integer> c_idsByChildNodeFromNodeById) {
		this.c_idsByChildNodeFromNodeById = c_idsByChildNodeFromNodeById;
	}

	public int getFixCopyId() {
		return fixCopyId;
	}

	public void setFixCopyId(int fixCopyId) {
		this.fixCopyId = fixCopyId;
	}

	public int getFixCopyPosition() {
		return fixCopyPosition;
	}

	public void setFixCopyPosition(int fixCopyPosition) {
		this.fixCopyPosition = fixCopyPosition;
	}

	public int getRightPositionFromNodeByRef() {
		return rightPositionFromNodeByRef;
	}

	public void setRightPositionFromNodeByRef(int rightPositionFromNodeByRef) {
		this.rightPositionFromNodeByRef = rightPositionFromNodeByRef;
	}

	public ComprehensiveTree getNodeById() {
		return nodeById;
	}

	public void setNodeById(ComprehensiveTree nodeById) {
		this.nodeById = nodeById;
	}

	public int getIdifLeft() {
		return idifLeft;
	}

	public void setIdifLeft(int idifLeft) {
		this.idifLeft = idifLeft;
	}

	public int getIdifRight() {
		return idifRight;
	}

	public void setIdifRight(int idifRight) {
		this.idifRight = idifRight;
	}
	
	public String getData() {
		return c_title;
	}

	public HashMap<String, String> getAttr() {
		attr.put("id", "node_" + c_id);
		attr.put("rel", c_type);
		return attr;
	}
}