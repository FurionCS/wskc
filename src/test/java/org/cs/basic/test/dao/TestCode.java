package org.cs.basic.test.dao;

import java.util.Date;

import org.junit.Test;

public class TestCode {

	public static void main(String[] args) {
		
			String code=Long.toHexString(new Date().getTime());
			System.out.println(code);
		
	}

}
