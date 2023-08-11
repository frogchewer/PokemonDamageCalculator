package PokemonDamageCalculator;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
//javac -d bin src/PokemonDamageCalculator/*.java
//java -cp bin PokemonDamageCalculator.GUI  
import javax.swing.JPanel;
import javax.swing.JTextField;

import PokemonDamageCalculator.IVEVNaturesPokemon;
import PokemonDamageCalculator.Pokedex;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class GUI implements ActionListener {

    static double[][] typeEffectiveness = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1, 1, 1, 0, 1, 1, 1, 1}, //normal
        {1, 1/2, 1/2, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1/2, 1, 1/2, 1, 2, 1}, //fire
        {1, 2, 1/2, 1/2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1/2, 1, 1, 1}, //water
        {1, 1/2, 2, 1/2, 1, 1, 1, 1/2, 2, 1/2, 1, 1/2, 2, 1, 1/2, 1, 1/2, 1}, //grass
        {1, 1, 2, 1/2, 1/2, 1, 1, 1, 0, 2, 1, 1, 1, 1, 1/2, 1, 1, 1}, //electric
        {1, 1/2, 1/2, 2, 1, 1/2, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 1/2, 1}, //ice
        {2, 1, 1, 1, 1, 2, 1, 1/2, 1, 1/2, 1/2, 1/2, 2,	0, 1, 2, 2, 1/2}, //fighting
        {1, 1, 1, 2, 1, 1, 1, 1/2, 1/2, 1, 1, 1, 1/2, 1/2, 1, 1, 0, 2}, //poison
        {1, 2, 1, 1/2, 2, 1, 1, 2, 1, 0, 1, 1/2, 2, 1, 1, 1, 2, 1}, //ground
        {1, 1, 1, 2, 1/2, 1, 2, 1, 1, 1, 1, 2, 1/2, 1, 1, 1, 1/2, 1}, //flying
        {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1/2, 1, 1, 1, 1, 0, 1/2, 1}, //psychic
        {1, 1/2, 1, 2, 1, 1, 1/2, 1/2, 1, 1/2, 2, 1, 1, 1/2, 1, 2, 1/2, 1/2 }, //bug
        {1, 2, 1, 1, 1, 2, 1/2, 1, 1/2, 2, 1, 2, 1, 1, 1, 1, 1/2, 1}, //rock
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1/2, 1, 1}, //ghost
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1/2, 0}, //dragon
        {1, 1, 1, 1, 1, 1, 1/2, 1, 1, 1, 2, 1, 1, 2, 1, 1/2, 1, 1/2}, //dark
        {1, 1/2, 1/2, 1, 1/2, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1/2, 2}, //steel
        {1, 1/2, 1, 1, 1, 1, 2, 1/2, 1, 1, 1, 1, 1, 1, 2, 2, 1/2, 1} //fairy
    };

    private JLabel pokeOneID;
    private JTextField inputOneID;
    private JLabel pokeOneName;
    private JLabel pokeOneSpecialName;
    private JLabel pokeOneHP;
    private JLabel pokeOneAttack;
    private JLabel pokeOneDefense;
    private JLabel pokeOneSpAttack;
    private JLabel pokeOneSpDefense;
    private JLabel pokeOneSpeed;

    private JLabel pokeOneLevelLabel;
    private JLabel pokeOneNatureLabel;

    private JLabel pokeOneHPEVLabel;
    private JLabel pokeOneAttackEVLabel;
    private JLabel pokeOneDefenseEVLabel;
    private JLabel pokeOneSpAttackEVLabel;
    private JLabel pokeOneSpDefenseEVLabel;
    private JLabel pokeOneSpeedEVLabel;

    private JLabel pokeOneHPIVLabel;
    private JLabel pokeOneAttackIVLabel;
    private JLabel pokeOneDefenseIVLabel;
    private JLabel pokeOneSpAttackIVLabel;
    private JLabel pokeOneSpDefenseIVLabel;
    private JLabel pokeOneSpeedIVLabel;

    private JTextField pokeOneLevelInput;
    private JTextField pokeOneNatureInput;
    
    private JTextField pokeOneHPEVInput;
    private JTextField pokeOneAttackEVInput;
    private JTextField pokeOneDefenseEVInput;
    private JTextField pokeOneSpAttackEVInput;
    private JTextField pokeOneSpDefenseEVInput;
    private JTextField pokeOneSpeedEVInput;

    private JTextField pokeOneHPIVInput;
    private JTextField pokeOneAttackIVInput;
    private JTextField pokeOneDefenseIVInput;
    private JTextField pokeOneSpAttackIVInput;
    private JTextField pokeOneSpDefenseIVInput;
    private JTextField pokeOneSpeedIVInput;



    
    
    private JPanel pokeOne;
    private JPanel statsOne;
    private JPanel evivOne;
   
    private JButton buttonOne;
    private JButton swapOne;

    private JLabel pokeTwoID;
    private JTextField inputTwoID;
    private JLabel pokeTwoName;
    private JLabel pokeTwoSpecialName;
    private JLabel pokeTwoHP;
    private JLabel pokeTwoAttack;
    private JLabel pokeTwoDefense;
    private JLabel pokeTwoSpAttack;
    private JLabel pokeTwoSpDefense;
    private JLabel pokeTwoSpeed;


    private JLabel pokeTwoLevelLabel;
    private JLabel pokeTwoNatureLabel;


    private JLabel pokeTwoHPEVLabel;
    private JLabel pokeTwoAttackEVLabel;
    private JLabel pokeTwoDefenseEVLabel;
    private JLabel pokeTwoSpAttackEVLabel;
    private JLabel pokeTwoSpDefenseEVLabel;
    private JLabel pokeTwoSpeedEVLabel;


    private JLabel pokeTwoHPIVLabel;
    private JLabel pokeTwoAttackIVLabel;
    private JLabel pokeTwoDefenseIVLabel;
    private JLabel pokeTwoSpAttackIVLabel;
    private JLabel pokeTwoSpDefenseIVLabel;
    private JLabel pokeTwoSpeedIVLabel;


    private JTextField pokeTwoLevelInput;
    private JTextField pokeTwoNatureInput;
  
    private JTextField pokeTwoHPEVInput;
    private JTextField pokeTwoAttackEVInput;
    private JTextField pokeTwoDefenseEVInput;
    private JTextField pokeTwoSpAttackEVInput;
    private JTextField pokeTwoSpDefenseEVInput;
    private JTextField pokeTwoSpeedEVInput;


    private JTextField pokeTwoHPIVInput;
    private JTextField pokeTwoAttackIVInput;
    private JTextField pokeTwoDefenseIVInput;
    private JTextField pokeTwoSpAttackIVInput;
    private JTextField pokeTwoSpDefenseIVInput;
    private JTextField pokeTwoSpeedIVInput;

  
    private JPanel pokeTwo;
    private JPanel statsTwo;
    private JPanel evivTwo;
 
    private JButton buttonTwo;
    private JButton swapTwo;


    private JFrame frame;
    private Pokedex pokedexInside = new Pokedex();
    private Species[] pokedex = pokedexInside.pokedex;

    private IVEVNaturesPokemon pokemonOne;
    private IVEVNaturesPokemon pokemonTwo;

    private Species speciesOne;
    private Species speciesTwo;

    private int pokeOneLevel;
    private int pokeOneNature;
    private int pokeOneAddress;
    private int pokeOneHPIV;
    private int pokeOneAttackIV;
    private int pokeOneDefenseIV;
    private int pokeOneSpAttackIV;
    private int pokeOneSpDefenseIV;
    private int pokeOneSpeedIV;
    private int pokeOneHPEV;
    private int pokeOneAttackEV;
    private int pokeOneDefenseEV;
    private int pokeOneSpAttackEV;
    private int pokeOneSpDefenseEV;
    private int pokeOneSpeedEV;

    private int pokeTwoLevel;
    private int pokeTwoNature;
    private int pokeTwoAddress;
    private int pokeTwoHPIV;
    private int pokeTwoAttackIV;
    private int pokeTwoDefenseIV;
    private int pokeTwoSpAttackIV;
    private int pokeTwoSpDefenseIV;
    private int pokeTwoSpeedIV;
    private int pokeTwoHPEV;
    private int pokeTwoAttackEV;
    private int pokeTwoDefenseEV;
    private int pokeTwoSpAttackEV;
    private int pokeTwoSpDefenseEV;
    private int pokeTwoSpeedEV;

    private JPanel calculations;


    private JLabel moveTypeLabel;
    private JTextField moveTypeInput;
    private JLabel physicalOrSpecialLabel;
    private JCheckBox physicalOrSpecialCheckBox;
    private JLabel moveBasePowerLabel;
    private JTextField moveBasePowerInput;
    private JLabel damageRange;
    private JButton calculateDamage;


    public GUI(){
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(1, 3));
        pokeOne = new JPanel();
        statsOne = new JPanel();
        evivOne = new JPanel();
        

        pokeOne.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        pokeOne.setLayout(new GridLayout(1,2));
        
        statsOne.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        statsOne.setLayout(new GridLayout(0,1));

        evivOne.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        evivOne.setLayout(new GridLayout(0,1));
        
       

        pokeOneID = new JLabel("ID: ");
        statsOne.add(pokeOneID);

        inputOneID = new JTextField(20);
        statsOne.add(inputOneID);

        pokeOneName = new JLabel("Name: ");
        statsOne.add(pokeOneName);

        pokeOneSpecialName = new JLabel("Special Name: ");
        statsOne.add(pokeOneSpecialName);

        pokeOneHP = new JLabel("HP: ");
        statsOne.add(pokeOneHP);

        pokeOneAttack = new JLabel("Attack: ");
        statsOne.add(pokeOneAttack);

        pokeOneDefense = new JLabel("Defense: ");
        statsOne.add(pokeOneDefense);

        pokeOneSpAttack = new JLabel("Special Attack: ");
        statsOne.add(pokeOneSpAttack);

        pokeOneSpDefense = new JLabel("Special Defense: ");
        statsOne.add(pokeOneSpDefense);

        pokeOneSpeed = new JLabel("Speed: ");
        statsOne.add(pokeOneSpeed);
        
        buttonOne = new JButton("Refresh Pokemon");
        buttonOne.addActionListener(this);
        statsOne.add(buttonOne);
        
        swapOne = new JButton("Different Form");
        swapOne.addActionListener(this);
        statsOne.add(swapOne);

        pokeOne.add(statsOne);

        
        

        pokeOneLevelLabel = new JLabel("Level: ");
        evivOne.add(pokeOneLevelLabel);
        pokeOneLevelInput = new JTextField(20);
        evivOne.add(pokeOneLevelInput);


        pokeOneNatureLabel = new JLabel("Nature: ");
        evivOne.add(pokeOneNatureLabel);
        pokeOneNatureInput = new JTextField(20);
        evivOne.add(pokeOneNatureInput);

    
        pokeOneHPEVLabel = new JLabel("HP EVs: ");
        evivOne.add(pokeOneHPEVLabel);
        pokeOneHPEVInput = new JTextField(20);
        evivOne.add(pokeOneHPEVInput);

        pokeOneAttackEVLabel = new JLabel("Attack EVs: ");
        evivOne.add(pokeOneAttackEVLabel);
        pokeOneAttackEVInput = new JTextField(20);
        evivOne.add(pokeOneAttackEVInput);

        pokeOneDefenseEVLabel = new JLabel("Defense EVs: ");
        evivOne.add(pokeOneDefenseEVLabel);
        pokeOneDefenseEVInput = new JTextField(20);
        evivOne.add(pokeOneDefenseEVInput);

        pokeOneSpAttackEVLabel = new JLabel("Special Attack EVs: ");
        evivOne.add(pokeOneSpAttackEVLabel);
        pokeOneSpAttackEVInput = new JTextField(20);
        evivOne.add(pokeOneSpAttackEVInput);

        pokeOneSpDefenseEVLabel  = new JLabel("Special Defense EVs: ");
        evivOne.add(pokeOneSpDefenseEVLabel);
        pokeOneSpDefenseEVInput = new JTextField(20);
        evivOne.add(pokeOneSpDefenseEVInput);

        pokeOneSpeedEVLabel = new JLabel("Speed EVs: ");
        evivOne.add(pokeOneSpeedEVLabel);
        pokeOneSpeedEVInput = new JTextField(20);
        evivOne.add(pokeOneSpeedEVInput);

        pokeOneHPIVLabel = new JLabel("HP IVs: ");
        evivOne.add(pokeOneHPIVLabel);
        pokeOneHPIVInput = new JTextField(20);
        evivOne.add(pokeOneHPIVInput);
        
        pokeOneAttackIVLabel = new JLabel("Attack IVs: ");
        evivOne.add(pokeOneAttackIVLabel);
        pokeOneAttackIVInput = new JTextField(20);
        evivOne.add(pokeOneAttackIVInput);

        pokeOneDefenseIVLabel = new JLabel("Defense IVs: ");
        evivOne.add(pokeOneDefenseIVLabel);
        pokeOneDefenseIVInput = new JTextField(20);
        evivOne.add(pokeOneDefenseIVInput);
        
        pokeOneSpAttackIVLabel = new JLabel("Special Attack IVs: ");
        evivOne.add(pokeOneSpAttackIVLabel);
        pokeOneSpAttackIVInput = new JTextField(20);
        evivOne.add(pokeOneSpAttackIVInput);
        
        pokeOneSpDefenseIVLabel = new JLabel("Special Defense IVs: ");
        evivOne.add(pokeOneSpDefenseIVLabel);
        pokeOneSpDefenseIVInput = new JTextField(20);
        evivOne.add(pokeOneSpDefenseIVInput);
        
        pokeOneSpeedIVLabel = new JLabel("Speed IVs: ");
        evivOne.add(pokeOneSpeedIVLabel);
        pokeOneSpeedIVInput = new JTextField(20);
        evivOne.add(pokeOneSpeedIVInput);
        
    

        pokeOne.add(evivOne);
        pokeTwo = new JPanel();
