# StephenMooreFinalProject
CPSC 233 Final Project

Inventory Management System App. Coded for javac 18.0.2 and javafx-sdk-18.0.2 (most current versions as of writing), so ensure version are up to date to run the 
application. Application includes a plain-text file where the inventory is stored from each use of the app so that when the user reopens, the inventory has 
not been lost. Current class diagram is also included in the GitHub repository for reference (under the name InventoryManagementClassDiagram). Enjoy!

Features to be added in next implementation:
  - Ability to edit valus in items already in inventory
    -> probably accomplished by having a similar search UI to the order scene but instead allowing for the adding/subtracting of stock and modification of
       wholesale and/or retail price
  - Ability to remove items from inventory:
    -> likely easy, would only require a UI that would employ a similar search method as in the order class but instead remove the Item object if found
  - Ability to modify order quantities without having to clear and restart the order
    -> probably accomplished by creating a search method like that in the order class (searching from inventory) but have it instead search from the order list
       and allow for editing of the ItemOrder objects using setters
Note that a few setter methods required for these above modifications are currently in the code of the project
