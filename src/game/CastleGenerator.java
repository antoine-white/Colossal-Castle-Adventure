package game;

import java.util.*;
import interactions.*;
import place.*;
import storage.*;
import exit.*;
import items.*;

/*
 * GameGenerator
 */
public class CastleGenerator { 

    
    private static Trunk generateTrunk(TakeableItem i){
        Trunk t = new Trunk(); 
        t.addItem(i); 
        return t; 
    }
        
    private static Trunk generateTrunk(TakeableItem[] tab){
        Trunk t = new Trunk(); 
        for(TakeableItem i : tab){
            t.addItem(i); 
        }
        return t; 
    }
    
    public static Room generateCastle(){
        /***************************************  REZ DE CHAUSSEE DU CHATEAU *********************************************/
        
        // Piece d'arrivée le hall, sans rien
        Room Entrance = new Room("Castle's Entrance ","entrance",0,null,null); 

        // Salle a manger sans coffre ni ennemi 
        Room DiningRoom = new Room("The dining room next the entrance","diningroom",0,null,null); 

        // Cuisine avec coffre sans ennemi
        Trunk KitchenTrunk = new Trunk(); 
        KitchenTrunk.addItem(new Stick(20,5,"Stick","Stick which can be used as weapon")); 
        Room Kitchen = new Room("Kitchen next the entrance","kitchen",0,KitchenTrunk,null);

        // Cellier sans coffre avec ennemi armure 
        Room Cellar = new Room("Cellar next the kitchen","cellar",0,null,new Armor(70,10));

        // salle de bal avec coffre normal et sans ennemi
        Trunk BalTrunk = new Trunk(); 
        BalTrunk.addItem(new DoorKey("doorkey","A key which can open a locked door")); 
        Room BallRoom = new Room("Ballroom next the entrance of the castle","ballroom",0,BalTrunk,null); 

        // Taverne sans coffre et sans ennemi
        Room Tavern = new Room("An old tavern","tavern",0,null,null); 

        // Terrasse avec coffre et sans ennemi 
        Trunk TerraceTrunk = new Trunk(); 
        TerraceTrunk.addItem(new HealObject(20,5,"HealObject","An item which can heal you")); 
        Room Terrace = new Room("Terrace next the ballroom","Terrace",0,TerraceTrunk,null); 
        
        // Jardin d'hiver sans coffre et avec ennemi 
        Room WinterGarden = new Room("A Winter garden next the entrance","wintergarden",0,null,new Skeleton(50,20)); 

            /** PORTES **/
        Door Entrance_DiningRoom = new Door(Entrance,DiningRoom);  
        Door Entrance_BallRoom = new Door(Entrance,BallRoom); 
        Door Entrance_WinterGarden = new Door(Entrance,WinterGarden); 
        Door Tavern_BallRoom = new Door(BallRoom,Tavern); 
        Door DiningRoom_Kitchen = new Door(DiningRoom,Kitchen); 
        Door Kitchen_Cellar = new Door(Kitchen,Cellar); 
       
            
           /** SORTIES **/ 
            
        Entrance.setExit(Entrance_DiningRoom);
        DiningRoom.setExit(Entrance_DiningRoom);
        
        Entrance.setExit(Entrance_BallRoom);
        BallRoom.setExit(Entrance_BallRoom);
        
        Entrance.setExit(Entrance_WinterGarden); 
        WinterGarden.setExit(Entrance_WinterGarden);
        
        DiningRoom.setExit(DiningRoom_Kitchen);
        Kitchen.setExit(DiningRoom_Kitchen);
        
        BallRoom.setExit(Tavern_BallRoom);
        Tavern.setExit(Tavern_BallRoom); 
        
        Kitchen.setExit(Kitchen_Cellar);
        Cellar.setExit(Kitchen_Cellar);
        
        /*****************************************  FIRST FLOOR  **************************************/
        
        // Hallway without trunk and ennemy 
        Room Hallway = new Room("A long hallway","hallway",1,null,null); 
        
        // Deluxe Room with locked door with trunk and no ennemy
        Trunk DeluxeTrunk = new Trunk(); a 
        DeluxeTrunk.addItem(new TrunkKey("trunkkey","A key which can open a locked trunk")); 
        Room DeluxeRoom = new Room("A deluxe room which greats and luxury decorations","deluxeroom",1,DeluxeTrunk,null); 
        
        
        //BedRoom with trunk and no ennemy
        Trunk BedroomTrunk = new Trunk(); 
        BedroomTrunk.addItem(new Axe(25,5,"Axe","A mighty axe")); 
        Room Bedroom = new Room("A basic room with a pile of straw as bed","bedroom",1,BedroomTrunk,null);


        //A big empty room with trunk and A MIGHTY ennemy
        Trunk EmptyRoomTrunk = new Trunk(); 
        EmptyRoomTrunk.addItem(new HealObject(45,5,"HealObject","An special item which can heal you after your rude fight")); 
        Room EmptyRoom = new Room("A big empty room with a big armor","emptyroom",1,EmptyRoomTrunk,new Armor(120,18));


        //A  room with trunk and A MIGHTY ennemy
        LockableTrunk LivingRoomTrunk = new LockableTrunk(); 
        LivingRoomTrunk.addItem(new HealObject(45,5,"HealObject","An item which can heal you")); 
        Room LivingRoom = new Room("A big living room with large sofa","livingroom",1,LivingRoomTrunk,null);
        
        
           /** PORTES **/
        LockedDoor Hallway_DeluxeRoom = new LockedDoor(Hallway,DeluxeRoom);  
        Door Hallway_Bedroom = new Door(Hallway,Bedroom);  
        OneWayDoor Hallway_EmptyRoom = new OneWayDoor(Hallway,EmptyRoom);  
        Door EmptyRoom_LivingRoom = new Door(EmptyRoom,LivingRoom); 

        
           /** SORTIES **/ 
            
        Hallway.setExit(Hallway_DeluxeRoom);
        DeluxeRoom.setExit(Hallway_DeluxeRoom);

        Hallway.setExit(Hallway_Bedroom);
        Bedroom.setExit(Hallway_Bedroom);
        
        Hallway.setExit(Hallway_EmptyRoom);
       // EmptyRoom.setExit(Hallway_EmptyRoom);

        LivingRoom.setExit(EmptyRoom_LivingRoom);
        EmptyRoom.setExit(EmptyRoom_LivingRoom);
        
        
        
        
        
        /*** STAIRS BETWEEN THE GROUND FLOOR AND THE FIRST FLOOR *****/
        Stairs WinterGarden_Hallway = new Stairs(WinterGarden,Hallway); 
         
         /** STAIRS' EXITS **/
        WinterGarden.setExit(WinterGarden_Hallway);         
        Hallway.setExit(WinterGarden_Hallway); 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
           /** ESCALIERS  **/
        
        return Entrance;
    }

    /**
     * Genarate a game from a file
     * 
     * @param path
     */
    public static Room generateCastle(String path) {
        // TODO :
        return null;
    }

}