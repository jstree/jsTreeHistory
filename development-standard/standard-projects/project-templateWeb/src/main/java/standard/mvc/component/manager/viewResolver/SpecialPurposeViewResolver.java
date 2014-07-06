package standard.mvc.component.manager.viewResolver;


import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;

import standard.mvc.manager.viewResolver.specialPurposeView.CloseDialogView;
import standard.mvc.manager.viewResolver.specialPurposeView.CsvView;
import standard.mvc.manager.viewResolver.specialPurposeView.ExitView;
import standard.mvc.manager.viewResolver.specialPurposeView.FileDownloadView;
import standard.mvc.manager.viewResolver.specialPurposeView.ImageView;
import standard.mvc.manager.viewResolver.specialPurposeView.JSONView;
import standard.mvc.manager.viewResolver.specialPurposeView.MessageShowView;
import standard.mvc.manager.viewResolver.specialPurposeView.NullView;
import standard.mvc.manager.viewResolver.specialPurposeView.UploadMaxErrorView;

public class SpecialPurposeViewResolver extends AbstractCachingViewResolver implements Ordered {
    private int order;
    
    @Override
    protected View loadView(String viewName, Locale locale) throws Exception {
        
        if (":json".equals(viewName)) {
            JSONView view = new JSONView();
            view.setApplicationContext(getApplicationContext());
            return view;
        } else if (":message".equals(viewName)) {
            MessageShowView view = new MessageShowView();
            view.setApplicationContext(getApplicationContext());
            return view;
        } else if (":csv".equals(viewName)) {
            CsvView view = new CsvView();
            view.setApplicationContext(getApplicationContext());
            return view;
        } else if (":exit".equals(viewName)) {
            ExitView view = new ExitView();
            view.setApplicationContext(getApplicationContext());
            return view;
        } else if (":closeDialog".equals(viewName)) {
        	CloseDialogView view = new CloseDialogView();
        	view.setApplicationContext(getApplicationContext());
	        return view;
        } else if (":download".equals(viewName)) {
            FileDownloadView view = new FileDownloadView();
            view.setApplicationContext(getApplicationContext());
            return view;
        } else if (":image".equals(viewName)) {
            ImageView view = new ImageView();
            view.setApplicationContext(getApplicationContext());
            return view;
        } else if (":uploadMaxError".equals(viewName)) {
            UploadMaxErrorView view = new UploadMaxErrorView();
            view.setApplicationContext(getApplicationContext());
            return view;
        } else if (":null".equals(viewName)) {
            NullView view = new NullView();
            view.setApplicationContext(getApplicationContext());
            return view;
        }
        return null;
    }
    
    @Override
    public int getOrder() {
        return this.order;
    }
    
    public void setOrder(int order) {
        this.order = order;
    }
    
}