package sample.utility;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.TreeSet;

public class ArgsParser {
	  private String[] args = null;

	  private HashMap<String, Integer> switchIndexes = new HashMap<String, Integer>();
	  private TreeSet<Integer> takenIndexes  = new TreeSet<Integer>();
	  
	  public ArgsParser (String[] args){
		  this.args = args;
		  switchIndexes.clear();
		  takenIndexes.clear();
		  for(int i=0; i < args.length; i++) {
			  if(args[i].startsWith("-") ){
				  switchIndexes.put(args[i], i);
			      takenIndexes.add(i);
			  }
		  }
	  }

	  public String[] args() {
	    return args;
	  }

	  public String arg(int index){
	    return args[index];
	  }

	  public boolean switchPresent(String switchName) {
	    return switchIndexes.containsKey(switchName);
	  }

	  public String switchValue(String switchName) {
	    return switchValue(switchName, null);
	  }

	  public String switchValue(String switchName, String defaultValue) {
	    if(!switchIndexes.containsKey(switchName)) return defaultValue;
	    
	    int switchIndex = switchIndexes.get(switchName);
	    if(switchIndex + 1 < args.length){
	      takenIndexes.add(switchIndex +1);
	      return args[switchIndex +1];
	    }
	    return defaultValue;
	  }

	  public String[] switchValues(String switchName) {
	    if(!switchIndexes.containsKey(switchName)) return new String[0];
	    
	    int switchIndex = switchIndexes.get(switchName);
	    
	    int nextArgIndex = switchIndex + 1;
	    while(nextArgIndex < args.length && !args[nextArgIndex].startsWith("-")){
	      takenIndexes.add(nextArgIndex);
	      nextArgIndex++;
	    }

	    String[] values = new String[nextArgIndex - switchIndex - 1];
	    for(int j=0; j < values.length; j++){
	      values[j] = args[switchIndex + j + 1];
	    }
	    return values;
	  }

	  public <T> T switchPojo(Class<T> pojoClass){
	    try {
	      T pojo = pojoClass.newInstance();
	    
	      Field[] fields = pojoClass.getFields();
	      for(Field field : fields) {
	        Class<?> fieldType = field.getType();
	        String fieldName = field.getName();
	        
	        if(fieldType.equals(Boolean.class) || fieldType.equals(boolean.class)){
	          field.set(pojo, switchPresent(fieldName) );
	        } else if(fieldType.equals(String.class)){
	          if(switchValue(fieldName) != null){
	            field.set(pojo, switchValue(fieldName ) );
	          }
	        } else if(fieldType.equals(String[].class)){
	          String[] values = switchValues(fieldName);
	          if(values.length != 0){
	            field.set(pojo, values);
	          }
	        }
	      }
	    
	      return pojo;
	    } catch (Exception e) {
	      throw new RuntimeException("Error creating switch POJO", e);
	    }
	  }

	  public String[] targets() {
		  String[] targetArray = new String[args.length - takenIndexes.size()];
		  int targetIndex = 0;
		  for(int i = 0; i < args.length ; i++) {
			  if(!takenIndexes.contains(i) ) {
				  targetArray[targetIndex++] = args[i];
		      }
		  }
		  return targetArray;
	  }
}