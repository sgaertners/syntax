package syntaxparser;
/**
 * Copyright [2016] [Stefan Gaertners, Wesel]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

 */
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Syntax {
	
	private String identifier; 
	private boolean debug;
	private String analyze;
	String checkPattern;
/**
 * Class constructor	
 */
	public Syntax () {
		identifier = "Syntax v1.0, written 11/2016 by Stefan Gärtners, Wesel\n";
		errorList = new SyntaxErrorList();
		patternList = new ArrayList<String>();
		checkPattern = "";
		debug = false;
	}
// List of all Syntaxerrors	
	SyntaxErrorList errorList;
// List of all Patterns	
	public ArrayList<String> patternList;
// Matcher
	Matcher mat;
	
/**
 * Original author
 * 	
 * @return
 */
	public String getIdentifier() {
		return identifier;
	}
	
/**
 * Check if an error occurs
 * 
 * @return true/false
 */
	public boolean hasError() {
		return !errorList.isEmpty();
	};
	
/**
 * Add syntax pattern to pattern list
 * 
 * @param pattern
 */
	public void addPattern(String pattern) {
		patternList.add(pattern);
	}

/**
 * returns the line which will be checked.
 * 	
 * @return
 */
	public String getAnalyze() {
		return analyze;
	}

/**
 * Set the line which will be checked.
 * 	
 * @param analyze
 */
	public void setAnalyze(String analyze) {
		this.analyze = analyze;
	}
	
	
/**
 * Check syntax
 * 	
 * @param line
 * @return corrected line
 */
	public boolean checkSyntax(String line) {
		errorList.clear();
		analyze = line;
		// For now, simply return the checked line, no correction will be done!
		String pattern = patternList.get(0);
		boolean okay = analyze.matches(pattern);

		Pattern p = Pattern.compile(pattern);
		mat = p.matcher(analyze);		
						
		while (mat.find()) {
			checkPattern = mat.group();
			if (isDebug()) {
	            System.out.print("Start index: " + mat.start());
	            System.out.print(" End index: " + mat.end() + " ");
	            System.out.println(mat.group());
	            dumpPatternGroups();
			}
		}
		
		boolean groupError = false;
		
		for (int i = 1; i <= mat.groupCount(); i++) {
			try {
				if (mat.start(i) == -1 ) {					
					groupError = true;
					break;
				}
			} catch (IllegalStateException e) {
				SyntaxError synErr = new SyntaxError();
				synErr.setLineNumber(1);
				synErr.setNumberOfPattern(1);
				synErr.setOriginal(analyze);
				synErr.setErrorMessage(e.getLocalizedMessage());
				errorList.addError(synErr);
				explainError(1,1);
				groupError = false;
				break;
			}
		}
		
		return okay && !groupError;
	}
	
	
/**
 * explains an error
 * 	
 * @param iLineNum
 * @param iPatNum
 */
	public void explainError(int iLineNum, int iPatNum) {
		int i = 0;
		int len = checkPattern.length();
		if (len > 0) {
			for (int j = 0; j < checkPattern.length()-1; j++) {
				char c1 = checkPattern.charAt(j);
				char c2 = analyze.charAt(j);
				if (c1 != c2) {
					SyntaxError synErr = new SyntaxError();
					synErr.setLineNumber(iLineNum);
					synErr.setNumberOfPattern(iPatNum);
					synErr.setOriginal(analyze);
					synErr.setPosInLine(j);
					synErr.setErrorMessage("'" + c1 + "' Char is not matching!");
					errorList.addError(synErr);
					checkPattern = "";
					break;
				}
			}
		} else {
			SyntaxError synErr = new SyntaxError();
			synErr.setLineNumber(iLineNum);
			synErr.setNumberOfPattern(iPatNum);
			synErr.setOriginal(analyze);
			synErr.setErrorMessage("String is not matching!");
			errorList.addError(synErr);			
		}
	}
	
	
/**
 * 	
 */
	public void dumpPatternGroups() {
		if (isDebug()) {
			System.out.println("Number of Patterngroups: " + mat.groupCount());
			for (int i = 0; i <= mat.groupCount(); i++) {
				System.out.println("PATTERNGROUP " + i + ": " + mat.group(i));
			}
		}
	}

/**
 * Is debuging enabled or not.
 * 	
 * @return
 */	
	public boolean isDebug() {
		return debug;
	}

/**
 * Controls debugging output.
 * 	
 * @param debug
 */	
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
/**
 * Enbables debug output
 */
	public void enableDebug() {
		this.debug = true;
	}

/**
 * Disables debug output
 */
	public void disableDebug() {
		this.debug = false;
	}

public SyntaxErrorList getErrorList() {
	return errorList;
}
	
}
