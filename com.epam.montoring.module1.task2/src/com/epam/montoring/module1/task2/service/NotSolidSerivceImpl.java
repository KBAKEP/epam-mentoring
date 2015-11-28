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
 * O - Open/closed principle:
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
	 *  O - Open/closed principle
	 *	“software entities … should be open for extension, but closed 
	 *	for modification.”
	 *
	 *	method is modified in child class by overriding
	 */
	@Override
	public void print(Document document) {
		if (document instanceof XmlDocument) {
			doPrintXml((XmlDocument)document);
		}
	}
	
	@Override
	public void doPrintXml(XmlDocument document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Document createDocument() {
		
		return new Document();
	}
	
	@Override
	public void fillDocument(Document document) {
		
	}
	
}
