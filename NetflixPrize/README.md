# NetflixPrize - Predict user ratings

This project, coded in Java, is based on the Netflix Prize competition for an algorithm to predict users' movie ratings. Data used for this project was taken from the MoviesLens recommendation small dataset (100,000 movie ratings from 1,000 different users). The goal was to use information from the dataset to create a method of predicting users' ratings of a movie based on their other movie ratings.

Functions:\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Parse information from the movielens file, sort into ArrayLists\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Categorise important user information as classes: Movie, Genre, Rating, Tag, User\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Use binary search to find/match movie and user data\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Calculate a user's predicted movie rating by weighing the user's ratings average and previous movie and genre ratings\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Use ratings predictions to recommend an unwatched movie to a selected user\
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Access online IMDB page to display poster of recommended movie in pop-up window

Test Results

![5testresults](https://github.com/hwang635/HS/blob/master/NetflixPrize/NetflixPrize%20Results.PNG)

Pop-up Display\
![pop-up](https://github.com/hwang635/HS/blob/master/NetflixPrize/NetflixPrizePopup.PNG)
![movie display](https://github.com/hwang635/HS/blob/master/NetflixPrize/NetflixPrizeDisplay.PNG)