statsTwo = new JPanel();
evivTwo = new JPanel();
      


pokeTwo.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
pokeTwo.setLayout(new GridLayout(1,2));
      
statsTwo.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
statsTwo.setLayout(new GridLayout(0,1));


evivTwo.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
evivTwo.setLayout(new GridLayout(0,1));
      


pokeTwoID = new JLabel("ID: ");
statsTwo.add(pokeTwoID);


inputTwoID = new JTextField(20);
statsTwo.add(inputTwoID);


pokeTwoName = new JLabel("Name: ");
statsTwo.add(pokeTwoName);

pokeTwoSpecialName = new JLabel("Special Name: ");
statsTwo.add(pokeTwoSpecialName);

pokeTwoHP = new JLabel("HP: ");
statsTwo.add(pokeTwoHP);


pokeTwoAttack = new JLabel("Attack: ");
statsTwo.add(pokeTwoAttack);


pokeTwoDefense = new JLabel("Defense: ");
statsTwo.add(pokeTwoDefense);


pokeTwoSpAttack = new JLabel("Special Attack: ");
statsTwo.add(pokeTwoSpAttack);


pokeTwoSpDefense = new JLabel("Special Defense: ");
statsTwo.add(pokeTwoSpDefense);


pokeTwoSpeed = new JLabel("Speed: ");
statsTwo.add(pokeTwoSpeed);
      
