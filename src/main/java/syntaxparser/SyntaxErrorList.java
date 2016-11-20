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
import java.util.Iterator;

public class SyntaxErrorList {

	public SyntaxErrorList() {
		errors = new ArrayList<SyntaxError>();
		errors.clear();
	}
	
	private ArrayList<SyntaxError> errors;
	
	public void addError(SyntaxError error) {
		String msg = error.getErrorMessage();
		boolean found = false;
		
		for (Iterator iterator = errors.iterator(); iterator.hasNext();) {
			SyntaxError syntaxError = (SyntaxError) iterator.next();
			if (syntaxError.getErrorMessage().equals(msg)) {
				found = true;
			}
		}
		
		if (!found ) {
			errors.add(error);
		}
	}
	
	public boolean isEmpty() {
		return errors.isEmpty();
	}
	
	public void clear() {
		errors.clear();
	}
	
	public String getAllErrorMsg() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < errors.size(); i++) {
			sb.append(errors.get(i).getErrorMessage());
			sb.append(" ");
		}
		return sb.toString();
	}
}
