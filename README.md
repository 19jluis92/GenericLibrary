# GenericLibrary
#How you use the generic object for java and lambda, optional jsp
#like this
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
