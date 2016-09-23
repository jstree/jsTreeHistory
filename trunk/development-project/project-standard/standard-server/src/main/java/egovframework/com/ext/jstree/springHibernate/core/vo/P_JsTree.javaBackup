package egovframework.com.ext.jstree.springHibernate.core.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import egovframework.com.ext.jstree.strutsiBatis.core.vo.T_ComprehensiveTree;

@Entity
@Table(name = "T_COMPREHENSIVETREE", schema = "STANDARD_DB")
@org.hibernate.annotations.Entity(
        selectBeforeUpdate = true,
        dynamicUpdate = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class P_JsTree extends T_JsTree  implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -6859122566734590165L;

    public P_JsTree()
    {
        attr = new HashMap<String, String>();
    }
    
    
    
    public P_JsTree(BigDecimal c_id, BigDecimal c_parentid, BigDecimal c_position, BigDecimal c_left,
            BigDecimal c_right, BigDecimal c_level, String c_title, String c_type, int ref,
            int copy, int multiCounter, int status, String childcount,
            int fixCopyId)
    {
        super(c_id, c_parentid, c_position, c_left, c_right, c_level, c_title, c_type,
                ref, copy, multiCounter, status, childcount, fixCopyId);
        attr = new HashMap<String, String>();
    }



    /*
     * DTO - Parameter
     */
    private String searchStr;
    
    private int idif;
    
    private int ldif;
    
    private int spaceOfTargetNode;
    
    private Collection<Integer> c_idsByChildNodeFromNodeById;
    
    private int fixCopyPosition;
    
    private int rightPositionFromNodeByRef;
    
    private T_ComprehensiveTree nodeById;
    
    private int idifLeft;
    
    private int idifRight;
    
    private Boolean copyBooleanValue;
    
    @Transient
    public String getSearchStr()
    {
        return searchStr;
    }
    
    public void setSearchStr(String searchStr)
    {
        this.searchStr = searchStr;
    }
    
    @Transient
    public int getIdif()
    {
        return idif;
    }
    
    public void setIdif(int idif)
    {
        this.idif = idif;
    }
    
    @Transient
    public int getLdif()
    {
        return ldif;
    }
    
    public void setLdif(int ldif)
    {
        this.ldif = ldif;
    }
    
    @Transient
    public int getSpaceOfTargetNode()
    {
        return spaceOfTargetNode;
    }
    
    public void setSpaceOfTargetNode(int spaceOfTargetNode)
    {
        this.spaceOfTargetNode = spaceOfTargetNode;
    }
    
    @Transient
    public Collection<Integer> getC_idsByChildNodeFromNodeById()
    {
        return c_idsByChildNodeFromNodeById;
    }
    
    public void setC_idsByChildNodeFromNodeById(
            Collection<Integer> c_idsByChildNodeFromNodeById)
    {
        this.c_idsByChildNodeFromNodeById = c_idsByChildNodeFromNodeById;
    }
    
    @Transient
    public int getFixCopyPosition()
    {
        return fixCopyPosition;
    }
    
    public void setFixCopyPosition(int fixCopyPosition)
    {
        this.fixCopyPosition = fixCopyPosition;
    }
    
    @Transient
    public int getRightPositionFromNodeByRef()
    {
        return rightPositionFromNodeByRef;
    }
    
    public void setRightPositionFromNodeByRef(int rightPositionFromNodeByRef)
    {
        this.rightPositionFromNodeByRef = rightPositionFromNodeByRef;
    }
    
    @Transient
    public T_ComprehensiveTree getNodeById()
    {
        return nodeById;
    }
    
    public void setNodeById(T_ComprehensiveTree nodeById)
    {
        this.nodeById = nodeById;
    }
    
    @Transient
    public int getIdifLeft()
    {
        return idifLeft;
    }
    
    public void setIdifLeft(int idifLeft)
    {
        this.idifLeft = idifLeft;
    }
    
    @Transient
    public int getIdifRight()
    {
        return idifRight;
    }
    
    public void setIdifRight(int idifRight)
    {
        this.idifRight = idifRight;
    }
    
    @Transient
    public Boolean getCopyBooleanValue()
    {
        copyBooleanValue = false;
        if (this.getCopy() == 0)
        {
            copyBooleanValue = false;
        }
        else
        {
            copyBooleanValue = true;
        }
        return copyBooleanValue;
    }
    
    public void setCopyBooleanValue(Boolean copyBooleanValue)
    {
        this.copyBooleanValue = copyBooleanValue;
    }
    
    @Transient
    public String getState()
    {
        String returnCode = new String();
        
        if (getChildcount() == null || getChildcount().equals(" "))
        {
            returnCode = "update status";
        }
        else if (getChildcount().equals("InChild"))
        {
            returnCode = "closed";
        }
        else
        {
            returnCode = "leafNode";
        }
        return returnCode;
    }
    
    /*
     * VO - Database set support
     */
    
    private int id; // moveNode
    
    private final HashMap<String, String> attr;
    
    @Transient
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    @Transient
    public HashMap<String, String> getAttr()
    {
        attr.put("id", "node_" + super.getC_id());
        attr.put("rel", super.getC_type());
        return attr;
    }
}
