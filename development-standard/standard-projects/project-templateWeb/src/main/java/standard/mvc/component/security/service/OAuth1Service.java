package standard.mvc.component.security.service;



import java.util.List;

public interface OAuth1Service {
	List<String> getLastTenPicasaPictureURLs();
	String getTwiterRestTemplate();
}
