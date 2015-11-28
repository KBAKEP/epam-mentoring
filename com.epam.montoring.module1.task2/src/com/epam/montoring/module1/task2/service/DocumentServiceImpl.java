package com.epam.montoring.module1.task2.service;

import com.epam.montoring.module1.task2.model.Document;

public abstract class DocumentServiceImpl implements DocumentService {

	public NotSolidSerivceImpl notSolidSerivceImpl;
	
	public void print(Document document) {
		
		sendToPrinter();
	}

	private void sendToPrinter() {
		// it should work
	}
	
	/**
	 * @author Aliaksei_Volkau
	 *
	 * example that not follow SOLID principle:
	 * 
	 * D - Dependency inversion principle
	 * one should “Depend upon Abstractions. Do not depend upon concretions."
	 * 
	 * abstract class depends on child concretion class
	 */
	public Document createDoc(Document document) {
		return notSolidSerivceImpl.createDocument();
	}

}
