package com.structure.common;

import org.springframework.stereotype.Component;

@Component
public class CommonFunctions implements SuperFunctions {

	public void startLog(String log) {
		normalLog("start", log);
	}

	public void endLog(String log) {
		normalLog("end", log);
	}

	public void invalidLog(String log) {
		normalLog("invalid", log);
	}

	private void normalLog(String prefix, String log) {
		String output = "[" + prefix + "]: " + log;
		System.out.println(output);
	}
}
