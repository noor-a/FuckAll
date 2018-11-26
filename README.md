Plants vs Zombie Puzzle Simulation Authors: 
Alexander Johns,Pragya Singh,Noor Ncho,Johan Westeinde

This is out milestone 2 code for Plants vs Zombie Puzzle Simulation. In this phase there is an added GUI, which allows the user to have a more interactive and personal feel with the game. The UML and sequence diagrams have been modified from iteration one in order to add in the interaction between the controller view and model. 

                                          The Design
The design pattern that was used to implement this GUI is MCV. The controller updates the GUI based, on player input while updating and keeping track of health of the flower, the balance of the player’s sun points and the attack and health of the zombies. 
The GUI is composed of a grid layout that has buttons that are landmarks that represent possible locations a player may want to plant a peashooter or a sunflower but not both. After clicking on the grid another window will pop up allowing the player to choose what they would like to plant, confirming that they are able to purchase this item with their current balance while outputting a message if they are able to based on their balance, so that the player knows why they are able to or not able to purchase a plant of their choosing. 
The reason our GUI is composed of two classes is to ensure that there is high cohesion, and low coupling. Each class is encourage of one frame and not both as they both have different functions. The main frame purpose is to pick where to put the plants and show the user where they have placed the plants. While the choice frame purpose function is to pick which plant the player would like to plant. The controller allows the view(GUI) to work independently of the model ( all the plant, zombie classes) as they are not aware of each other but the controller is as it passes information in between the view and the model.

The info Panel follows the event model the reason for this is that this is the panel that holds the update amount of coins, and the real time actions that have occurred on the bored either while the playing is planting their different assortment of plants or if it's that the zombies have attacked at a particular location or a huge wave of Zombies have approached. Due to this constant update and invocation of the panel we felt that using Event model driven pattern was a good idea so that it could be called a number of times and therefore creating pending operations that would be done in the sequence of call.

                                              Roles
Milestone 1:
UML Diagram- Pragya and Johan
Sequence Diagram- Noor and Alexander
All Plant related classes- Pragya and Noor
Any Zombie and game board related classes- Alexander and Johan
Refactoring and Java Docs: Everyone

Milestone 2:
View Classes( ButtonLayout, MainFrame)- Pragya Singh and Alexander
Controller- Noor(created functionalities), Pragya(initial very basic code), Johan(functionalities), Alexander(created a large sum of functionalities) 
UML Diagrams(class)-Pragya
UML Diagrams(Sequence)-Noor
Testing-Johan
Read Me-Pragya 
                                                  Change log 
	New: 
	Visual Improvement
          There will now be an interactive visual view of the bored. Where by users are able to put their desired piece on the board (sunflower plant/pea plants) and view the health of these pieces as the game progresses. They will also be able to find out when the waves of zombies will appear due to a simple message that will indicate the zombies attacking. 
	  
Fixed: When a number is greater than 4 the game no longer crashes, as the model does now account for it, it account for the game to be able to handle peashooters/sunflower plants/zombies at any of the given spots on the grid.

Changed: The main class is now a different class as this class is now in charge of initializing the view, model and controller class as they all need to be initialized in order for the game to start properly. The main class is in the class application. 
	The "MainFrame" is now a new added class that is used for the GUI. It holds all the buttons that are used to create the illusion of a grid and even the infoPanel, which is a panel that consists of all the information that may be pertinent to the user such as how much a sunflower/peashooter costs, to the location and the kind of damage the zombies have done.  This class also holds a start button that initiates the start of this level( only needs one for this milestone), and another that indicates that the user is ready for their next turn. 
	The Info Panel is not only in charge of creating information for the bored in the text field so that the players are able to see what has happened during and since their last turn.
	The Controller: Is in charge of the interaction between the model and the view. It takes the input which is based on the user which is based on where the peashooter or plant is located and then the controller then allows the zombies to have a turn which can be seen by the user in the infopanel on the main frame which is also known as the board in this case. While this happens almost simultaneously the controller sends all this information that is on the board the user can see to the board that has been implemented to the model. This is because the model is really where all the data is stored and or compared to in order for the controller to know of the different states/ conditions that the game might be in. The controller based on these states can also in out game send out information dialogue regarding the happenings at a certain button, when a sun plant or peashooter is placed.
	The Turn class no longer exists as it's functionalities can not be replicated by the GUI functionalities. 
	
Known Issues: 
GUI: The GUI  visually has to have more aligned labels
It also needs to be able to have icons that can be seen on non mac computers pc wise, as the directory implementation that is used to import the jpeg do not work appropriately for that. 
Road Map:
	Next Deliverable: To create and implement the game so that the player is able to choose from a variety of different plants and types of zombies, while adding in a redo button, that can be used as many times as possible.
	
Performance: In the future iteration we would like to make sure that mac users to can also see the icons that are used to represent the zombies, plants and peashooters.

User-Interface(GUI)-In the future iterations we will be looking at aligning and making the GUI  look a lot more in sync and therefore appealing to the user.
