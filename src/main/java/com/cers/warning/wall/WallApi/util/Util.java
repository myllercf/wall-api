package com.cers.warning.wall.WallApi.util;

import java.util.Collection;

public class Util {
	
	public static boolean stringIsNullOrEmpty(String src) {
		return src == null || src.isEmpty();
	}
	
	public static boolean listaVazia(Collection coll) {
	    return (coll == null || coll.isEmpty());
	}

}
