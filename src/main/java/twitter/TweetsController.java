package twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@Controller
@RequestMapping("/tweets")
public class TweetsController {
	
	 private Twitter twitter;

	    private ConnectionRepository connectionRepository;

	    @Inject
	    public TweetsController(Twitter twitter, ConnectionRepository connectionRepository) {
	        this.twitter = twitter;
	        this.connectionRepository = connectionRepository;
	    }

	   
	    @RequestMapping(method=RequestMethod.GET)
	    public String getTweetResult(Model model) {
	    	
	        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
	            return "redirect:/connect/twitter";
	        }

	        model.addAttribute(twitter.userOperations().getUserProfile());
	        System.out.println("Before search results");
	        SearchResults tweetresult = twitter.searchOperations().search("#spring", 10,10, 0);
	        System.out.println("Before model add attr");
	        List<Tweet> tweets = tweetresult.getTweets();
	        model.addAttribute("tweets", tweets);
	        System.out.println("After model add attribute part");
	        return "tweets";
	    }

}