buttonTwo = new JButton("Refresh Pokemon");
buttonTwo.addActionListener(this);
statsTwo.add(buttonTwo);

swapTwo = new JButton("Different Form");
swapTwo.addActionListener(this);
statsTwo.add(swapTwo);

pokeTwo.add(statsTwo);


pokeTwoLevelLabel = new JLabel("Level: ");
evivTwo.add(pokeTwoLevelLabel);
pokeTwoLevelInput = new JTextField(20);
evivTwo.add(pokeTwoLevelInput);




pokeTwoNatureLabel = new JLabel("Nature: ");
evivTwo.add(pokeTwoNatureLabel);
pokeTwoNatureInput = new JTextField(20);
evivTwo.add(pokeTwoNatureInput);


  
pokeTwoHPEVLabel = new JLabel("HP EVs: ");
evivTwo.add(pokeTwoHPEVLabel);
pokeTwoHPEVInput = new JTextField(20);
evivTwo.add(pokeTwoHPEVInput);


pokeTwoAttackEVLabel = new JLabel("Attack EVs: ");
evivTwo.add(pokeTwoAttackEVLabel);
pokeTwoAttackEVInput = new JTextField(20);
evivTwo.add(pokeTwoAttackEVInput);


pokeTwoDefenseEVLabel = new JLabel("Defense EVs: ");
evivTwo.add(pokeTwoDefenseEVLabel);
pokeTwoDefenseEVInput = new JTextField(20);
evivTwo.add(pokeTwoDefenseEVInput);


