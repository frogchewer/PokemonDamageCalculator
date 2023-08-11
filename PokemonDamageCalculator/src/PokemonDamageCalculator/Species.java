package PokemonDamageCalculator;

public class Species {
    int ID;
    String name;
    String specialName;
    int type1;
    int type2;
    int BST;
    int hp;
    int attack;
    int defense;
    int spAttack;
    int spDefense;
    int speed;
    Species alternate;
    static String[] types = { "Normal", "Fire", "Water", "Grass", "Electric", "Ice", "Fighting", "Poison", "Ground", "Flying", "Psychic", "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel", "Fairy"};

    public Species(int ID, String name, int type1, int type2, int BST, int hp, int attack, int defense, int spAttack, int spDefense, int speed){
        this.ID = ID;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.BST = BST;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.specialName = null;
        this.alternate = null;
    }
    public Species(int ID, String name, String specialName, int type1, int type2, int BST, int hp, int attack, int defense, int spAttack, int spDefense, int speed){
        this.ID = ID;
        this.name = name;
        this.specialName = specialName;
        this.type1 = type1;
        this.type2 = type2;
        this.BST = BST;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.alternate = null;
    }

    public void addAlt(Species alternate){
        if(this.alternate ==null){
            this.alternate = alternate;
        }
        else this.alternate.addAlt(alternate);
    }
}
