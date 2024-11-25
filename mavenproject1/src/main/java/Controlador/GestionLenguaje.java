
package Controlador;
import Modelo.LenguajeProgramacion;

public class GestionLenguaje {
    private int FACTOR_CRECIMIENTO=2;
    private LenguajeProgramacion[] ArregloLenguajes= new LenguajeProgramacion[FACTOR_CRECIMIENTO];
    private int ContadorLenguaje=0;
    
    
    
    public void AgregarFila(){
        LenguajeProgramacion[] AgregarFila= new LenguajeProgramacion[ContadorLenguaje+FACTOR_CRECIMIENTO];
        System.arraycopy(ArregloLenguajes, 0, AgregarFila, 0, ArregloLenguajes.length);
        ArregloLenguajes=AgregarFila;
    }
    
    
    
    public void AgregarLenguaje(int AnioCreacion,String CaracteristicaPrincipal,String Nombre,String Utilizacion) {
        if (ContadorLenguaje==ArregloLenguajes.length){
            AgregarFila();
        }
            ArregloLenguajes[ContadorLenguaje++] = new LenguajeProgramacion(AnioCreacion,CaracteristicaPrincipal,Nombre,Utilizacion);
    }
    
    
    public LenguajeProgramacion BuscarLenguaje(String Nombre){
        for(int i=0; i<ContadorLenguaje;i++){
            if (ArregloLenguajes[i].getNombre().equalsIgnoreCase(Nombre)){
                return ArregloLenguajes[i];
            }
        }
       return null;
    }
    
    
    public boolean EliminarLenguaje(String Nombre){
        for(int i=0;i<ContadorLenguaje;i++){
            if (ArregloLenguajes[i].getNombre().equalsIgnoreCase(Nombre)){
                for (int j=i;j<ContadorLenguaje-1;j++){
                    ArregloLenguajes[j]=ArregloLenguajes[j+1];
                }
            ArregloLenguajes[--ContadorLenguaje]=null;
            return true;
            }
        }
        return false;
    }
    
    
    public LenguajeProgramacion[] getArregloLenguaje(){
        return ArregloLenguajes;
    }
    
    
    public void ImprimirLenguaje(){
        if(ContadorLenguaje==0){
            System.out.println("REGISTRO VACIO");
        }
        else{
            for(int i=0;i<ContadorLenguaje;i++){
                System.out.println(ArregloLenguajes[i]);
            }
        }
    }
}