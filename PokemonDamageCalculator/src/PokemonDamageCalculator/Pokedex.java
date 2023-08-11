package PokemonDamageCalculator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


// Made using tutorials from Alex Lee
public class Pokedex {

    Species[] pokedex;

    static String[] types = { "Normal", "Fire", "Water", "Grass", "Electric", "Ice", "Fighting", "Poison", "Ground", "Flying", "Psychic", "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel", "Fairy"};
    public Pokedex(){
        String path = "firstTen.csv";
        String line = "";
        this.pokedex = new Species[1010];
        int ID = 0;
        String name = "";
        String specialName = "";
        int type1 = -1;
        int type2 = -1;
        int BST = -1;
        int hp = -1;
        int attack = -1;
        int defense = -1;
        int spAttack = -1;
        int spDefense = -1;
        int speed = -1;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            int i = 0;
            while((line = br.readLine()) != null){
                String values[] = line.split(",");
                
                if(!line.equals(",,,,,,,,,,")){
                    if(isNumeric(values[0])&&i!=0){
                    System.out.println("Create Pokemon");
                    
                    Species insert = new Species(ID, name, specialName, type1, type2, BST, hp, attack, defense, spAttack, spDefense, speed);
                    insert(insert, ID, pokedex);
                    ID = 0;
                    name = "";
                    specialName = "";
                    type1 = -1;
                    type2 = -1;
                    BST = -1;
                    hp = -1;
                    attack = -1;
                    defense = -1;
                    spAttack = -1;
                    spDefense = -1;
                    speed = -1;
                }
                }
                
                if(line.equals(",,,,,,,,,,")){
                    System.out.println("Empty Line");
                }
                
                else if(values[1].equals("")){
                    type2 = returnType(values[2]);
                }
                else if(values[0].equals("")){
                    specialName = values[1];
                }
                else{
                    ID = Integer.parseInt(values[0]);
                    System.out.println(ID);
                    name = values[1];
                    specialName = name;
                    type1 = returnType(values[2]);
                    BST = Integer.parseInt(values[3]);
                    hp = Integer.parseInt(values[4]);
                    attack = Integer.parseInt(values[5]);
                    defense = Integer.parseInt(values[6]);
                    spAttack = Integer.parseInt(values[7]);
                    spDefense = Integer.parseInt(values[8]);
                    speed = Integer.parseInt(values[9]);
                }
                
                i++;
                /* 
                if(i%3==0){
                    System.out.println("Create Pokemon");
                    
                    Species insert = new Species(ID, name, specialName, type1, type2, BST, hp, attack, defense, spAttack, spDefense, speed);
                    insert(insert, ID, pokedex);
                    ID = 0;
                    name = "";
                    specialName = "";
                    type1 = -1;
                    type2 = -1;
                    BST = -1;
                    hp = -1;
                    attack = -1;
                    defense = -1;
                    spAttack = -1;
                    spDefense = -1;
                    speed = -1;
                }
                */
                
            }
            System.out.println("Create Pokemon");
            Species insert = new Species(ID, name, specialName, type1, type2, BST, hp, attack, defense, spAttack, spDefense, speed);
            insert(insert, ID, pokedex);
            for(int j = 0; j < 1010; j++){
                Species current = pokedex[j];
                if(current == null){
                    System.out.println("The cycle has been broken");
                    break;
                } 
                System.out.println("ID: " + current.ID);
                System.out.println("Name: " + current.name);
                System.out.println("Special Name: " + current.specialName);
                System.out.println("BST: " + current.BST);
                
                while(current.alternate != null){
                    current = current.alternate;
                    System.out.println("ID: " + current.ID);
                    System.out.println("Name: " + current.name);
                    System.out.println("Special Name: " + current.specialName);
                    System.out.println("BST: " + current.BST);
                }
            }
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
    }

    static public int returnType(String type){
        if(type.equals("Normal")){
            return 0;
        }
        else if(type.equals("Fire")){
            return 1;
        }
        else if(type.equals("Water")){
            return 2;
        }
        else if(type.equals("Grass")){
            return 3;
        }
        else if(type.equals("Electric")){
            return 4;
        }
        else if(type.equals("Ice")){
            return 5;
        }
        else if(type.equals("Fighting")){
            return 6;
        }
        else if(type.equals("Poison")){
            return 7;
        }
        else if(type.equals("Ground")){
            return 8;
        }
        else if(type.equals("Flying")){
            return 9;
        }
        else if(type.equals("Psychic")){
            return 10;
        }
        else if(type.equals("Bug")){
            return 11;
        }
        else if(type.equals("Rock")){
            return 12;
        }
        else if(type.equals("Ghost")){
            return 13;
        }
        else if(type.equals("Dragon")){
            return 14;
        }
        else if(type.equals("Dark")){
            return 15;
        }
        else if(type.equals("Steel")){
            return 16;
        }
        else if(type.equals("Fairy")){
            return 17;
        }
        else return -1;
        
    }
    static public void insert(Species insert, int ID, Species[] pokedex){
        if(pokedex[ID-1]==null){
            pokedex[ID-1] = insert;
        }
        else pokedex[ID-1].addAlt(insert);
        System.out.println("inserted " + insert.name + " at " + ID);
    }

        public static boolean isNumeric(String strNum) {
            if (strNum == null) {
                return false;
            }
            try {
                double d = Double.parseDouble(strNum);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }
        
}
