package me.espiiii.test.spigot.pluginTest.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnagramType 
{

	public String defaultWorld;
	public String anagram;
	public Boolean activity;
	
	public AnagramType(String defaultWorld)
	{
		
		this.defaultWorld = defaultWorld;
		this.anagram = randomLetters(defaultWorld);
		this.activity = true;
		
		
	}
	public String randomLetters(String w){
        List<Character> chara = new ArrayList<Character>();
        for(char c:w.toCharArray()){
            chara.add(c);
        }
        StringBuilder output = new StringBuilder(w.length());
        while(chara.size()!=0){
            int randPicker = (int)(Math.random()*chara.size());
            output.append(chara.remove(randPicker));
        }
        return output.toString();
    }
	public static ArrayList<AnagramType> defaultListAnagram() 
	{
		
		ArrayList<AnagramType> anagramList = new ArrayList<AnagramType>();
		AnagramType anagram1 = new AnagramType("Espiiii");
		AnagramType anagram2 = new AnagramType("Vivisoubar");
		AnagramType anagram3 = new AnagramType("Saucisse");
		AnagramType anagram4 = new AnagramType("onyxworld");
		AnagramType anagram5 = new AnagramType("prison");
		AnagramType anagram6 = new AnagramType("rushffa");
		
		anagramList.add(anagram6);
		anagramList.add(anagram5);
		anagramList.add(anagram4);
		anagramList.add(anagram3);
		anagramList.add(anagram2);
		anagramList.add(anagram1);
		
		return anagramList;
		
	}
	public static int random(int min, int max)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
		
	}
	
}