pokeTwoSpAttackEVLabel = new JLabel("Special Attack EVs: ");
evivTwo.add(pokeTwoSpAttackEVLabel);
pokeTwoSpAttackEVInput = new JTextField(20);
evivTwo.add(pokeTwoSpAttackEVInput);


pokeTwoSpDefenseEVLabel  = new JLabel("Special Defense EVs: ");
evivTwo.add(pokeTwoSpDefenseEVLabel);
pokeTwoSpDefenseEVInput = new JTextField(20);
evivTwo.add(pokeTwoSpDefenseEVInput);


pokeTwoSpeedEVLabel = new JLabel("Speed EVs: ");
evivTwo.add(pokeTwoSpeedEVLabel);
pokeTwoSpeedEVInput = new JTextField(20);
evivTwo.add(pokeTwoSpeedEVInput);


pokeTwoHPIVLabel = new JLabel("HP IVs: ");
evivTwo.add(pokeTwoHPIVLabel);
pokeTwoHPIVInput = new JTextField(20);
evivTwo.add(pokeTwoHPIVInput);
      
pokeTwoAttackIVLabel = new JLabel("Attack IVs: ");
evivTwo.add(pokeTwoAttackIVLabel);
pokeTwoAttackIVInput = new JTextField(20);
evivTwo.add(pokeTwoAttackIVInput);


