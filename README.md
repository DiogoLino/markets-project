# Tasks

1. Update the project to pass the selected market object from the MarketListFragment to the MarketDetailScreen (Compose).
2. Implement the MVVM (Model-View-ViewModel) architecture in the MarketDetailScreen.
3. Populate the following fields in the MarketDetailScreen from the selected market object using the Text component:
      Epic
      Current Price
      Current Change
      Current Change Percentage
4. Use proper state composables to display the MarketDetailScreen effectively.
5. Ensure that any business logic in the ViewModel is covered by unit tests.
6. After completing the first task, what would you choose to do next? In this task we would like to see which would be your next priority and why.

1 -My first priority was to update the project structure for to use MVVM , adding any packages that might be use across the project (core). 
2 -My second priority was to create a compose navigator from 1 screen to another , i decided to use a new adaptive navigation lib from google IO , that allow for 
adapt to screen sizes and configurations changes (screen rotation adaptive).

AdaptiveNavigationPanel ref :(https://developer.android.com/develop/ui/compose/layouts/adaptive/list-detail?_gl=1*1asqmki*_up*MQ..*_ga*ODczNzczNDEyLjE3Mjk2ODExODE.*_ga_6HH9YJMN9M*MTcyOTY4MTE4MC4xLjAuMTcyOTY4MTE4MC4wLjAuMjA0OTUyOTI4Ng..)

3 - Prepare the Project for scalability adding a domain layer and introducing Dependency Injection to the project. 
We are using a local json to load the data, But we can easily add another datasource (network api call) to get data) 

4 - Creating the Screens and displaying the data, with the view model UI states

7. If you had more time what would you improve?
I think for a small project like this, the refactor in terms of scalability that i have introduced is what i would have done.
There was a mix between xml/fragments and compose , i had prefer to use KISS, and keep it simple by refactoring the code to use full compose , with State flows .


8. What would you do differently if you were to start from scratch?
Feature Modules for scalability 