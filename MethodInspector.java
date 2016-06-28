import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodInspector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class  inspect;
		try{
			if(args.length>0){
				inspect=Class.forName(args[0]);
			}else{
				inspect=Class.forName("MethodInspector");
			}
			Method[] methods=inspect.getDeclaredMethods();
			for(int i=0;i<methods.length;i++){
				Method methVal=methods[i];
				Class retuVal=methVal.getReturnType();
				int mods=methVal.getModifiers();
				String modVal=Modifier.toString(mods);
				Class[] paramVal=methVal.getParameterTypes();
				StringBuffer params=new StringBuffer();
				for(int j=0;j<paramVal.length;j++){
					if(j>0){
						params.append(", ");
					}
					params.append(paramVal[j].getName());
				}
				System.out.println("Method: "+methVal.getName()+"()");
				System.out.println("Modifiers: "+modVal);
				System.out.println("Return Type: "+retuVal.getName());
				System.out.println("Parameters: "+params+"\n");
			}
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}

}