pokeTwoDefenseIVLabel = new JLabel("Defense IVs: ");
evivTwo.add(pokeTwoDefenseIVLabel);
pokeTwoDefenseIVInput = new JTextField(20);
evivTwo.add(pokeTwoDefenseIVInput);
      
pokeTwoSpAttackIVLabel = new JLabel("Special Attack IVs: ");
evivTwo.add(pokeTwoSpAttackIVLabel);
pokeTwoSpAttackIVInput = new JTextField(20);
evivTwo.add(pokeTwoSpAttackIVInput);
      
pokeTwoSpDefenseIVLabel = new JLabel("Special Defense IVs: ");
evivTwo.add(pokeTwoSpDefenseIVLabel);
pokeTwoSpDefenseIVInput = new JTextField(20);
evivTwo.add(pokeTwoSpDefenseIVInput);
      
pokeTwoSpeedIVLabel = new JLabel("Speed IVs: ");
evivTwo.add(pokeTwoSpeedIVLabel);
pokeTwoSpeedIVInput = new JTextField(20);
evivTwo.add(pokeTwoSpeedIVInput);
      
  


pokeTwo.add(evivTwo);

calculations = new JPanel();

calculations.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
calculations.setLayout(new GridLayout(0,1));



moveTypeLabel = new JLabel("Move Type: ");
moveTypeInput = new JTextField(20);
physicalOrSpecialLabel = new JLabel("Physical");
physicalOrSpecialCheckBox = new JCheckBox("Physical or Special");
physicalOrSpecialCheckBox.addActionListener(this);    
moveBasePowerLabel = new JLabel("Base Power: ");
moveBasePowerInput = new JTextField(20);
damageRange = new JLabel("Damage will be displayed here");
calculateDamage = new JButton("Calculate Damage");
calculateDamage.addActionListener(this);

