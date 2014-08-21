package standard.mvc.component.dwr.sample.service;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

@RemoteProxy
public class AjaxService {
    
    @RemoteMethod
    public String[] getOptions() {
        
        return new String[] { "1", "2", "3" };
    }
}