package com.webapp.common;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Collection;
import java.util.Map;

public final class ApplicationUtils{

	private ApplicationUtils() {
		throw new IllegalAccessError("Utility class");
	}

	
	public static String getJVMRootOrEmpty() {
		RuntimeMXBean runtimemxBean = ManagementFactory.getRuntimeMXBean();
		String serverRoot = null;

		serverRoot = runtimemxBean.getSystemProperties().get("server.root");
		if ((serverRoot != null) && (!("".equals(serverRoot))))
			if (!(serverRoot.endsWith("/"))) {
				serverRoot = serverRoot.concat("/");
			} else {
				serverRoot="";
			} 
		return serverRoot;
	}
	
    /**
     * fsilverio
     * 
     * Este método verifica se um dado objecto é nulo ou está vazio
     * @param obj a referência para o objecto
     * @return true se o objecto for nulo ou vazio, false caso contrário
     */
    public static boolean checkIfNullOrEmpty(Object obj) {
        boolean conditionA = false;
        boolean conditionB = false;
        // 01. tratar de objectos nulos
        conditionA = (obj == null);
        if(conditionA) return true;
        // 02. tratar de arrays
        conditionA = (obj.getClass().isArray());
        conditionB = (conditionA && ((Object[])obj).length == 0);
        if(conditionB) return true;
        // 03. tratar de strings
        conditionA = (String.class.isInstance(obj));
        conditionB = (conditionA && "".equalsIgnoreCase((String)obj));
        if(conditionB) return true;
        // 04. tratar de colecções: List, Vector, ... tudo o que derive de java.util.Collection
        conditionA = (Collection.class.isInstance(obj));
        conditionB = (conditionA && ((Collection<?>)obj).size() == 0);
        if(conditionB) return true;
        // 05. tratar de colecções: Map... tudo o que derive de java.util.Collection
        conditionA = (Map.class.isInstance(obj));
        conditionB = (conditionA && ((Map<?,?>)obj).size() == 0);
        if(conditionB) return true;
        return false;
    }
    
    
	
}