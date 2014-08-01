package egovframework.com.ext.jstree.strutsiBatis.service;

import egovframework.com.ext.jstree.strutsiBatis.dto.P_ComprehensiveTree;
import egovframework.com.ext.jstree.strutsiBatis.vo.T_ComprehensiveTree;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * bean을 복사하는 class
 * 
 * */
public class Util_SwapNode {
	
	/**
	 * bean을 복사하는 메소드
	 * 
	 * @param T_ComprehensiveTree(originNode)
	 * @return P_ComprehensiveTree(destNode)
	 * 
	 * */
	public static P_ComprehensiveTree swapTtoP(T_ComprehensiveTree originNode) {

		P_ComprehensiveTree destNode = new P_ComprehensiveTree();

		try {
			BeanUtils.copyProperties(destNode, originNode);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return destNode;
	}
	
	/**
	 * bean을 복사하는 메소드
	 * 
	 * @param P_ComprehensiveTree(originNode)
	 * @return T_ComprehensiveTree(destNode)
	 * 
	 * */
	public static T_ComprehensiveTree swapPtoT(P_ComprehensiveTree originNode) {

		T_ComprehensiveTree destNode = new T_ComprehensiveTree();

		try {
			BeanUtils.copyProperties(destNode, originNode);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return destNode;
	}
	
	/**
	 * bean을 복사하는 메소드
	 * 
	 * @param T_ComprehensiveTree(originNode)
	 * @return T_ComprehensiveTree(destNode)
	 * 
	 * */
	public static T_ComprehensiveTree copyTtoT(T_ComprehensiveTree originNode,
			T_ComprehensiveTree destNode) {

		try {
			BeanUtils.copyProperties(destNode, originNode);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return destNode;
	}

}
