package egovframework.com.ext.jstree.springiBatis.core.vo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ComprehensiveTreeTest {

    @Test
    public void equalsHashCodeTest() throws Exception {
        ComprehensiveTree ct1 = new ComprehensiveTree();
        ComprehensiveTree ct2 = new ComprehensiveTree();

        assertThat(ct1.equals(ct2), is(Boolean.TRUE));
        assertThat(ct1.hashCode(), is(ct2.hashCode()));
        assertThat(ct1.equals(ct2), is(ct1.hashCode() == ct2.hashCode()));

        ct1.setC_id(1);
        assertThat(ct1.equals(ct2), is(Boolean.FALSE));
    }
}