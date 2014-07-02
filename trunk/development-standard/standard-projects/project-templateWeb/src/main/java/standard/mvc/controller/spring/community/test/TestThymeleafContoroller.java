package standard.mvc.controller.spring.community.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestThymeleafContoroller {
	
	@RequestMapping(value = "thymeleaf/test")
	public String thymeleafTest(ModelMap map){
		return "/jsp/commitor";
	}
	
	@RequestMapping(value = "thymeleaf/sample1")
	public String thymeleafSample(ModelMap map){
		map.addAttribute("currentUser", new SampleObj("NAVER", "naver.com"));
		map.addAttribute("imgsrc","img.naver.net/static/www/u/2013/0731/nmms_224940510.gif");
		return "/thymeleaf/sample1";
	}
	
	@RequestMapping(value = "thymeleaf/sample2")
	public String thymeleafSample2(ModelMap map){
		map.addAttribute("styleList", this.getStyleList());
		map.addAttribute("countryList", this.getCountryList());
		map.addAttribute("search", new Search());
		return "sample2";
	}
	
	
	@RequestMapping(value = "thymeleaf/searchSample")
	public String thymeleafSample3(@ModelAttribute("search") Search search, ModelMap map){
		map.addAttribute("styleList", this.getStyleList());
		map.addAttribute("countryList", this.getCountryList());
		map.addAttribute("search", search);
		map.addAttribute("results", this.getResults());
		return "sample2";
	}
	
	private List<String> getStyleList()
	{
		return Arrays.asList("Rock", "Pop", "Metal", "House", "RnB", "Dance", "Country", "Techno", "Classical");
	}
	
	private List<String> getCountryList()
	{
		return Arrays.asList("Korea", "United States", "United Kingdom", "China", "Japan", "France", "Spain", "Germany", "Canada", "Australia");
	}
	private List<Artist> getResults()
	{
		List<Artist> results = new ArrayList<Artist>();

		results.add(new Artist(
				"Mariah",
				"Carrey",
				Arrays.asList("Mariah Carey", "Emotions", "Music Box", "Merry Christmas", "DayDream", "ButterFly"),
				"Mariah Carey (born March 27, 1970) is an American singer, songwriter, record producer, and actress. She made her recording debut in 1990 under the guidance of Columbia Records executive Tommy Mottola, and released her self-titled debut studio album, Mariah Carey.",
				true));

		results.add(new Artist(
				"Elvis",
				"Presley",
				Arrays.asList("Elvis Presley", "Elvis", "Loving You", "Elvis' Christmas Album", "Elvis Is Back!", "G.I. Blues"),
				"Elvis Aaron Presleya (January 8, 1935 – August 16, 1977) was one of the most popular American singers of the 20th century. A cultural icon, he is widely known by the single name Elvis. He is often referred to as the 'King of Rock and Roll' or simply 'the King'.",
				false));

		results.add(new Artist(
				"John",
				"Lennon",
				Arrays.asList("John Lennon", "Imagine", "Some Time in New York City", "Mind Games", "Walls and Bridges", "Rock 'n' Roll"),
				"John Winston Lennon (9 October 1940 – 8 December 1980) was an English musician and singer-songwriter who rose to worldwide fame as one of the founding members of The Beatles, one of the most commercially successful and critically acclaimed acts in the history of popular music. Along with fellow Beatle Paul McCartney, he formed one of the most successful songwriting partnerships of the 20th century.",
				false));
		return results;
	}
}

class SampleObj {

	private String firstName;

	private String lastName;

	public SampleObj(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

/* 샘플코드에서 필요한 클래스들 최초출처 : https://github.com/doanduyhai/ThymeLeafDemo*/
class Search
{
	private String name;

	private String style;

	private String title;

	private String country;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getStyle()
	{
		return style;
	}

	public void setStyle(String style)
	{
		this.style = style;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

}

class Artist
{

	private String firstname;

	private String lastname;

	private List<String> discography = new ArrayList<String>();

	private String bio;

	private boolean alive;

	public Artist(String firstname, String lastname, List<String> discography, String bio, boolean alive) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.discography = discography;
		this.bio = bio;
		this.alive = alive;
	}

	public String getName()
	{
		return this.firstname + ' ' + this.lastname;
	}

	public List<String> getDiscography()
	{
		return discography;
	}

	public String getBio()
	{
		return bio;
	}

	public boolean isAlive()
	{
		return alive;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

}
