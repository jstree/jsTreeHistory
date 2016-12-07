package egovframework.com.ext.jstree.springHibernate.core.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import egovframework.com.ext.jstree.springHibernate.core.vo.JsTreeHibernateBaseDTO;

@Repository
public class JsTreeHibernateDaoImpl extends JsTreeHibernateDaoSupport<JsTreeHibernateBaseDTO, Long> implements JsTreeHibernateDao{
	
    @Resource(name = "sessionFactory")
    public void init(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
    @Override
    protected Class<JsTreeHibernateBaseDTO> getEntityClass() {
        return JsTreeHibernateBaseDTO.class;
    }
    
    @Override
    public DetachedCriteria createDetachedCriteria() {
        DetachedCriteria detachedCriteria = super.createDetachedCriteria();
        return detachedCriteria;
    }

	@Override
	public <T extends JsTreeHibernateBaseDTO> List<T> getChildNode(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> List<T> searchNodeByString(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> List<String> searchNodeByPosition(List<T> searchNodeByPositions) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> T getNode(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> T getNodeByRef(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> int getChildCountByParentId(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> void cutMyself(T p_OnlyCutMyselfFromJstree) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> void stretchPositionForMyselfFromJstree(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> void stretchLeftRightForMyselfFromJstree(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> int pasteMyselfFromJstree(T p_OnlyPasteMyselfFromJstree) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> List<T> getChildNodeByLeftRight(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> void fixCopy(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> void fixCopyIF(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> void enterMyselfFromJstree(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> int addMyselfFromJstree(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> int alterNode(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> int removeNode(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> int alterNodeType(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> void enterMyselfFixPosition(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> void enterMyselfFixLeftRight(T T_JsTree) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> int getCountOfDescendantNodes(T T_JsTree) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T extends JsTreeHibernateBaseDTO> List<T> getDescendantNodesPaginated(T T_JsTree) {
		// TODO Auto-generated method stub
		return null;
	}
}
