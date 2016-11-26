package egovframework.com.ext.jstree.springiBatis.dwr;

import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.servlet.DwrServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
/**
 * Created by wangmm on 2016/4/21.
 */
public class DwrScriptSessionManagerUtil extends DwrServlet {
    private static final long serialVersionUID = -7504612622407420071L;

    public void init()throws ServletException {

        Container container = ServerContextFactory.get().getContainer();
        ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
        ScriptSessionListener listener = new ScriptSessionListener() {
            public void sessionCreated(ScriptSessionEvent ev) {
                HttpSession session = WebContextFactory.get().getSession();
                System.out.println(session.getId());
                ev.getSession().setAttribute("userId", session.getId());
            }
            public void sessionDestroyed(ScriptSessionEvent ev) {
                System.out.println("a ScriptSession is distroyed");
            }
        };
        manager.addScriptSessionListener(listener);
    }
}
