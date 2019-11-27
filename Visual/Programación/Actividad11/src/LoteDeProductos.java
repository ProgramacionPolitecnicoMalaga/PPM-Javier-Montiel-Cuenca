public class LoteDeProductos {
    private final static int MAX_PRODUCTOS=100;
    private Productos[] lote;
    private int totalproductos;
    private SelectorDeMejoresProductos selectorDeMejoresProductos;
    public LoteDeProductos(){
        totalproductos=0;
        lote=new Productos[MAX_PRODUCTOS];
        selectorDeMejoresProductos=new MejorPrecio();
    }
    Productos getProductoEnPosicion(int i){
        Productos devolverproducto=null;
        if((i>=0)&& (i<totalproductos)){
            devolverproducto=lote[i];

        }
        return devolverproducto;
    }
    public Productos getProducto(String nombre) {
        for (Productos devolverProducto : lote){
            if (devolverProducto.getNombre().equalsIgnoreCase(nombre)) {
                return devolverProducto;
            }
        }
        return null;
    }
    public int getTotalProductos(){
        return totalproductos;
    }
    public void addProducto(Productos producto){

    }
    public int getTotalproductos(){
        return totalproductos;
    }

    public void getSelectorDeMejoresProductos(SelectorDeMejoresProductos selectorDeMejoresProductos) {
         this.selectorDeMejoresProductos=selectorDeMejoresProductos;
    }

}
