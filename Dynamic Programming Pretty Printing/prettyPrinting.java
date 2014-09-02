import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class prettyPrinting {

	public static void main(String[] args) {
		Data data = new Data();
		data = getInput();
		prettyPrint(data);
	}
	
	//pretty print algorithm 
	public static void prettyPrint(Data data){
		ArrayList<String> words = data.getWords();
		ArrayList<Integer> charactersPerWord = data.getcharactersPerWord();
		
		ArrayList<Integer> OPT = new ArrayList<Integer>();
		ArrayList<Integer> IndexofOPTsolution = new ArrayList<Integer>();
		
		ArrayList<Integer> localOPT = new ArrayList<Integer>();
		ArrayList<Integer> localWords = new ArrayList<Integer>();
		
		int lineLength = data.getLineLength();
		int line = 0;

		
		for( int j = 0; j < words.size(); j++){
			
			for(int i = 0; i <= j; i++){
				
				for( int k = i; k <= j;k++){
					line  = line + charactersPerWord.get(k);
				}
				
				int slack = lineLength - line;
				slack = slack * slack;
				
				if(line <= lineLength){
					if(i == 0){
						// there is no opt[i] when i == 0
						localOPT.add(slack);
						localWords.add((j +1)-i);
					}else{
						localOPT.add(slack + OPT.get(i-1));
						localWords.add((j +1)-i);
					}
				}else{
					// the characters exceeded the line length, not usable
					localOPT.add(Integer.MAX_VALUE);
					localWords.add((j +1)-i);
				}
					
				line = 0;
				slack = 0;
				
			}
			int min = Integer.MAX_VALUE;
			int IndexUsed = 0;
			for(int i = 0; i < localOPT.size(); i++){
				if(localOPT.get(i) < min){
					min = localOPT.get(i);
						IndexUsed = i;
				}
			}
			
			OPT.add(min);
			IndexofOPTsolution.add(IndexUsed);
			localOPT.clear();
			localWords.clear();
		}
		
		ArrayList<String> storeOutput = new ArrayList<String>();
		String tempLine = "";
		int start = 1;
		int Max = words.size() -1;
		System.out.println("");
		while( start > 0){
			start= IndexofOPTsolution.get(Max);
			for(int i = start; i <= Max; i++){
				tempLine = tempLine + words.get(i) + " ";
			}
			System.out.println("");
			Max = start -1;
			storeOutput.add(0, tempLine);
			tempLine = "";
		}
		
		for(int i = 0; i < storeOutput.size(); i++){
			System.out.println(storeOutput.get(i));
		}
	}
	
	// Reads in the original text from a file
	public static Data getInput() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> charactersPerWord = new ArrayList<Integer>();
		String[] splitWords;
		String line = "";
		int lineNumber = 0;
		int lineLength = 0;
		Data dataToPass = new Data();
		
		try {
			while( (line = bReader.readLine()) != null && line.length() != 0){
				if(lineNumber == 0){
					lineLength = Integer.parseInt(line);
				}else{
					splitWords = line.split(" ");
					for( int i = 0; i < splitWords.length; i++){
						words.add(splitWords[i]);
						// add one for the space after the word
						charactersPerWord.add(splitWords[i].length() + 1);
					}
				}
				// used to exclude the first line, the length of each line
				lineNumber++;
			}
		} catch (IOException ioe) {
			System.out.println("Buffer Reader Fail");
		}
		dataToPass.setData(words, charactersPerWord, lineLength);
		return dataToPass;
	}
	
	// Small object used to transfer several pieces of data from function to function
	public static class Data{
		
		ArrayList<String> wordsToPass = new ArrayList<String>();
		ArrayList<Integer> charactersPerWordToPass = new ArrayList<Integer>();
		int lineLengthToPass = 0;
		
		public Data(){
			
		}
		
		public void setData(ArrayList<String> words, ArrayList<Integer> charactersPerLine, int lineLength){
			wordsToPass = words;
			charactersPerWordToPass = charactersPerLine;
			lineLengthToPass = lineLength;
		}
		
		public ArrayList<String> getWords(){
			return wordsToPass;
		}
		
		public ArrayList<Integer> getcharactersPerWord(){
			return charactersPerWordToPass;
		}
		
		public int getLineLength(){
			return lineLengthToPass;
		}
		
	}

}
