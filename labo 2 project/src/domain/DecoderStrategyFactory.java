package domain;

import java.lang.reflect.Constructor;

public class DecoderStrategyFactory {
	public static DecoderStrategy createDecoderStrategy(String type, Object... args) {
		DecoderStrategy instance = null;
		
		Class <?> [] arg = new Class[args.length];
		int tel = 0;
		for (Object object:args){
			arg[tel++] = object.getClass();
		}
		
		try {
			Class<?> classs = Class.forName(type);
			Constructor<?> constructor = classs.getConstructor(arg); 
			instance = (DecoderStrategy)constructor.newInstance(args);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return instance;
	}
}
