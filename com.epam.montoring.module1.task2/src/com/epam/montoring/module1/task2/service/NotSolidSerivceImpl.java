package com.epam.montoring.module1.task2.service;

import com.epam.montoring.module1.task2.model.Document;
import com.epam.montoring.module1.task2.model.XmlDocument;


/**
 * @author Aliaksei_Volkau
 *
 * example that not follow SOLID principle:
 * 
 * S -Single responsibility principle: class is responsible for creation and 
 * filling and printing of document
 */
public class NotSolidSerivceImpl extends DocumentServiceImpl {
	
	/**
	 * @param document
	 * 
	 * L - Liskov substitution principle:
	 * 
	 * “objects in a program should be replaceable with instances of their 
	 * subtypes without altering the correctness of that program.”
	 * 
	 * it can only work with child class
	 * 
	 */
	@Override
	public void print(Document document) {
		if (document instanceof XmlDocument) {
			doPrintXml((XmlDocument)document);
		}
	}
	
	@Override
	public void doPrintXml(XmlDocument document) {
//		 *  O - Open/closed principle
//		 *	“software entities … should be open for extension, but closed 
//		 *	for modification.”
//		 *
//		 * it needs to modify entity to change printing mechanism
	    
//	         * D - Dependency inversion principle
//	         * one should “Depend upon Abstractions. Do not depend upon concretions."
//	         * 
//	         * using concrete class, not an interface/abstraction
	        
		document.print();
		
	}

	@Override
	public Document createDocument() {
		
		return new Document();
	}
	
	@Override
	public void fillDocument(Document document) {
		
	}
	
}
