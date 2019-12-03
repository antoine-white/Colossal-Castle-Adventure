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
     
        /************************************************************************  GROUND FLOOR  ************************************************************************/
        
        // Piece d'arrivée le hall, sans rien
        Room Entrance = new Room("Castle's Entrance. A large room with a huge golden door ","entrance",0,null,null); 

        // Salle a manger sans coffre ni ennemi 
        Room DiningRoom = new Room("A dining room which contains a long table covered with dishes and several silver chairs","diningroom",0,null,null); 

        // Cuisine avec coffre sans ennemi
        Trunk KitchenTrunk = new Trunk(); 
        KitchenTrunk.addItem(new Stick(20,5,"Stick","Massive stick in woods which can be used as weapon")); 
        Room Kitchen = new Room("A Large kitchen which can be used by several employees at the same time next the entrance","kitchen",0,KitchenTrunk,null);

        // Cellier sans coffre avec ennemi armure 
        Room Cellar = new Room("A small cellar without many lights next the kitchen","cellar",0,null,new Armor(70,10));

        // salle de bal avec coffre normal et sans ennemi
        Trunk BalTrunk = new Trunk(); 
        BalTrunk.addItem(new DoorKey("doorkey","A key which can open a locked door")); 
        Room BallRoom = new Room("A huge ballroom with a lot of chandelier and beautiful tiling","ballroom",0,BalTrunk,null); 

        // Taverne sans coffre et sans ennemi
        Room Tavern = new Room("An old tavern fulfil of alcohol bottles of all kinds","tavern",0,null,null); 

        // Terrasse avec coffre et sans ennemi 
        Trunk TerraceTrunk = new Trunk(); 
        TerraceTrunk.addItem(new HealObject(20,5,"HealObject","An item which can heal you")); 
        Room Terrace = new Room("A pretty large terrace ","Terrace",0,TerraceTrunk,null); 
        
        // Jardin d'hiver sans coffre et avec ennemi 
        Room WinterGarden = new Room("A Winter garden with a lot of tree and a small pond","wintergarden",0,null,new Skeleton(50,20)); 

            /** PORTES **/
        Door Entrance_DiningRoom = new Door(Entrance,DiningRoom);  
        Door Entrance_BallRoom = new Door(Entrance,BallRoom); 
        Door Entrance_WinterGarden = new Door(Entrance,WinterGarden); 
        Door Tavern_BallRoom = new Door(BallRoom,Tavern); 
        Door DiningRoom_Kitchen = new Door(DiningRoom,Kitchen); 
        Door Kitchen_Cellar = new Door(Kitchen,Cellar); 
        Door BallRoom_Terrace = new Door(BallRoom,Terrace); 
       
            
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

        BallRoom.setExit(BallRoom_Terrace); 
        Terrace.setExit(BallRoom_Terrace); 
        
        Kitchen.setExit(Kitchen_Cellar);
        Cellar.setExit(Kitchen_Cellar);
        
        /************************************************************************  FIRST FLOOR  ************************************************************************/
        
        // Hallway without trunk and ennemy 
        Room Hallway = new Room("A long hallway","hallway",1,null,null); 
        
        // Deluxe Room with locked door with trunk and no ennemy
        Trunk DeluxeTrunk = new Trunk();
        DeluxeTrunk.addItem(new TrunkKey("trunkkey","A key which can open a locked trunk")); 
        Room DeluxeRoom = new Room("A deluxe room which greats and luxury decorations","deluxeroom",1,DeluxeTrunk,null); 
        
        
        //BedRoom with trunk and no ennemy
        Trunk BedroomTrunk = new Trunk(); 
        BedroomTrunk.addItem(new Axe(25,5,"Axe","A mighty axe")); 
        Room Bedroom = new Room("A basic room with a pile of straw as bed","bedroom",1,BedroomTrunk,null);


        //A big empty room with trunk and A MIGHTY ennemy
        LockableTrunk EmptyRoomTrunk = new LockableTrunk(); 
        EmptyRoomTrunk.addItem(new HealObject(45,5,"HealObject","An special item which can heal you after your rude fight")); 
        Room EmptyRoom = new Room("A big empty room with a big armor","emptyroom",1,EmptyRoomTrunk,new Armor(120,18));


        //A room with trunk and without ennemy
        Trunk LivingRoomTrunk = new Trunk(); 
        LivingRoomTrunk.addItem(new HealObject(20,5,"HealObject","An item which can heal you")); 
        Room LivingRoom = new Room("A big living room with large sofa","livingroom",1,LivingRoomTrunk,new Skeleton(50,10));
        
        
           /** PORTES **/
        LockedDoor Hallway_DeluxeRoom = new LockedDoor(Hallway,DeluxeRoom);  
        Door Hallway_Bedroom = new Door(Hallway,Bedroom);  
        OneWayDoor Hallway_EmptyRoom = new OneWayDoor(Hallway,EmptyRoom);  
        

        
           /** SORTIES **/ 
            
        Hallway.setExit(Hallway_DeluxeRoom);
        DeluxeRoom.setExit(Hallway_DeluxeRoom);

        Hallway.setExit(Hallway_Bedroom);
        Bedroom.setExit(Hallway_Bedroom);
        
        Hallway.setExit(Hallway_EmptyRoom);
       // EmptyRoom.setExit(Hallway_EmptyRoom);

        
        /*** STAIRS BETWEEN THE GROUND FLOOR AND THE FIRST FLOOR *****/
        Stairs WinterGarden_Hallway = new Stairs(WinterGarden,Hallway); 
        Stairs Tavern_LivingRoom = new Stairs(Tavern,LivingRoom); 
         
         /** STAIRS' EXITS **/
        WinterGarden.setExit(WinterGarden_Hallway);         
        Hallway.setExit(WinterGarden_Hallway); 

        Tavern.setExit(Tavern_LivingRoom); 
        LivingRoom.setExit(Tavern_LivingRoom); 


         /************************************************************************  SECOND FLOOR  ************************************************************************/
        // Art gallery with a trunk and no ennemy
        Trunk ArtGalleryTrunk = new Trunk(); 
        ArtGalleryTrunk.addItem(new TrunkKey("trunkkey","A beautiful key which seems to be used in order to open a locked trunk")); 
        Room ArtGallery = new Room("A large room full of paintings and works of art","artgallery",2,ArtGalleryTrunk,null);
        
        // Hallway without trunk and ennemy 
        Room SecondHallway = new Room("A long hallway","hallway",2,null,null); 
        
        // Library with a locked trunk and without ennemy
        LockableTrunk LibraryTrunk = new LockableTrunk(); 
        LibraryTrunk.addItem(new DoorKey("doorkey","A grey key a bit rusty which can be used to open a locked door")); 
        Room Library = new Room("A huge library with all kinds of books","library",2,LibraryTrunk,null); 
        
        // Music room without trunk and an ennemy
        Room MusicRoom = new Room("A large room fullfil of musical instruments","musicroom",2,null,new Armor(75,25)); 


        // Small empty room without anything 
        TresorTrunk TresorTrunk = new TresorTrunk(); 
        TresorTrunk.addItem(new Tresor(1,"tresor","An large amount of golden coins, a lot of diamonds and emeralds with some jewelry")); 
        Room SmallEmptyRoom = new Room("A small empty room","smallroom",2,null,null); 

        // HIDDEN ROOM WITH THE TRESOR KEY 
        Trunk TresorKeyTrunk = new Trunk();
        TresorKeyTrunk.addItem(new TresorKey("tresorkey","A luxurious gold key with a lot of ornaments and a ruby in the midlle ")); 
        HiddenRoom TresorKeyRoom = new HiddenRoom("A hole in the wall which reveals the hidden room","hiddenroom",2,TresorKeyTrunk,null); 

        
         /** PORTES **/
        OneWayDoor ArtGallery_SecondHallway = new OneWayDoor(ArtGallery,SecondHallway);
        Door Library_SecondHallway = new Door(Library,SecondHallway); 
        Door MusicRoom_SecondHallway = new Door(MusicRoom,SecondHallway); 
        SecretExit SmallEmptyRoom_TresorKeyRoom = new SecretExit(SmallEmptyRoom,TresorKeyRoom); 
         
 
         
        /** SORTIES **/ 
        ArtGallery.setExit(ArtGallery_SecondHallway); 
         
        Library.setExit(Library_SecondHallway);
        SecondHallway.setExit(Library_SecondHallway); 

        MusicRoom.setExit(MusicRoom_SecondHallway); 
        SecondHallway.setExit(MusicRoom_SecondHallway); 

        SmallEmptyRoom.setExit(SmallEmptyRoom_TresorKeyRoom); 
        TresorKeyRoom.setExit(SmallEmptyRoom_TresorKeyRoom); 


        /*** STAIRS BETWEEN THE FIRST FLOOR AND THE SECOND FLOOR *****/
        Stairs ArtGallery_EmptyRoom = new Stairs(ArtGallery,EmptyRoom); 
        Stairs SecondHallway_Hallway = new Stairs(SecondHallway,Hallway); 
        Stairs LivingRoom_SmallEmptyRoom = new Stairs(LivingRoom,SmallEmptyRoom); 
         
         /** STAIRS' EXITS **/
        ArtGallery.setExit(ArtGallery_EmptyRoom); 
        EmptyRoom.setExit(ArtGallery_EmptyRoom); 

        Hallway.setExit(SecondHallway_Hallway); 
        SecondHallway.setExit(SecondHallway_Hallway); 

        LivingRoom.setExit(LivingRoom_SmallEmptyRoom); 
        SmallEmptyRoom.setExit(LivingRoom_SmallEmptyRoom); 


        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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