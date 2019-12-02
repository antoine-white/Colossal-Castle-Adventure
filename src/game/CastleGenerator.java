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

    /**
     * generate a default game 
     */
    public static Room generateCastle(){
        //                                         DEMANDER A ANTOINE POUR LES STORAGES 

        // Initialisation des objets et ennemi ( degat et volume arbitraire)
        Armor ArmorEnnemy = new Armor(70,25); 
        Skeleton skeletonEnnemy = new Skeleton(50,20); 
        Stick StickWeapon = new Stick(15,5,"Baton","Baton qui sert d'armes"); 
        Axe AxeWeapon = new Axe(20,5,"Hache","Hache servant d'armes"); 
        

        /***************  REZ DE CHAUSSEE DU CHATEAU *******************/
        
        // Piece d'arrivée le hall, sans rien 
        Room Entrance = new Room("Entree du chateau ","Entrée",0,null,null); 

        // Salle a manger sans coffre ni ennemi 
        Room DiningRoom = new Room("Salle a manger près de l'entrée du chateau","Salle A Manger",0,null,null); 

        // Cuisine avec coffre sans ennemi
        Trunk KitchenTrunk = new Trunk(); // ------> Arme dans celui la 
        Room Kitchen = new Room("Cuisine près de l'entrée du chateau","Cuisine",0,KitchenTrunk,null);

                                                        // rajouter piece inconnue 

        // Sellier sans coffre avec ennemi armure 
        Room Cellar = new Room("Cellier près de l'entrée du chateau","Cellier",0,null,ArmorEnnemy);

        // salle de bal avec coffre normal et sans ennemi
        Trunk BalTrunk = new Trunk(); // ------> Clé dans celui la 
        Room BallRoom = new Room("Salle de bal près de l'entrée du chateau","Salle de Bal",0,BalTrunk,null); 

        // Taverne sans coffre et sans ennemie 
        Room Tavern = new Room("Ancienne Taverne du chateau","Taverne",0,null,null); 

        // Terrasse avec coffre et sans ennemi 
        Trunk TerraceTrunk = new Trunk(); // ------> Objet de Soin dans celui la 
        Room Terrace = new Room("Terrace près de la salle de bal","Terrasse",0,TerraceTrunk,null); 

            /** PORTES **/
        //Porte reliant salle a manger et entrée 
        Door Entrance_DiningRoom = new Door(Entrance,DiningRoom); 
        //Porte reliant entrée et salle de bal 
        Door Entrance_BallRoom = new Door(Entrance,BallRoom); 
        //Porte reliant Salle de Bal et Taverne 
        Door Tavern_BallRoom = new Door(BallRoom,Tavern); 
        // Porte reliant cuisine et salle a manger 
        Door DiningRoom_Kitchen = new Door(DiningRoom,Kitchen); 
        // Porte reliant cellier à la cuisine 
        Door Kitchen_Cellar = new Door(Kitchen,Cellar); 

        Entrance.setExit(Entrance_DiningRoom);
        Entrance.setExit(Entrance_BallRoom);
        DiningRoom.setExit(Entrance_DiningRoom);
        DiningRoom.setExit(DiningRoom_Kitchen);
        BallRoom.setExit(Entrance_BallRoom);
        BallRoom.setExit(Tavern_BallRoom);
        Kitchen.setExit(Kitchen_Cellar);
        Kitchen.setExit(DiningRoom_Kitchen);
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
