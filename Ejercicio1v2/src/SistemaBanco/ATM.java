package SistemaBanco;

public class ATM {

    public ATM(){}

    public boolean retiroATM(Tarjeta tarjeta, int monto, String nipIngresado) {
        tarjeta.validarNip(nipIngresado);
        if (monto % 100 != 0) {
            throw new IllegalArgumentException("Solo multiplos de 100");
        }
        return tarjeta.getCuenta().retiro(monto);
    }

    public boolean depositoATM(Tarjeta tarjeta, int monto, String nipIngresado) {
        tarjeta.validarNip(nipIngresado);
        if (monto % 100 != 0 || monto < 200) {
            throw new IllegalArgumentException("Debe ser multiplo de 100 y mayor o igual a 200");
        }
        return tarjeta.getCuenta().deposito(monto);
    }

    public boolean pagarServicio(double totalPagar, double totalIngresado) {
        if(totalPagar <= 0){
            throw new IllegalArgumentException("El monto a pagar no puede ser negativo.");
        }
        if(totalPagar>totalIngresado){
            throw new IllegalArgumentException("El monto ingresado es insuficiente");
        }
        return true;        
    }

    public boolean billetesValidos(int billete) {
        int[] denominaciones = {1000, 500, 200, 100, 50, 20};

        for (int denom : denominaciones) {
            if (billete == denom) {
                return true;
            }
        }
        return false;
        //throw new IllegalArgumentException("Billete no valido");
    }

    public double calcularCambio(double totalIngresado, double totalPagar){
        if (totalIngresado == totalPagar){
            return 0;
        }
        double cambio = totalIngresado - totalPagar;
        return cambio;
    }
}