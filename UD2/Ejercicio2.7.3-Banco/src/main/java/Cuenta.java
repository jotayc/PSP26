/**
 * Una cuenta. No protege nada por sí misma: quien la use desde varios hilos
 * tiene que coger su cerrojo (synchronized sobre ella) antes de tocarla.
 */
public class Cuenta {

    private final String nombre;
    private int saldo;

    public Cuenta(String nombre, int saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    public void sacar(int cantidad) {
        saldo = saldo - cantidad;
    }

    public void ingresar(int cantidad) {
        saldo = saldo + cantidad;
    }
}
