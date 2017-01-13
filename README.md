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
