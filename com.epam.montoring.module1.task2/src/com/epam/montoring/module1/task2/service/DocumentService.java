package com.epam.montoring.module1.task2.service;

import com.epam.montoring.module1.task2.model.Document;
import com.epam.montoring.module1.task2.model.XmlDocument;

/**
 * @author Aliaksei_Volkau
 *
 * example that not follow SOLID principle:
 * 
 * I - Interface segregation principle
 * “many client-specific interfaces are better than one general-purpose interface.”
 * 
 * interface is multi-purpose
 */
public interface DocumentService {
	
	void print(Document document);
	
	void doPrintXml(XmlDocument document);

	Document createDocument();
	
	void fillDocument(Document document);
}
