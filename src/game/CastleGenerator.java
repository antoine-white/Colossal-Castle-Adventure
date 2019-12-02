package game;

import java.util.*;
import interactions.*;
import place.*;
import storage.Trunk;
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
        /***************  REZ DE CHAUSSEE DU CHATEAU *******************/
        
        // Piece d'arrivée le hall, sans rien
        Room Entrance = new Room("Castle's Entrance ","entrance",0,null,null); 

        // Salle a manger sans coffre ni ennemi 
        Room DiningRoom = new Room("The dining room next the entrance","diningroom",0,null,null); 

        // Cuisine avec coffre sans ennemi
        Trunk KitchenTrunk = new Trunk(); // ------> Arme (Baton) dans celui la 
        KitchenTrunk.addItem(new Stick(20,5,"Stick","Stick which can be used as weapon")); 
        Room Kitchen = new Room("Kitchen next the entrance","kitchen",0,KitchenTrunk,null);

        // Cellier sans coffre avec ennemi armure 
        Room Cellar = new Room("Cellar next the kitchen","cellar",0,null,new Armor(70,10));

        // salle de bal avec coffre normal et sans ennemi
        Trunk BalTrunk = new Trunk(); // ------> Clé dans celui la 
        BalTrunk.addItem(new DoorKey("Key","Key which can open a locked door")); 
        Room BallRoom = new Room("Ballroom next the entrance of the castle","ballroom",0,BalTrunk,null); 

        // Taverne sans coffre et sans ennemi
        Room Tavern = new Room("An old tavern","tavern",0,null,null); 

        // Terrasse avec coffre et sans ennemi 
        Trunk TerraceTrunk = new Trunk(); // ------> Objet de Soin dans celui la 
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