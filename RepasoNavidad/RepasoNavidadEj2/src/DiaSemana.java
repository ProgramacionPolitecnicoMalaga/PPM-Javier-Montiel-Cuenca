public class DiaSemana {
    public String devolverDiaSemana(int numero){
        switch (numero){
            case 0: return "Lunes";
            case 1: return "Martes";
            case 2: return "Miercoles";
            case 3: return "Jueves";
            case 4: return "Viernes";
            default: return "Dia desconocido";
        }

    }
}
