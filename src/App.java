interface ManejadorDispensadora {
    void asignarSiguienteDenominacion(ManejadorDispensadora manejador);

    void validarSolicitud(int valor);
}

class CienMilManejador implements ManejadorDispensadora {
    private ManejadorDispensadora siguiente;

    public void asignarSiguienteDenominacion(ManejadorDispensadora manejador) {
        this.siguiente = manejador;
    }

    public void validarSolicitud(int valor) {
        if (valor >= 100000) {
            int numeroDeBilletes = valor / 100000;
            int sobrante = valor % 100000;

            System.out.println("Dispensando " + numeroDeBilletes + " billete(s) de 100000");

            if (sobrante != 0) {
                this.siguiente.validarSolicitud(sobrante);
            }
        } else {
            this.siguiente.validarSolicitud(valor);
        }
    }
}

class CincuentaMilManejador implements ManejadorDispensadora {
    private ManejadorDispensadora siguiente;

    public void asignarSiguienteDenominacion(ManejadorDispensadora manejador) {
        this.siguiente = manejador;
    }

    public void validarSolicitud(int valor) {
        if (valor >= 50000) {
            int numeroDeBilletes = valor / 50000;
            int sobrante = valor % 50000;

            System.out.println("Dispensando " + numeroDeBilletes + " billete(s) de 50000");

            if (sobrante != 0) {
                this.siguiente.validarSolicitud(sobrante);
            }
        } else {
            this.siguiente.validarSolicitud(valor);
        }
    }
}

class VeinteMilManejador implements ManejadorDispensadora {
    private ManejadorDispensadora siguiente;

    public void asignarSiguienteDenominacion(ManejadorDispensadora manejador) {
        this.siguiente = manejador;
    }

    public void validarSolicitud(int valor) {
        if (valor >= 20000) {
            int numeroDeBilletes = valor / 20000;
            int sobrante = valor % 20000;

            System.out.println("Dispensando " + numeroDeBilletes + " billete(s) de 20000");

            if (sobrante != 0) {
                this.siguiente.validarSolicitud(sobrante);
            }
        } else {
            this.siguiente.validarSolicitud(valor);
        }
    }
}

class DiezMilManejador implements ManejadorDispensadora {
    private ManejadorDispensadora siguiente;

    public void asignarSiguienteDenominacion(ManejadorDispensadora manejador) {
        this.siguiente = manejador;
    }

    public void validarSolicitud(int valor) {
        if (valor >= 10000) {
            int numeroDeBilletes = valor / 10000;
            int sobrante = valor % 10000;

            System.out.println("Dispensando " + numeroDeBilletes + " billete(s) de 10000");

            if (sobrante != 0) {
                this.siguiente.validarSolicitud(sobrante);
            }
        } else {
            this.siguiente.validarSolicitud(valor);
        }
    }
}

class CincoMilManejador implements ManejadorDispensadora {
    private ManejadorDispensadora siguiente;

    public void asignarSiguienteDenominacion(ManejadorDispensadora manejador) {
        this.siguiente = manejador;
    }

    public void validarSolicitud(int valor) {
        if (valor >= 5000) {
            int numeroDeBilletes = valor / 5000;
            int sobrante = valor % 5000;

            System.out.println("Dispensando " + numeroDeBilletes + " billete(s) de 5000");

            if (sobrante != 0) {
                this.siguiente.validarSolicitud(sobrante);
            }
        } else {
            this.siguiente.validarSolicitud(valor);
        }
    }
}

class Cajero {
    private ManejadorDispensadora billeteCienMil;

    public Cajero() {
        ManejadorDispensadora billeteCincuentaMil = new CincuentaMilManejador();
        ManejadorDispensadora billeteVeinteMil = new CincuentaMilManejador();
        ManejadorDispensadora billeteDiezMil = new CincuentaMilManejador();
        ManejadorDispensadora billeteCincoMil = new CincuentaMilManejador();

        this.billeteCienMil = new CienMilManejador();

        this.billeteCienMil.asignarSiguienteDenominacion(billeteCincuentaMil);
        billeteCincuentaMil.asignarSiguienteDenominacion(billeteVeinteMil);
        billeteVeinteMil.asignarSiguienteDenominacion(billeteDiezMil);
        billeteDiezMil.asignarSiguienteDenominacion(billeteCincoMil);
    }

    public void dispensar(int cantidad) {
        if (cantidad % 5000 != 0) {
            System.out.print("El valor ingresado no es permitido");
        } else {
            this.billeteCienMil.validarSolicitud(cantidad);
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Cajero cajero = new Cajero();

        cajero.dispensar(150000);
        System.out.print("---------\n");
        cajero.dispensar(200000);
        System.out.print("---------\n");
        cajero.dispensar(450000);
        System.out.print("---------\n");
    }
}