calculations.add(moveTypeLabel);
calculations.add(moveTypeInput);
calculations.add(physicalOrSpecialLabel);
calculations.add(physicalOrSpecialCheckBox);
calculations.add(moveBasePowerLabel);
calculations.add(moveBasePowerInput);
calculations.add(damageRange);
calculations.add(calculateDamage);

        frame.add(pokeOne, BorderLayout.WEST);
        frame.add(calculations, BorderLayout.CENTER);
        frame.add(pokeTwo, BorderLayout.EAST);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pokemon Damage Calculator");
        frame.getContentPane().setBackground(new Color(50, 120, 200));
        frame.setSize(500, 500);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new GUI();
    }


        public void actionPerformed(ActionEvent e){
            if(e.getSource()==buttonOne){
                try{
                    String idTextOne = inputOneID.getText();
                    pokeOneAddress = Integer.parseInt(idTextOne)-1;

                    String levelTextOne = pokeOneLevelInput.getText();
                    pokeOneLevel = Integer.parseInt(levelTextOne);

                    String natureTextOne = pokeOneNatureInput.getText();
                    pokeOneNature = Integer.parseInt(natureTextOne);

                    String hpEVTextOne = pokeOneHPEVInput.getText();
                    pokeOneHPEV = Integer.parseInt(hpEVTextOne);

                    String attackEVTextOne = pokeOneAttackEVInput.getText();
                    pokeOneAttackEV = Integer.parseInt(attackEVTextOne);

                    String defenseEVTextOne = pokeOneDefenseEVInput.getText();
                    pokeOneDefenseEV = Integer.parseInt(defenseEVTextOne);

                    String spAttackEVTextOne = pokeOneSpAttackEVInput.getText();
                    pokeOneSpAttackEV = Integer.parseInt(spAttackEVTextOne);

                    String spDefenseEVTextOne = pokeOneSpDefenseEVInput.getText();
                    pokeOneSpDefenseEV = Integer.parseInt(spDefenseEVTextOne);

                    String speedEVTextOne = pokeOneSpeedEVInput.getText();
                    pokeOneSpeedEV = Integer.parseInt(speedEVTextOne);

                    String hpIVTextOne = pokeOneHPIVInput.getText();
                    pokeOneHPIV = Integer.parseInt(hpIVTextOne);

                    String attackIVTextOne = pokeOneAttackIVInput.getText();
                    pokeOneAttackIV = Integer.parseInt(attackIVTextOne);

                    String defenseIVTextOne = pokeOneDefenseIVInput.getText();
                    pokeOneDefenseIV = Integer.parseInt(defenseIVTextOne);

                    String spAttackIVTextOne = pokeOneSpAttackIVInput.getText();
                    pokeOneSpAttackIV = Integer.parseInt(spAttackIVTextOne);

                    String spDefenseIVTextOne = pokeOneSpDefenseIVInput.getText();
                    pokeOneSpDefenseIV = Integer.parseInt(spDefenseIVTextOne);

                    String speedIVTextOne = pokeOneSpeedIVInput.getText();
                    pokeOneSpeedIV = Integer.parseInt(speedIVTextOne);

                    speciesOne = pokedex[pokeOneAddress];

                    pokemonOne = new IVEVNaturesPokemon(speciesOne, pokeOneLevel, pokeOneNature, pokeOneHPIV, pokeOneAttackIV, pokeOneDefenseIV, pokeOneSpAttackIV, pokeOneSpDefenseIV, pokeOneSpeedIV, pokeOneHPEV, pokeOneAttackEV, pokeOneDefenseEV, pokeOneSpAttackEV, pokeOneSpDefenseEV, pokeOneSpeedEV);
                    
                    
                    
                    pokeOneName.setText("Name: "  + pokemonOne.name);
                    pokeOneSpecialName.setText("Special Name: "  + pokemonOne.specialName);
                    pokeOneHP.setText("HP: " + pokemonOne.hp);
                    pokeOneAttack.setText("Attack: " + pokemonOne.attack);
                    pokeOneDefense.setText("Defense: " + pokemonOne.defense);
                    pokeOneSpAttack.setText("Special Attack: " + pokemonOne.spAttack);
                    pokeOneSpDefense.setText("Special Defense: " + pokemonOne.spDefense);
                    pokeOneSpeed.setText("Speed: " + pokemonOne.speed);

                } catch (Exception f) {
                    pokeOneName.setText("Name: Something's Wrong!");
                    pokeOneSpecialName.setText("Special Name: ");
                    pokeOneHP.setText("HP: ");
                    pokeOneAttack.setText("Attack: ");
                    pokeOneDefense.setText("Defense: ");
                    pokeOneSpAttack.setText("Special Attack: ");
                    pokeOneSpDefense.setText("Special Defense: ");
                    pokeOneSpeed.setText("Speed: ");
            }
            }
            if(e.getSource()==buttonTwo){
                try{
                    String idTextTwo = inputTwoID.getText();
                    pokeTwoAddress = Integer.parseInt(idTextTwo)-1;
 
 
                    String levelTextTwo = pokeTwoLevelInput.getText();
                    pokeTwoLevel = Integer.parseInt(levelTextTwo);
 
 
                    String natureTextTwo = pokeTwoNatureInput.getText();
                    pokeTwoNature = Integer.parseInt(natureTextTwo);
 
 
                    String hpEVTextTwo = pokeTwoHPEVInput.getText();
                    pokeTwoHPEV = Integer.parseInt(hpEVTextTwo);
 
 
                    String attackEVTextTwo = pokeTwoAttackEVInput.getText();
                    pokeTwoAttackEV = Integer.parseInt(attackEVTextTwo);
 
 
                    String defenseEVTextTwo = pokeTwoDefenseEVInput.getText();
                    pokeTwoDefenseEV = Integer.parseInt(defenseEVTextTwo);
 
 
                    String spAttackEVTextTwo = pokeTwoSpAttackEVInput.getText();
                    pokeTwoSpAttackEV = Integer.parseInt(spAttackEVTextTwo);
 
 
                    String spDefenseEVTextTwo = pokeTwoSpDefenseEVInput.getText();
                    pokeTwoSpDefenseEV = Integer.parseInt(spDefenseEVTextTwo);
 
 
                    String speedEVTextTwo = pokeTwoSpeedEVInput.getText();
                    pokeTwoSpeedEV = Integer.parseInt(speedEVTextTwo);
 
 
                    String hpIVTextTwo = pokeTwoHPIVInput.getText();
                    pokeTwoHPIV = Integer.parseInt(hpIVTextTwo);
 
 
                    String attackIVTextTwo = pokeTwoAttackIVInput.getText();
                    pokeTwoAttackIV = Integer.parseInt(attackIVTextTwo);
 
 
                    String defenseIVTextTwo = pokeTwoDefenseIVInput.getText();
                    pokeTwoDefenseIV = Integer.parseInt(defenseIVTextTwo);
 
 
                    String spAttackIVTextTwo = pokeTwoSpAttackIVInput.getText();
                    pokeTwoSpAttackIV = Integer.parseInt(spAttackIVTextTwo);
 
 
                    String spDefenseIVTextTwo = pokeTwoSpDefenseIVInput.getText();
                    pokeTwoSpDefenseIV = Integer.parseInt(spDefenseIVTextTwo);
 
 
                    String speedIVTextTwo = pokeTwoSpeedIVInput.getText();
                    pokeTwoSpeedIV = Integer.parseInt(speedIVTextTwo);

                    
 
                    speciesTwo = pokedex[pokeTwoAddress];
                    pokemonTwo = new IVEVNaturesPokemon(speciesTwo, pokeTwoLevel, pokeTwoNature, pokeTwoHPIV, pokeTwoAttackIV, pokeTwoDefenseIV, pokeTwoSpAttackIV, pokeTwoSpDefenseIV, pokeTwoSpeedIV, pokeTwoHPEV, pokeTwoAttackEV, pokeTwoDefenseEV, pokeTwoSpAttackEV, pokeTwoSpDefenseEV, pokeTwoSpeedEV);
                   
                   
                   
                    pokeTwoName.setText("Name: "  + pokemonTwo.name);
                    pokeTwoSpecialName.setText("Special Name: "  + pokemonTwo.specialName);
                    pokeTwoHP.setText("HP: " + pokemonTwo.hp);
                    pokeTwoAttack.setText("Attack: " + pokemonTwo.attack);
                    pokeTwoDefense.setText("Defense: " + pokemonTwo.defense);
                    pokeTwoSpAttack.setText("Special Attack: " + pokemonTwo.spAttack);
                    pokeTwoSpDefense.setText("Special Defense: " + pokemonTwo.spDefense);
                    pokeTwoSpeed.setText("Speed: " + pokemonTwo.speed);
 
 
                } catch (Exception f) {
                    pokeTwoName.setText("Name: Something's Wrong!");
                    pokeTwoSpecialName.setText("Special Name: ");
                    pokeTwoHP.setText("HP: ");
                    pokeTwoAttack.setText("Attack: ");
                    pokeTwoDefense.setText("Defense: ");
                    pokeTwoSpAttack.setText("Special Attack: ");
                    pokeTwoSpDefense.setText("Special Defense: ");
                    pokeTwoSpeed.setText("Speed: ");
            }
            }
            if(e.getSource()==swapOne){
                if(speciesOne.alternate!=null){
                    speciesOne = speciesOne.alternate;
                
                }
                else{
                    speciesOne = pokedex[pokeOneAddress];
                   
                }
                pokemonOne = new IVEVNaturesPokemon(speciesOne, pokeOneLevel, pokeOneNature, pokeOneHPIV, pokeOneAttackIV, pokeOneDefenseIV, pokeOneSpAttackIV, pokeOneSpDefenseIV, pokeOneSpeedIV, pokeOneHPEV, pokeOneAttackEV, pokeOneDefenseEV, pokeOneSpAttackEV, pokeOneSpDefenseEV, pokeOneSpeedEV);
                pokeOneName.setText("Name: "  + pokemonOne.name);
                pokeOneSpecialName.setText("Special Name: "  + pokemonOne.specialName);
                pokeOneHP.setText("HP: " + pokemonOne.hp);
                pokeOneAttack.setText("Attack: " + pokemonOne.attack);
                pokeOneDefense.setText("Defense: " + pokemonOne.defense);
                pokeOneSpAttack.setText("Special Attack: " + pokemonOne.spAttack);
                pokeOneSpDefense.setText("Special Defense: " + pokemonOne.spDefense);
                pokeOneSpeed.setText("Speed: " + pokemonOne.speed);

            }
            if(e.getSource()==swapTwo){
                if(speciesTwo.alternate!=null){
                    speciesTwo = speciesTwo.alternate;
                
                }
                else{
                    speciesTwo = pokedex[pokeTwoAddress];
                   
                }
                pokemonTwo = new IVEVNaturesPokemon(speciesTwo, pokeTwoLevel, pokeTwoNature, pokeTwoHPIV, pokeTwoAttackIV, pokeTwoDefenseIV, pokeTwoSpAttackIV, pokeTwoSpDefenseIV, pokeTwoSpeedIV, pokeTwoHPEV, pokeTwoAttackEV, pokeTwoDefenseEV, pokeTwoSpAttackEV, pokeTwoSpDefenseEV, pokeTwoSpeedEV);
                pokeTwoName.setText("Name: "  + pokemonTwo.name);
                pokeTwoSpecialName.setText("Special Name: "  + pokemonTwo.specialName);
                pokeTwoHP.setText("HP: " + pokemonTwo.hp);
                pokeTwoAttack.setText("Attack: " + pokemonTwo.attack);
                pokeTwoDefense.setText("Defense: " + pokemonTwo.defense);
                pokeTwoSpAttack.setText("Special Attack: " + pokemonTwo.spAttack);
                pokeTwoSpDefense.setText("Special Defense: " + pokemonTwo.spDefense);
                pokeTwoSpeed.setText("Speed: " + pokemonTwo.speed);

            }
            if(e.getSource()==physicalOrSpecialCheckBox){
                if(physicalOrSpecialCheckBox.isSelected()){
                    physicalOrSpecialLabel.setText("Special");
                }
                else physicalOrSpecialLabel.setText("Physical");
            }
            if(e.getSource()==calculateDamage){
                String moveTypeString = moveTypeInput.getText();
                int moveType = Integer.parseInt(moveTypeString);
                Boolean physicalOrSpecial = physicalOrSpecialCheckBox.isSelected();
                String moveBasePowerString = moveBasePowerInput.getText();
                int moveBasePower = Integer.parseInt(moveBasePowerString);
                int[] highAndLow = returnDamageRange(pokemonOne, pokemonTwo, physicalOrSpecial, moveType, moveBasePower);
                damageRange.setText("Range: " + highAndLow[0] + "-" + highAndLow[1]);
                
                
            }
 
 
            


        }
        public int[] returnDamageRange(IVEVNaturesPokemon pokemonOne, IVEVNaturesPokemon pokemonTwo, Boolean special, int type, int basePower){
            int attack;
            int defense;
            if(!special){
                attack = pokemonOne.attack;
                defense = pokemonTwo.defense;
            }
            else{
                attack = pokemonOne.spAttack;
                defense = pokemonTwo.spDefense;
            }
            double type1Effectiveness = typeEffectiveness[type][pokemonTwo.type1];
            double type2Effectiveness = 1;
            if(pokemonTwo.type2!=-1){
                type2Effectiveness = typeEffectiveness[type][pokemonTwo.type2];
            } 
            double stab = 1;
            if(type==pokemonOne.type1||type==pokemonOne.type2){
                stab = 1.5;
            }
            double lowDamage = ((((((2*pokemonOne.level)/5)+2)*basePower*attack/defense)/50)+2) * type1Effectiveness * type2Effectiveness * stab * 0.85;
            double highDamage = ((((((2*pokemonOne.level)/5)+2)*basePower*attack/defense)/50)+2) * type1Effectiveness * type2Effectiveness * stab;
           int[] highAndLow = {(int)lowDamage, (int)highDamage};
           return highAndLow;
        }

    }

