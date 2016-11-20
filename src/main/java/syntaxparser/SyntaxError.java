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
public class SyntaxError {

	public SyntaxError() {
		lineNumber = 0;
		posInLine = 0;
		numberOfPattern = 0;
		original = "";
		corrected = "";
		errorMessage = "";
	}
	
	private Integer lineNumber;
	private Integer posInLine;
	private Integer numberOfPattern;
	private String original;	
	private String corrected;
	private String errorMessage;
	
	public Integer getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}
	public Integer getPosInLine() {
		return posInLine;
	}
	public void setPosInLine(Integer posInLine) {
		this.posInLine = posInLine;
	}
	public Integer getNumberOfPattern() {
		return numberOfPattern;
	}
	public void setNumberOfPattern(Integer numberOfPattern) {
		this.numberOfPattern = numberOfPattern;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	public String getCorrected() {
		return corrected;
	}
	public void setCorrected(String corrected) {
		this.corrected = corrected;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
