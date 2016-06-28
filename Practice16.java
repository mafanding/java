import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Practice16 {
	public static void main(String[] args){
		if(args.length>0){
			boolean application=isApplication(args[0]);
			if(application){
				System.out.println("True");
			}else{
				System.out.println("Fail");
			}
			try{
			Class c=Class.forName(args[0]);
			Object obj=c.newInstance();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}else{
			System.out.println("Error");
			System.exit(-1);
		}
	}
	
	private static boolean isApplication(String className){
		try{
		Class application=Class.forName(className);
		Method[] methods=application.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			Method method=methods[i];
			Class returnVal=method.getReturnType();
			int mods=method.getModifiers();
			String modsVal=Modifier.toString(mods);
			Class[] paramsVal=method.getParameterTypes();
			String params = "";
			for(int j=0;j<paramsVal.length;j++){
				params+=paramsVal[j].getName();
			}
			if(modsVal.equals("public static")&params.equals("[Ljava.lang.String;")&method.getName()=="main"&returnVal.getName()=="void"){
				return true;
			}
		}
		return false;
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
}
