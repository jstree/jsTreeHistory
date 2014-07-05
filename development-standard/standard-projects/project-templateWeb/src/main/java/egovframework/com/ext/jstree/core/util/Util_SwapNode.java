package egovframework.com.ext.jstree.core.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import egovframework.com.ext.jstree.core.vo.P_ComprehensiveTree;
import egovframework.com.ext.jstree.core.vo.T_ComprehensiveTree;

public class Util_SwapNode {

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
