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
public class SyntaxStrings {

	public SyntaxStrings() {
		lineStart = "";
		space = " ";
	    setLineEnd("\n");
	    filler = "";
	    setdQuotes("\"");
	    sQuotes = "'";
	    setInstrEnd(";");
	    setToken("\\w*");
	    setAssign("=");
	}
	
// Start of Line	
	public String lineStart;
// 	
	public String space;
// End of Line	
	public String lineEnd;
// Fill char/string	
	public String filler;
// double quotes	
	public String dQuotes;
// single quotes	
	public String sQuotes;
// instruction end	
	public String instrEnd;
// token
	public String token;
// Assignment
	public String assign;
	
	public String getLineStart() {
		return lineStart;
	}
	public void setLineStart(String lineStart) {
		this.lineStart = lineStart;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getLineEnd() {
		return lineEnd;
	}
	public void setLineEnd(String lineEnd) {
		this.lineEnd = "("+lineEnd+")";
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public String getdQuotes() {
		return dQuotes;
	}
	public void setdQuotes(String dQuotes) {
		this.dQuotes = "("+dQuotes+")";
	}
	public String getsQuotes() {
		return sQuotes;
	}
	public void setsQuotes(String sQuotes) {
		this.sQuotes = sQuotes;
	}
	public String getInstrEnd() {
		return instrEnd;
	}
	public void setInstrEnd(String instrEnd) {
		this.instrEnd = "("+instrEnd+")";
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = "("+token+")";
	}
	public String getAssign() {
		return assign;
	}
	public void setAssign(String assign) {
		this.assign = "("+assign+")";
	}

}
