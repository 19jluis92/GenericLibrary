# GenericLibrary
# Library for generic object for java and lambda, optional  you can use jsp

I   could not to  read a Object type from java inside the jsp so  a need to create a functiion for that because 
jsp can not read this type the object.
This is the lambda I used for  create my generic object and I tried to read this inside the JSP and  this  was my solution.

sitioRepository.findList(alias, params, SitioRegistro.class).stream().map(x ->{ return  new Object(){
				public long id = x.getSubclasificacionInmueble().getClasificacionInmueble().getId();
				public String name = x.getSubclasificacionInmueble().getClasificacionInmueble().getClasificacionInmueble();
				public long getId() {
					return id;
				}
				public void setId(long id) {
					this.id = id;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}		
			}; } ).collect(Collectors.toList());

If you only need to work inside the Java code  you only need the library but if you need to use 
inside the JSP you will need  make this:

Then make a file called generictaglib.tld in WEB-INF/tags/:

<?xml version="1.0" encoding="UTF-8"?>
<taglib version="2.1" xmlns="http://java.sun.com/xml/ns/javaee"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_2_1.xsd">
 <tlib-version>1.0</tlib-version>
 <short-name>generic</short-name>
 
 	<function>
          <name>getValue</name>
          <function-class>GenericPackage.GenericUtilities</function-class>
          <function-signature>java.lang.String getValue(java.lang.Object,java.lang.CharSequence)</function-signature>
     	</function>  
</taglib>

So Note the function part, which specified the name of the new EL function, what class it resides in and its function signature.

The uri would be used if we were accessing this directly, but instead we’ll be accessing the url from the web.xml below:

<web-app 
        xmlns="http://java.sun.com/xml/ns/j2ee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd"
        version="2.4">

        ...

       <jsp-config>
       <taglib>
         <taglib-uri>
           http://localhost/generic
         </taglib-uri>
         <taglib-location>
           /WEB-INF/tags/generictaglib.tld
         </taglib-location>
       </taglib> 
       </jsp-config>

       ...

     </web-app>
     
     Note we’re pointing to the generictaglib.tld file just created. And taglib-uri is how we’ll refer to it in the JSP:
     
     <%@ taglib uri="http://localhost/generice" prefix="gr" %> 

    ${gr:getValue(Object,"id")}
