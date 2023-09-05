1. About/Overview. Give a general overview of the problem and how your program solves the problem.

The soccer team project is designed to create a soccer team as required, following certain rules given, by keeping track of the players, teams, starting lineup and results. It provides functionality to add new players, delete players, create teams, create starting lineup, and record the results of the matches. This program allows for easy management and analysis of the team's performance.

2. List of features. List all features that are present in your program.

Features are:
Add new players to the team
Add new teams to the league
Add new matches of starting lineup to be played
Record the results of matches
View team, starting lineup and player statistics

3. How To Run. Instructions to run the program should include the following:
How to run the jar file
What arguments are needed (if any) to run the jar file, what do they mean

Follow these steps to run the program:
1) Download the SoccerTeam.jar file.
2) Open the command prompt or terminal window.
3) Navigate to the directory where the SoccerTeam.jar file is located.
4) Run the command "java -jar SoccerTeam.jar".


4. How to Use the Program. Instructions on how to use functionality in your program. if interactive, how to interact with your program? Pay particular attention to the parts that are not part of the example runs that you provided.

Open the jar file, and once the program is running, the user will be prompted to enter the basic information of the input. The input includes:
First Name, Last Name, Date of Birth, Position, Skill Level.

If any of the above input information is not entered according to the requirements, then related error messages will be prompted.

Then the program will read the input and display a menu with the available options:
Add a player
Create a team
Create the starting lineup
Exit the program

Click the available button to reach the performance the user chooses, the console will display related information.

5. Design/Model Changes. It is important to document what changes that you have made from earlier designs. Why were those changes required? You can write these changes in terms of version if you wish.

When I was testing the GUI performance, I found out a problem that as long as I added seven or more players, the program would be able to create a starting lineup successfully, even the number of each of the four positions did not meet the requirements to build one. For example, I added 2 goalkeepers, 3 defenders, 3 midfielders, the starting lineup was created without any forward, which is not correct. So I checked the original method to create the starting lineup, finding that the requirement was just set to get a total number of players of seven or more, without restrcting each position's player number. And I made modifications to that method, then the functionality has been implemented better.

6. Assumptions. List what assumptions you made during program development and implementation. Be sure that these do not conflict with the requirements of the project.

The assumptions I made was that the program assumes that the user has basic knowledge of soccer, at least can understand the rules and regulations as listed in the program of the soccer team. It also assumes that the user has access to the internet in order to look up information about teams and players.

7. Limitations. Limitations of your program if any. This should include any requirements that were not implemented or were not working correctly (including something that might work some of the time).

For basic operations, the program does not provide the option to delete a player or change a player in the team when using the window to make options. It simply goes with adding players, creating team and creating starting lineup, then exiting the program. Also, the program does not include any advance statistical analysis or predictive modeling. It does not have any integration with external data sources. All of these functionalities can be implemented further in the future.

8. Citations. Be sure to include any citations that are required for your project. Citations should include references (paper, website, etc.) for any site that you used to research a solution. Proper APA format should be used. For websites this includes the name of the website, title of the article, the url, and the date of retrieval. If you have nothing to cite, you should indicate this.

I did not use any citations, so there's nothing to cite here.

