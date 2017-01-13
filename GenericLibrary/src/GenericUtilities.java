
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 *
 * @author jluis
 */
public class GenericUtilities {
    	/**
	 * Metodo que devuelve la columna especifica de un generico.
	 * 
	 * 
	 * @author jose luis
	 * 
	 * @param data
	 * @param column
	 * @return Value
	 */
	public static String getValue(Object data, CharSequence column){
		//========================================
		
		//========================================
		for (Method method : data.getClass().getDeclaredMethods()) {
		    if (Modifier.isPublic(method.getModifiers())
		        && method.getParameterTypes().length == 0
		        && method.getReturnType() != void.class
		        && method.getName().toLowerCase().contains(column)
		        && (method.getName().startsWith("get") || method.getName().startsWith("is"))
		    ) {
		    	method.setAccessible(true);
		        Object value = null;
				try {
					value = method.invoke(data);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        if (value != null) {
		           return  value.toString();
		        }
		    }
		}
		return "";
		
	}
}
