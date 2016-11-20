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
public class SyntaxParser {

	public static void main(String[] args) {		
		SyntaxStrings synChars = new SyntaxStrings();
		Syntax syn = new Syntax();
		System.out.println(syn.getIdentifier());
		syn.enableDebug();
//		syn.disableDebug();
		syn.addPattern(synChars.getToken()+synChars.getAssign()+synChars.getdQuotes()+synChars.getToken()+synChars.getdQuotes()+synChars.getInstrEnd());
		
		if (syn.checkSyntax("eins=\"AAAA\";")) {
			System.out.println("\nSTATUS: OKAY, die Zeichenkette " + syn.getAnalyze() + " entspricht dem Pattern!");
		} else {
			if (syn.hasError()) {
				System.out.println("\nSTATUS: NICHT OKAY, die Zeichenkette " + syn.getAnalyze() + " entspricht nicht dem Pattern!");
				System.out.println(syn.getErrorList().getAllErrorMsg());
			}
		}	
		
		if (syn.checkSyntax("eins==\"AAA\";")) {
			System.out.println("\nSTATUS: OKAY, die Zeichenkette " + syn.getAnalyze() + " entspricht dem Pattern!");
		} else {
			if (syn.hasError()) {
				System.out.println("\nSTATUS: NICHT OKAY, die Zeichenkette " + syn.getAnalyze() + " entspricht nicht dem Pattern!");
				System.out.println(syn.getErrorList().getAllErrorMsg());
			}
		}
		
		if (syn.checkSyntax("eins=\"AAAA\"")) {
			System.out.println("\nSTATUS: OKAY, die Zeichenkette " + syn.getAnalyze() + " entspricht dem Pattern!");
		} else {
			if (syn.hasError()) {
				System.out.println("\nSTATUS: NICHT OKAY, die Zeichenkette " + syn.getAnalyze() + " entspricht nicht dem Pattern!");
				System.out.println(syn.getErrorList().getAllErrorMsg());
			}
		}	
	}

}