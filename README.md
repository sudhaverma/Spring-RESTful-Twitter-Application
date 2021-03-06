
#Description
This is a RESTful web application which allows a third party application to access a given user's resources on Twitter (i.e, accessing friends list, searching for a particular tweet on the timeline and reading top 20 recent tweets from user's timeline).
This uses Spring and the REST components to do the above.

#What you need to do before using this application

You need to do the following before starting with the application: 

* Get [JDK version 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* Get [Apache Maven version 3 and above](http://maven.apache.org/download.cgi)
* Obtain application key and application secret by [registering an application with Twitter](https://apps.twitter.com)
* Build the project with Maven. If you're not familiar with Maven, refer [here] (https://spring.io/guides/gs/maven/)

#Enable Twitter
* Before accessing twitter data, you need to configure `appId` and `appSecret` fields in `application.properties` file of the project. `appId` and `appSecret` correspond to consumer key and consumer secret key that you get after registering the application with Twitter.
Path for the same is:
`src/main/resources/application.properties`

#Creating connection with Twitter

* Whenever the request comes from the end user with `http://locahost:8080`, the first page displayed will show that there is not a connection with Twitter application yet and the user will be asked to connect first.
Here's the view which is shown when no connection exists.

![Connect to Twitter](https://www.dropbox.com/s/mzqd0d3jkp8kx8u/connect_twitter_jpeg.jpg?dl=0)

* Once the user clicks on the submit button of the above page, a POST request will be generated and the user will pass through OAuth flow and below is the view when the user is connected with Twitter. Everything is taken care by the ConnectController of the Twitter API.

src/main/resources/templates/connect/twitterConnected.html

#Fetching basic twitter features

* Once connection is established, end user will have various options of viewing his/her friend list, searching for a particular tweet on public timeline and reading of 20 recent tweets from the timeline.
* There are three different types of controller created in this applicaiton to handle three different requests from the user. 
* `FriendsController` is responsible for directing the user to a page where he can see his complete friend's list, `TweetsController` is responsible for directing the user to a a page where he can see the tweets with the given search criteria.
`TimelineController` is responsible for displaying of the recent 20 tweets from the user's timeline.


#Running the application
* Application.java class present in the project is the main class which makes the entire application to execute.
