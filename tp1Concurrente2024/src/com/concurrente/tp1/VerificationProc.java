package com.concurrente.tp1;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import com.concurrente.tp1.Registers.Reservation;

/*
 * Proceso de Verificación: Al finalizar la ejecución, se debe verificar el 
 * estado final de la matriz de asientos y los registros de reservas para 
 * asegurar que las operaciones se hayan realizado correctamente. Este proceso 
 * selecciona de manera aleatoria una reserva del registro de reservas 
 * confirmadas. Para cada reserva marcada como “checked”, se debe eliminar del 
 * registro de reservas confirmadas y se debe insertar en el registro de 
 * reservas verificadas. Este proceso es ejecutado por dos hilos.
*/
public class VerificationProc implements Runnable {

    private Random rand = new Random();
    final Logger logger = Logger.getLogger(VerificationProc.class.getName());
    private Registers registers;

    public VerificationProc(Registers registers) {
        this.registers = registers;
    }

    @Override
    public void run() {
        boolean isStopped = false;
        List<Reservation> reservations = registers.getReservations();
        List<Integer> confirmed = registers.getConfirmed();
        List<Integer> verified = registers.getVerified();

        while (!isStopped) {
            try {
                int randomIndex = rand.nextInt(confirmed.size());
                Integer randomConfirmed = confirmed.get(randomIndex);
                if (reservations.get(randomIndex).isChecked()) {
                    confirmed.remove(randomConfirmed);
                    verified.add(randomConfirmed);
                }
            } catch (Exception e) {
                logger.severe(e.getMessage());
                isStopped = true;
            }
        }
    }
}
