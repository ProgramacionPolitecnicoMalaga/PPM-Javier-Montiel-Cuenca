public class MejorPrecio implements SelectorDeMejoresProductos {
    @Override
    public Productos seleccionarloteproductos(Productos[]lote) {
        Productos productomasbarato=null;
        double MenorPrecio=Double.MAX_VALUE;
        for (Productos Producto:lote){
            if(Producto.getPrecio()<MenorPrecio){
                productomasbarato=Producto;
                MenorPrecio=Producto.getPrecio();
            }
        }
        return productomasbarato;

    }
}
