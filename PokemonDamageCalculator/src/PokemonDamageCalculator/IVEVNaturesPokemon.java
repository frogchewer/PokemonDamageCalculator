package PokemonDamageCalculator;
import javax.sound.sampled.SourceDataLine;
import javax.swing.event.SwingPropertyChangeSupport;

public class IVEVNaturesPokemon {
    String name;
    String specialName;
    int ID;
    int level;
    int type1;
    int type2;

    int nature;

    int IVh;
    int IVa;
    int IVd;
    int IVsa;
    int IVsd;
    int IVs;
    
    int EVh;
    int EVa;
    int EVd;
    int EVsa;
    int EVsd;
    int EVs;
    
    int baseHP;
    int baseAttack;
    int baseDefense;
    int baseSpecialAttack;
    int baseSpecialDefense;
    int baseSpeed;

    int hp;
    int attack;
    int defense; 
    int spAttack;
    int spDefense;
    int speed;

    public IVEVNaturesPokemon(Species species, int level, int nature, int IVh, int IVa, int IVd, int IVsa, int IVsd, int IVs, int EVh, int EVa, int EVd, int EVsa, int EVsd, int EVs){
        // using ID, obtain base stats
        this.ID = species.ID;
        this.name = species.name;
        this.specialName = species.specialName;
        this.level = level;
        this.nature = nature;
        this.type1 = species.type1;
        this.type2 = species.type2;
        
        this.baseHP = species.hp;
        this.baseAttack = species.attack;
        this.baseDefense = species.defense;
        this.baseSpecialAttack = species.spAttack;
        this.baseSpecialDefense = species.spDefense;
        this.baseSpeed = species.speed;
        
        this.IVh = IVh;
        this.IVa = IVa;
        this.IVd = IVd;
        this.IVsa = IVsa;
        this.IVsd = IVsd;
        this.IVs = IVs;

        this.EVh = EVh;
        this.EVa = EVa;
        this.EVd = EVd;
        this.EVsa = EVsa;
        this.EVsd = EVsd;
        this.EVs = EVs;

        this.hp = (((2 * baseHP + IVh + EVh/4) * level)/100)+level + 10;

        double natureEffect = 1;
        if(nature/5 == 0 && nature%5 == 0){
            natureEffect = 1;
        }
        else if(nature/5 == 0){
            natureEffect = 1.1;
        }
        else if(nature%5 == 0){
            natureEffect = 0.9;
        }
        else natureEffect = 1;

        this.attack = (int)(((((2 * baseAttack + IVa + EVa/4) * level)/100)+5) * natureEffect);
        
        natureEffect = 1;
        if(nature/5 == 1 && nature%5 == 1){
            natureEffect = 1;
        }
        else if(nature/5 == 1){
            natureEffect = 1.1;
        }
        else if(nature%5 == 1){
            natureEffect = 0.9;
        }
        else natureEffect = 1;

        this.defense = (int)(((((2 * baseDefense + IVd + EVd/4) * level)/100)+5) * natureEffect);

        natureEffect = 1;
        if(nature/5 == 2 && nature%5 == 2){
            natureEffect = 1;
        }
        else if(nature/5 == 2){
            natureEffect = 1.1;
        }
        else if(nature%5 == 2){
            natureEffect = 0.9;
        }
        else natureEffect = 1;

        this.spAttack = (int)(((((2 * baseSpecialAttack + IVsa + EVsa/4) * level)/100)+5) * natureEffect);

        natureEffect = 1;
        if(nature/5 == 3 && nature%5 == 3){
            natureEffect = 1;
        }
        else if(nature/5 == 3){
            natureEffect = 1.1;
        }
        else if(nature%5 == 3){
            natureEffect = 0.9;
        }
        else natureEffect = 1;

        this.spDefense = (int)(((((2 * baseSpecialDefense + IVsd + EVsd/4) * level)/100)+5) * natureEffect);

        natureEffect = 1;
        if(nature/5 == 4 && nature%5 == 4){
            natureEffect = 1;
        }
        else if(nature/5 == 4){
            natureEffect = 1.1;
        }
        else if(nature%5 == 4){
            natureEffect = 0.9;
        }
        else natureEffect = 1;

        this.speed = (int)(((((2 * baseSpeed + IVs + EVs/4) * level)/100)+5) * natureEffect);
        System.out.println(this.hp + " " + this.attack + " " + this.defense + " " + this.spAttack + " " + this.spDefense + " " + this.speed);

    }
}
